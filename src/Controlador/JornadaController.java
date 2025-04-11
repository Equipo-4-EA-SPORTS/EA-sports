package Controlador;

import Modelo.JornadaDAO;

import java.time.LocalDate;

public class JornadaController {

    public static boolean crearJornada(LocalDate fechaInicio) {
        return JornadaDAO.crearJornada(fechaInicio);
    }

    public static boolean existeJornada (String numJornada){
        return JornadaDAO.existeJornada(numJornada);
    }
}
