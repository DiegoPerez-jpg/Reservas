package com.mycompany.reservadiego.Servicios;


import com.mycompany.reservadiego.DAOS.DAOCocina;
import com.mycompany.reservadiego.modelos.Cocina;
import com.mycompany.reservadiego.modelos.Tipoevento;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CocinaService {
    private final DAOCocina cocinaDAO = new DAOCocina();

    public ArrayList<String> getNombres(){
        return cocinaDAO.findAll().stream().map(Cocina::getTipococina).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getIdByNombre(String nombre){
        return getCocinaByNombre(nombre).getId();
    }

    public Cocina getCocinaByNombre(String nombre){
        return cocinaDAO.findAll().stream().filter(p-> p.getTipococina().equals(nombre)).findFirst().orElse(null);
    }

}
