package com.example.scrollview;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private final int DURACION_CARGA = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            public void run() {
                Intent intent = new Intent(com.example.scrollview.SplashScreen.this, Registro.class);
                startActivity(intent);
                finish();
            };
        },DURACION_CARGA);
    }

    public void verificacion(){

        Registro registro = new Registro();

        registro.leerDocumento();

    }

}