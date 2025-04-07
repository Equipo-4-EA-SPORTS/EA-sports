package Modelo;

import Modelo.Enumeraciones.EstadoCompeticion;

public class Competicion {
private int idCompeticion;
private EstadoCompeticion estadoCompeticion;
public Competicion(int idCompeticion, String estadoCompeticion) {}
public Competicion(){}

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public EstadoCompeticion getEstadoCompeticion() {
        return estadoCompeticion;
    }

    public void setEstadoCompeticion(EstadoCompeticion estadoCompeticion) {
        this.estadoCompeticion = estadoCompeticion;
    }
}
