/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reservadiego.Modelo;

/**
 *
 * @author m
 */
public class Congreso {

    private int id;
    private int fkEvento;
    private int numeroJornadas;

    // Constructor vacío
    public Congreso() {}

    // Constructor con parámetros
    public Congreso(int id, int fkEvento, int numeroJornadas) {
        this.id = id;
        this.fkEvento = fkEvento;
        this.numeroJornadas = numeroJornadas;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkEvento() {
        return fkEvento;
    }

    public void setFkEvento(int fkEvento) {
        this.fkEvento = fkEvento;
    }

    public int getNumeroJornadas() {
        return numeroJornadas;
    }

    public void setNumeroJornadas(int numeroJornadas) {
        this.numeroJornadas = numeroJornadas;
    }

    @Override
    public String toString() {
        return "Congreso { " +
                "id=" + id +
                ", fkEvento=" + fkEvento +
                ", numeroJornadas=" + numeroJornadas +
                " }";
    }
}