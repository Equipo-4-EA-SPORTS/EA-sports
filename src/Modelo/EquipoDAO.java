package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class EquipoDAO {

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
        }catch (Exception e){}
        return encontrado;
    }

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
}
