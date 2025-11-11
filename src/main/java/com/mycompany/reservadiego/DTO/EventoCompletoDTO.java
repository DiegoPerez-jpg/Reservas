package com.mycompany.reservadiego.DTO;

public class EventoCompletoDTO {
    public int numeroTelefono;
    public String correoElectronico;
    public String tipoEvento;
    public String cocina;
    public int numeroPersonas;
    public boolean requiereHabitaciones;
    public int jornadas;
    public String nombreCompleto;

    public EventoCompletoDTO(String nombreCompleto, int numeroTelefono, String correoElectronico,
                             String tipoEvento, String cocina, int numeroPersonas, boolean requiereHabitaciones,int jornadas) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.correoElectronico = correoElectronico;
        this.tipoEvento = tipoEvento;
        this.cocina = cocina;
        this.numeroPersonas = numeroPersonas;
        this.requiereHabitaciones = requiereHabitaciones;
        this.jornadas = jornadas;
    }

    public Object[] toObject(){
        return new Object[]{nombreCompleto,numeroTelefono,correoElectronico,tipoEvento,cocina,numeroPersonas,requiereHabitaciones,tipoEvento,cocina,numeroPersonas,requiereHabitaciones,jornadas};
    }

    @Override
    public String toString() {
        return "EventoCompletoDTO{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", numeroTelefono=" + numeroTelefono +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", cocina='" + cocina + '\'' +
                ", numeroPersonas=" + numeroPersonas +
                ", requiereHabitaciones=" + (requiereHabitaciones ? "Sí" : "No") +
                ", jornadas=" + jornadas +
                '}';
    }
}
