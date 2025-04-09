package Modelo;

import javax.sound.midi.Track;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDAO {
    public static boolean iniciarSesion(String nombre, String contra, String usr){
        boolean encontrado = false;
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();

            String plantilla = "SELECT nombre FROM USUARIOS WHERE nombre = ? AND contrasena = ? AND tipousuario = ?";

            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1,nombre);
            ps.setString(2,contra);
            ps.setString(3,usr.toLowerCase());

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                encontrado = true;
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos","ERROR",-1,null);
        }
        return encontrado;

    }
}
