package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.CarritoProducto;
import com.variedadesbyj.byj.modelo.Cliente;
import com.variedadesbyj.byj.servicio.ICarritoProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("byj")
public class CarritoProductoControlador {
    @Autowired
    private ICarritoProductoServicio carritoProductoServicio;

    @GetMapping("/carritoProductos")
    public List<CarritoProducto> optenerEmpleados(){
        return carritoProductoServicio.listarCarritoProductos();
    }
}
