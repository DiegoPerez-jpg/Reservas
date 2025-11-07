package com.mycompany.reservadiego.Service;

import com.mycompany.reservadiego.DAO.ServicioCocinaDAO;
import com.mycompany.reservadiego.Modelo.ServicioCocina;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CocinaService {

    private static CocinaService instancia;
    private ServicioCocinaDAO cocinaDAO;

    // 🔒 Constructor privado: evita instanciación directa
    private CocinaService() {
        this.cocinaDAO = new ServicioCocinaDAO(Conexion.getConnection());
    }

    // 🧠 Método Singleton: obtiene la única instancia del servicio
    public static CocinaService getInstancia() {
        if (instancia == null) {
            instancia = new CocinaService();
        }
        return instancia;
    }


    public static int obtenerPorNOmbre(String name){
        try {
           int id = getInstancia().cocinaDAO.obtenerPorNombre(name).getId(); 
            return id;

        } catch (SQLException e) {
            System.out.println("Error no existe el name");
        }
        return -1;
    }
}
