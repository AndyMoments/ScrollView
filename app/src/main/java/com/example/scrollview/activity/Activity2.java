package com.example.scrollview.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scrollview.R;
import com.example.scrollview.adapter.PopularFoodAdapter;
import com.example.scrollview.model.PopularFood;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    RecyclerView popularRecycler;
    PopularFoodAdapter popularFoodAdapter;

    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_2);

        List<PopularFood> popularFoodList = new ArrayList<>();

        popularFoodList.add(new PopularFood("Big Mac", "7.00€", R.drawable.mcdonaldsbigmac));
        popularFoodList.add(new PopularFood("CBO", "7.75€", R.drawable.mcdonaldscbo));
        popularFoodList.add(new PopularFood("McPollo", "7.00€", R.drawable.mcdonaldsmcpollo));
        popularFoodList.add(new PopularFood("Cuarto de libra", "7.10€", R.drawable.mcdonaldscuartodelibra));
        popularFoodList.add(new PopularFood("Cuarto de libra", "7.10€", R.drawable.mcdonaldscuartodelibra));
        popularFoodList.add(new PopularFood("Cuarto de libra", "7.10€", R.drawable.mcdonaldscuartodelibra));
        popularFoodList.add(new PopularFood("Cuarto de libra", "7.10€", R.drawable.mcdonaldscuartodelibra));
        popularFoodList.add(new PopularFood("Cuarto de libra", "7.10€", R.drawable.mcdonaldscuartodelibra));
        popularFoodList.add(new PopularFood("Cuarto de libra", "7.10€", R.drawable.mcdonaldscuartodelibra));
        popularFoodList.add(new PopularFood("Cuarto de libra", "7.10€", R.drawable.mcdonaldscuartodelibra));


        setPopularRecycler(popularFoodList);

    }

    private  void setPopularRecycler(List<PopularFood> popularFoodList) {

        popularRecycler = findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularFoodAdapter = new PopularFoodAdapter(this, popularFoodList);
        popularRecycler.setAdapter(popularFoodAdapter);

    }











}