package Controlador;

import Modelo.EquipoRolesDAO;

import java.util.List;

public class EquipoRolesController {
    public static List<String> obtenerRoles(String equipoSeleccionado){
        return EquipoRolesDAO.obtenerRoles(equipoSeleccionado);
    }

    public static boolean insertarRolJugadorEliminado(String jugador){
        return EquipoRolesDAO.insertarRolJugadorEliminado(jugador);
    }
}
