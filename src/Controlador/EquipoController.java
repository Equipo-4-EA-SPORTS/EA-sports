package Controlador;

import Modelo.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class EquipoController {

    public static boolean inscribirEquipo(String nombre, LocalDate fecha){
        boolean insertado = false;
        insertado = EquipoDAO.inscribirEquipo(nombre,fecha);

        if (insertado){
            EquipoRolesDAO.añadirRolesDefaultEquipo(nombre);
        }
        return insertado;
    }

    public static boolean buscarEquipo(String nombre){
        return EquipoDAO.buscarEquipo(nombre);
    }
    public static List<String> listaEquipos(){
        return EquipoDAO.listaEquipos();
    }
    public static boolean eliminarEquipo(String equipoSeleccionado) {
        return EquipoDAO.eliminarEquipo(equipoSeleccionado);
    }
    public static List<String[]> obtenerEquiposConFechas(){
        return EquipoDAO.obtenerEquiposConFechas();
    }
    public static boolean modificarEquipo(String nuevoNombre, LocalDate nuevaFecha, String nombre){
        return EquipoDAO.modificarEquipo(nuevoNombre,nuevaFecha,nombre);
    }
    public static boolean modificarEquipo(String nuevoNombre, String nombre){
        return EquipoDAO.modificarEquipo(nuevoNombre,nombre);
    }
    public static boolean modificarEquipo(LocalDate nuevaFecha, String nombre){
        return EquipoDAO.modificarEquipo(nuevaFecha,nombre);
    }
    public static int obtenerPKequipo(String nombre){
        return EquipoDAO.obtenerPKequipo(nombre);
    }

}
