package com.mycompany.reservadiego.modelos;


public class Congreso{
private int id;
private int fkidevento;
private int numerojornadas;

public Congreso( int id, int fkidevento, int numerojornadas )  {
this.id = id;
this.fkidevento = fkidevento;
this.numerojornadas = numerojornadas;
}

public int getId() {
    return id;
}
 
public void setId(int id) {
    this.id = id;
}
 
public int getFkidevento() {
    return fkidevento;
}
 
public void setFkidevento(int fkidevento) {
    this.fkidevento = fkidevento;
}
 
public int getNumerojornadas() {
    return numerojornadas;
}
 
public void setNumerojornadas(int numerojornadas) {
    this.numerojornadas = numerojornadas;
}
 


}