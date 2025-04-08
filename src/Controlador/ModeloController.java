package Controlador;

import Modelo.*;

import java.sql.Connection;

public class ModeloController {

    private JugadorDAO jugadorDAO;
    private JugadorController jugadorController;

    private EquipoDAO equipoDAO;
    private EquipoController equipoController;

    private EnfrentamientoDAO enfrentamientoDAO;
    private EnfrentamientoController enfrentamientoController;

    private JornadaDAO jornadaDAO;
    private JornadaController jornadaController;

    private CompeticionDAO competicionDAO;
    private CompeticionController competicionController;


    private VistaController vc;

    public ModeloController()
    {
        try{
            BaseDatos.abrirConexion();
            Connection con = BaseDatos.getCon();



        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void setVistaController(VistaController vc)
    {
        this.vc = vc;
    }
}
