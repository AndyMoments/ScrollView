package com.example.scrollview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Activity2_platos extends AppCompatActivity {

    AlertDialog.Builder builder;
    RecyclerView popularRecycler;
    PopularFoodAdapter popularFoodAdapter;
    private ImageView imgbtn;
    private int restaurantElegido = 0;
    private int productosAñadidos = 0;
    private TextView txtcantidad;
    private ImageView imgBack;
    private ImageView btnConfig;
    private TextView txtRestaurante;
    private String nombre; //nombre y contraseña del ususario para el onbackPresed
    private String contraseña;
    private String nombreRestaurante;

    private ArrayList<Pedidos> arrayPedidos = new ArrayList<>(); //array donde se almacenaran los datos de los pedidos que se añaden a la cesta

    List<PopularFood> popularFoodList = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_2platos);
        Utils.changeStatusBarAndNavigationBarColor(Activity2_platos.this, R.color.mirage, R.color.mirage_dark);

        imgbtn = findViewById(R.id.img_btn_cesta);
        txtcantidad = findViewById(R.id.txt_Cantidad_row_item);
        imgBack = findViewById(R.id.img_back_pressed);
        btnConfig = findViewById(R.id.img_configuracion);
        txtRestaurante = findViewById(R.id.restaurant_name);

        //recuperamos el int que devuelve la pagina anterior para saber que restaurante has elegido

        Intent intent = getIntent();
        //saber que restaurante has elegido
        restaurantElegido = intent.getIntExtra("restauranteElegido",0);
        nombre = intent.getStringExtra("nombre");
        contraseña = intent.getStringExtra("contra");
        //nombre del restaurante
        nombreRestaurante = intent.getStringExtra("restaurante");

        //ponemos el nombre del restaurante
        txtRestaurante.setText(nombreRestaurante);

        //los distintos platos de cada restaurante

        if(restaurantElegido==1) {
            popularFoodList.add(new PopularFood("Big Mac", "4,30 €", R.drawable.bigmac));
            popularFoodList.add(new PopularFood("Cuarto de Libra", "4,40 €", R.drawable.cuartodelibra));
            popularFoodList.add(new PopularFood("Hamburguesa con Queso", "1,30 €", R.drawable.hamburguesaqueso));
            popularFoodList.add(new PopularFood("Filete de Pescado", "4,40 €", R.drawable.filetepescado));
        }
        else if(restaurantElegido==2) {
            popularFoodList.add(new PopularFood("Whooper", "5,35 €", R.drawable.whopper));
            popularFoodList.add(new PopularFood("The King Huevo", "7,90 €", R.drawable.whopper));
            popularFoodList.add(new PopularFood("Big King", "6,60 €", R.drawable.whopper));
            popularFoodList.add(new PopularFood("Steakhouse", "6,95 €", R.drawable.whopper));
        }
        else if(restaurantElegido==3) {
            popularFoodList.add(new PopularFood("Quesarito", "5,00 €", R.drawable.quesarito));
            popularFoodList.add(new PopularFood("Chicken Burrito", "5,00 €", R.drawable.quesarito));
            popularFoodList.add(new PopularFood("Burrito Supreme", "3,90 €", R.drawable.quesarito));
            popularFoodList.add(new PopularFood("Burrito GSB", "5,00 €", R.drawable.quesarito));
        }
        else if(restaurantElegido==4) {
            popularFoodList.add(new PopularFood("Bucket Mix", "9,49 €", R.drawable.cubokfc));
            popularFoodList.add(new PopularFood("Menú 5 tiras", "8,99 €", R.drawable.cubokfc));
            popularFoodList.add(new PopularFood("Menú 3 piezas", "8,99 €", R.drawable.cubokfc));
            popularFoodList.add(new PopularFood("Menú 8 alitas", "8,99 €", R.drawable.cubokfc));
        }
        else if(restaurantElegido==5) {
            popularFoodList.add(new PopularFood("Bocadillo British Bacon", "5,80 €", R.drawable.pansbocata));
            popularFoodList.add(new PopularFood("Bocadillo Serrano Brie", "6,70 €", R.drawable.pansbocata));
            popularFoodList.add(new PopularFood("Bocadillo Vegetal de Atún", "6,95 €", R.drawable.pansbocata));
            popularFoodList.add(new PopularFood("Bocadillo Pechuga de Pollo", "6,80 €", R.drawable.pansbocata));
        }
        else if(restaurantElegido==6) {
            popularFoodList.add(new PopularFood("Hamburguesa VIPS Burger", "12,50 €", R.drawable.vipsburger));
            popularFoodList.add(new PopularFood("Hamburguesa Pampera", "12,50 €", R.drawable.vipsburger));
            popularFoodList.add(new PopularFood("Hamburguesa Big Tower", "12,25 €", R.drawable.vipsburger));
            popularFoodList.add(new PopularFood("Aguacate Chicken Burger", "12,25 €", R.drawable.vipsburger));
        }
        else if(restaurantElegido==7) {
            popularFoodList.add(new PopularFood("Big Mac", "12,50 €", R.drawable.mcdonalds));
            popularFoodList.add(new PopularFood("Chicken", "12,50 €", R.drawable.mcdonalds));
            popularFoodList.add(new PopularFood("Cheese burguer", "5,35 €", R.drawable.mcdonalds));
            popularFoodList.add(new PopularFood("Aguacate Chicken Burger", "5,35 €", R.drawable.mcdonalds));
        }
        else if(restaurantElegido==8) {
            popularFoodList.add(new PopularFood("Pizza Barbacoa", "3,90 €", R.drawable.pizza));
            popularFoodList.add(new PopularFood("Pizza Americana", "3,90 €", R.drawable.pizza));
            popularFoodList.add(new PopularFood("Cheese burguer", "3,90 €", R.drawable.pizza));
            popularFoodList.add(new PopularFood("Big mag grande", "3,90 €", R.drawable.pizza));
        }
        else if(restaurantElegido==9) {
            popularFoodList.add(new PopularFood("Fettuccine Pirata\n", "13,50 €", R.drawable.pastaginos));
            popularFoodList.add(new PopularFood("Rigatoni al Forno", "12,95 €", R.drawable.pastaginos));
            popularFoodList.add(new PopularFood("Spaghetti Bolognesa", "11,95 €", R.drawable.pastaginos));
            popularFoodList.add(new PopularFood("Spaghetti al Frutti di Mare", "14,50 €", R.drawable.pastaginos));
        }
        else if(restaurantElegido==10) {
            popularFoodList.add(new PopularFood("Hamburger", "9,95 €", R.drawable.hardrockburger));
            popularFoodList.add(new PopularFood("Cheeseburger", "9,95 €", R.drawable.hardrockburger));
            popularFoodList.add(new PopularFood("Rwb Burger", "9,95 €", R.drawable.hardrockburger));
            popularFoodList.add(new PopularFood("All American Burger", "9,95 €", R.drawable.hardrockburger));
        }
        else{
            Log.i("fallo","ha puesto el default");
        }
        setPopularRecycler(popularFoodList);

        builder = new AlertDialog.Builder(this);

        //On click para saber a que carta del menu seleccionas
        popularRecycler.addOnItemTouchListener(new RecyclerItemClickListener(this, popularRecycler ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {

                Pedidos pedidos = new Pedidos();//creamos el objeto para cada vez que se haga click

                if(position==0){

                    configurarAlertDialog(builder,pedidos,position);

                }
                else if(position==1){

                    configurarAlertDialog(builder,pedidos,position);

                }
                else if(position==2){

                    configurarAlertDialog(builder,pedidos,position);

                }
                else{

                    configurarAlertDialog(builder,pedidos,position);

                }

                //mirar otra forma si es posible
                //temporizador para que el valor de pedidos.getPrecios recoga lo que tu hayas pedido en la alerta
                Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //de esta forma si le das a cancelar no te lleva a la cesta un pedido por defecto
                        Log.i("precioPedido", String.valueOf(pedidos.getPrecio()));
                        if (pedidos.getPrecio()>0) {

                            productosAñadidos++; //contador de cuantos pedidos se han añadido a la cesta

                            arrayPedidos.add(pedidos); //guardamos en el array los pedidos que se soliciten

                            Log.i("pedidosarray", String.valueOf(arrayPedidos));
                        }
                    }
                },4000);
            }
            @Override public void onLongItemClick(View view, int position) {

            }
        }));

        //boton ir a la cesta
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("pedidosarray",arrayPedidos.toString() + " " + productosAñadidos);

                Intent cesta = new Intent(Activity2_platos.this,Cesta.class);

                cesta.putExtra("arrayPedidos",arrayPedidos);
                cesta.putExtra("nombre",nombre);
                cesta.putExtra("contra",contraseña);

                startActivity(cesta);
            }
        });

        //boton ir atras
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });

        //boton de configuracion abajo
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent config = new Intent(Activity2_platos.this,Layout_Account.class);
                config.putExtra("nombre",nombre);
                config.putExtra("contra",contraseña);
                startActivity(config);
            }
        });

    }

    //creacion de los reciclerView y sus adaptadores
    private  void setPopularRecycler(List<PopularFood> popularFoodList) {

        popularRecycler = findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularFoodAdapter = new PopularFoodAdapter(this, popularFoodList);
        popularRecycler.setAdapter(popularFoodAdapter);

    }

    //cnfigurar el alertDialog
    public void configurarAlertDialog(AlertDialog.Builder builder,Pedidos pedidos,int position){

        final View view = getLayoutInflater().inflate(R.layout.activity_alert_dialog,null);

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        builder.setCancelable(false);

        final EditText editText = view.findViewById(R.id.txtCantidad);

        final String[] cantidadDePedidosSeleccionados = new String[1];

        //boton de añadir al carrito el pedido
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Añadir al carro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //cantidad que tu has escrito del pedido, como recibimos un String lo paso a double cambiando la coma por el punto para que funcione
                 cantidadDePedidosSeleccionados[0] = editText.getText().toString();

                //pasamos la cantidad a int
                int cantidadPedidos = Integer.parseInt((cantidadDePedidosSeleccionados[0]));
                Log.i("cantidad", String.valueOf(cantidadPedidos));

                //recogemos el valor del precio de la lista
                String precio = popularFoodList.get(position).getPrice();

                //lo dividimos para quedarnos con los numeros
                String [] precioProcesado = precio.split(" ");
                Log.i("precio", precioProcesado[0]);

                //metodo para sustituir las comas por punto y que pueda ser un double
                double precioDouble = getValor(precioProcesado);
                Log.i("precio", String.valueOf(precioDouble*cantidadPedidos));

                //limitamos el numero de decimales a dos
                DecimalFormat formato = new DecimalFormat("#.00");
                double multiplicacion = precioDouble*cantidadPedidos;

                //los valores que se pasaran  la cesta
                pedidos.setName(popularFoodList.get(position).getName());
                pedidos.setPrecio(Double.parseDouble(formato.format(multiplicacion)));
                Toast.makeText(Activity2_platos.this, "pedido añadido", Toast.LENGTH_SHORT).show();

            }
        });
        //boton de cancelar el pedido
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Activity2_platos.this, "Operacion cancelada", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();

            }
        });

        alertDialog.setView(view);

        alertDialog.show();

    }
    //metodo para sustitutir las comas por puntos de un string
    public double getValor(String []texto){
        if(texto[0].contains(",")){
            return Double.parseDouble(texto[0].replace(",", ".").trim());
        }
        return Double.parseDouble(texto[0].trim());
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}