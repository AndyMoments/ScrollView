package com.example.scrollview;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.prefs.PreferenceChangeEvent;

public class Registro extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private EditText etxtUsuario;
    private EditText etxtContraseña;
    private Button btnCrearUsuario;

    String nombreUsuario;
    String password;
    String creedenciales;
    String datosNube;

    Usuario user = new Usuario();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        Utils.changeStatusBarAndNavigationBarColor(Registro.this, R.color.mirage, R.color.mirage_dark);

        etxtUsuario = findViewById(R.id.etxt_usuario);
        etxtContraseña = findViewById(R.id.etxt_contraseña);
        btnCrearUsuario = findViewById(R.id.btn_crear_usuario);


        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombreUsuario = etxtUsuario.getText().toString();
                password = etxtContraseña.getText().toString();

                creedenciales = nombreUsuario + "," + password;

                Toast.makeText(Registro.this, creedenciales, Toast.LENGTH_SHORT).show();
                user.setNombreUsuario(nombreUsuario);
                user.setContraseña(password);

                //crearusuario(nombreUsuario,password);

                //leerDocumento();

                //Log.i("creed2",creedenciales);

            }
        });
    }

    public void crearusuario (String nombreUsuario, String contraseña){

        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("usuario", nombreUsuario);
        user.put("contraseña", contraseña);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(com.example.scrollview.Registro.this, "Registro completado", Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(com.example.scrollview.Registro.this, "Registro fallido", Toast.LENGTH_SHORT).show();

                        Log.w("TAG", "Error adding document", e);
                    }
                });

    }

    public void leerDocumento (){
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData().get("usuario") +
                                        document.getData().get("contraseña"));

                                datosNube = (document.getData().get("usuario")+","+(document.getData().get("contraseña")));


                            }
                        } else {
                            Toast.makeText(com.example.scrollview.Registro.this, "Lectura fallida", Toast.LENGTH_SHORT).show();
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public String getCreedenciales() {
        return creedenciales;
    }

    public void setCreedenciales(String creedenciales) {
        this.creedenciales = creedenciales;
    }

    public String getDatosNube() {
        return datosNube;
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

        creedenciales = datos.getString("creedenciales",null);

    }

}