package com.example.scrollview;

public class Usuario {

    private String nombreUsuario;
    private String contraseña;

    public Usuario(String nombreUsuario, String contraseña){
        this.nombreUsuario=nombreUsuario;
        this.contraseña=contraseña;
    }
    public Usuario(){

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
