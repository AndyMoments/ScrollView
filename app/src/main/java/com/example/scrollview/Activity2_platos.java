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

    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_2platos);

        imgbtn = findViewById(R.id.img_btn);



        List<PopularFood> popularFoodList = new ArrayList<>();

        popularFoodList.add(new PopularFood("Big Mac", "1.99$", R.drawable.mcdonalds));
        popularFoodList.add(new PopularFood("Big Mac", "1.99$", R.drawable.mcdonalds));
        popularFoodList.add(new PopularFood("Big Mac", "1.99$", R.drawable.mcdonalds));
        popularFoodList.add(new PopularFood("Big Mac", "1.99$", R.drawable.mcdonalds));

        setPopularRecycler(popularFoodList);

        popularRecycler.addOnItemTouchListener(new RecyclerItemClickListener(this, popularRecycler ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {

                if(position==0){



                }

            }
            @Override public void onLongItemClick(View view, int position) {



            }
        }));

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2_platos.this,Cesta.class);
                startActivity(intent);
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




    public void crearPedido (String nombrePlato2, String precioPlato2){

        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("nombre", nombrePlato2);
        user.put("precio", precioPlato2);

// Add a new document with a generated ID
        db.collection("cesta")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Activity2_platos.this, "Registro completado", Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Activity2_platos.this, "Registro fallido", Toast.LENGTH_SHORT).show();

                        Log.w("TAG", "Error adding document", e);
                    }
                });

    }






}