package Controlador;

import Modelo.UsuarioDAO;

public class UsuarioController {
    public static boolean inciarSesionusUario(String usr,String con, String tipoUsr){
        return UsuarioDAO.iniciarSesion(usr,con,tipoUsr);
    }


}
