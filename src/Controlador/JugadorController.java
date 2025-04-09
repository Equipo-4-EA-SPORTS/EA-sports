package Controlador;

import Modelo.Jugador;
import Modelo.JugadorDAO;

import java.time.LocalDate;

public class JugadorController {
    public static boolean inscribirJugador(String nombre, String apellido, String nacionalidad, LocalDate fechaParseada, String nickname, float sueldoFloat) {
        return JugadorDAO.inscribirJugador(nombre,apellido,nacionalidad,fechaParseada,nickname,sueldoFloat);
    }
}
