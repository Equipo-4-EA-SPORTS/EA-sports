package Controlador;

import Vista.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class VistaController {
    private static ModeloController mc = new ModeloController();

    public static void usuario(JFrame frame,String tipoUsr) {
        frame.dispose();
        InicioComUsuar iniciarUsuario = new InicioComUsuar(tipoUsr);
        iniciarUsuario.setVisible(true);
    }

    public static void mostrarinicioSesion(JFrame ventana) {
        ventana.dispose();
        UsuarioAdmin ventanaSeleccionUsuario = new UsuarioAdmin();
        ventanaSeleccionUsuario.setVisible(true);
    }
    //Jugadores
    public static void mostrarinscribirJugador() {
        VentanaInscribirJugadores inscribir = new VentanaInscribirJugadores();
        inscribir.setVisible(true);

    }

    public static boolean inscribirJugador(String nombre, String apellido, String nacionalidad, LocalDate fechaParseada, String nickname, float sueldoFloat, String rol, String equipo) {
        return ModeloController.inscribirJugador(nombre, apellido,nacionalidad,fechaParseada,nickname,sueldoFloat, rol, equipo);
    }

    public static boolean VentanaEliminarJugador(JFrame ventana) {
        VentanaEliminarJugador ve = new VentanaEliminarJugador();
        List<String> listaJugadores = ModeloController.listaJugadores();
        ve.setVisible(!listaJugadores.isEmpty());
        return !listaJugadores.isEmpty();
    }

    public static  boolean buscarJugador(String nombre){
        return ModeloController.buscarJugador(nombre);
    }

    public static List<String> listaJugadores(){
        return ModeloController.listaJugadores();
    }

    public static boolean eliminarJugador(String jugadorSeleccionado) {
        return ModeloController.eliminarJugador(jugadorSeleccionado);
    }



    public static boolean buscarNickname(String nickname) {
        return ModeloController.buscarNickname(nickname);
    }
    public static List<String> obtenerRoles(String equipoSeleccionado) {
        return ModeloController.obtenerRoles(equipoSeleccionado);}
    public static boolean VentanaMostrarJugadores() {
        VentanaMostrarJugadores ve = new VentanaMostrarJugadores();
        List<String[]> listaJugadores = ModeloController.obtenerJugadores();
        ve.setVisible(!listaJugadores.isEmpty());
        return !listaJugadores.isEmpty();
    }
    public static List<String[]> obtenerJugadores() {
        return ModeloController.obtenerJugadores();
    }

    public static boolean VentanaMostrarEquipos() {
        VentanaMostrarEquipos ve = new VentanaMostrarEquipos();
        List<String> listaEquipos = ModeloController.listaEquipos();
        ve.setVisible(!listaEquipos.isEmpty());
        return !listaEquipos.isEmpty();
    }

    public static List<String> listaEquipos(){
        return ModeloController.listaEquipos();
    }

    public static void modificarJugador(String nombre, String apellido, String nacionalidad, LocalDate fecha, String nickname, float sueldoFloat, String rol, int equipoSeleccionado) {
        ModeloController.modificarJugador(nombre, apellido, nacionalidad, fecha, nickname, sueldoFloat, rol, equipoSeleccionado);
    }

    public static void mostrarModificarJugador(JFrame ventana) {
        VentanaModificacionJugador mj = new VentanaModificacionJugador();
        mj.setVisible(true);
    }


    public void mostrarInicio() {
        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);
    }

    //Usuario
    public void mostrarPanelUsuario() {

    }


    public static boolean inciarSesionUsuario(String usr, String con, String tipoUsr) {
        return ModeloController.inciarSesionUsuario(usr,con,tipoUsr);
    }

    public static void ventanaInformesEquipos(JFrame ventana) {
        ventana.dispose();
    }
    public static void ventanaVerResultadosUltimJornada(JFrame ventana) {
        ventana.dispose();
    }

    public static void ventanaAdministrador(JFrame ventana,String nombre) {
        ventana.dispose();
        VentanaAdministrador va = new VentanaAdministrador(nombre);
        va.setVisible(true);
    }

    public static void ventanaUsuario(JFrame ventana,String nombre) {
        ventana.dispose();
        VentanaUsuario vu = new VentanaUsuario(nombre);
        vu.setVisible(true);
    }


    public static void ventanaGestionEquipos(JFrame ventana,String nombre) {
        ventana.dispose();
        VentanaGestionEquipos vge = new VentanaGestionEquipos(nombre);
        vge.setVisible(true);
    }

    public static void ventanaInscribirEquipo(JFrame ventana) {
        VentanaInscribirEquipo vi = new VentanaInscribirEquipo(ventana);
        vi.setVisible(true);
    }

    public static boolean ventanaModificarEquipo() {
        VentanaModificacionEquipo ve = new VentanaModificacionEquipo();
        List<String> listaEquipos = ModeloController.listaEquipos();
        ve.setVisible(!listaEquipos.isEmpty());
        return !listaEquipos.isEmpty();
    }

    public static boolean inscribirEquipo(String nombre, LocalDate fecha) {
        return ModeloController.inscribirEquipo(nombre,fecha);
    }


    public static boolean VentanaEliminarEquipo () {
        VentanaEliminarEquipo ve = new VentanaEliminarEquipo();
        List<String> listaEquipos = ModeloController.listaEquipos();
        ve.setVisible(!listaEquipos.isEmpty());
        return !listaEquipos.isEmpty();
    }

    public static void ventanaGestionJornadas(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionJornada vgj = new VentanaGestionJornada(nombre);
        vgj.setVisible(true);
    }

    public static void ventanaCrearJornada(JFrame ventana, String nombre) {
        VentanaCrearJornada vcj = new VentanaCrearJornada(ventana);
        vcj.setVisible(true);
    }

    public static boolean crearJornada(LocalDate fechaInicio) {
        return ModeloController.crearJornada(fechaInicio);
    }

    public static boolean existeJornada (String numJornada){
        return ModeloController.existeJornada(numJornada);
    }

    public static void VentanaGestionEnfrentamientos(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionEnfrentamientos vgj = new VentanaGestionEnfrentamientos(nombre);
        vgj.setVisible(true);
    }


    public static boolean modificarEquipo(String nuevoNombre, LocalDate nuevaFecha, String nombre){
        return ModeloController.modificarEquipo(nuevoNombre,nuevaFecha,nombre);
    }
    public static boolean modificarEquipo(String nuevoNombre,String nombre){
        return ModeloController.modificarEquipo(nuevoNombre,nombre);
    }
    public static boolean modificarEquipo(LocalDate nuevaFecha, String nombre){
        return ModeloController.modificarEquipo(nuevaFecha,nombre);
    }

    public static boolean buscarEquipo(String nombre){
        return ModeloController.buscarEquipo(nombre);
    }



    public static boolean eliminarEquipo(String equipoSeleccionado) {
        return ModeloController.eliminarEquipo(equipoSeleccionado);
    }

    public static List<String[]> obtenerEquiposConFechas(){
        return ModeloController.obtenerEquiposConFechas();
    }

    public static boolean ventanaConfirmacion(String title){
        VentanaConfirmacion vc = new VentanaConfirmacion(title);
        vc.setVisible(true);
        return vc.isConfirmado();
    }

    public static void ventanaGestionCompeticion(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionCompeticion vge = new VentanaGestionCompeticion(nombre);
        vge.setVisible(true);
    }

    public static void ventanaGestionJugadores(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionJugadores vge = new VentanaGestionJugadores(nombre);
        vge.setVisible(true);
    }

    public static boolean abrirCompeticion(){
        return ModeloController.abrirCompeticion();
    }

    public static boolean cerrarCompeticion(){
        return ModeloController.cerrarCompeticion();
    }

    public static void crearCompeticion(){
        ModeloController.crearCompeticion();
    }

    public static int verificarCompeticionCreada(){
        return ModeloController.verificarCompeticionCreada();
    }

    public static boolean estadoCompeticion() {
        return ModeloController.estadoCompeticion();
    }

    public static void cerrarVentanas(JFrame ventana){
        ventana.dispose();
    }
    public static void cerrarModales(JDialog modal){
        modal.dispose();
    }
}