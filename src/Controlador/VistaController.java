package Controlador;

import Vista.InicioSesion;
import Vista.UsuarioAdmin;

import javax.swing.*;

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


    public void mostrarinicioSesion(JFrame ventana) {
        ventana.dispose();
    }

    public void mostrarInicio() {
        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);
    }

//Usuario
    public void mostrarPanelUsuario() {

    }


    public void iniciarSesionUsuario(String usr, String con){
        ModeloController.inciarSesionUsuario(usr,con);
    }
}
