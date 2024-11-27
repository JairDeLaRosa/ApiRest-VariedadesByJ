package com.variedadesbyj.byj.objets;

public class AdminResponse {
    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String tipo;

    public AdminResponse(String nombre, String apellido, Integer idCliente, String email, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCliente = idCliente;
        this.email = email;
        this.tipo=tipo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
