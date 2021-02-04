package com.example.scrollview.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.example.scrollview.model.Product;
import com.example.scrollview.adapter.ProductAdapter;
import com.example.scrollview.R;
import com.example.scrollview.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Product> productList = new ArrayList<>( );
    private LinearLayoutManager manager;
    private ProductAdapter productAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.changeStatusBarAndNavigationBarColor(MainActivity.this, R.color.mirage, R.color.mirage_dark);

        recyclerView = findViewById(R.id.recyclerView);

        setProductAdapter();

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
        productList.add(new Product("McDonalds", "Americana" , "1.99€" , "https://logos-world.net/wp-content/uploads/2020/04/McDonalds-Logo.png"));

        productAdapter = new ProductAdapter(MainActivity.this, productList);
        recyclerView.setAdapter(productAdapter);
        manager = new LinearLayoutManager(MainActivity.this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager );

    }

}