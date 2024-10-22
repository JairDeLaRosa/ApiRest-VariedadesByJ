package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Carrito;
import com.variedadesbyj.byj.modelo.Cliente;
import com.variedadesbyj.byj.servicio.ICarritoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("byj")
@CrossOrigin(value = "http://localhost:5173")
public class CarritoControlador {
    @Autowired
    private ICarritoServicio carritoServicio;

    @GetMapping("/carritos")
    public List<Carrito> optenerEmpleados(){
        return carritoServicio.listarCarritos();
    }
}
