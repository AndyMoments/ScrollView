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
    int j = 0;
    int contador = 0;

    ArrayList<String> nombrePedidos = new ArrayList<>();
    ArrayList<Double> precioPedidos = new ArrayList<>();

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

        Bundle extras = getIntent().getExtras();

        ArrayList<Pedidos> aux;
        if (extras != null) {

            aux = (ArrayList<Pedidos>) extras.get("arrayPedidos");

            for (Pedidos objeto : aux) {

                nombrePedidos.add(objeto.getName());
                precioPedidos.add(objeto.getPrecio());

                contador++;

            }

        }

        for (int i = 0;i<contador;i++){


            if (i==0){

                txtNombrePrimerPLato.setText(nombrePedidos.get(i));
                txtPrecioprimerPlato.setText(precioPedidos.get(i) + " €");

            }
            else if(i==1){

                txtNombreSegundoPLato.setText(nombrePedidos.get(i));
                txtPrecioSegundoPlato.setText(precioPedidos.get(i) + " €");

            }
            else if(i==2){

                txtNombretercerPLato.setText(nombrePedidos.get(i));
                txtPrecioTercerPlato.setText(precioPedidos.get(i) + " €");

            }
            else if(i==3){

                txtNombreCuartoPLato.setText(nombrePedidos.get(i));
                txtPrecioCuartoPlato.setText(precioPedidos.get(i) + " €");

            }
            else if(i==4){

                txtNombreQuintoPLato.setText(nombrePedidos.get(i));
                txtPrecioQuintoPlato.setText(precioPedidos.get(i) + " €");

            }
            else if(i==5){

                txtNombreSextoPLato.setText(nombrePedidos.get(i));
                txtPrecioSextoPlato.setText(precioPedidos.get(i) + " €");

            }
            else if(i==6){

                txtNombreSeptimoPLato.setText(nombrePedidos.get(i));
                txtPrecioSeptimoPlato.setText(precioPedidos.get(i) + " €");

            }
            else if(i==7){

                txtNombreOctavoPLato.setText(nombrePedidos.get(i));
                txtPrecioOctavoPlato.setText(precioPedidos.get(i) + " €");

            }

        }

    }
}