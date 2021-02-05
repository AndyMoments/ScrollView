package com.example.scrollview;

public class Pedidos {

    private String name;
    private String precio;

    public Pedidos(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "name='" + name + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
