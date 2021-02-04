package com.example.scrollview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Cesta extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    private TextView txtNombrePrimerPLato;
    private TextView txtPrecioprimerPlato;
    private TextView txtNombreSegundoPLato;
    private TextView txtPrecioSegundoPlato;
    String[] nombrePlato = new String[10];
    String[] precioPlato= new String[10];
    boolean campoRelleno;
    int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta);

        txtNombrePrimerPLato = findViewById(R.id.txt_nombre_pedido1);
        txtPrecioprimerPlato = findViewById(R.id.txt_precio_pedido1);
        txtNombreSegundoPLato = findViewById(R.id.txt_nombre_pedido2);
        txtPrecioSegundoPlato = findViewById(R.id.txt_precio_pedido2);

    leerDocumento();

    }
    public void leerDocumento (){
        db.collection("cesta")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData().get("nombre") +
                                        document.getData().get("precio"));

                                nombrePlato[j] = (document.getData().get("nombre") + "");
                                precioPlato[j] = (document.getData().get("precio") + "");
                                Log.d("plato",nombrePlato[j]);
                                Log.d("plato",precioPlato[j]);

                                j++;
                            }
                        } else {
                            Toast.makeText(Cesta.this, "Lectura fallida", Toast.LENGTH_SHORT).show();
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                        Log.d("tamaño", String.valueOf(nombrePlato.length));
                        for (int i = 0; i<nombrePlato.length;i++){

                            if(nombrePlato[i]!=null) {


                                if (i == 0) {
                                    Log.i("info", "rellena primer plato");
                                    txtNombrePrimerPLato.setText(nombrePlato[i]);
                                    txtPrecioprimerPlato.setText(precioPlato[i]);
                                    campoRelleno = true;
                                } else if (i == 1) {
                                    txtNombreSegundoPLato.setText(nombrePlato[i]);
                                    txtPrecioSegundoPlato.setText(precioPlato[i]);
                                } else {

                                }
                            }
                        }

                    }
                });
    }
}