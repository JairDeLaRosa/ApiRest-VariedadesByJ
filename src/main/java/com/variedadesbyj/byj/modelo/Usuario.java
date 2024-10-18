package com.variedadesbyj.byj.modelo;
import jakarta.persistence.*;


@MappedSuperclass
public abstract class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getApellido() {
        return apellido;
    }
}