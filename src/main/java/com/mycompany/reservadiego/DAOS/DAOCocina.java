package com.mycompany.reservadiego.DAOS;

import com.mycompany.reservadiego.conexion.Conexion;
import com.mycompany.reservadiego.modelos.Cocina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCocina {

public void insert(Cocina entity) {
    String sql = "INSERT INTO cocina (int(11), varchar(100)) VALUES (?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(1, entity.getId());
ps.setString(2, entity.getTipococina());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public List<Cocina> findByFilters(int id, String tipococina) {
        List<Cocina> list = new ArrayList<>();
        String sql = "SELECT * FROM cocina WHERE " +
                "(id = ? OR ? = 0) AND " +
                "(tipococina = ? OR ? = '')";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.setString(3, tipococina);
            ps.setString(4, tipococina);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Cocina(
                        rs.getInt("id"),
                        rs.getString("tipococina")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }



public void update(Cocina cocina) {
    String sql = "UPDATE cocina SET tipococina = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, cocina.getTipococina());
        ps.setInt(2, cocina.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM cocina WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Cocina> findAll() {
    List<Cocina> list = new ArrayList<>();
    String sql = "SELECT * FROM cocina";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Cocina(rs.getInt("id"), rs.getString("tipococina")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Cocina findById(int id) {
    String sql = "SELECT * FROM cocina WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Cocina(rs.getInt("id"), rs.getString("tipococina"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}