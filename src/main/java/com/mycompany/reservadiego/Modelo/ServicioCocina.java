/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reservadiego.Modelo;

/**
 *
 * @author m
 */
public class ServicioCocina {

    private int id;
    private String nombre;

    // Constructor vacío
    public ServicioCocina() {}

    // Constructor con parámetros
    public ServicioCocina(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
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

    @Override
    public String toString() {
        return "ServicioCocina { " +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                " }";
    }
}
