package com.example.scrollview;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scrollview.R;
import com.example.scrollview.PopularFoodAdapter;
import com.example.scrollview.PopularFood;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity2_platos extends AppCompatActivity {

    RecyclerView popularRecycler;
    PopularFoodAdapter popularFoodAdapter;
    private ImageButton imgbtn;
    private int restaurantElegido = 0;
    private int productosAñadidos = 0;

    private ArrayList<Pedidos> arrayPedidos = new ArrayList<>(); //array donde se almacenaran los datos de los pedidos que se añaden a la cesta

    List<PopularFood> popularFoodList = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_2platos);
        Utils.changeStatusBarAndNavigationBarColor(Activity2_platos.this, R.color.mirage, R.color.mirage_dark);

        imgbtn = findViewById(R.id.img_btn);

        //recuperamos el int que devuelve la pagina anterior para saber que restaurante has elegido

        Intent intent = getIntent();
        restaurantElegido = intent.getIntExtra("restauranteElegido",0);

        //los distintos platos de cada restaurante

        if(restaurantElegido==1) {
            popularFoodList.add(new PopularFood("Big Mac", "4,30 €", R.drawable.bigmac));
            popularFoodList.add(new PopularFood("Cuarto de Libra", "4,40 €", R.drawable.cuartodelibra));
            popularFoodList.add(new PopularFood("Hamburguesa con Queso", "1,30 €", R.drawable.hamburguesaqueso));
            popularFoodList.add(new PopularFood("Filete de Pescado", "4,40 €", R.drawable.filetepescado));
        }
        else if(restaurantElegido==2) {
            popularFoodList.add(new PopularFood("Whooper", "5,35 €", R.drawable.whopper));
            popularFoodList.add(new PopularFood("The King Huevo", "7,90 €", R.drawable.whopper));
            popularFoodList.add(new PopularFood("Big King", "6,60 €", R.drawable.whopper));
            popularFoodList.add(new PopularFood("Steakhouse", "6,95 €", R.drawable.whopper));
        }
        else if(restaurantElegido==3) {
            popularFoodList.add(new PopularFood("Quesarito", "5,00 €", R.drawable.quesarito));
            popularFoodList.add(new PopularFood("Chicken Burrito", "5,00 €", R.drawable.quesarito));
            popularFoodList.add(new PopularFood("Burrito Supreme", "3,90 €", R.drawable.quesarito));
            popularFoodList.add(new PopularFood("Burrito GSB", "5,00 €", R.drawable.quesarito));
        }
        else if(restaurantElegido==4) {
            popularFoodList.add(new PopularFood("Bucket Mix", "9,49 €", R.drawable.cubokfc));
            popularFoodList.add(new PopularFood("Menú 5 tiras", "8,99 €", R.drawable.cubokfc));
            popularFoodList.add(new PopularFood("Menú 3 piezas", "8,99 €", R.drawable.cubokfc));
            popularFoodList.add(new PopularFood("Menú 8 alitas", "8,99 €", R.drawable.cubokfc));
        }
        else if(restaurantElegido==5) {
            popularFoodList.add(new PopularFood("Bocadillo British Bacon", "5,80 €", R.drawable.pansbocata));
            popularFoodList.add(new PopularFood("Bocadillo Serrano Brie", "6,70 €", R.drawable.pansbocata));
            popularFoodList.add(new PopularFood("Bocadillo Vegetal de Atún", "6,95 €", R.drawable.pansbocata));
            popularFoodList.add(new PopularFood("Bocadillo Pechuga de Polloe", "6,80 €", R.drawable.pansbocata));
        }
        else if(restaurantElegido==6) {
            popularFoodList.add(new PopularFood("Hamburguesa VIPS Burger", "12,50 €", R.drawable.vipsburger));
            popularFoodList.add(new PopularFood("Hamburguesa Pampera", "12,50 €", R.drawable.vipsburger));
            popularFoodList.add(new PopularFood("Hamburguesa Big Tower", "12,25 €", R.drawable.vipsburger));
            popularFoodList.add(new PopularFood("Aguacate Chicken Burger", "12,25 €", R.drawable.vipsburger));
        }
        else if(restaurantElegido==7) {
            popularFoodList.add(new PopularFood("Big Mac", "12,50 €", R.drawable.mcdonalds));
            popularFoodList.add(new PopularFood("Chicken", "12,50 €", R.drawable.mcdonalds));
            popularFoodList.add(new PopularFood("Cheese burguer", "5,35 €", R.drawable.mcdonalds));
            popularFoodList.add(new PopularFood("Aguacate Chicken Burger", "5,35 €", R.drawable.mcdonalds));
        }
        else if(restaurantElegido==8) {
            popularFoodList.add(new PopularFood("Pizza Barbacoa", "3,90 €", R.drawable.pizza));
            popularFoodList.add(new PopularFood("Pizza Americana", "3,90 €", R.drawable.pizza));
            popularFoodList.add(new PopularFood("Cheese burguer", "3,90 €", R.drawable.pizza));
            popularFoodList.add(new PopularFood("Big mag grande", "3,90 €", R.drawable.pizza));
        }
        else if(restaurantElegido==9) {
            popularFoodList.add(new PopularFood("Fettuccine Pirata\n", "13,50 €", R.drawable.pastaginos));
            popularFoodList.add(new PopularFood("Rigatoni al Forno", "12,95 €", R.drawable.pastaginos));
            popularFoodList.add(new PopularFood("Spaghetti Bolognesa", "11,95 €", R.drawable.pastaginos));
            popularFoodList.add(new PopularFood("Spaghetti al Frutti di Mare", "14,50 €", R.drawable.pastaginos));
        }
        else if(restaurantElegido==10) {
            popularFoodList.add(new PopularFood("Hamburger", "9,95 €", R.drawable.hardrockburger));
            popularFoodList.add(new PopularFood("Cheeseburger", "9,95 €", R.drawable.hardrockburger));
            popularFoodList.add(new PopularFood("Rwb Burger", "9,95 €", R.drawable.hardrockburger));
            popularFoodList.add(new PopularFood("All American Burger", "9,95 €", R.drawable.hardrockburger));
        }
        else{
            Log.i("fallo","ha puesto el default");
        }
        setPopularRecycler(popularFoodList);

        popularRecycler.addOnItemTouchListener(new RecyclerItemClickListener(this, popularRecycler ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {

                Pedidos pedidos = new Pedidos();//creamos el objeto para cada vez que se haga click

                String nombre;
                String precio;
                if(position==0){

                    nombre = (popularFoodList.get(position).getName());
                    pedidos.setName(nombre);
                    precio = (popularFoodList.get(position).getPrice());
                    pedidos.setPrecio(precio);

                    Log.i("pedido",popularFoodList.get(position).getName());
                    Log.i("pedido",popularFoodList.get(position).getPrice());
                    Toast.makeText(Activity2_platos.this, "pedido añadido", Toast.LENGTH_SHORT).show();

                }
                else if(position==1){

                    pedidos.setName(popularFoodList.get(position).getName());
                    pedidos.setPrecio(popularFoodList.get(position).getPrice());
                    Toast.makeText(Activity2_platos.this, "pedido añadido", Toast.LENGTH_SHORT).show();


                }
                else if(position==2){

                    pedidos.setName(popularFoodList.get(position).getName());
                    pedidos.setPrecio(popularFoodList.get(position).getPrice());
                    Toast.makeText(Activity2_platos.this, "pedido añadido", Toast.LENGTH_SHORT).show();


                }
                else{

                    pedidos.setName(popularFoodList.get(position).getName());
                    pedidos.setPrecio(popularFoodList.get(position).getPrice());
                    Toast.makeText(Activity2_platos.this, "pedido añadido", Toast.LENGTH_SHORT).show();

                }

                productosAñadidos++; //contador de cuantos pedidos se han añadido a la cesta

                arrayPedidos.add(pedidos); //guardamos en el array los pedidos que se soliciten

                Log.i("pedidosarray", String.valueOf(arrayPedidos));

            }
            @Override public void onLongItemClick(View view, int position) {

            }
        }));

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("pedidosarray",arrayPedidos.toString() + " " + productosAñadidos);

                Intent cesta = new Intent(Activity2_platos.this,Cesta.class);

                cesta.putExtra("arrayPedidos",arrayPedidos);

                startActivity(cesta);
            }
        });

    }

    private  void setPopularRecycler(List<PopularFood> popularFoodList) {

        popularRecycler = findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularFoodAdapter = new PopularFoodAdapter(this, popularFoodList);
        popularRecycler.setAdapter(popularFoodAdapter);

    }

}