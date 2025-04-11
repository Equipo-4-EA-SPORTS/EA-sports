package Controlador;

import Modelo.JugadorDAO;

import java.time.LocalDate;
import java.util.List;

public class JugadorController {
    public static boolean inscribirJugador(String nombre, String apellido, String nacionalidad, LocalDate fechaParseada, String nickname, float sueldoFloat, String rol, int equipo) {
        return JugadorDAO.inscribirJugador(nombre, apellido, nacionalidad, fechaParseada, nickname, sueldoFloat, rol, equipo);
    }

    public static boolean buscarJugador(String nombre) {
        return JugadorDAO.buscarJugador(nombre);
    }

    public static List<String> listaJugadores() {
        return JugadorDAO.listaJugadores();
    }

    public static boolean eliminarJugador(String jugadorSeleccionado) {
        return JugadorDAO.eliminarJugador(jugadorSeleccionado);
    }


    public static boolean buscarNickname(String nickname) {
        return JugadorDAO.buscarNickname(nickname);
    }

    public static List<String> obtenerRoles(String equipoSeleccionado) {
        return JugadorDAO.obtenerRoles(equipoSeleccionado);
    }

    public static List<String[]> obtenerJugadores() {
        return JugadorDAO.obtenerJugadores();

    }

    public static void modificarJugador(String nombre, String apellido, String nacionalidad, LocalDate fecha, String nickname, float sueldoFloat, String rol, int equipoSeleccionado) {
            JugadorDAO.modificarJugador(nombre, apellido, nacionalidad, fecha, nickname, sueldoFloat, rol, equipoSeleccionado);
    }
}

