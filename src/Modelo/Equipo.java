package Modelo;

import java.util.ArrayList;

public class Equipo {
    private int idEquipo;
    private String nombre;
    private String fechaFund;
    private ArrayList<Enfrentamiento> enfrentamientos = new ArrayList<>();
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    public Equipo(int idEquipo, String nombre, String fechaFund) {}
    public Equipo(){}

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaFund() {
        return fechaFund;
    }

    public void setFechaFund(String fechaFund) {
        this.fechaFund = fechaFund;
    }

    public ArrayList<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    public void setEnfrentamientos(ArrayList<Enfrentamiento> enfrentamientos) {
        this.enfrentamientos = enfrentamientos;
    }
}
