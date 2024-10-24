package com.variedadesbyj.byj.modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@MappedSuperclass
public abstract class Usuario {
    private String nombre;
    private String apellido;

    @Column(unique = true)
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}