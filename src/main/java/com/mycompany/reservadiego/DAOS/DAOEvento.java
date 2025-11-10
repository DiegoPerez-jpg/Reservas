package com.mycompany.reservadiego.DAOS;

import com.mycompany.reservadiego.conexion.Conexion;
import com.mycompany.reservadiego.modelos.Contacto;
import com.mycompany.reservadiego.modelos.Evento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEvento {

public void insert(Evento entity) {
    String sql = "INSERT INTO evento (id, fkidcontacto, fkttipodeevento, fktipodecocina, numeropersonas, requierehabitaciones) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(1, entity.getId());
ps.setInt(2, entity.getFkidcontacto());
ps.setInt(3, entity.getFkidtipodeevento());
ps.setInt(4, entity.getFkidtipodecocina());
ps.setInt(5, entity.getNumeropersonas());
ps.setInt(6, entity.getRequierehabitaciones());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void insertWithoutID(Evento entity) {
    String sql = "INSERT INTO evento (fkIdContacto, fkIdTipoDeEvento, fkIdTipoDeCocina, numeroPersonas, requiereHabitaciones) VALUES ( ?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, entity.getFkidcontacto());
        ps.setInt(2, entity.getFkidtipodeevento());
        ps.setInt(3, entity.getFkidtipodecocina());
        ps.setInt(4, entity.getNumeropersonas());
        ps.setInt(5, entity.getRequierehabitaciones());          ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Evento evento) {
    String sql = "UPDATE evento SET fkidcontacto = ?, fkidtipodeevento = ?, fkidtipodecocina = ?, numeropersonas = ?, requierehabitaciones = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, evento.getFkidcontacto());
        ps.setInt(2, evento.getFkidtipodeevento());
        ps.setInt(3, evento.getFkidtipodecocina());
        ps.setInt(4, evento.getNumeropersonas());
        ps.setInt(5, evento.getRequierehabitaciones());
        ps.setInt(6, evento.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public List<Evento> findByFilters(int fkidcontacto, int fkidtipodeevento, int fkidtipodecocina, int numeropersonas, int requierehabitaciones) {
        List<Evento> list = new ArrayList<>();
        String sql = "SELECT * FROM evento WHERE " +
                "(fkidcontacto = ? OR ? = 0) AND " +
                "(fkidtipodeevento = ? OR ? = 0) AND " +
                "(fkidtipodecocina = ? OR ? = 0) AND " +
                "(numeropersonas = ? OR ? = 0) AND " +
                "(requierehabitaciones = ? OR ? = 0)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, fkidcontacto);
            ps.setInt(2, fkidcontacto);
            ps.setInt(3, fkidtipodeevento);
            ps.setInt(4, fkidtipodeevento);
            ps.setInt(5, fkidtipodecocina);
            ps.setInt(6, fkidtipodecocina);
            ps.setInt(7, numeropersonas);
            ps.setInt(8, numeropersonas);
            ps.setInt(9, requierehabitaciones);
            ps.setInt(10, requierehabitaciones);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Evento(
                        rs.getInt("id"),
                        rs.getInt("fkidcontacto"),
                        rs.getInt("fkidtipodeevento"),
                        rs.getInt("fkidtipodecocina"),
                        rs.getInt("numeropersonas"),
                        rs.getInt("requierehabitaciones")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


public void delete(int id) {
    String sql = "DELETE FROM evento WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Evento> findAll() {
    List<Evento> list = new ArrayList<>();
    String sql = "SELECT * FROM evento";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Evento(rs.getInt("id"), rs.getInt("fkidcontacto"), rs.getInt("fkidtipodeevento"), rs.getInt("fkidtipodecocina"), rs.getInt("numeropersonas"), rs.getInt("requierehabitaciones")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Evento findById(int id) {
    String sql = "SELECT * FROM evento WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Evento(rs.getInt("id"), rs.getInt("fkidcontacto"), rs.getInt("fkidtipodeevento"), rs.getInt("fkidtipodecocina"), rs.getInt("numeropersonas"), rs.getInt("requierehabitaciones"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}