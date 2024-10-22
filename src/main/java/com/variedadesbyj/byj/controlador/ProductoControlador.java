package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Producto;
import com.variedadesbyj.byj.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("byj")
@CrossOrigin(value = "http://localhost:5173")
public class ProductoControlador {

    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> productos(){
        return productoServicio.listarProductos();
    }
}
