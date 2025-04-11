package Modelo;

import java.time.LocalDate;
import java.util.List;

public class Jornada {
    private int numJornada;  // Número de la jornada
    private LocalDate fechaInicio; // Fecha de inicio de la jornada
    private List<Enfrentamiento> enfrentamientos;  // Lista de enfrentamientos en la jornada

    // Constructor
    public Jornada(int numJornada, LocalDate fechaInicio, List<Enfrentamiento> enfrentamientos) {
        this.numJornada = numJornada;
        this.fechaInicio = fechaInicio;
        this.enfrentamientos = enfrentamientos;
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

    public List<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    public void setEnfrentamientos(List<Enfrentamiento> enfrentamientos) {
        this.enfrentamientos = enfrentamientos;
    }

}