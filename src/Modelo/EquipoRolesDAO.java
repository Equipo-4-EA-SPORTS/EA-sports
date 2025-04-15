package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase EquipoRolesDAO que gestiona las operaciones relacionadas con los roles de los equipos en la base de datos.
 */
public class EquipoRolesDAO {

    /**
     * Obtiene la lista de roles asociados a un equipo específico.
     *
     * @param nombreEquipo Nombre del equipo del cual se desean obtener los roles.
     * @return Una lista de nombres de roles asociados al equipo.
     */
    public static List<String> obtenerRoles(String nombreEquipo){
        List<String> listaRoles = new ArrayList<>();
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT idRol FROM equipoRoles Where idEquipo = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setInt(1,EquipoDAO.obtenerPKequipo(nombreEquipo));

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String nombreRol = RolesDAO.obtenerRolPK(rs.getInt("idRol"));
                listaRoles.add(nombreRol);
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }

        return listaRoles;
    }

    /**
     * Añade los roles predeterminados a un equipo en la base de datos.
     *
     * @param nombre Nombre del equipo al cual se le asignarán los roles predeterminados.
     */
    public static void añadirRolesDefaultEquipo(String nombre){
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "INSERT INTO equipoRoles (idEquipo,idRol) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setInt(1,EquipoDAO.obtenerPKequipo(nombre));

            for (int i = 1; i<7; i++){
                ps.setInt(2, i);
                ps.executeUpdate();
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
    }

    /**
     * Elimina un rol específico de todos los equipos en la base de datos.
     *
     * @param rol Nombre del rol que se desea eliminar.
     */
    public static void eliminarRolEquipo(String rol){
        try {
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "DELETE FROM equipoRoles Where idRol=?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setInt(1,RolesDAO.obtenerPKRol(rol));

            ps.executeUpdate();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
    }
}
