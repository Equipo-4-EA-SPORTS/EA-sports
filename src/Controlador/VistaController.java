package Controlador;

import Vista.InicioSesion;

public class VistaController {
    private static ModeloController mc = new ModeloController();


    public void mostrarinicioSesion() {

    }

    public void mostrarInicio() {
        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);
    }
}
