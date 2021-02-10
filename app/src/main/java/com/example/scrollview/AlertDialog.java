package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertDialog extends AppCompatActivity {

    private EditText cantidad;
    private int numero = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        cantidad = findViewById(R.id.txtCantidad);

        Log.i("cantidad","asdadasdasdasdas");

    }
}