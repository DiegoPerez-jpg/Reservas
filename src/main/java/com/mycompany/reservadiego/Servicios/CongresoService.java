package com.mycompany.reservadiego.Servicios;

import com.mycompany.reservadiego.DAOS.DAOCongreso;
import com.mycompany.reservadiego.modelos.Cocina;
import com.mycompany.reservadiego.modelos.Congreso;
import com.mycompany.reservadiego.modelos.Congreso;
import com.mycompany.reservadiego.modelos.Evento;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CongresoService {
    private final DAOCongreso congresoDAO = new DAOCongreso();

    public void insertCongreso(int numero){
        int id = new EventoService().getLastEvento().getId();
        congresoDAO.insertWithoutId(new Congreso(0,id,numero));
    }
    public ArrayList<Congreso> findAll(){
        return congresoDAO.findAll().stream().collect(Collectors.toCollection(ArrayList::new));
    }
}
