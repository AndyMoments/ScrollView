package com.example.scrollview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    RecyclerView popularRecycler;
    PopularFoodAdapter popularFoodAdapter;

    private ImageButton imgbtn;

    int productosAñadidos = 0;


    private ArrayList<Pedidos> arrayPedidos = new ArrayList<>(); //array donde se almacenaran los datos de los pedidos que se añaden a la cesta

    List<PopularFood> popularFoodList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_2platos);

        imgbtn = findViewById(R.id.img_btn);

        popularFoodList.add(new PopularFood("Big Mac", "1.99$", R.drawable.mcdonalds));
        popularFoodList.add(new PopularFood("Chicken", "1.99$", R.drawable.mcdonalds));
        popularFoodList.add(new PopularFood("Cheese burguer", "1.99$", R.drawable.mcdonalds));
        popularFoodList.add(new PopularFood("Big mag grande", "1.99$", R.drawable.mcdonalds));

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