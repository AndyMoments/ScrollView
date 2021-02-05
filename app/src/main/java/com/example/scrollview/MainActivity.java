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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView nombreUsuario;
    private RecyclerView recyclerView;
    private List<Product> productList = new ArrayList<>( );
    private LinearLayoutManager manager;
    private ProductAdapter productAdapter;

    String nombre;

    Usuario usuario = new Usuario();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.changeStatusBarAndNavigationBarColor(MainActivity.this, R.color.mirage, R.color.mirage_dark);

        recyclerView = findViewById(R.id.recyclerView);
        nombreUsuario = findViewById(R.id.userName);

        //nombre de bienvenido del usuario que me lo pasa la pagina de carga

        Intent intent = getIntent();

        nombre = intent.getStringExtra("nombre");

        nombreUsuario.setText(nombre);

        setProductAdapter();

        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {

                if (position==0){
                    Toast.makeText(MainActivity.this, "item1", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(MainActivity.this,Activity2.class);
                    startActivity(intent1);
                }
                else if (position==1){
                    Toast.makeText(MainActivity.this, "item2", Toast.LENGTH_SHORT).show();
                }
                else if (position==2){
                    Toast.makeText(MainActivity.this, "item3", Toast.LENGTH_SHORT).show();
                }
                else if (position==3){
                    Toast.makeText(MainActivity.this, "item4", Toast.LENGTH_SHORT).show();
                }
                else if (position==4){
                    Toast.makeText(MainActivity.this, "item5", Toast.LENGTH_SHORT).show();
                }
                else if (position==5){
                    Toast.makeText(MainActivity.this, "item6", Toast.LENGTH_SHORT).show();
                }
                else if (position==6){
                    Toast.makeText(MainActivity.this, "item7", Toast.LENGTH_SHORT).show();
                }
                else if (position==7){
                    Toast.makeText(MainActivity.this, "item8", Toast.LENGTH_SHORT).show();
                }
                else if (position==8){
                    Toast.makeText(MainActivity.this, "item8", Toast.LENGTH_SHORT).show();
                }
                else if (position==9){
                    Toast.makeText(MainActivity.this, "item9", Toast.LENGTH_SHORT).show();
                }
                else if (position==10){
                    Toast.makeText(MainActivity.this, "item10", Toast.LENGTH_SHORT).show();
                }

            }

            @Override public void onLongItemClick(View view, int position) {



            }
        }));

    }


    private void setProductAdapter() {

        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));
        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));

        productAdapter = new ProductAdapter(MainActivity.this, productList);
        recyclerView.setAdapter(productAdapter);
        manager = new LinearLayoutManager(MainActivity.this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager );
        Log.d("layout", String.valueOf(recyclerView.getAdapter().getItemId(2)));



    }

}