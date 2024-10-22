package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Imagen;

import com.variedadesbyj.byj.servicio.IImagenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("byj")
@CrossOrigin(value = "http://localhost:5173")
public class ImagenControlador {
    @Autowired
    private IImagenServicio imagenServicio;

    @GetMapping("/imagenesProductos")
    public List<Imagen> imagenes(){
        return imagenServicio.listarImagenes();
    }
}
