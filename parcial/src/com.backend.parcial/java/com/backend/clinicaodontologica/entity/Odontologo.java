package com.backend.parcial.entity;

public class Odontologo {
    private int id;
    private String nombre;
    private String apellido;
    private int númeroDeMatrícula;


    public Odontologo( int id, String nombre, String apellido, int númeroDeMatrícula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.númeroDeMatrícula = númeroDeMatrícula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNúmeroDeMatrícula() {
        return númeroDeMatrícula;
    }

    public void setNúmeroDeMatrícula(int númeroDeMatrícula) {
        this.númeroDeMatrícula = númeroDeMatrícula;
    }

    public void add(Odontologo odontologo) {
    }
    @Override
    public String toString() {
        return "Id: " + id + " - Nombre: " + nombre + " - Apellido: " + apellido + " - Apellido: " + númeroDeMatrícula ;
    }
}
