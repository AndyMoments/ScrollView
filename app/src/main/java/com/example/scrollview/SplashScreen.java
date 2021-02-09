package com.example.scrollview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private final int DURACION_CARGA = 6000;

    String creedenciales = null;

    boolean verification;

    String datosNube;

    String nombrePersona;

    Registro registro = new Registro();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            public void run() {

                leerDocumento();

                finish();
            };
        },DURACION_CARGA);
    }

    public void onPause(){

        super.onPause();

        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor miEditor = datos.edit();

        miEditor.putString("creedenciales",creedenciales);

        miEditor.apply();

    }

    public void onResume(){

        super.onResume();

        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);

        registro.getCreedenciales();

        creedenciales = datos.getString("creedenciales",null);

    }


    public void leerDocumento (){

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                     datosNube = document.getData().get("usuario") + "," + document.getData().get("contraseña");
                                    Log.d("datosnube", datosNube);

                                    Log.i("creed", creedenciales);

                                        if (datosNube.equals(creedenciales)) {
                                            Log.i("creed", "son iguales");
                                            nombrePersona = document.getData().get("usuario") + "";
                                            verification=true;
                                            break;
                                        }
                                        else{
                                            Log.i("creed", "no son iguales");
                                            verification=false;
                                        }

                                }


                            } else {
                                Toast.makeText(SplashScreen.this, "Lectura fallida", Toast.LENGTH_SHORT).show();
                                Log.w("TAG", "Error getting documents.", task.getException());

                            }
                            verificacion();
                            //invoco a la funcion de verificar aqui ya que al hacerlo en el run se ejecuta antes que recupera los valores de la nube y da falso siempre
                    }

                });
    }

    public void verificacion(){

        if (verification==true){
            Log.d("acceso","confirmado, llevandote al menu");
            Intent intent2 = new Intent(com.example.scrollview.SplashScreen.this, MainActivity.class);
            intent2.putExtra("nombre",nombrePersona);
            startActivity(intent2);
        }
        else{
            Log.d("acceso","denegado,registrate");
            Intent intent = new Intent(com.example.scrollview.SplashScreen.this, Registro.class);
            startActivity(intent);
        }
    }

}