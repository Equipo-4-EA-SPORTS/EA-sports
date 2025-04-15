package Modelo;

import java.time.LocalDate;
import java.util.List;

public class Jornada {
    private int numJornada;  // Número de la jornada
    private LocalDate fechaInicio;// Fecha de inicio de la jornada
    private LocalDate fechaFin;
    private List<Enfrentamiento> enfrentamientos;  // Lista de enfrentamientos en la jornada

    // Constructor
    public Jornada(int numJornada, LocalDate fechaInicio,LocalDate fechaFin, List<Enfrentamiento> enfrentamientos) {
        this.numJornada = numJornada;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.enfrentamientos = enfrentamientos;
    }

    public Jornada(int numJornada, LocalDate fechaInicio, LocalDate fechaFin) {
        this.numJornada = numJornada;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Métodos getters y setters
    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    public void setEnfrentamientos(List<Enfrentamiento> enfrentamientos) {
        this.enfrentamientos = enfrentamientos;
    }

}