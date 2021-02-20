package com.example.scrollview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class Layout_Account extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    //creedenciales del usuario
    private String nombre;
    private String nombreCambiado;
    private String contraseña;
    private String contraseñaCambiada;
    private String id;
    private String creedenciales;

    private EditText etxtUsuario;
    private EditText etxtContraseña;
    private Button btnCambiarCreedenciales;
    private ImageView imgBackPressed;

    Registro registro = new Registro();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_account);

        etxtUsuario = findViewById(R.id.etxt_usuario_config);
        etxtContraseña = findViewById(R.id.etxt_contraseña_congif);
        btnCambiarCreedenciales = findViewById(R.id.btn_cambiar_creedenciales);
        imgBackPressed = findViewById(R.id.img_back_pressed);

        //obtenemos los valores del usuario
        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre") + "";
        contraseña = intent.getStringExtra("contra") + "";

        //ponemos los valores en el edit text
        etxtUsuario.setText(nombre);
        etxtContraseña.setText(contraseña);

        //añadimos el texto al textwatcher
        etxtUsuario.addTextChangedListener(textWatcher);
        etxtContraseña.addTextChangedListener(textWatcher);

        //imageView para volver a la actividad anterior

        imgBackPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //llamo al metodo de onbackpressed ya creado en esa actividad

                onBackPressed();
            }
        });
    }

    public void actualizarDatos (){

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                String usuario =  document.getData().get("usuario") + "";
                                if (usuario.equals(nombre)){

                                    //almacenamos la id de donde esta los creedenciales del usuario
                                    id = document.getId();
                                    Log.i("id obtenida",id);

                                    //ahora que tenemos la id pasamos a hacer un update de los datos
                                    DocumentReference docRef = db.collection("users").document(id);
                                    Map<String,Object> updates = new HashMap<>();

                                    //Indicamos los nuevos valores
                                    updates.put("usuario",nombreCambiado);
                                    updates.put("contraseña",contraseñaCambiada);

                                    //lo actualizamos en la base de datos
                                    docRef.update(updates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(Layout_Account.this, "Cambio de creedenciales correcto", Toast.LENGTH_SHORT).show();

                                            //temporizador de 2 segundos para que aparezca el aviso
                                            Handler handler = new Handler();

                                            handler.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(Layout_Account.this, "Redirigiendo al inicio", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(Layout_Account.this,MainActivity.class);
                                                    //le pasamos el nuevo nombre actualizado
                                                    intent.putExtra("nombre",nombreCambiado);
                                                    intent.putExtra("contra",contraseñaCambiada);
                                                    startActivity(intent);
                                                    }

                                            },4000);

                                        }


                                    });

                                    break;
                                }
                                else{
                                    Log.i("error lectura","error, no es igaul");
                                }

                            }


                        } else {
                            Toast.makeText(Layout_Account.this, "Lectura fallida", Toast.LENGTH_SHORT).show();
                            Log.w("TAG", "Error getting documents.", task.getException());

                        }
                    }

                });
    }

    //metodo de cambio de creedenciales
    public TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            //decimos el texto que ha de cambiar
            String usernameInput = etxtUsuario.getText().toString().trim();
            String passwordInput = etxtContraseña.getText().toString().trim();

            //cuando el texto cambia poner en enabled el btn
            btnCambiarCreedenciales.setEnabled(usernameInput!=etxtUsuario.getText().toString().trim()
                    || passwordInput!=etxtContraseña.getText().toString().trim());


            //una vez permitido que cambie los creedenciales al pulsarlo
            btnCambiarCreedenciales.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //antes de actualizar los datos guardamos nuestras nuevas creedenciales
                    nombreCambiado = etxtUsuario.getText().toString().trim();
                    contraseñaCambiada = etxtContraseña.getText().toString().trim();

                    //le damos valor a creedenciales para que al volver a iniciar sesion esten cambiados a los nuevos valores
                    creedenciales = nombreCambiado + "," + contraseñaCambiada;
                    actualizarDatos();

                }
            });

        }

        @Override
        public void afterTextChanged(Editable s) {



        }

    };

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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
