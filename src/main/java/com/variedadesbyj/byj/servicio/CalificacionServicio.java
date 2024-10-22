package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Calificacion;
import com.variedadesbyj.byj.repositorio.CalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionServicio implements ICalificacionServicio{

    @Autowired
    private CalificacionRepositorio calificacionRepositorio;

    @Override
    public List<Calificacion> listarCalificacions() {
        return calificacionRepositorio.findAll();
    }

    @Override
    public Calificacion buscarCalificacion(Integer idCalificacion) {
        return calificacionRepositorio.findById(idCalificacion).orElse(null);
    }

    @Override
    public boolean guardarCalificacion(Calificacion calificacion) {
        boolean guardado=false;
        if (calificacion!=null){
            calificacionRepositorio.save(calificacion);
            guardado=true;
        }
        return guardado;
    }

    @Override
    public boolean eliminarCalificacion(Calificacion calificacion) {
        boolean eliminado=false;
        if (calificacion!=null){
            calificacionRepositorio.delete(calificacion);
            eliminado=true;
        }
        return eliminado;
    }
}

