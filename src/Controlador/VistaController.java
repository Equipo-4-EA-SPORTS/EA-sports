package Controlador;

import Vista.InicioSesion;
import Vista.UsuarioAdmin;

public class VistaController {
    private static ModeloController mc = new ModeloController();

    public static void usuario() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin();
        usuarioAdmin.setVisible(true);
    }

    public static void admin() {
        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(false);
    }


    public void mostrarinicioSesion() {

    }

    public void mostrarInicio() {
        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);
    }
}
