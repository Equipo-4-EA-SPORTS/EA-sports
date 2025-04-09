package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

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
}
