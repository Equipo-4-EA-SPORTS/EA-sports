package Controlador;

import Modelo.EquipoDAO;

import java.time.LocalDate;
import java.util.Date;

public class EquipoController {

    public static boolean inscribirEquipo(String nombre, LocalDate fecha){

        return EquipoDAO.inscribirEquipo(nombre,fecha);
    }

    public static boolean buscarEquipo(String nombre){
        return EquipoDAO.buscarEquipo(nombre);
    }
}
