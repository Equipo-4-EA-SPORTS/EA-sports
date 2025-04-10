package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatos
{
    //Abrir y cerrar la conexión con la base de datos.

    private static Connection con;

    public static void abrirConexion() throws Exception
    {
        Class.forName("oracle.jdbc.OracleDriver");
        String user = " equipoMedina"; //poner user y contra de la bd de oracle
        String password = "Jm12345";
        String url ="jdbc:oracle:thin:@ccsatserv.dnsdojo.com:1521/xepdb1";
        con = DriverManager.getConnection(url, user, password);
    }

    public static Connection getCon() throws Exception
    {
        return con;
    }

    public static void cerrarConexion() throws Exception
    {
        con.close();
    }
}