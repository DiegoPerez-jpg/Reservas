package com.mycompany.reservadiego.modelos;

public class Tipoevento{
private int id;
private String tipoevento;

public Tipoevento( int id, String tipoevento )  {
this.id = id;
this.tipoevento = tipoevento;
}

public int getId() {
    return id;
}
 
public void setId(int id) {
    this.id = id;
}
 
public String getTipoevento() {
    return tipoevento;
}
 
public void setTipoevento(String tipoevento) {
    this.tipoevento = tipoevento;
}
 


}