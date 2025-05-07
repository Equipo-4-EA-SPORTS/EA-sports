
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
    public static List<String> listaNicknames(){
        return ModeloController.listaNicknames();
    }

    public static boolean eliminarJugador(String jugadorSeleccionado) {
        return ModeloController.eliminarJugador(jugadorSeleccionado);
    }

    public static boolean modificarJugador(String nombre, String apellido, String nacionalidad, LocalDate fecha, String nickname, Float sueldoFloat, String rol, String equipo,Boolean duplicado,String nickname_viejo,Boolean cambiarRoles) {
        return ModeloController.modificarJugador(nombre,apellido,nacionalidad,fecha,nickname,sueldoFloat,rol,equipo,duplicado,nickname_viejo,cambiarRoles);
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


    public static void mostrarInicio() {
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



    public static boolean existeJornada (String numJornada){
        return ModeloController.existeJornada(numJornada);
    }

    public static boolean VentanaMostrarJornada() {
        VentanaMostrarJornada vmj = new VentanaMostrarJornada();
        List<String> listaJornadas = ModeloController.listaJornadas();
        vmj.setVisible(!listaJornadas.isEmpty());
        return !listaJornadas.isEmpty();
    }

    public static List<String[]> obtenerJornadas(){
        return ModeloController.obtenerJornadas();
    }



    public static void VentanaGestionEnfrentamientos(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionEnfrentamientos vgj = new VentanaGestionEnfrentamientos(nombre);
        vgj.setVisible(true);
    }


    public static boolean modificarEquipo(String nuevoNombre, LocalDate nuevaFecha, Boolean duplicado, String nombre){
        return ModeloController.modificarEquipo(nuevoNombre,nuevaFecha,duplicado,nombre);
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


    //VENTANAS NUEVAS

    public static void VentanaPrincipalV2(){
        VentanaPrincipalV2 vp2 = new VentanaPrincipalV2();
        vp2.setVisible(true);
    }

    public static void VentanaAdministradorV2(String nombre, JFrame ventana) {
        ventana.dispose();
        VentanaAdministradorV2 va2 = new VentanaAdministradorV2(nombre);
        va2.setVisible(true);
    }

    public static void VentanaGestionJugadoresV2(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionJugadoresV2 vg2 = new VentanaGestionJugadoresV2(nombre);
        vg2.setVisible(true);
    }
    public static void VentanaGestionEquiposV2(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionEquiposV2 vg2 = new VentanaGestionEquiposV2(nombre);
        vg2.setVisible(true);
    }
    public static void ModalInscripcionJugadoresV2() {
        ModalInscripcionJugadoresV2 vg2 = new ModalInscripcionJugadoresV2();
        vg2.setVisible(true);
    }

    public static boolean ModalAdvertencia(){
        ModalAdvertencia vc = new ModalAdvertencia();
        vc.setVisible(true);
        return vc.isConfirmado();
    }

    public static void ModalDescripcionUsuariosV2(String nombre){
        ModalDescripcionUsuariosV2 vdu2 = new ModalDescripcionUsuariosV2(nombre);
        vdu2.setVisible(true);
    }

    public static void VentanaInciarSesionV2(String tipoUsr,JFrame ventana){
        ventana.dispose();
        VentanaIniciarSesionV2 vis2 = new VentanaIniciarSesionV2(tipoUsr);
        vis2.setVisible(true);
    }

    public static void VentanaSelccionUsuarioV2(JFrame ventana){
        ventana.dispose();
        VentanaSeleccionUsuarioV2 vsu2 = new VentanaSeleccionUsuarioV2();
        vsu2.setVisible(true);
    }

    public static void ModalEliminacionJugadoresV2(){
        ModalEliminacionJugadresV2 mej2 = new ModalEliminacionJugadresV2();
        mej2.setVisible(true);
    }

    public static List<String> ModalSeleccionGanador(List<String> equipo,int numJor){
        ModalSeleccionGanadroV2 mdg2 = new ModalSeleccionGanadroV2();
        mdg2.ModalSeleccionGanadroV2(equipo,numJor);
        mdg2.setVisible(true);
        return mdg2.getGanadorPerdedor();
    }

    public static void ModalMostrarJugadoresV2(){
        ModalMostrarJugadoresV2 mmj2 = new ModalMostrarJugadoresV2();
        mmj2.setVisible(true);
    }

    public static void ModalModificarJugadorV2(JDialog modal,String jugador){
        modal.dispose();
        ModalModificarJugadoresV2 mmj2 = new ModalModificarJugadoresV2(jugador);
        mmj2.setVisible(true);
    }

    public static void ModalSeleccionarJugadorV2(){
        ModalSeleccionJugadorV2 msj2 = new ModalSeleccionJugadorV2();
        msj2.setVisible(true);
    }

    public static int obtenerCantidadJugadoreEquipo(String equipo){
        return ModeloController.obtenerCantidadJugadoreEquipo(equipo);
    }

    public static String obtenerRolJugadorNick(String nickname){
        return ModeloController.obtenerRolJugadorNick(nickname);
    }
    public static void ModalEliminacionEquiposV2(){
        ModalEliminacionEquiposV2 mee2 = new ModalEliminacionEquiposV2();
        mee2.setVisible(true);
    }
    public static void ModalMostrarEquiposV2(){
        ModalMostrarEquiposV2 mme2 = new ModalMostrarEquiposV2();
        mme2.setVisible(true);
    }
    public static void ModalInscripcionEquiposV2(){
        ModalInscripcionEquipoV2 mme2 = new ModalInscripcionEquipoV2();
        mme2.setVisible(true);
    }
    public static void ModalModificarEquipoV2(JDialog modal,String equipo){
        modal.dispose();
        ModalModificarEquipoV2 mme2 = new ModalModificarEquipoV2(equipo);
        mme2.setVisible(true);
    }
    public static void ModalSeleccionarEquipoV2(){
        ModalSeleccionEquipoV2 mse2 = new ModalSeleccionEquipoV2();
        mse2.setVisible(true);
    }

}