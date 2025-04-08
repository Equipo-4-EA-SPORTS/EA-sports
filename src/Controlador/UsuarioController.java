package Controlador;

import Modelo.UsuarioDAO;

public class UsuarioController {
    public static void inciarSesionusUario(String usr,String con){
        UsuarioDAO.iniciarSesion(usr,con,"usuario");
    };
    public static void inciarSesionAdmin(String usr,String con){
        UsuarioDAO.iniciarSesion(usr,con,"administrador");
    }
}
