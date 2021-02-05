package com.example.scrollview;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Activity2 extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private TextView nombrePlato;
    private TextView precioPlato;
    private Button btnAñadirPlato;
    private Button btnIrCesta;

    private TextView nombrePlato2;
    private TextView precioPlato2;
    private Button btnAñadirPlato2;

    String platoNombre;
    String platoPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombrePlato = findViewById(R.id.txt_nombre_plato1);
        precioPlato = findViewById(R.id.txt_precio_plato1);
        btnAñadirPlato = findViewById(R.id.btn_añadir_plato_cesta);
        btnIrCesta = findViewById(R.id.btn_ir_cesta);

        nombrePlato2 = findViewById(R.id.txt_nombre_plato2);
        precioPlato2 = findViewById(R.id.txt_precio_plato2);
        btnAñadirPlato2 = findViewById(R.id.btn_añadir_plato_cesta2);

        btnAñadirPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                platoNombre = nombrePlato.getText().toString();

                platoPrecio = precioPlato.getText().toString();

                crearusuario(platoNombre,platoPrecio);

            }
        });
        btnAñadirPlato2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                platoNombre = nombrePlato2.getText().toString();

                platoPrecio = precioPlato2.getText().toString();

                crearusuario(platoNombre,platoPrecio);

            }
        });

        btnIrCesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity2.this,Cesta.class);
                startActivity(intent);

            }
        });

    }

    public void crearusuario (String nombrePlato2, String precioPlato2){

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
                        Toast.makeText(Activity2.this, "Registro completado", Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Activity2.this, "Registro fallido", Toast.LENGTH_SHORT).show();

                        Log.w("TAG", "Error adding document", e);
                    }
                });

    }
}