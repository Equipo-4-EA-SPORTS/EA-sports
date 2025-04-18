package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 * Clase JornadaDAO que gestiona las operaciones relacionadas con la tabla de jornadas en la base de datos.
 */
public class JornadaDAO {

    /**
     * Crea una nueva jornada en la base de datos con la fecha de inicio proporcionada.
     * La fecha de fin se calcula automáticamente sumando una semana a la fecha de inicio.
     *
     * @param fechaInicio Fecha de inicio de la jornada.
     * @return true si la jornada fue creada correctamente, false en caso contrario.
     */
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



    /**
     * Verifica si existe una jornada en la base de datos con el número de jornada proporcionado.
     *
     * @param numJornada Número de la jornada a verificar.
     * @return true si la jornada existe, false en caso contrario.
     */
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