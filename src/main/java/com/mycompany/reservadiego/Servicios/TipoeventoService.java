package com.mycompany.reservadiego.Servicios;

import com.mycompany.reservadiego.DAOS.DAOContacto;
import com.mycompany.reservadiego.DAOS.DAOTipoevento;
import com.mycompany.reservadiego.modelos.Cocina;
import com.mycompany.reservadiego.modelos.Congreso;
import com.mycompany.reservadiego.modelos.Tipoevento;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TipoeventoService {
    private final DAOTipoevento tipoeventoDAO = new DAOTipoevento();

    public int getIdByNombre(String nombre){
        return getTipoEventoByNombre(nombre).getId();
    }

    public Tipoevento getTipoEventoByNombre(String nombre){
        return tipoeventoDAO.findAll().stream().filter(p-> p.getTipoevento().equals(nombre)).findFirst().orElse(null);
    }

    public ArrayList<String> getNombres(){
        return tipoeventoDAO.findAll().stream().map(Tipoevento::getTipoevento).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Tipoevento> findAll(){
        return new ArrayList<>(tipoeventoDAO.findAll());
    }

    public ArrayList<Tipoevento> findByFilters(int id, String nombre){
        return new ArrayList<>(tipoeventoDAO.findByFilters(id,nombre));
    }


}
