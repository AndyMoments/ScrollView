package com.example.scrollview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView nombreUsuario;
    private RecyclerView recyclerView;
    private List<Restaurantes> restaurantesList = new ArrayList<>( );
    private LinearLayoutManager manager;
    private ProductAdapter productAdapter;
    private String nombre;
    private int restauranteElegido = 0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.changeStatusBarAndNavigationBarColor(MainActivity.this, R.color.mirage, R.color.mirage_dark);

        recyclerView = findViewById(R.id.recyclerView);
        nombreUsuario = findViewById(R.id.userName);

        //nombre de bienvenido del usuario que me lo pasa la pagina de validacion

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        nombreUsuario.setText(nombre);


        setProductAdapter();

        //metodo para saber a que restaurante le estas dando click

        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {

                //Cada uno de los restaurantes ( lo que se ve en la app)

                if (position==0){
                    restauranteElegido = 1;
                    Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
                    intent1.putExtra("restauranteElegido",restauranteElegido);
                    startActivity(intent1);

                }
                else if (position==1){
                    restauranteElegido = 2;
                    Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
                    intent1.putExtra("restauranteElegido",restauranteElegido);
                    startActivity(intent1);
                }
                else if (position==2){
                    restauranteElegido = 3;
                    Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
                    intent1.putExtra("restauranteElegido",restauranteElegido);
                    startActivity(intent1);
                }
                else if (position==3){
                    restauranteElegido = 4;
                    Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
                    intent1.putExtra("restauranteElegido",restauranteElegido);
                    startActivity(intent1);
                }
                else if (position==4){
                    restauranteElegido = 5;
                    Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
                    intent1.putExtra("restauranteElegido",restauranteElegido);
                    startActivity(intent1);
                }
                else if (position==5){
                    restauranteElegido = 6;
                    Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
                    intent1.putExtra("restauranteElegido",restauranteElegido);
                    startActivity(intent1);
                }
                else if (position==6){
                    restauranteElegido = 7;
                    Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
                    intent1.putExtra("restauranteElegido",restauranteElegido);
                    startActivity(intent1);
                }
                else if (position==7){
                    restauranteElegido = 8;
                    Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
                    intent1.putExtra("restauranteElegido",restauranteElegido);
                    startActivity(intent1);
                }
                else if (position==8){
                    restauranteElegido = 9;
                    Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
                    intent1.putExtra("restauranteElegido",restauranteElegido);
                    startActivity(intent1);
                }
                else if (position==9){
                    restauranteElegido = 10;
                    Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
                    intent1.putExtra("restauranteElegido",restauranteElegido);
                    startActivity(intent1);

                }


            }

            @Override public void onLongItemClick(View view, int position) {



            }
        }));

    }

    //la información que tiene cada restaurante
    private void setProductAdapter() {

        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));

        productAdapter = new ProductAdapter(MainActivity.this, restaurantesList);
        recyclerView.setAdapter(productAdapter);
        manager = new LinearLayoutManager(MainActivity.this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager );



    }

}