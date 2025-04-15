package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * Clase CompeticionDAO que gestiona las operaciones relacionadas con la tabla de competiciones en la base de datos.
 */
public class CompeticionDAO {

    /**
     * Crea una nueva competición en la base de datos con el estado predeterminado.
     * Muestra un mensaje de error si ocurre algún problema al conectarse a la base de datos.
     */
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
    /**
     * Abre una competición actualizando su estado a 'abierto' en la base de datos.
     *
     * @return true si se actualizó correctamente, false en caso contrario.
     */
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

    /**
     * Cierra una competición actualizando su estado a 'cerrado' en la base de datos.
     *
     * @return true si se actualizó correctamente, false en caso contrario.
     */
    public static boolean cerrarCompeticion(){

        boolean cerrado = false;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "UPDATE competiciones SET estado='cerrado' ";
            PreparedStatement ps = con.prepareStatement(plantilla);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                cerrado = true;
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return cerrado;
    }
    /**
     * Verifica si existe al menos una competición creada en la base de datos.
     *
     * @return 1 si existe al menos una competición, 0 en caso contrario.
     */
    public static int verificarCompeticionCreada(){
        int filasSelect = 0;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT COUNT(*) cant FROM competiciones";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ResultSet filas = ps.executeQuery();

            if (filas.next()){
                if (filas.getInt("cant")!=0){
                    filasSelect=1;
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return filasSelect;
    }
    /**
     * Verifica si existe alguna competición con el estado 'abierto' en la base de datos.
     *
     * @return true si existe una competición abierta, false en caso contrario.
     */
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