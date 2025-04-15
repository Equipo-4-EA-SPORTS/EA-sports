package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase EquipoDAO que gestiona las operaciones relacionadas con la tabla de equipos en la base de datos.
 */
public class EquipoDAO {

    /**
     * Inscribe un equipo en la base de datos con el nombre y la fecha de fundación proporcionados.
     *
     * @param nombre Nombre del equipo.
     * @param fecha Fecha de fundación del equipo.
     * @return true si el equipo fue inscrito correctamente, false en caso contrario.
     */
    public static boolean inscribirEquipo(String nombre,LocalDate fecha){
        boolean encontrado=false;

        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "INSERT INTO equipos (nombre,fechafund) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1,nombre);

            java.sql.Date fechafund = java.sql.Date.valueOf(fecha);

            ps.setDate(2, fechafund);

            int filas = ps.executeUpdate();
            if(filas>0){
                encontrado=true;
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return encontrado;
    }
    /**
     * Busca un equipo en la base de datos por su nombre.
     *
     * @param nombre Nombre del equipo a buscar.
     * @return true si el equipo fue encontrado, false en caso contrario.
     */
    public static boolean buscarEquipo(String nombre){
        boolean encontrado=false;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();
            String plantilla = "SELECT * FROM equipos WHERE nombre = ?";

            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                encontrado=true;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return encontrado;
    }
    /**
     * Busca el nombre de un equipo en la base de datos por su identificador.
     *
     * @param id Identificador del equipo.
     * @return El nombre del equipo si se encuentra, una cadena vacía en caso contrario.
     */
    public static String buscarEquipoPK(int id){
        String nombreEquipo = "";
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();
            String plantilla = "SELECT nombre FROM equipos WHERE idEquipo = ?";

            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nombreEquipo=rs.getString("nombre");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return nombreEquipo;
    }

    /**
     * Obtiene una lista con los nombres de todos los equipos en la base de datos.
     *
     * @return Una lista de nombres de equipos.
     */
    public static List<String> listaEquipos(){
        List<String> equipos = new ArrayList<>();

        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM equipos");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                equipos.add(rs.getString(1));
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return equipos;
    }
    /**
     * Elimina un equipo de la base de datos por su nombre.
     *
     * @param equipoSeleccionado Nombre del equipo a eliminar.
     * @return true si el equipo fue eliminado correctamente, false en caso contrario.
     */
    public static boolean eliminarEquipo(String equipoSeleccionado){
        boolean eliminado = false;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "DELETE FROM equipos WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1,equipoSeleccionado);

            int filas = ps.executeUpdate();
            if(filas > 0){
                eliminado = true;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return eliminado;
    }

    /**
     * Obtiene una lista de equipos con sus respectivas fechas de fundación.
     *
     * @return Una lista de arreglos de cadenas, donde cada arreglo contiene el nombre y la fecha de fundación de un equipo.
     */
    public static List<String[]> obtenerEquiposConFechas() {
        List<String[]> equipos = new ArrayList<>();

        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT nombre, fechafund FROM equipos";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String fecha = rs.getDate("fechafund").toString();
                equipos.add(new String[]{nombre, fecha});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return equipos;
    }
    /**
     * Verifica si hay más de dos equipos registrados en la base de datos.
     *
     * @return true si hay más de dos equipos, false en caso contrario.
     */
    public static boolean hayMasDeDosEquipos() {
        boolean resultado = false;

        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT COUNT(*) AS total FROM equipos";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int cantidad = rs.getInt("total");
                resultado = cantidad >= 2;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }

        return resultado;
    }
    /**
     * Verifica si la cantidad de equipos registrados en la base de datos es par.
     *
     * @return true si la cantidad de equipos es par, false en caso contrario.
     */
    public static boolean hayCantidadParDeEquipos() {
        boolean resultado = false;

        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT COUNT(*) AS total FROM equipos";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int cantidad = rs.getInt("total");
                resultado = cantidad % 2 == 0;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }

        return resultado;
    }

    /**
     * Modifica el nombre y/o la fecha de fundación de un equipo en la base de datos.
     *
     * @param nuevoNombre Nuevo nombre del equipo.
     * @param nuevaFecha Nueva fecha de fundación del equipo.
     * @param nombre Nombre actual del equipo.
     * @return true si el equipo fue actualizado correctamente, false en caso contrario.
     */
    public static boolean modificarEquipo(String nuevoNombre, LocalDate nuevaFecha, String nombre){
        boolean actualizado = false;

        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String sentencia = "UPDATE equipos SET nombre = ?, fechafund = ? Where nombre = ?";

            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1,nuevoNombre);
            ps.setDate(2,java.sql.Date.valueOf(nuevaFecha));
            ps.setString(3,nombre);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas>0){
                actualizado = true;
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }

        return actualizado;
    }
    /**
     * Modifica solo el nombre de un equipo en la base de datos.
     *
     * @param nuevoNombre Nuevo nombre del equipo.
     * @param nombre Nombre actual del equipo.
     * @return true si el equipo fue actualizado correctamente, false en caso contrario.
     */
    public static boolean modificarEquipo(String nuevoNombre,String nombre){
        boolean actualizado = false;
        try{

            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String sentencia = "UPDATE equipos SET nombre = ? Where nombre = ?";

            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1,nuevoNombre);
            ps.setString(2,nombre);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas>0){
                actualizado = true;
            }


        }catch (Exception e){
            e.printStackTrace(); // Opcional: lo imprime en consola

            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }

        return actualizado;
    }
    /**
     * Modifica solo la fecha de fundación de un equipo en la base de datos.
     *
     * @param nuevaFecha Nueva fecha de fundación del equipo.
     * @param nombre Nombre actual del equipo.
     * @return true si el equipo fue actualizado correctamente, false en caso contrario.
     */
    public static boolean modificarEquipo(LocalDate nuevaFecha,String nombre){

        boolean actualizado = false;
        try{

            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String sentencia = "UPDATE equipos SET fechafund = ? Where nombre = ?";

            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setDate(1,java.sql.Date.valueOf(nuevaFecha));
            ps.setString(2,nombre);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas>0){
                actualizado = true;
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return actualizado;
    }

    /**
     * Obtiene el identificador único de un equipo en la base de datos por su nombre.
     *
     * @param nombre Nombre del equipo.
     * @return El identificador del equipo si se encuentra, 0 en caso contrario.
     */
    public static int obtenerPKequipo(String nombre){
        int idEquipo = 0;
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT idEquipo FROM equipos Where nombre=?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                idEquipo = rs.getInt("idEquipo");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return idEquipo;
    }




}