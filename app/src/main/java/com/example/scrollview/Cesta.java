package com.example.scrollview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private TextView precioTotal;
    private Button btnFinalizarCompra;
    int contador = 0;
    private Double precioFinal = 0.0;
    private String precioString;
    private int tiempo;
    //creamos la alerta
    AlertDialog.Builder builder;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

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
        precioTotal = findViewById(R.id.txt_precio_final);
        btnFinalizarCompra = findViewById(R.id.btn_finalizar_pedido);

        Bundle extras = getIntent().getExtras();

        ArrayList<Pedidos> aux;
        if (extras != null) {

            aux = (ArrayList<Pedidos>) extras.get("arrayPedidos");

            for (Pedidos objeto : aux) {

                nombrePedidos.add(objeto.getName());
                precioPedidos.add(objeto.getPrecio());

                //saber cuantos pedidos se han realizado
                contador++;

            }

        }

        //introducimos los valores de los pedidos en la cesta
        for (int i = 0;i<contador;i++){


            if (i==0){

                txtNombrePrimerPLato.setText(nombrePedidos.get(i));
                txtPrecioprimerPlato.setText(precioPedidos.get(i) + " €");
                precioFinal = precioFinal + precioPedidos.get(i); //el valor del double en otra variable para hacer la suma sonstante de los rpecios
                Log.i("precioFinal", String.valueOf(precioFinal));
            }
            else if(i==1){

                txtNombreSegundoPLato.setText(nombrePedidos.get(i));
                txtPrecioSegundoPlato.setText(precioPedidos.get(i) + " €");
                precioFinal = precioFinal + precioPedidos.get(i);
                Log.i("precioFinal", String.valueOf(precioFinal));
            }
            else if(i==2){

                txtNombretercerPLato.setText(nombrePedidos.get(i));
                txtPrecioTercerPlato.setText(precioPedidos.get(i) + " €");
                precioFinal = precioFinal + precioPedidos.get(i);
                Log.i("precioFinal", String.valueOf(precioFinal));
            }
            else if(i==3){

                txtNombreCuartoPLato.setText(nombrePedidos.get(i));
                txtPrecioCuartoPlato.setText(precioPedidos.get(i) + " €");
                precioFinal = precioFinal + precioPedidos.get(i);
                Log.i("precioFinal", String.valueOf(precioFinal));
            }
            else if(i==4){

                txtNombreQuintoPLato.setText(nombrePedidos.get(i));
                txtPrecioQuintoPlato.setText(precioPedidos.get(i) + " €");
                precioFinal = precioFinal + precioPedidos.get(i);
                Log.i("precioFinal", String.valueOf(precioFinal));
            }
            else if(i==5){

                txtNombreSextoPLato.setText(nombrePedidos.get(i));
                txtPrecioSextoPlato.setText(precioPedidos.get(i) + " €");
                precioFinal = precioFinal + precioPedidos.get(i);
                Log.i("precioFinal", String.valueOf(precioFinal));
            }
            else if(i==6){

                txtNombreSeptimoPLato.setText(nombrePedidos.get(i));
                txtPrecioSeptimoPlato.setText(precioPedidos.get(i) + " €");
                precioFinal = precioFinal + precioPedidos.get(i);
                Log.i("precioFinal", String.valueOf(precioFinal));
            }
            else if(i==7){

                txtNombreOctavoPLato.setText(nombrePedidos.get(i));
                txtPrecioOctavoPlato.setText(precioPedidos.get(i) + " €");
                precioFinal = precioFinal + precioPedidos.get(i);
                Log.i("precioFinal", String.valueOf(precioFinal));
            }

        }
        //suma de todos los precios
        Log.i("precio total", String.valueOf(precioFinal));
        DecimalFormat formato = new DecimalFormat("#.00");

        //pasamos el double a string para sustituir el punto por la coma
        precioString = String.valueOf(formato.format(precioFinal));
        Log.i("precio sin cambiar",precioString);

        precioString = precioString.replace(".",",");
        Log.i("precio cambiado",precioString);

        //añadir el precio al txt para visualizarlo
        precioTotal.setText(precioString + " €");


        //calculamos el tiempo que se tarda el pedido en repartir
        tiempo=calcularTiempoPedido(Double.parseDouble(formato.format(precioFinal)));
        Log.i("tiempo", String.valueOf(tiempo));

         builder = new AlertDialog.Builder(this);

        //boton para finalizar el pedido
        btnFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //subimos los pedidos a la base de datos
                finalizarPedido(nombrePedidos,precioPedidos,contador);

                //llamamos al metodo para crear la alerta que avisa del tiempo
                crearAlerta(builder,tiempo);
            }
        });

    }

    public void finalizarPedido (ArrayList<String> nombrePedidos, ArrayList<Double> precioPedidos ,int contador){

        //usp el contador para saber cuantos pedidos se han realizado y asi recorre los array para tener cada valor
        for (int i = 0;i<contador;i++) {
            // Create a new user with a first and last name
            Map<String, Object> user = new HashMap<>();
            user.put("nombre del plato", nombrePedidos.get(i));
            user.put("precio plato", precioPedidos.get(i) + " €");


// Add a new document with a generated ID
            db.collection("Pedidos")
                    .add(user)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("TAG", "Error adding document", e);
                        }
                    });
        }
    }

    public int calcularTiempoPedido(double precioFinal){

        int tiempo = 0;

        //del precio final lo dividimos entre 4,5
        tiempo = (int) (precioFinal%4.5);

        //por cada plato le ponemos 9 minutos;
        tiempo = tiempo*9;

        return tiempo;
    }

    public void crearAlerta(AlertDialog.Builder builder , int minutos){

        //hacemos que la alerta te lleve de nuevo a la pagina de inicio
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Pedido realizado con éxito");
        builder.setMessage("Tardara " + minutos + " minutos en llegarle a su destino");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Cesta.this,MainActivity.class);
                startActivity(intent);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}