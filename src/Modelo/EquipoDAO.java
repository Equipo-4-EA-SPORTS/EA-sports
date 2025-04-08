package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
}
