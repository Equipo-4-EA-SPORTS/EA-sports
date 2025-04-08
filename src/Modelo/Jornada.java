package Modelo;

import java.time.LocalDate;
import java.util.List;

public class Jornada {
    private int nroJornada;
    private LocalDate fechaInicio;

    //Relacion
    private List<Enfrentamiento> listaEnfrentamientos;
    private Competicion competicion;

    //Constructores

    public Jornada() {
    }

    public Jornada(int nroJornada, LocalDate fechaInicio, List<Enfrentamiento> listaEnfrentamientos, Competicion competicion) {
        this.nroJornada = nroJornada;
        this.fechaInicio = fechaInicio;
        this.listaEnfrentamientos = listaEnfrentamientos;
        this.competicion = competicion;
    }

    //Getters y setters

    public int getNroJornada() {
        return nroJornada;
    }

    public void setNroJornada(int nroJornada) {
        this.nroJornada = nroJornada;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<Enfrentamiento> getListaEnfrentamientos() {
        return listaEnfrentamientos;
    }

    public void setListaEnfrentamientos(List<Enfrentamiento> listaEnfrentamientos) {
        this.listaEnfrentamientos = listaEnfrentamientos;
    }

    public Competicion getCompeticion() {
        return competicion;
    }

    public void setCompeticion(Competicion competicion) {
        this.competicion = competicion;
    }
}