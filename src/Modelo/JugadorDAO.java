package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {
    public static boolean inscribirJugador(String nombre, String apellido, String nacionalidad, LocalDate fechaParseada, String nickname, float sueldoFloat) {
        boolean insertado = false;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();
            String plantilla = "INSERT INTO jugadores(NOMBRE,APELLIDO,NACIONALIDAD,FECHANAC,NICKNAME,SUELDO) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, nacionalidad);
            java.sql.Date fechanac = java.sql.Date.valueOf(fechaParseada);

            ps.setDate(4, fechanac);
            ps.setString(5,nickname);
            ps.setFloat(6,sueldoFloat);
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

    public static List<String[]> obtenerJugadores(){
        List<String[]> jugadores = new ArrayList<>();
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT nombre, apellido, nacionalidad, fechanac, nickname, sueldo, rol, idequipo FROM jugadores";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String nacionalidad = rs.getString("nacionalidad");
                String fechanac = rs.getDate("fechanac").toString();
                String nickname = rs.getString("nickname");
                String sueldo = String.valueOf(rs.getFloat("sueldo"));
                String rol = rs.getString("rol");
                String idequipo = String.valueOf(rs.getInt("idequipo"));

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return jugadores;
    }
}
