package com.mycompany.reservadiego.Servicios;

import com.mycompany.reservadiego.DAOS.DAOCocina;
import com.mycompany.reservadiego.DAOS.DAOCongreso;
import com.mycompany.reservadiego.DAOS.DAOContacto;
import com.mycompany.reservadiego.DAOS.DAOEvento;
import com.mycompany.reservadiego.DTO.EventoCompletoDTO;
import com.mycompany.reservadiego.Exception.UserNotFound;
import com.mycompany.reservadiego.modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public ArrayList<Evento> findByFilters(int fkidcontacto, int fkidtipodeevento, int fkidtipodecocina, int numeropersonas, int requierehabitaciones){
        return new ArrayList<>(evento.findByFilters(fkidcontacto,fkidtipodeevento,fkidtipodecocina,numeropersonas,requierehabitaciones));
    }
    public void cancelarReserva(int id){
        evento.delete(id);
    }


    public Object[]  getEventosCompletos(String nombre, String correo, int numero, String cocina, String tipoEvento, Boolean habitaciones, int numeroPersonas, int numeroJornadas) {
        ArrayList<EventoCompletoDTO> eventosCompletos = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();

        EventoService eventoService = new EventoService();
        CocinaService cocinaService = new CocinaService();
        TipoeventoService tipoeventoService = new TipoeventoService();
        ContactoService contactoService = new ContactoService();

        ArrayList<Evento> eventos = eventoService.findByFilters(0, 0, 0, numeroPersonas, habitaciones ? 1 : 0);
        ArrayList<Cocina> cocinas = cocinaService.findByFilters(0, cocina);
        ArrayList<Tipoevento> tipoEventos = tipoeventoService.findByFilters(0, tipoEvento);
        ArrayList<Contacto> contactos = contactoService.findByFilters(nombre, correo, numero);

        for (Evento evento : eventos) {
            Contacto contacto = contactos.stream()
                    .filter(c -> c.getId() == evento.getFkidcontacto())
                    .findFirst().orElse(null);

            Cocina cocinaObj = cocinas.stream()
                    .filter(c -> c.getId() == evento.getFkidtipodecocina())
                    .findFirst().orElse(null);

            Tipoevento tipoEventoObj = tipoEventos.stream()
                    .filter(t -> t.getId() == evento.getFkidtipodeevento())
                    .findFirst().orElse(null);
            Congreso congreso =  new DAOCongreso().findById(evento.getId());
            if(congreso!=null && congreso.getNumerojornadas()!=numeroJornadas ) congreso = null;
            // Solo añadimos si todos existen (como INNER JOIN)
            if (contacto != null && cocinaObj != null && tipoEventoObj != null) {
                EventoCompletoDTO dto = new EventoCompletoDTO(
                        contacto.getNombre(),
                        Integer.parseInt(contacto.getNumero()),
                        contacto.getCorreo(),
                        tipoEventoObj.getTipoevento(),
                        cocinaObj.getTipococina(),
                        evento.getNumeropersonas(),
                        evento.getRequierehabitaciones() == 1,
                        congreso == null ? 0 : congreso.getId()
                );
                System.out.println(dto);
                eventosCompletos.add(dto);
                ids.add(evento.getId());
            }
        }

        return new Object[]{eventosCompletos,ids};
    }
}
