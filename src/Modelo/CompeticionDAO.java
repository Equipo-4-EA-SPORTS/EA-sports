package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompeticionDAO {

    public static void crearCompeticion(){
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "INSERT INTO competiciones (estado) VALUES (DEFAULT)";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static boolean abrirCompeticion(){

        boolean abierto = false;

        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "UPDATE competiciones SET estado='abierto'";
            PreparedStatement ps = con.prepareStatement(plantilla);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                abierto = true;
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return abierto;
    }

    public static void cerrarCompeticion(){
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "UPDATE competiciones SET estado='cerrado' ";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int verificarCompeticionCreada(){
        int filasSelect = 0;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT COUNT(*) FROM competiciones";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ResultSet filas = ps.executeQuery();

            if (filas.next()){
                filasSelect = 1;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return filasSelect;
    }

    public static boolean estadoCompeticion(){
        boolean estado = false;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT * FROM competiciones Where estado='abierto'";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ResultSet filas = ps.executeQuery();

            if (filas.next()){
                estado = true;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return estado;
    }

}