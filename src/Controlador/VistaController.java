package Controlador;

import Modelo.JornadaDAO;
import Vista.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
/**
 * La clase `VistaController` actúa como un controlador para gestionar la interacción entre la vista y el modelo.
 * Proporciona métodos para manejar las acciones de la interfaz gráfica de usuario (GUI) y delega la lógica al `ModeloController`.
 */
public class VistaController {

    /**
     * Instancia de `ModeloController` para delegar las operaciones al modelo.
     */
    private static ModeloController mc = new ModeloController();
    // Métodos relacionados con la gestión de usuarios

    /**
     * Cambia la vista al inicio de sesión de un usuario específico.
     *
     * @param frame Ventana actual que se cerrará.
     * @param tipoUsr Tipo de usuario (por ejemplo, administrador, cliente, etc.).
     */
    public static void usuario(JFrame frame,String tipoUsr) {
        frame.dispose();
        InicioComUsuar iniciarUsuario = new InicioComUsuar(tipoUsr);
        iniciarUsuario.setVisible(true);
    }
    /**
     * Muestra la ventana de inicio de sesión.
     *
     * @param ventana Ventana actual que se cerrará.
     */
    public static void mostrarinicioSesion(JFrame ventana) {
        ventana.dispose();
        UsuarioAdmin ventanaSeleccionUsuario = new UsuarioAdmin();
        ventanaSeleccionUsuario.setVisible(true);
    }

    // Métodos relacionados con jugadores

    /**
     * Muestra la ventana para inscribir jugadores.
     */
    public static void mostrarinscribirJugador() {
        VentanaInscribirJugadores inscribir = new VentanaInscribirJugadores();
        inscribir.setVisible(true);

    }
    /**
     * Inscribe un jugador con los datos proporcionados.
     *
     * @param nombre Nombre del jugador.
     * @param apellido Apellido del jugador.
     * @param nacionalidad Nacionalidad del jugador.
     * @param fechaParseada Fecha de nacimiento del jugador.
     * @param nickname Apodo del jugador.
     * @param sueldoFloat Sueldo del jugador.
     * @param rol Rol del jugador en el equipo.
     * @param equipo Nombre del equipo al que pertenece el jugador.
     * @return true si el jugador fue inscrito correctamente, false en caso contrario.
     */
    public static boolean inscribirJugador(String nombre, String apellido, String nacionalidad, LocalDate fechaParseada, String nickname, float sueldoFloat, String rol, String equipo) {
        return ModeloController.inscribirJugador(nombre, apellido,nacionalidad,fechaParseada,nickname,sueldoFloat, rol, equipo);
    }

    /**
     * Muestra la ventana para eliminar jugadores si hay jugadores disponibles.
     *
     * @param ventana Ventana actual que se cerrará.
     * @return true si hay jugadores disponibles, false en caso contrario.
     */
    public static boolean VentanaEliminarJugador(JFrame ventana) {
        VentanaEliminarJugador ve = new VentanaEliminarJugador();
        List<String> listaJugadores = ModeloController.listaJugadores();
        ve.setVisible(!listaJugadores.isEmpty());
        return !listaJugadores.isEmpty();
    }

    /**
     * Busca un jugador por su nombre.
     *
     * @param nombre Nombre del jugador a buscar.
     * @return true si el jugador existe, false en caso contrario.
     */
    public static  boolean buscarJugador(String nombre){
        return ModeloController.buscarJugador(nombre);
    }
    /**
     * Obtiene una lista de nombres de todos los jugadores registrados.
     *
     * @return Una lista de cadenas con los nombres de los jugadores.
     */
    public static List<String> listaJugadores(){
        return ModeloController.listaJugadores();
    }

    /**
     * Elimina un jugador seleccionado.
     *
     * @param jugadorSeleccionado Nombre del jugador a eliminar.
     * @return true si el jugador fue eliminado correctamente, false en caso contrario.
     */
    public static boolean eliminarJugador(String jugadorSeleccionado) {
        return ModeloController.eliminarJugador(jugadorSeleccionado);
    }

    /**
     * Modifica un jugador (actualmente solo cierra la ventana).
     *
     * @param ventana Ventana actual que se cerrará.
     */
    public static void modificarJugador(JFrame ventana) {
        ventana.dispose();
    }

