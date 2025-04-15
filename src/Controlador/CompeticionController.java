package Controlador;

import Modelo.CompeticionDAO;
import Modelo.EquipoDAO;

import javax.swing.*;

public class CompeticionController {

    public static boolean abrirCompeticion(){
        return CompeticionDAO.abrirCompeticion();
    }
    //Comprobacion para cerrar la Competicion (Equipos)
    public static boolean cerrarCompeticion() {
        boolean cerrado = false;
        if (ModeloController.hayMasDeDosEquipos()) {
            if (ModeloController.hayCantidadParDeEquipos()) {
                //Comprobacion para cerrar la Competicion (Jugadores)
                if(ModeloController.equiposConCantidadValidaDeJugadores()) {
                    cerrado = CompeticionDAO.cerrarCompeticion();
                }else{
                    JOptionPane.showMessageDialog(null, "La cantidad valida de jugadores por equipos(min 2/max 6) no es valida para cerrar la competicion)");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad de equipos debe ser par para cerrar la competición.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay suficientes equipos para cerrar la competición.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return cerrado;
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
