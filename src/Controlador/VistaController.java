package Controlador;

import Vista.VinicioSesion;

public class VistaController
{
    //Ventanas
    private VinicioSesion vi;

    // Comunicación con el "jefe" del modelo
    private ModeloController modeloController;

    public VistaController(ModeloController modeloController) {
        this.modeloController = modeloController;

        //Vista principal
        vi = new VinicioSesion(this);
        vi.setVisible(true);
    }

    //Vista de usuario o admin
    public void mostrarinicioSesion()
    {
        //crear la vista siguiente, set a true y disposear vi


    }
}
