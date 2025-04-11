package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class JornadaDAO {

    public static boolean crearJornada(LocalDate fechaInicio) {
        boolean encontrado = false;

        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            LocalDate fechaFin = fechaInicio.plusWeeks(1);

            String plantilla = "INSERT INTO jornadas (fechaInicio, fechaFin) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(plantilla);

            java.sql.Date fechaInicioSql = java.sql.Date.valueOf(fechaInicio);
            java.sql.Date fechaFinSql = java.sql.Date.valueOf(fechaFin);

            ps.setDate(1, fechaInicioSql);
            ps.setDate(2, fechaFinSql);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                encontrado = true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return encontrado;
    }



    public static boolean existeJornada(String numJornada) {
        boolean existe = false;
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String consulta = "SELECT COUNT(*) FROM jornadas WHERE numJornada = ?";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, numJornada);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = rs.getInt(1) > 0;  // Si el count es mayor que 0, significa que ya existe
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return existe;
    }

}