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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView nombreUsuario;
    private RecyclerView recyclerView;
    private List<Restaurantes> restaurantesList = new ArrayList<>( );
    private LinearLayoutManager manager;
    private ProductAdapter productAdapter;
    private String nombre;
    private String contraseña;
    private int restauranteElegido = 0;
    private ImageButton imgbtn;
    private ImageButton img_icon;
    private ImageView btnConfiguracion;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtn = findViewById(R.id.img_btn_cesta);imgbtn = findViewById(R.id.img_btn_cesta);
        img_icon = findViewById(R.id.img_back_pressed);img_icon = findViewById(R.id.img_back_pressed);
        btnConfiguracion = findViewById(R.id.img_configuracion);

        Utils.changeStatusBarAndNavigationBarColor(MainActivity.this, R.color.mirage, R.color.mirage_dark);

        recyclerView = findViewById(R.id.recyclerView);
        nombreUsuario = findViewById(R.id.userName);

        //nombre de bienvenido del usuario que me lo pasa la pagina de validacion

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        nombreUsuario.setText(nombre);

        //recogemos tambien la contraseña
        contraseña = intent.getStringExtra("contra");
        Log.i("contra",contraseña);

        setProductAdapter();

        //metodo para saber a que restaurante le estas dando click

        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {

                //Cada uno de los restaurantes ( lo que se ve en la app)

                rellenarRestaurantes(position);

            }

            @Override public void onLongItemClick(View view, int position) {

            }
        }));

        //botons para ir a la cesta
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cesta = new Intent(MainActivity.this,Cesta.class);

                startActivity(cesta);
            }
        });

        //boton de configuracion arriba
        img_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent config = new Intent(MainActivity.this,Layout_Account.class);
                config.putExtra("nombre",nombre);
                config.putExtra("contra",contraseña);
                startActivity(config);
            }
        });
        //boton de configuracion abajo
        btnConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent config = new Intent(MainActivity.this,Layout_Account.class);
                config.putExtra("nombre",nombre);
                config.putExtra("contra",contraseña);
                startActivity(config);
            }
        });

    }

    //la información que tiene cada restaurante
    private void setProductAdapter() {

        restaurantesList.add(new Restaurantes("McDonalds", "Americana" , "Envío 1.99€" , "https://d2egcvq7li5bpq.cloudfront.net/es/images/restaurants/32834.gif"));
        restaurantesList.add(new Restaurantes("Burger King", "Americana" , "Envío 1.99€" , "https://d2egcvq7li5bpq.cloudfront.net/es/images/restaurants/29468.gif"));
        restaurantesList.add(new Restaurantes("Taco Bell", "Americana, Tex-Mex" , "Envío 1.99€" , "https://d2egcvq7li5bpq.cloudfront.net/es/images/restaurants/39052.gif"));
        restaurantesList.add(new Restaurantes("KFC", "Pollo, Americana" , "Envío 1.99€" , "https://d2egcvq7li5bpq.cloudfront.net/es/images/restaurants/24584.gif"));
        restaurantesList.add(new Restaurantes("Pans&Company", "Sandwiches, bocadillos" , "Envío 1.99€" , "https://d2egcvq7li5bpq.cloudfront.net/es/images/restaurants/29855.gif"));
        restaurantesList.add(new Restaurantes("VIPS", "Americana" , "Envío 1.99€" , "https://d2egcvq7li5bpq.cloudfront.net/es/images/restaurants/17292.gif"));
        restaurantesList.add(new Restaurantes("Foster's Hollywood", "Americana" , "Envío 1.99€" , "https://d2egcvq7li5bpq.cloudfront.net/es/images/restaurants/42568.gif"));
        restaurantesList.add(new Restaurantes("Pomodoro", "Pizza, Hamburguesas" , "Envío 1.99€" , "https://d2egcvq7li5bpq.cloudfront.net/es/images/restaurants/45584.gif"));
        restaurantesList.add(new Restaurantes("Ginos", "Italiana, Pizza" , "Envío 1.99€" , "https://d2egcvq7li5bpq.cloudfront.net/es/images/restaurants/18141.gif"));
        restaurantesList.add(new Restaurantes("Hard Rock Café", "Americana" , "Envío 1.99€" , "https://d2egcvq7li5bpq.cloudfront.net/es/images/restaurants/40880.gif"));

        productAdapter = new ProductAdapter(MainActivity.this, restaurantesList);
        recyclerView.setAdapter(productAdapter);
        manager = new LinearLayoutManager(MainActivity.this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager );



    }
    //metodo que introduce toda la informacion de los restaurantes y lleva a su correspondiente menu
    public void rellenarRestaurantes(int position){

        if (position==0){
            restauranteElegido = 1;
            Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
            intent1.putExtra("restauranteElegido",restauranteElegido);
            //pasamos estos datos para el onBackPressed
            intent1.putExtra("nombre",nombre);
            intent1.putExtra("contra",contraseña);
            //para que se vea el nombre de cada restaurante enviamos el dato
            intent1.putExtra("restaurante",restaurantesList.get(0).getName());
            startActivity(intent1);

        }
        else if (position==1){
            restauranteElegido = 2;
            Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
            intent1.putExtra("restauranteElegido",restauranteElegido);
            intent1.putExtra("nombre",nombre);
            intent1.putExtra("contra",contraseña);
            intent1.putExtra("restaurante",restaurantesList.get(0).getName());
            startActivity(intent1);
        }
        else if (position==2){
            restauranteElegido = 3;
            Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
            intent1.putExtra("restauranteElegido",restauranteElegido);
            intent1.putExtra("nombre",nombre);
            intent1.putExtra("contra",contraseña);
            intent1.putExtra("restaurante",restaurantesList.get(0).getName());
            startActivity(intent1);
        }
        else if (position==3){
            restauranteElegido = 4;
            Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
            intent1.putExtra("restauranteElegido",restauranteElegido);
            intent1.putExtra("nombre",nombre);
            intent1.putExtra("contra",contraseña);
            intent1.putExtra("restaurante",restaurantesList.get(0).getName());
            startActivity(intent1);
        }
        else if (position==4){
            restauranteElegido = 5;
            Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
            intent1.putExtra("restauranteElegido",restauranteElegido);
            intent1.putExtra("nombre",nombre);
            intent1.putExtra("contra",contraseña);
            intent1.putExtra("restaurante",restaurantesList.get(0).getName());

            startActivity(intent1);
        }
        else if (position==5){
            restauranteElegido = 6;
            Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
            intent1.putExtra("restauranteElegido",restauranteElegido);
            intent1.putExtra("nombre",nombre);
            intent1.putExtra("contra",contraseña);
            intent1.putExtra("restaurante",restaurantesList.get(0).getName());

            startActivity(intent1);
        }
        else if (position==6){
            restauranteElegido = 7;
            Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
            intent1.putExtra("restauranteElegido",restauranteElegido);
            intent1.putExtra("nombre",nombre);
            intent1.putExtra("contra",contraseña);
            intent1.putExtra("restaurante",restaurantesList.get(0).getName());

            startActivity(intent1);
        }
        else if (position==7){
            restauranteElegido = 8;
            Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
            intent1.putExtra("restauranteElegido",restauranteElegido);
            intent1.putExtra("nombre",nombre);
            intent1.putExtra("contra",contraseña);
            startActivity(intent1);
        }
        else if (position==8){
            restauranteElegido = 9;
            Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
            intent1.putExtra("restauranteElegido",restauranteElegido);
            intent1.putExtra("nombre",nombre);
            intent1.putExtra("contra",contraseña);
            intent1.putExtra("restaurante",restaurantesList.get(0).getName());

            startActivity(intent1);
        }
        else if (position==9){
            restauranteElegido = 10;
            Intent intent1 = new Intent(MainActivity.this,Activity2_platos.class);
            intent1.putExtra("restauranteElegido",restauranteElegido);
            intent1.putExtra("nombre",nombre);
            intent1.putExtra("contra",contraseña);
            intent1.putExtra("restaurante",restaurantesList.get(0).getName());

            startActivity(intent1);

        }

    }

}