    /**
     * Busca un jugador por su apodo (nickname).
     *
     * @param nickname Apodo del jugador a buscar.
     * @return true si el apodo existe, false en caso contrario.
     */
    public static boolean buscarNickname(String nickname) {
        return ModeloController.buscarNickname(nickname);
    }
    /**
     * Obtiene una lista de roles disponibles para un equipo seleccionado.
     *
     * @param equipoSeleccionado Nombre del equipo.
     * @return Una lista de cadenas con los roles disponibles.
     */
    public static List<String> obtenerRoles(String equipoSeleccionado) {
        return ModeloController.obtenerRoles(equipoSeleccionado);}

    /**
     * Muestra la ventana con la lista de jugadores si hay jugadores disponibles.
     *
     * @return true si hay jugadores disponibles, false en caso contrario.
     */
    public static boolean VentanaMostrarJugadores() {
        VentanaMostrarJugadores ve = new VentanaMostrarJugadores();
        List<String[]> listaJugadores = ModeloController.obtenerJugadores();
        ve.setVisible(!listaJugadores.isEmpty());
        return !listaJugadores.isEmpty();
    }
    /**
     * Obtiene una lista de jugadores con sus detalles.
     *
     * @return Una lista de arreglos de cadenas con los detalles de los jugadores.
     */
    public static List<String[]> obtenerJugadores() {
        return ModeloController.obtenerJugadores();
    }
    /**
     * Muestra la ventana con la lista de equipos si hay equipos disponibles.
     *
     * @return true si hay equipos disponibles, false en caso contrario.
     */
    public static boolean VentanaMostrarEquipos() {
        VentanaMostrarEquipos ve = new VentanaMostrarEquipos();
        List<String> listaEquipos = ModeloController.listaEquipos();
        ve.setVisible(!listaEquipos.isEmpty());
        return !listaEquipos.isEmpty();
    }
    /**
     * Obtiene una lista de nombres de todos los equipos registrados.
     *
     * @return Una lista de cadenas con los nombres de los equipos.
     */
    public static List<String> listaEquipos(){
        return ModeloController.listaEquipos();
    }

