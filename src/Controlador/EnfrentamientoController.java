package Controlador;

import Modelo.EnfrentamientoDAO;

import java.util.List;

public class EnfrentamientoController {
    public static List<String[]> obtenerEnfrentamientos(){
        return EnfrentamientoDAO.obtenerEnfrentamientos();
    }
}
