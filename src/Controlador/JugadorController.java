package Controlador;

import Modelo.BaseDatos;
import Modelo.EquipoDAO;
import Modelo.EquipoRolesDAO;
import Modelo.JugadorDAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

public class JugadorController {
    public static boolean inscribirJugador(String nombre, String apellido, String nacionalidad, LocalDate fechaParseada, String nickname, float sueldoFloat, String rol, String equipo) {
        boolean insertado =  JugadorDAO.inscribirJugador(nombre,apellido,nacionalidad,fechaParseada,nickname,sueldoFloat, rol, equipo);

        if (insertado){
            EquipoRolesDAO.eliminarRolEquipo(rol);
        }

        return insertado;
    }

    public static boolean buscarJugador(String nombre){
        return JugadorDAO.buscarJugador(nombre);
    }
    public static List<String> listaJugadores(){
        return JugadorDAO.listaJugadores();
    }
    public static boolean eliminarJugador(String jugadorSeleccionado) {
        boolean eliminado = false;

        if (EquipoRolesController.insertarRolJugadorEliminado(jugadorSeleccionado)){
            eliminado = JugadorDAO.eliminarJugador(jugadorSeleccionado);
        }

        return eliminado;
    }


    public static boolean buscarNickname(String nickname) {
        return JugadorDAO.buscarNickname(nickname);
    }

    public static List<String[]> obtenerJugadores() {
        return JugadorDAO.obtenerJugadores();

    }
    //Comprobacion para cerrar Competicion(Jugadores)
    public static boolean equiposConCantidadValidaDeJugadores() {
        return JugadorDAO.equiposConCantidadValidaDeJugadores();
    }

    public static int obtenerPKjugador(String jugador){
        return JugadorDAO.obtenerPKjugador(jugador);
    }

    public static String obtenerRolJugador(String jugador){
        return JugadorDAO.obtenerRolJugador(jugador);
    }
    public static int obtenerEquipoJugador(int idJugador){
        return JugadorDAO.obtenerEquipoJugador(idJugador);
    }

}
