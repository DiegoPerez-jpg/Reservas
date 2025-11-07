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
import com.mycompany.reservadiego.Modelo.ServicioCocina;

public class ServicioCocinaDAO {

    private Connection conexion;

    public ServicioCocinaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public static ServicioCocinaDAO create(){
        return new ServicioCocinaDAO(null);
    }

    // INSERTAR
    public void insertar(ServicioCocina servicio) throws SQLException {
        String sql = "INSERT INTO servicio_cocina (id, nombre) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, servicio.getId());
            ps.setString(2, servicio.getNombre());
            ps.executeUpdate();
        }
    }

    // OBTENER TODOS
    public List<ServicioCocina> obtenerTodos() throws SQLException {
        List<ServicioCocina> lista = new ArrayList<>();
        String sql = "SELECT * FROM servicio_cocina";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new ServicioCocina(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }
        }
        return lista;
    }

    // OBTENER POR ID
    public ServicioCocina obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM servicio_cocina WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ServicioCocina(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
            }
        }
        return null;
    }

    // OBTENER POR ID
    public ServicioCocina obtenerPorNombre(String name) throws SQLException {
        String sql = "SELECT * FROM servicio_cocina WHERE name = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ServicioCocina(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
            }
        }
        return null;
    }

    // ACTUALIZAR
    public void actualizar(ServicioCocina servicio) throws SQLException {
        String sql = "UPDATE servicio_cocina SET nombre = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, servicio.getNombre());
            ps.setInt(2, servicio.getId());
            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM servicio_cocina WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