    /**
     * Muestra la ventana de inicio de sesión.
     */
    public void mostrarInicio() {
        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);
    }
    /**
     * Muestra el panel de usuario. (Actualmente no implementado).
     */
    //Usuario
    public void mostrarPanelUsuario() {

    }


    /**
     * Inicia sesión para un usuario con las credenciales proporcionadas.
     *
     * @param usr Nombre de usuario.
     * @param con Contraseña del usuario.
     * @param tipoUsr Tipo de usuario (por ejemplo, administrador, cliente, etc.).
     * @return true si las credenciales son correctas y el inicio de sesión es exitoso, false en caso contrario.
     */
    public static boolean inciarSesionUsuario(String usr, String con, String tipoUsr) {
        return ModeloController.inciarSesionUsuario(usr,con,tipoUsr);
    }
    /**
     * Cierra la ventana actual y muestra la ventana de informes de equipos.
     *
     * @param ventana Ventana actual que se cerrará.
     */
    public static void ventanaInformesEquipos(JFrame ventana) {
        ventana.dispose();
    }

    /**
     * Cierra la ventana actual y muestra los resultados de la última jornada.
     *
     * @param ventana Ventana actual que se cerrará.
     */
    public static void ventanaVerResultadosUltimJornada(JFrame ventana) {
        ventana.dispose();
    }
    /**
     * Cierra la ventana actual y abre la ventana del administrador.
     *
     * @param ventana Ventana actual que se cerrará.
     * @param nombre Nombre del administrador.
     */
    public static void ventanaAdministrador(JFrame ventana,String nombre) {
        ventana.dispose();
        VentanaAdministrador va = new VentanaAdministrador(nombre);
        va.setVisible(true);
    }
    /**
     * Cierra la ventana actual y abre la ventana del usuario.
     *
     * @param ventana Ventana actual que se cerrará.
     * @param nombre Nombre del usuario.
     */
    public static void ventanaUsuario(JFrame ventana,String nombre) {
        ventana.dispose();
        VentanaUsuario vu = new VentanaUsuario(nombre);
        vu.setVisible(true);
    }

    /**
     * Cierra la ventana actual y abre la ventana de gestión de equipos.
     *
     * @param ventana Ventana actual que se cerrará.
     * @param nombre Nombre del usuario.
     */
    public static void ventanaGestionEquipos(JFrame ventana,String nombre) {
        ventana.dispose();
        VentanaGestionEquipos vge = new VentanaGestionEquipos(nombre);
        vge.setVisible(true);
    }
    /**
     * Muestra la ventana para inscribir un equipo.
     *
     * @param ventana Ventana actual que se cerrará.
     */
    public static void ventanaInscribirEquipo(JFrame ventana) {
        VentanaInscribirEquipo vi = new VentanaInscribirEquipo(ventana);
        vi.setVisible(true);
    }
    /**
     * Muestra la ventana para modificar un equipo si hay equipos disponibles.
     *
     * @return true si hay equipos disponibles, false en caso contrario.
     */
    public static boolean ventanaModificarEquipo() {
        VentanaModificacionEquipo ve = new VentanaModificacionEquipo();
        List<String> listaEquipos = ModeloController.listaEquipos();
        ve.setVisible(!listaEquipos.isEmpty());
        return !listaEquipos.isEmpty();
    }
    /**
     * Inscribe un equipo con los datos proporcionados.
     *
     * @param nombre Nombre del equipo.
     * @param fecha Fecha de creación del equipo.
     * @return true si el equipo fue inscrito correctamente, false en caso contrario.
     */
    public static boolean inscribirEquipo(String nombre, LocalDate fecha) {
        return ModeloController.inscribirEquipo(nombre,fecha);
    }

    /**
     * Muestra la ventana para eliminar un equipo si hay equipos disponibles.
     *
     * @return true si hay equipos disponibles, false en caso contrario.
     */
    public static boolean VentanaEliminarEquipo () {
        VentanaEliminarEquipo ve = new VentanaEliminarEquipo();
        List<String> listaEquipos = ModeloController.listaEquipos();
        ve.setVisible(!listaEquipos.isEmpty());
        return !listaEquipos.isEmpty();
    }
    /**
     * Cierra la ventana actual y abre la ventana de gestión de jornadas.
     *
     * @param ventana Ventana actual que se cerrará.
     * @param nombre Nombre del usuario o contexto asociado.
     */
    public static void ventanaGestionJornadas(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionJornada vgj = new VentanaGestionJornada(nombre);
        vgj.setVisible(true);
    }
    /**
     * Muestra la ventana para crear una nueva jornada.
     *
     * @param ventana Ventana actual que se cerrará.
     * @param nombre Nombre del usuario o contexto asociado.
     */
    public static void ventanaCrearJornada(JFrame ventana, String nombre) {
        VentanaCrearJornada vcj = new VentanaCrearJornada(ventana);
        vcj.setVisible(true);
    }

    /**
     * Crea una nueva jornada con la fecha de inicio proporcionada.
     *
     * @param fechaInicio Fecha de inicio de la jornada.
     * @return true si la jornada fue creada correctamente, false en caso contrario.
     */
    public static boolean crearJornada(LocalDate fechaInicio) {
        return ModeloController.crearJornada(fechaInicio);
    }

    /**
     * Verifica si una jornada existe en la base de datos.
     *
     * @param numJornada Número de la jornada a verificar.
     * @return true si la jornada existe, false en caso contrario.
     */
    public static boolean existeJornada (String numJornada){
        return ModeloController.existeJornada(numJornada);
    }
    /**
     * Obtiene una lista de jornadas con sus detalles almacenados en la base de datos.
     *
     * @return Una lista de arreglos de cadenas, donde cada arreglo contiene los detalles de una jornada.
     */
    public static List<String[]> obtenerJornadas(){
        return ModeloController.obtenerJornadas();
    }
    /**
     * Muestra la ventana con la lista de jornadas si hay jornadas disponibles.
     *
     * @return true si hay jornadas disponibles, false en caso contrario.
     */
    public static boolean VentanaMostrarJornada() {
        VentanaMostrarJornada vmj = new VentanaMostrarJornada();
        List<String> listaJornadas = ModeloController.listaJornadas();
        vmj.setVisible(!listaJornadas.isEmpty());
        return !listaJornadas.isEmpty();
    }
    /**
     * Obtiene una lista de nombres de todas las jornadas registradas.
     *
     * @return Una lista de cadenas con los nombres de las jornadas.
     */
    public static List<String> listaJornadas(){
        return ModeloController.listaJornadas();
    }
    /**
     * Cierra la ventana actual y abre la ventana de gestión de enfrentamientos.
     *
     * @param ventana Ventana actual que se cerrará.
     * @param nombre Nombre del usuario o contexto asociado.
     */
    public static void VentanaGestionEnfrentamientos(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionEnfrentamientos vgj = new VentanaGestionEnfrentamientos(nombre);
        vgj.setVisible(true);
    }


    /**
     * Modifica los datos de un equipo en la base de datos.
     *
     * @param nuevoNombre Nuevo nombre del equipo.
     * @param nuevaFecha Nueva fecha de creación del equipo.
     * @param nombre Nombre actual del equipo.
     * @return true si el equipo fue modificado correctamente, false en caso contrario.
     */
    public static boolean modificarEquipo(String nuevoNombre, LocalDate nuevaFecha, String nombre){
        return ModeloController.modificarEquipo(nuevoNombre,nuevaFecha,nombre);
    }
    /**
     * Modifica el nombre de un equipo en la base de datos.
     *
     * @param nuevoNombre Nuevo nombre del equipo.
     * @param nombre Nombre actual del equipo.
     * @return true si el equipo fue modificado correctamente, false en caso contrario.
     */
    public static boolean modificarEquipo(String nuevoNombre,String nombre){
        return ModeloController.modificarEquipo(nuevoNombre,nombre);
    }

    /**
     * Modifica la fecha de creación de un equipo en la base de datos.
     *
     * @param nuevaFecha Nueva fecha de creación del equipo.
     * @param nombre Nombre actual del equipo.
     * @return true si el equipo fue modificado correctamente, false en caso contrario.
     */
    public static boolean modificarEquipo(LocalDate nuevaFecha, String nombre){
        return ModeloController.modificarEquipo(nuevaFecha,nombre);
    }
    /**
     * Busca un equipo en la base de datos por su nombre.
     *
     * @param nombre Nombre del equipo a buscar.
     * @return true si el equipo existe, false en caso contrario.
     */
    public static boolean buscarEquipo(String nombre){
        return ModeloController.buscarEquipo(nombre);
    }


    /**
     * Elimina un equipo de la base de datos.
     *
     * @param equipoSeleccionado Nombre del equipo a eliminar.
     * @return true si el equipo fue eliminado correctamente, false en caso contrario.
     */

    public static boolean eliminarEquipo(String equipoSeleccionado) {
        return ModeloController.eliminarEquipo(equipoSeleccionado);
    }
    /**
     * Obtiene una lista de equipos con sus fechas de creación almacenadas en la base de datos.
     *
     * @return Una lista de arreglos de cadenas, donde cada arreglo contiene los detalles de un equipo.
     */
    public static List<String[]> obtenerEquiposConFechas(){
        return ModeloController.obtenerEquiposConFechas();
    }
    /**
     * Muestra una ventana de confirmación con el título proporcionado.
     *
     * @param title Título de la ventana de confirmación.
     * @return true si el usuario confirma, false en caso contrario.
     */
    public static boolean ventanaConfirmacion(String title){
        VentanaConfirmacion vc = new VentanaConfirmacion(title);
        vc.setVisible(true);
        return vc.isConfirmado();
    }
    /**
     * Cierra la ventana actual y abre la ventana de gestión de competiciones.
     *
     * @param ventana Ventana actual que se cerrará.
     * @param nombre Nombre del usuario o contexto asociado.
     */
    public static void ventanaGestionCompeticion(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionCompeticion vge = new VentanaGestionCompeticion(nombre);
        vge.setVisible(true);
    }
    /**
     * Cierra la ventana actual y abre la ventana de gestión de jugadores.
     *
     * @param ventana Ventana actual que se cerrará.
     * @param nombre Nombre del usuario o contexto asociado.
     */
    public static void ventanaGestionJugadores(JFrame ventana, String nombre) {
        ventana.dispose();
        VentanaGestionJugadores vge = new VentanaGestionJugadores(nombre);
        vge.setVisible(true);
    }
    /**
     * Abre una competición.
     *
     * @return true si la competición fue abierta correctamente, false en caso contrario.
     */
    public static boolean abrirCompeticion(){
        return ModeloController.abrirCompeticion();
    }
    /**
     * Cierra una competición.
     *
     * @return true si la competición fue cerrada correctamente, false en caso contrario.
     */
    public static boolean cerrarCompeticion(){
        return ModeloController.cerrarCompeticion();
    }
    /**
     * Crea una nueva competición.
     */
    public static void crearCompeticion(){
        ModeloController.crearCompeticion();
    }
    /**
     * Verifica si una competición ya ha sido creada.
     *
     * @return Un entero que indica el estado de la competición.
     */
    public static int verificarCompeticionCreada(){
        return ModeloController.verificarCompeticionCreada();
    }

    /**
     * Verifica el estado actual de la competición.
     *
     * @return true si la competición está activa, false en caso contrario.
     */
    public static boolean estadoCompeticion() {
        return ModeloController.estadoCompeticion();
    }


}