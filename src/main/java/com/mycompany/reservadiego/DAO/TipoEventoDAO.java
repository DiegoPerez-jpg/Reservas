/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reservadiego.DAO;

/**
 *
 * @author m
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.reservadiego.Modelo.TipoEvento;

public class TipoEventoDAO {

    private Connection conexion;

    public TipoEventoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // INSERTAR
    public void insertar(TipoEvento tipoEvento) throws SQLException {
        String sql = "INSERT INTO tipo_evento (id, nombre) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, tipoEvento.getId());
            ps.setString(2, tipoEvento.getNombre());
            ps.executeUpdate();
        }
    }

    // OBTENER TODOS
    public List<TipoEvento> obtenerTodos() throws SQLException {
        List<TipoEvento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipo_evento";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new TipoEvento(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }
        }
        return lista;
    }

    // OBTENER POR ID
    public TipoEvento obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM tipo_evento WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new TipoEvento(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
            }
        }
        return null;
    }

    public TipoEvento obtenerPorNombre(String name) throws SQLException {
        String sql = "SELECT * FROM tipo_evento WHERE name = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new TipoEvento(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
            }
        }
        return null;
    }
    // ACTUALIZAR
    public void actualizar(TipoEvento tipoEvento) throws SQLException {
        String sql = "UPDATE tipo_evento SET nombre = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, tipoEvento.getNombre());
            ps.setInt(2, tipoEvento.getId());
            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM tipo_evento WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
