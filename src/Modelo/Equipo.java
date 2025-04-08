package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equipo {
    private int idEquipo;
    private String nombre;
    private LocalDate fechaFund;
    private List<String> listaRolesDisponibles;

    //Relacion
    private List<Jugador> listaJugadores;

    //Constructores

    public Equipo() {
    }

    public Equipo(int idEquipo, String nombre, LocalDate fechaFund, List<Jugador> listaJugadores) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.fechaFund = fechaFund;
        this.listaJugadores = listaJugadores;
        this.listaRolesDisponibles = new ArrayList<>(Arrays.asList("Duelista","Controlador","Centinela","Iniciador","Asesino","Mago"));
    }

    //Getters y setters

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaFund() {
        return fechaFund;
    }

    public void setFechaFund(LocalDate fechaFund) {
        this.fechaFund = fechaFund;
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public List<String> getListaRolesDisponibles() {
        return listaRolesDisponibles;
    }

    public void setListaRolesDisponibles(List<String> listaRolesDisponibles) {
        this.listaRolesDisponibles = listaRolesDisponibles;
    }

    public void eliminarRol(String rol){
        this.listaRolesDisponibles.remove(rol);
    }

}