package com.mycompany.reservadiego.modelos;


public class Evento{
private int id;
private int fkidcontacto;
private int fkidtipodeevento;
private int fkidtipodecocina;
private int numeropersonas;
private int requierehabitaciones;

public Evento( int id, int fkidcontacto, int fkidtipodeevento, int fkidtipodecocina, int numeropersonas, int requierehabitaciones )  {
this.id = id;
this.fkidcontacto = fkidcontacto;
this.fkidtipodeevento = fkidtipodeevento;
this.fkidtipodecocina = fkidtipodecocina;
this.numeropersonas = numeropersonas;
this.requierehabitaciones = requierehabitaciones;
}

public int getId() {
    return id;
}
 
public void setId(int id) {
    this.id = id;
}
 
public int getFkidcontacto() {
    return fkidcontacto;
}
 
public void setFkidcontacto(int fkidcontacto) {
    this.fkidcontacto = fkidcontacto;
}
 
public int getFkidtipodeevento() {
    return fkidtipodeevento;
}
 
public void setFkidtipodeevento(int fkidtipodeevento) {
    this.fkidtipodeevento = fkidtipodeevento;
}
 
public int getFkidtipodecocina() {
    return fkidtipodecocina;
}
 
public void setFkidtipodecocina(int fkidtipodecocina) {
    this.fkidtipodecocina = fkidtipodecocina;
}
 
public int getNumeropersonas() {
    return numeropersonas;
}
 
public void setNumeropersonas(int numeropersonas) {
    this.numeropersonas = numeropersonas;
}
 
public int getRequierehabitaciones() {
    return requierehabitaciones;
}
 
public void setRequierehabitaciones(int requierehabitaciones) {
    this.requierehabitaciones = requierehabitaciones;
}
 


}