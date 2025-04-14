package Controlador;

import Modelo.CompeticionDAO;
import Modelo.EquipoDAO;

public class CompeticionController {

    public static boolean abrirCompeticion(){
        return CompeticionDAO.abrirCompeticion();
    }
    public static boolean cerrarCompeticion(){
        return CompeticionDAO.cerrarCompeticion();
    }

    public static void crearCompeticion(){
        CompeticionDAO.crearCompeticion();
    }

    public static int verificarCompeticionCreada(){
        return CompeticionDAO.verificarCompeticionCreada();

    }

    public static boolean estadoCompeticion() {
        return CompeticionDAO.estadoCompeticion();
    }
}
