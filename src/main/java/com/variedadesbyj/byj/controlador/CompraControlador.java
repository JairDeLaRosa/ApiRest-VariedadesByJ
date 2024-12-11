package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Compra;
import com.variedadesbyj.byj.servicio.ICompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("byj")
public class CompraControlador {
    @Autowired
    private ICompraServicio compraServicio;

    @GetMapping("/compras")
    public List<Compra> imagenes(){
        return compraServicio.listarCompras();
    }
}
