package com.mycompany.reservadiego.modelos;


public class Contacto{
private int id;
private String nombre;
private String numero;
private String correo;

public Contacto( int id, String nombre, String numero, String correo )  {
this.id = id;
this.nombre = nombre;
this.numero = numero;
this.correo = correo;
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
 
public String getNumero() {
    return numero;
}
 
public void setNumero(String numero) {
    this.numero = numero;
}
 
public String getCorreo() {
    return correo;
}
 
public void setCorreo(String correo) {
    this.correo = correo;
}
 


}