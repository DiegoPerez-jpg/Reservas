package com.mycompany.reservadiego.Servicios;

import com.mycompany.reservadiego.DAOS.DAOCocina;
import com.mycompany.reservadiego.DAOS.DAOContacto;
import com.mycompany.reservadiego.DAOS.DAOEvento;
import com.mycompany.reservadiego.Exception.UserNotFound;
import com.mycompany.reservadiego.modelos.*;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.List;

public class EventoService {
    private final DAOEvento evento = new DAOEvento();

    public Evento getLastEvento(){
        List<Evento> lista = evento.findAll();
        if (!lista.isEmpty()) {
            return lista.get(lista.size() - 1);
        } else {
            return null;
        }
    }
    public void crearEvento(String numero, LocalDate date, Tipoevento tipoevento, int numeroPersonas, Cocina cocina, Boolean habitaciones) throws  UserNotFound {
        Contacto contacto = new ContactoService().buscarPorNumero(numero);
        if(contacto == null){
            throw new UserNotFound();
        }

        Evento evento = new Evento(
                0,
                contacto.getId(),
                tipoevento.getId(),
                cocina.getId(),
                numeroPersonas,
                Boolean.compare(habitaciones, false)
        );

        new DAOEvento().insertWithoutID(evento);
    }

    public void cancelarReserva(int id){
        evento.delete(id);
    }
}
