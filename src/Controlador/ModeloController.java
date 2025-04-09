package Controlador;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ModeloController {

    public static boolean inciarSesionUsuario(String usr, String con, String tipoUsr){
        return UsuarioController.inciarSesionusUario(usr, con,tipoUsr);
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

    public static boolean modificarEquipo(String nuevoNombre, LocalDate nuevaFecha, String nombre){
        return EquipoController.modificarEquipo(nuevoNombre,nuevaFecha,nombre);
    }
    public static boolean modificarEquipo(String nuevoNombre){
        return EquipoController.modificarEquipo(nuevoNombre);
    }
    public static boolean modificarEquipo(LocalDate nuevaFecha){
        return EquipoController.modificarEquipo(nuevaFecha);
    }
}
