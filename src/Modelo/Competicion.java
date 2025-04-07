package Modelo;

import java.util.List;

public class Competicion {
    private int idCompeticion;
    private EstadoCompeticion estado;

    //Relacion
    private List<Jornada> listaJornadas;

    //Constructores

    public Competicion() {
    }

    public Competicion(int idCompeticion, EstadoCompeticion estado, List<Jornada> listaJornadas) {
        this.idCompeticion = idCompeticion;
        this.estado = estado;
        this.listaJornadas = listaJornadas;
    }

    //Getters y setters

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public EstadoCompeticion getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompeticion estado) {
        this.estado = estado;
    }

    public List<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(List<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }
}