package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JugadorDAO {
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


    public static void modificarJugador(String nombre, String apellido, String nacionalidad, LocalDate fecha, String nickname, float sueldoFloat, String rol, int equipoSeleccionado) {

        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "UPDATE JUGADORES SET " +
                    "NOMBRE = ?, " +
                    "APELLIDO = ?, " +
                    "NACIONALIDAD = ?, " +
                    "FECHANAC = ?, " +
                    "NICKNAME = ?, " +
                    "SUELDO = ?, " +
                    "ROL = ?, " +
                    "IDEQUIPO = ? " +
                    "WHERE NICKNAME = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, nacionalidad);
            ps.setString(4, String.valueOf(fecha));
            ps.setString(5, nickname);
            ps.setFloat(6, sueldoFloat);
            ps.setString(7, rol);
            ps.setInt(8, equipoSeleccionado);
            int filas = ps.executeUpdate();
            if (filas  == 0) {
                JOptionPane.showMessageDialog(null, "Error al modificar al jugador");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

