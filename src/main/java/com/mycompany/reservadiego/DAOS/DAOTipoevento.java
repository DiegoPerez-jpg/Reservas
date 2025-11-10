package com.mycompany.reservadiego.DAOS;

import com.mycompany.reservadiego.conexion.Conexion;
import com.mycompany.reservadiego.modelos.Tipoevento;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOTipoevento {

public void insert(Tipoevento entity) {
    String sql = "INSERT INTO tipoevento (int(11), varchar(100)) VALUES (?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(01, entity.getId());
ps.setString(11, entity.getTipoevento());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Tipoevento tipoevento) {
    String sql = "UPDATE tipoevento SET tipoevento = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, tipoevento.getTipoevento());
        ps.setInt(2, tipoevento.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM tipoevento WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Tipoevento> findAll() {
    List<Tipoevento> list = new ArrayList<>();
    String sql = "SELECT * FROM tipoevento";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Tipoevento(rs.getInt("id"), rs.getString("tipoevento")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Tipoevento findById(int id) {
    String sql = "SELECT * FROM tipoevento WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Tipoevento(rs.getInt("id"), rs.getString("tipoevento"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}