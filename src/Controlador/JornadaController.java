package Controlador;

import Modelo.JornadaDAO;

import java.time.LocalDate;
import java.util.List;


public class JornadaController {

    public static boolean crearJornada(LocalDate fechaInicio) {
        return JornadaDAO.crearJornada(fechaInicio);
    }

    public static boolean existeJornada (String numJornada){
        return JornadaDAO.existeJornada(numJornada);
    }

    public static List<String[]> obtenerJornadas(){
        return JornadaDAO.obtenerJornadas();
    }

    public static List<String> listaJornadas(){
        return JornadaDAO.listaJornadas();
    }

}
