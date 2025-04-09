package Controlador;

import Modelo.Equipo;
import Modelo.EquipoDAO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class EquipoController {

    public static boolean inscribirEquipo(String nombre, LocalDate fecha){

        return EquipoDAO.inscribirEquipo(nombre,fecha);
    }

    public static boolean buscarEquipo(String nombre){
        return EquipoDAO.buscarEquipo(nombre);
    }
    public static List<String> listaEquipos(){
        return EquipoDAO.listaEquipos();
    }

    public static boolean modificarEquipo(String nuevoNombre, LocalDate nuevaFecha, String nombre){
        return EquipoDAO.modificarEquipo(nuevoNombre,nuevaFecha,nombre);
    }
    public static boolean modificarEquipo(String nuevoNombre){
        return EquipoDAO.modificarEquipo(nuevoNombre);
    }
    public static boolean modificarEquipo(LocalDate nuevaFecha){
        return EquipoDAO.modificarEquipo(nuevaFecha);
    }
}
