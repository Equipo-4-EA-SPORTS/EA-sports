package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Enfrentamiento {
    private int idEnfrentamiento;  // Identificador único del enfrentamiento
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipoGanador;  // El equipo ganador del enfrentamiento
    private Equipo equipoPerdedor; // El equipo perdedor
    private LocalDate fecha;  // Fecha del enfrentamiento
    private LocalTime hora;
    private boolean jugado;  // Si el enfrentamiento ya ha sido jugado

    // Constructor
    public Enfrentamiento(int idEnfrentamiento, Equipo equipo1, Equipo equipo2, LocalDate fecha, LocalTime hora) {
        this.idEnfrentamiento = idEnfrentamiento;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.hora = hora;
        this.equipoGanador = null;
        this.equipoPerdedor = null;
        this.jugado = false;
    }

    public Enfrentamiento(int idEnfrentamiento, Equipo equipo1, Equipo equipo2, String string) {
    }

    // Métodos getters y setters
    public int getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(int idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
        this.equipoPerdedor = (equipoGanador == equipo1) ? equipo2 : equipo1;  // El perdedor es el que no ganó
        this.jugado = true;  // Al asignar un ganador, el enfrentamiento se considera jugado
    }

    public Equipo getEquipoPerdedor() {
        return equipoPerdedor;
    }

    public void setEquipoPerdedor(Equipo equipoPerdedor) {
        this.equipoPerdedor = equipoPerdedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }

}