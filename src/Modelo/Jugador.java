package Modelo;

import Modelo.Enumeraciones.Rol;

import javax.management.relation.Role;
import java.time.LocalDate;

public class Jugador {
    private int idJugador;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private LocalDate fechaNac;
    private String nickname;
    private double sueldo;
    private Rol roles;

    public Jugador(int idJugador, String nombre, String apellido, String nacionalidad, LocalDate fechaNac, String nickname, double sueldo, Rol rol) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fechaNac = fechaNac;
        this.nickname = nickname;
        this.sueldo = sueldo;
        this.roles = roles;
    }
    public Jugador(){}
    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Rol getRol() {
        return roles;
    }

    public void setRol(Rol roles) {
        this.roles = roles;
    }
}
