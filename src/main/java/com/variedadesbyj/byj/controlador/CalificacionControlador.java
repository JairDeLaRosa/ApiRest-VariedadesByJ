package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Calificacion;
import com.variedadesbyj.byj.servicio.ICalificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("byj")
public class CalificacionControlador {
    @Autowired
    private ICalificacionServicio calificacionServicio;

    @GetMapping("/calificaciones")
    public List<Calificacion> calificaciones(){
        return calificacionServicio.listarCalificacions();
    }
}
