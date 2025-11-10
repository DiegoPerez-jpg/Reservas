package com.mycompany.reservadiego.DAOS;

import com.mycompany.reservadiego.conexion.Conexion;
import com.mycompany.reservadiego.modelos.Contacto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOContacto {

public void insert(Contacto entity) {
    String sql = "INSERT INTO contacto (id, nombre, numero, correo) VALUES (?, ?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(1, entity.getId());
ps.setString(2, entity.getNombre());
ps.setString(3, entity.getNumero());
ps.setString(4, entity.getCorreo());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void insertWithoutID(Contacto entity) {
    String sql = "INSERT INTO contacto (nombre, numero, correo) VALUES ( ?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, entity.getNombre());
        ps.setString(2, entity.getNumero());
        ps.setString(3, entity.getCorreo());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Contacto contacto) {
    String sql = "UPDATE contacto SET nombre = ?, numero = ?, correo = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, contacto.getNombre());
        ps.setString(2, contacto.getNumero());
        ps.setString(3, contacto.getCorreo());
        ps.setInt(4, contacto.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM contacto WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Contacto> findAll() {
    List<Contacto> list = new ArrayList<>();
    String sql = "SELECT * FROM contacto";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Contacto(rs.getInt("id"), rs.getString("nombre"), rs.getString("numero"), rs.getString("correo")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Contacto findById(int id) {
    String sql = "SELECT * FROM contacto WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Contacto(rs.getInt("id"), rs.getString("nombre"), rs.getString("numero"), rs.getString("correo"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}