package Modelo;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
    public static List<String[]> obtenerEnfrentamientos(){
        List<String[]> listaEnfrentamientos = new ArrayList<>();
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();


            String plantilla = "SELECT idEnf,fecha,hora,ganadorenf,perdedorenf,idjornada From enfrentamientos";
            PreparedStatement ps = con.prepareStatement(plantilla);


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idJorStr = String.valueOf(rs.getInt("idEnf"));
                String fechaInicio = rs.getDate("fecha").toString();
                String hora = Time.valueOf( rs.getString("hora")).toString();
                String ganadorenf = EquipoDAO.buscarEquipoPK(rs.getInt("ganadorenf"));
                String perdedorenf = EquipoDAO.buscarEquipoPK(rs.getInt("perdedorenf"));
                String idjornada = rs.getString("idjornada");
                listaEnfrentamientos.add(new String[]{idJorStr,fechaInicio, hora,ganadorenf,perdedorenf,idjornada});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
        return listaEnfrentamientos;
    }
}
