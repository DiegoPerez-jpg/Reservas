package com.mycompany.reservadiego.DAOS;

import com.mycompany.reservadiego.conexion.Conexion;
import com.mycompany.reservadiego.modelos.Congreso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCongreso {

public void insert(Congreso entity) {
    String sql = "INSERT INTO congreso (int(11), int(11), int(11)) VALUES (?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(1, entity.getId());
ps.setInt(2, entity.getFkidevento());
ps.setInt(3, entity.getNumerojornadas());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public void insertWithoutId(Congreso entity) {
        String sql = "INSERT INTO congreso ( fkdeevento, numerojornadas) VALUES ( ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getFkidevento());
            ps.setInt(2, entity.getNumerojornadas());        ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


public void update(Congreso congreso) {
    String sql = "UPDATE congreso SET fkidevento = ?, numerojornadas = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, congreso.getFkidevento());
        ps.setInt(2, congreso.getNumerojornadas());
        ps.setInt(3, congreso.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM congreso WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Congreso> findAll() {
    List<Congreso> list = new ArrayList<>();
    String sql = "SELECT * FROM congreso";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Congreso(rs.getInt("id"), rs.getInt("fkidevento"), rs.getInt("numerojornadas")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Congreso findById(int id) {
    String sql = "SELECT * FROM congreso WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Congreso(rs.getInt("id"), rs.getInt("fkidevento"), rs.getInt("numerojornadas"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}