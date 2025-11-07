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
import com.mycompany.reservadiego.Modelo.Congreso;

public class CongresoDAO {

    private Connection conexion;

    public CongresoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // INSERTAR
    public void insertar(Congreso congreso) throws SQLException {
        String sql = "INSERT INTO congreso (id, fk_evento, numero_jornadas) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, congreso.getId());
            ps.setInt(2, congreso.getFkEvento());
            ps.setInt(3, congreso.getNumeroJornadas());
            ps.executeUpdate();
        }
    }

    // OBTENER TODOS
    public List<Congreso> obtenerTodos() throws SQLException {
        List<Congreso> lista = new ArrayList<>();
        String sql = "SELECT * FROM congreso";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Congreso(
                        rs.getInt("id"),
                        rs.getInt("fk_evento"),
                        rs.getInt("numero_jornadas")
                ));
            }
        }
        return lista;
    }

    // OBTENER POR ID
    public Congreso obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM congreso WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Congreso(
                        rs.getInt("id"),
                        rs.getInt("fk_evento"),
                        rs.getInt("numero_jornadas")
                );
            }
        }
        return null;
    }

    // ACTUALIZAR
    public void actualizar(Congreso congreso) throws SQLException {
        String sql = "UPDATE congreso SET fk_evento = ?, numero_jornadas = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, congreso.getFkEvento());
            ps.setInt(2, congreso.getNumeroJornadas());
            ps.setInt(3, congreso.getId());
            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM congreso WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
