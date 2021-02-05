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

public class Cesta extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    private TextView txtNombrePrimerPLato;
    private TextView txtPrecioprimerPlato;
    private TextView txtNombreSegundoPLato;
    private TextView txtPrecioSegundoPlato;
    private TextView txtNombretercerPLato;
    private TextView txtPrecioTercerPlato;
    private TextView txtNombreCuartoPLato;
    private TextView txtPrecioCuartoPlato;
    private TextView txtNombreQuintoPLato;
    private TextView txtPrecioQuintoPlato;
    private TextView txtNombreSextoPLato;
    private TextView txtPrecioSextoPlato;
    private TextView txtNombreSeptimoPLato;
    private TextView txtPrecioSeptimoPlato;
    private TextView txtNombreOctavoPLato;
    private TextView txtPrecioOctavoPlato;
    String[] nombrePlato = new String[8];
    String[] precioPlato= new String[8];
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
        txtNombretercerPLato = findViewById(R.id.txt_nombre_pedido3);
        txtPrecioTercerPlato = findViewById(R.id.txt_precio_pedido3);
        txtNombreCuartoPLato = findViewById(R.id.txt_nombre_pedido4);
        txtPrecioCuartoPlato = findViewById(R.id.txt_precio_pedido4);
        txtNombreQuintoPLato = findViewById(R.id.txt_nombre_pedido5);
        txtPrecioQuintoPlato = findViewById(R.id.txt_precio_pedido5);
        txtNombreSextoPLato = findViewById(R.id.txt_nombre_pedido6);
        txtPrecioSextoPlato = findViewById(R.id.txt_precio_pedido6);
        txtNombreSeptimoPLato = findViewById(R.id.txt_nombre_pedido7);
        txtPrecioSeptimoPlato = findViewById(R.id.txt_precio_pedido7);
        txtNombreOctavoPLato = findViewById(R.id.txt_nombre_pedido8);
        txtPrecioOctavoPlato = findViewById(R.id.txt_precio_pedido8);

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
                                } else if (i == 1) {
                                    Log.i("info", "rellena segundo plato");
                                    txtNombreSegundoPLato.setText(nombrePlato[i]);
                                    txtPrecioSegundoPlato.setText(precioPlato[i]);
                                }
                                else if (i == 2) {
                                    Log.i("info", "rellena tercer plato");
                                    txtNombretercerPLato.setText(nombrePlato[i]);
                                    txtPrecioTercerPlato.setText(precioPlato[i]);
                                } else if (i == 3) {
                                    Log.i("info", "rellena cuarto plato");
                                    txtNombreCuartoPLato.setText(nombrePlato[i]);
                                    txtPrecioCuartoPlato.setText(precioPlato[i]);
                                }
                                else if (i == 4) {
                                    Log.i("info", "rellena quinto plato");
                                    txtNombreQuintoPLato.setText(nombrePlato[i]);
                                    txtPrecioQuintoPlato.setText(precioPlato[i]);
                                } else if (i == 5) {
                                    Log.i("info", "rellena sexto plato");
                                    txtNombreSextoPLato.setText(nombrePlato[i]);
                                    txtPrecioSextoPlato.setText(precioPlato[i]);
                                }
                                else if (i == 6) {
                                    Log.i("info", "rellena septimo plato");
                                    txtNombreSeptimoPLato.setText(nombrePlato[i]);
                                    txtPrecioSeptimoPlato.setText(precioPlato[i]);
                                } else if (i == 7) {
                                    Log.i("info", "rellena octavo plato");
                                    txtNombreOctavoPLato.setText(nombrePlato[i]);
                                    txtPrecioOctavoPlato.setText(precioPlato[i]);
                                }
                                else {
                                    Log.i("info", "No hay mas platos añadidos a la cesta");

                                }
                            }
                        }

                    }
                });
    }
}