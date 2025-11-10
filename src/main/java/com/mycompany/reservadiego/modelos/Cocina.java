package com.mycompany.reservadiego.modelos;


public class Cocina{
private int id;
private String tipococina;

public Cocina( int id, String tipococina )  {
this.id = id;
this.tipococina = tipococina;
}

public int getId() {
    return id;
}
 
public void setId(int id) {
    this.id = id;
}
 
public String getTipococina() {
    return tipococina;
}
 
public void setTipococina(String tipococina) {
    this.tipococina = tipococina;
}
 


}