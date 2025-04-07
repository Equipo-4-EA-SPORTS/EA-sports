package Modelo;

import java.util.ArrayList;

public class Jornada {
    private int numJornada;
    private String fechaInicio;
    private ArrayList<Competicion> competiciones = new ArrayList<Competicion>();
    public Jornada(int numJornada, String fechaInicio) {}
    public Jornada() {}

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public ArrayList<Competicion> getCompeticiones() {
        return competiciones;
    }

    public void setCompeticiones(ArrayList<Competicion> competiciones) {
        this.competiciones = competiciones;
    }
}
