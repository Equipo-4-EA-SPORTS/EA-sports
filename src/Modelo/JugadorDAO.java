package Modelo;

import oracle.jdbc.internal.OracleTypes;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Constructor por defecto que inicializa un jugador sin valores específicos.
 */
public class JugadorDAO {
    /**
     * Inscribe un jugador en la base de datos con los datos proporcionados.
     *
     * @param nombre Nombre del jugador.
     * @param apellido Apellido del jugador.
     * @param nacionalidad Nacionalidad del jugador.
     * @param fechaParseada Fecha de nacimiento del jugador.
     * @param nickname Apodo o nickname del jugador.
     * @param sueldoFloat Sueldo del jugador.
     * @param rol Rol del jugador.
     * @param equipo Nombre del equipo al que pertenece el jugador.
     * @return true si el jugador fue inscrito correctamente, false en caso contrario.
     */
    public static boolean inscribirJugador(String nombre, String apellido, String nacionalidad, LocalDate fechaParseada, String nickname, float sueldoFloat, String rol, String equipo) {
        boolean insertado = false;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();
            String plantilla = "INSERT INTO jugadores(NOMBRE,APELLIDO,NACIONALIDAD,FECHANAC,NICKNAME,SUELDO, ROL, IDEQUIPO) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, nacionalidad);
            java.sql.Date fechanac = java.sql.Date.valueOf(fechaParseada);

            ps.setDate(4, fechanac);
            ps.setString(5,nickname);
            ps.setFloat(6,sueldoFloat);
            ps.setString(7,rol);
            ps.setInt(8,EquipoDAO.obtenerPKequipo(equipo));
            int filasInsertadas = ps.executeUpdate();

            if (filasInsertadas>0){
                insertado = true;
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return insertado;
    }

    /**
     * Busca un jugador en la base de datos por su nombre.
     *
     * @param nombre Nombre del jugador a buscar.
     * @return true si el jugador fue encontrado, false en caso contrario.
     */
    public static boolean buscarJugador(String nombre){
        boolean encontrado=false;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();
            String plantilla = "SELECT * FROM jugadores WHERE nombre = ?";

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
     * Obtiene una lista con los nombres de todos los jugadores en la base de datos.
     *
     * @return Una lista de nombres de jugadores.
     */
    public static List<String> listaJugadores(){
        List<String> jugadores = new ArrayList<>();

        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM jugadores");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                jugadores.add(rs.getString(1));
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return jugadores;
    }
    /**
     * Elimina un jugador de la base de datos por su nombre.
     *
     * @param jugadorSeleccionado Nombre del jugador a eliminar.
     * @return true si el jugador fue eliminado correctamente, false en caso contrario.
     */
    public static boolean eliminarJugador(String jugadorSeleccionado){
        boolean eliminado = false;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "DELETE FROM jugadores WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1,jugadorSeleccionado);

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
     * Verifica si existe un jugador en la base de datos por su nickname.
     *
     * @param nickname Nickname del jugador a buscar.
     * @return true si el nickname existe, false en caso contrario.
     */

    public static boolean buscarNickname(String nickname) {
        boolean existe = false;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();
            String plantilla = "SELECT * FROM jugadores WHERE nickname = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1,nickname);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                existe = true;
            }
        }

        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return existe;
    }
    /**
     * Obtiene una lista de jugadores con sus datos personales y profesionales.
     *
     * @return Una lista de arreglos de cadenas, donde cada arreglo contiene los datos de un jugador.
     */
    public static List<String[]> obtenerJugadores() {
            List<String[]> jugadores = new ArrayList<>();

            try {
                BaseDatos.abrirConexion();
                Connection con = BaseDatos.getCon();

                String plantilla = "SELECT nombre, apellido, nacionalidad, fechanac, nickname, sueldo, rol, idequipo  FROM jugadores";
                PreparedStatement ps = con.prepareStatement(plantilla);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String nacionalidad = rs.getString("nacionalidad");
                    String fechaNac = String.valueOf(rs.getDate("fechaNac"));
                    String nickname = rs.getString("nickname");
                    String sueldo = String.valueOf(rs.getFloat("sueldo"));
                    String rol = rs.getString("rol");
                    String idequipo = EquipoDAO.buscarEquipoPK(rs.getInt("idequipo"));

                    jugadores.add(new String[]{nombre, apellido, nacionalidad, fechaNac, nickname, sueldo, rol, idequipo});
                }

            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return jugadores;

    }

    //Comprobacion Para CerrarCoompeticion
    /**
     * Verifica si todos los equipos tienen una cantidad válida de jugadores.
     * La cantidad válida es entre 2 y 6 jugadores por equipo.
     *
     * @return true si todos los equipos tienen una cantidad válida de jugadores, false en caso contrario.
     */
    public static boolean equiposConCantidadValidaDeJugadores() {
        boolean valido = true;

        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT idequipo, COUNT(*) AS cantidad FROM jugadores GROUP BY idequipo";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ResultSet rs = ps.executeQuery();

            while (rs.next() && valido) {
                int cantidad = rs.getInt("cantidad");

                if (cantidad < 2 || cantidad > 6) {
                    valido = false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            valido = false; // por si hay error, lo consideramos inválido
        }

        return valido;
    }

    public static int obtenerPKjugador(String jugador){
        int idJugador = 0;
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT idJugador FROM jugadores WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1,jugador);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                idJugador=rs.getInt("idJugador");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return idJugador;
    }

    public static String obtenerRolJugador(String jugador){
        String rol = "";
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "Select rol From jugadores WHERE idJugador = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setInt(1,obtenerPKjugador(jugador));
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                rol = rs.getString("rol");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return rol;
    }
    public static int obtenerEquipoJugador(int jugador){
        int idEquipo = 0;
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT idEquipo FROM jugadores WHERE idJugador = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setInt(1,jugador);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                idEquipo=rs.getInt("idEquipo");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return idEquipo;
    }

public static void informeJugadoresEquipo(String nombreEquipo) throws Exception {
    BaseDatos.abrirConexion();
    Connection con = BaseDatos.getCon();
    // Llamada al procedimiento almacenado
    CallableStatement cs = con.prepareCall("{ call obtener_jugadores_equipo(?, ?) }");
    cs.setString(1, "NombreDelEquipo");
    cs.registerOutParameter(2, OracleTypes.CURSOR);

    cs.execute();

    ResultSet rs = (ResultSet) cs.getObject(2);
    while (rs.next()) {
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String rol = rs.getString("rol");
        double sueldo = rs.getDouble("sueldo");

    }
}

}

