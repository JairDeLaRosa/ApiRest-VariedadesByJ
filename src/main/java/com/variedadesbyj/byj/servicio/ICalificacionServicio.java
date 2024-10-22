package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Calificacion;

import java.util.List;

public interface ICalificacionServicio {
    public List<Calificacion> listarCalificacions();
    public Calificacion buscarCalificacion(Integer idCalificacion);
    public boolean guardarCalificacion(Calificacion calificacion);
    public boolean eliminarCalificacion(Calificacion calificacion);
}
