package Modelo;

import java.awt.*;
import java.util.ArrayList;

public class Enfrentamiento{
    private int idEnfrentamiento;
    private String ganadorEnf;
    private String perdedorEnf;
    private String fecha;
    private String hora;
// TODO Cada enfrentamiento debe de tener 2 equipos
    public Enfrentamiento() {}

    public Enfrentamiento(int idEnfrentamiento, String ganadorEnf, String perdedorEnf, String fecha, String hora) {
        this.idEnfrentamiento = idEnfrentamiento;
        this.ganadorEnf = ganadorEnf;
        this.perdedorEnf = perdedorEnf;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(int idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    public String getGanadorEnf() {
        return ganadorEnf;
    }

    public void setGanadorEnf(String ganadorEnf) {
        this.ganadorEnf = ganadorEnf;
    }

    public String getPerdedorEnf() {
        return perdedorEnf;
    }

    public void setPerdedorEnf(String perdedorEnf) {
        this.perdedorEnf = perdedorEnf;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
