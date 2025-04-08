package Controlador;

import java.time.LocalDate;
import java.util.Date;

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
}
