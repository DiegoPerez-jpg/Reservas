package com.mycompany.reservadiego.DTO;

public class EventoCompletoDTO {
    private String numeroTelefono;
    private String correoElectronico;
    private String tipoEvento;
    private String cocina;
    private int numeroPersonas;
    private boolean requiereHabitaciones;
    private int jornadas;
    private String nombreCompleto;

    public EventoCompletoDTO(String nombreCompleto, String numeroTelefono, String correoElectronico,
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public String getCocina() {
        return cocina;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public boolean isRequiereHabitaciones() {
        return requiereHabitaciones;
    }

    public int getJornadas() {
        return jornadas;
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
