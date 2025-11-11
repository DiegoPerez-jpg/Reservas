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

    public List<Evento> findByFilters(int fkidcontacto, int fkidtipodeevento, int fkidtipodecocina,
                                      int numeropersonas, int requierehabitaciones) {
        System.out.println(fkidcontacto+ " " + fkidtipodecocina + " " + numeropersonas + " " + requierehabitaciones+" " + fkidtipodeevento);
        List<Evento> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM evento WHERE 1=1");
        List<Integer> parametros = new ArrayList<>();

        if (fkidcontacto != 0) {
            sql.append(" AND fkidcontacto = ?");
            parametros.add(fkidcontacto);
        }
        if (fkidtipodeevento != 0) {
            sql.append(" AND fkidtipodeevento = ?");
            parametros.add(fkidtipodeevento);
        }
        if (fkidtipodecocina != 0) {
            sql.append(" AND fkidtipodecocina = ?");
            parametros.add(fkidtipodecocina);
        }
        if (numeropersonas != 0) {
            sql.append(" AND numeropersonas = ?");
            parametros.add(numeropersonas);
        }
        if (requierehabitaciones != 0) {
            sql.append(" AND requierehabitaciones = ?");
            parametros.add(requierehabitaciones);
        }

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < parametros.size(); i++) {
                ps.setInt(i + 1, parametros.get(i));
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("0");
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