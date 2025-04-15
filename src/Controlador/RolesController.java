package Controlador;

import Modelo.RolesDAO;

public class RolesController {
    public static int obtenerPKRol(String rol){
        return RolesDAO.obtenerPKRol(rol);
    }
}
