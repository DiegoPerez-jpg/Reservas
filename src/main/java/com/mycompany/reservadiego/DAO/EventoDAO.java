/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author m
 */
package com.mycompany.reservadiego.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.reservadiego.Modelo.Evento;

public class EventoDAO {

    private Connection conexion;

    public EventoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // INSERTAR
    public void insertar(Evento evento) throws SQLException {
        String sql = "INSERT INTO evento (id, fecha, cantidad_personas, fk_tipo_evento, fk_servicio_cocina, fk_contacto) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, evento.getId());
            ps.setDate(2, Date.valueOf(evento.getFecha()));
            ps.setInt(3, evento.getCantidadPersonas());
            ps.setInt(4, evento.getFkTipoEvento());
            ps.setInt(5, evento.getFkServicioCocina());
            ps.setInt(6, evento.getFkContacto());
            ps.executeUpdate();
        }
    }

    // OBTENER TODOS
    public List<Evento> obtenerTodos() throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM evento";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Evento e = new Evento(
                        rs.getInt("id"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("cantidad_personas"),
                        rs.getInt("fk_tipo_evento"),
                        rs.getInt("fk_servicio_cocina"),
                        rs.getInt("fk_contacto")
                );
                eventos.add(e);
            }
        }
        return eventos;
    }

    // OBTENER POR ID
    public Evento obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM evento WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Evento(
                        rs.getInt("id"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("cantidad_personas"),
                        rs.getInt("fk_tipo_evento"),
                        rs.getInt("fk_servicio_cocina"),
                        rs.getInt("fk_contacto")
                );
            }
        }
        return null;
    }

    // ACTUALIZAR
    public void actualizar(Evento evento) throws SQLException {
        String sql = "UPDATE evento SET fecha = ?, cantidad_personas = ?, fk_tipo_evento = ?, fk_servicio_cocina = ?, fk_contacto = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(evento.getFecha()));
            ps.setInt(2, evento.getCantidadPersonas());
            ps.setInt(3, evento.getFkTipoEvento());
            ps.setInt(4, evento.getFkServicioCocina());
            ps.setInt(5, evento.getFkContacto());
            ps.setInt(6, evento.getId());
            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM evento WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
