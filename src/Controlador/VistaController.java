package Controlador;

import Vista.InicioSesion;

public class VistaController {
    //Comunicación
    private static ModeloController mc = new ModeloController();


    public void mostrarinicioSesion() {

    }

    public void mostrarInicio() {
        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);
    }

//Usuario
    public void mostrarPanelUsuario() {

    }
}
