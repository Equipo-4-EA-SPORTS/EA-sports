package Controlador;

import Modelo.EquipoDAO;
import Modelo.Jugador;
import Modelo.JugadorDAO;

import java.time.LocalDate;
import java.util.List;

public class JugadorController {
    public static boolean inscribirJugador(String nombre, String apellido, String nacionalidad, LocalDate fechaParseada, String nickname, float sueldoFloat) {
        return JugadorDAO.inscribirJugador(nombre,apellido,nacionalidad,fechaParseada,nickname,sueldoFloat);
    }

    public static boolean buscarJugador(String nombre){
        return JugadorDAO.buscarJugador(nombre);
    }
    public static List<String> listaJugadores(){
        return JugadorDAO.listaJugadores();
    }
    public static boolean eliminarJugador(String jugadorSeleccionado) {
        return JugadorDAO.eliminarJugador(jugadorSeleccionado);
    }
    public static List<String[]> obtenerJugadores() {return JugadorDAO.obtenerJugadores();}
}
