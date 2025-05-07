package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class EnfrentamientoDAO {
    public static void crearEnfrentamiento(LocalDate fecha, LocalTime hora,String ganador,String perdedor,int numJor){
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();


            String plantilla = "INSERT INTO enfrentamientos (fecha,hora,idjornada,ganadorenf,perdedorenf) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(plantilla);

            ps.setDate(1, Date.valueOf(fecha));
            ps.setTime(2, Time.valueOf(hora));
            ps.setInt(3,numJor);
            ps.setInt(4,EquipoDAO.obtenerPKequipo(ganador));
            ps.setInt(5,EquipoDAO.obtenerPKequipo(perdedor));

            ps.executeUpdate();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
    }
}
