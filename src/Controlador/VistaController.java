package Controlador;

import Vista.InicioComUsuar;
import Vista.InicioSesion;
import Vista.UsuarioAdmin;

public class VistaController {
    private static ModeloController mc = new ModeloController();

    public static void usuario() {
        InicioComUsuar inicioUsuario = new InicioComUsuar();
        inicioUsuario.setVisible(true);
    }

    public static void admin() {

    }


    public void mostrarinicioSesion() {
    UsuarioAdmin usuarioAdmin = new UsuarioAdmin();
    usuarioAdmin.setVisible(true);

    }

    public void mostrarInicio() {
        InicioSesion inicio = new InicioSesion();
        inicio.setVisible(true);
    }

//Usuario
    public void mostrarPanelUsuario() {

    }
}
