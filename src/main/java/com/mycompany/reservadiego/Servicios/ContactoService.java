package com.mycompany.reservadiego.Servicios;

import com.mycompany.reservadiego.DAOS.DAOContacto;
import com.mycompany.reservadiego.Exception.MailAlreadyExists;
import com.mycompany.reservadiego.Exception.NumberAlreadyExist;
import com.mycompany.reservadiego.modelos.Contacto;

import java.util.ArrayList;

public class ContactoService {
    private final DAOContacto contactoDAO = new DAOContacto();

    public Contacto buscarPorNumero(String nombre) {
        return contactoDAO.findAll().stream().filter(contacto -> contacto.getNumero().equals(nombre)).findFirst().orElse(null);
    }
    public Contacto buscarPorCorreo(String nombre) {
        return contactoDAO.findAll().stream().filter(contacto -> contacto.getCorreo().equals(nombre)).findFirst().orElse(null);
    }

    public Boolean existePorNombre(String nombre) {
        return buscarPorNumero(nombre) != null;
    }

    public void insertContacto(Contacto contacto) throws MailAlreadyExists, NumberAlreadyExist {
        if(buscarPorCorreo(contacto.getCorreo()) != null){throw new MailAlreadyExists("Contacto ya existe");}
        if(buscarPorNumero(contacto.getNumero()) != null){throw new NumberAlreadyExist("Contacto ya existe");}
        contactoDAO.insertWithoutID(contacto);
    }

    public ArrayList<Contacto> findByFilters(String nombre, String correo, String numero){
        return new ArrayList<>(contactoDAO.findByFilters(0,nombre,numero,correo));
    }
}
