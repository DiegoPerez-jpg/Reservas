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
import com.mycompany.reservadiego.Modelo.Contacto;

public class ContactoDAO {

    private Connection conexion;

    // Constructor que recibe la conexión
    public ContactoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar un contacto
    public void insertar(Contacto contacto) throws SQLException {
        String sql = "INSERT INTO contacto (id, nombre_completo, telefono, correo_electronico) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, contacto.getId());
            ps.setString(2, contacto.getNombreCompleto());
            ps.setString(3, contacto.getTelefono());
            ps.setString(4, contacto.getCorreoElectronico());
            ps.executeUpdate();
        }
    }

    // Método para obtener todos los contactos
    public List<Contacto> obtenerTodos() throws SQLException {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contacto";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Contacto c = new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre_completo"),
                        rs.getString("telefono"),
                        rs.getString("correo_electronico")
                );
                contactos.add(c);
            }
        }
        return contactos;
    }

    // Método para buscar un contacto por id
    public Contacto obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM contacto WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre_completo"),
                        rs.getString("telefono"),
                        rs.getString("correo_electronico")
                );
            }
        }
        return null; // No encontrado
    }

    // Método para actualizar un contacto
    public void actualizar(Contacto contacto) throws SQLException {
        String sql = "UPDATE contacto SET nombre_completo = ?, telefono = ?, correo_electronico = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, contacto.getNombreCompleto());
            ps.setString(2, contacto.getTelefono());
            ps.setString(3, contacto.getCorreoElectronico());
            ps.setInt(4, contacto.getId());
            ps.executeUpdate();
        }
    }

    // Método para eliminar un contacto
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM contacto WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
