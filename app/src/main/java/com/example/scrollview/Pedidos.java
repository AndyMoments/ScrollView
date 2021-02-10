package com.example.scrollview;

import java.io.Serializable;

public class Pedidos implements Serializable {

    private String name;
    private double precio;

    public Pedidos(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void guardar(){
        name = name;
        precio = precio;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "name='" + name + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
