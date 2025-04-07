package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Enfrentamiento {
    private int idEnfrentamiento;
    private LocalDate fehca;
    private LocalTime hora;

    //Relacion
    private Equipo ganadorEnf;
    private Equipo perdedorEnf;
    private Jornada jornada;

    //Constructores

    public Enfrentamiento() {
    }

    public Enfrentamiento(int idEnfrentamiento, LocalDate fehca, LocalTime hora, Equipo ganadorEnf, Equipo perdedorEnf, Jornada jornada) {
        this.idEnfrentamiento = idEnfrentamiento;
        this.fehca = fehca;
        this.hora = hora;
        this.ganadorEnf = ganadorEnf;
        this.perdedorEnf = perdedorEnf;
        this.jornada = jornada;
    }

    //Getters y setters


    public int getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(int idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    public LocalDate getFehca() {
        return fehca;
    }

    public void setFehca(LocalDate fehca) {
        this.fehca = fehca;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Equipo getGanadorEnf() {
        return ganadorEnf;
    }

    public void setGanadorEnf(Equipo ganadorEnf) {
        this.ganadorEnf = ganadorEnf;
    }

    public Equipo getPerdedorEnf() {
        return perdedorEnf;
    }

    public void setPerdedorEnf(Equipo perdedorEnf) {
        this.perdedorEnf = perdedorEnf;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }
}