package Controlador;

import Modelo.EnfrentamientoDAO;

import java.util.ArrayList;

public class EnfrentamientoController {
    public static ArrayList<Integer> obtenerEnfrentamientos() {
        return EnfrentamientoDAO.obtenerEnfrentamientos();
    }
}
