package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EnfrentamientoDAO {
    public static ArrayList<Integer> obtenerEnfrentamientos() {
        ArrayList<Integer> id_enfrentamientos = new ArrayList<Integer>();
        try {
          BaseDatos.abrirConexion();
          Connection con = BaseDatos.abrirConexion();
          String plantilla = "SELECT IDENF FROM ENFRENTAMIENTOS";
          PreparedStatement ps = con.prepareStatement(plantilla);
          ResultSet rs = ps.executeQuery();
          id_enfrentamientos.clear();
          while (rs.next()) {
              id_enfrentamientos.add(rs.getInt("IDENF"));
          }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return id_enfrentamientos;
    }
}
