package Controlador;

import Modelo.EquipoDAO;
import Modelo.Jugador;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ModeloController {

    public static boolean inciarSesionUsuario(String usr, String con, String tipoUsr){
        return UsuarioController.inciarSesionusUario(usr, con,tipoUsr);
    }
    public static  boolean inscribirJugador(String nombre, String apellido, String nacionalidad, LocalDate fechaParseada, String nickname, float sueldoFloat){
        return JugadorController.inscribirJugador(nombre,apellido,nacionalidad,fechaParseada,nickname,sueldoFloat);
    }

    public static boolean inscribirEquipo(String nombre, LocalDate fecha){
        return EquipoController.inscribirEquipo(nombre,fecha);
    }

    public static boolean buscarEquipo(String nombre){
        return EquipoController.buscarEquipo(nombre);
    }
    public static List<String> listaEquipos(){
        return EquipoController.listaEquipos();
    }
    public static boolean eliminarEquipo(String equipoSeleccionado) {
        return EquipoController.eliminarEquipo(equipoSeleccionado);
    }
    public static List<String[]> obtenerEquiposConFechas(){
        return EquipoController.obtenerEquiposConFechas();
    }

    public static boolean modificarEquipo(String nuevoNombre, LocalDate nuevaFecha, String nombre){
        return EquipoController.modificarEquipo(nuevoNombre,nuevaFecha,nombre);
    }
    public static boolean modificarEquipo(String nuevoNombre, String nombre){
        return EquipoController.modificarEquipo(nuevoNombre,nombre);
    }
    public static boolean modificarEquipo(LocalDate nuevaFecha, String nombre){
        return EquipoController.modificarEquipo(nuevaFecha,nombre);
    }
}
