/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reservadiego.Modelo;

/**
 *
 * @author m
 */
import java.time.LocalDate;
public class Evento {

    private int id;
    private LocalDate fecha;
    private int cantidadPersonas;
    private int fkTipoEvento;
    private int fkServicioCocina;

    public Evento() {
    }

    public Evento(int id, LocalDate fecha, int cantidadPersonas, int fkTipoEvento, int fkServicioCocina) {
        this.id = id;
        this.fecha = fecha;
        this.cantidadPersonas = cantidadPersonas;
        this.fkTipoEvento = fkTipoEvento;
        this.fkServicioCocina = fkServicioCocina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Evento setFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public Evento setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
        return this;
    }

    public int getFkTipoEvento() {
        return fkTipoEvento;
    }

    public Evento setFkTipoEvento(int fkTipoEvento) {
        this.fkTipoEvento = fkTipoEvento;
        return this;
    }

    public int getFkServicioCocina() {
        return fkServicioCocina;
    }

    public Evento setFkServicioCocina(int fkServicioCocina) {
        this.fkServicioCocina = fkServicioCocina;
        return this;
    }

    @Override
    public String toString() {
        return "Evento {" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cantidadPersonas=" + cantidadPersonas +
                ", fkTipoEvento=" + fkTipoEvento +
                ", fkServicioCocina=" + fkServicioCocina +
                '}';
    }
}