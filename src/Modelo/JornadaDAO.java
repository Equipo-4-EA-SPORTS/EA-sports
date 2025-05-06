package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    /**
     * Obtiene una lista de jornadas con sus fechas de inicio y fin desde la base de datos.
     *
     * @return Una lista de arreglos de cadenas, donde cada arreglo contiene dos elementos:
     *         la fecha de inicio y la fecha de fin de una jornada.
     *         Si ocurre un error, se devuelve una lista vacía.
     */
    public static List<String[]> obtenerJornadas() {
        List<String[]> jornadas = new ArrayList<>();
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT fechainicio,fechafin FROM jornadas";
            PreparedStatement ps = con.prepareStatement(plantilla);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String fechaInicio = rs.getDate("fechainicio").toString();
                String fechaFin = rs.getDate("fechafin").toString();
                jornadas.add(new String[]{fechaInicio, fechaFin});
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return jornadas;
    }
    /**
     * Obtiene una lista de los números de jornadas existentes en la base de datos.
     *
     * @return Una lista de cadenas, donde cada cadena representa el número de una jornada.
     *         Si ocurre un error, se devuelve una lista vacía.
     */
    public static List<String> listaJornadas() {
        List<String> jornadas = new ArrayList<>();
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT numJornada FROM jornadas";
            PreparedStatement ps = con.prepareStatement(plantilla);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jornadas.add(rs.getString(1));
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return jornadas;
    }

}