package Controlador;

import Modelo.JornadaDAO;

import java.time.LocalDate;
import java.util.List;

public class ModeloController {

    public static boolean inciarSesionUsuario(String usr, String con, String tipoUsr){
        return UsuarioController.inciarSesionusUario(usr, con,tipoUsr);
    }
    //Jugadores
    public static  boolean inscribirJugador(String nombre, String apellido, String nacionalidad, LocalDate fechaParseada, String nickname, float sueldoFloat, String rol, int equipo){
        return JugadorController.inscribirJugador(nombre,apellido,nacionalidad,fechaParseada,nickname,sueldoFloat, rol, equipo);
    }
    public static boolean buscarJugador(){
        return JugadorController.buscarJugador();
    }

    public static List<String> listaJugadores(){
        return JugadorController.listaJugadores();
    }

    public static boolean eliminarJugador(String jugadorSeleccionado) {
        return JugadorController.eliminarJugador(jugadorSeleccionado);
    }

    //Equipos

    public static List<String[]> obtenerJugadores(){
        return JugadorController.obtenerJugadores();
    }
//Equipos

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

    //Competicion
    public static boolean abrirCompeticion(){
        return CompeticionController.abrirCompeticion();
    }

    public static void crearCompeticion(){
        CompeticionController.crearCompeticion();
    }

    public static int verificarCompeticionCreada(){
        return CompeticionController.verificarCompeticionCreada();
    }
    public static boolean estadoCompeticion() {
        return CompeticionController.estadoCompeticion();
    }

    //Jornada
    public static boolean crearJornada(LocalDate fechaInicio) {
        return JornadaController.crearJornada(fechaInicio);
    }

    public static boolean existeJornada (String numJornada){
        return JornadaController.existeJornada(numJornada);
    }

    public static boolean buscarNickname(String nickname) {
        return JugadorController.buscarNickname(nickname);
    }

    public static List<String> obtenerRoles(String equipoSeleccionado) {
        return JugadorController.obtenerRoles(equipoSeleccionado);
    }

    public static void modificarJugador(String nombre, String apellido, String nacionalidad, LocalDate fecha, String nickname, float sueldoFloat, String rol, int equipoSeleccionado) {
        JugadorController.modificarJugador(nombre, apellido, nacionalidad, fecha, nickname, sueldoFloat, rol, equipoSeleccionado);
    }
}