package com.variedadesbyj.byj.controlador;


import com.variedadesbyj.byj.modelo.DetalleCompra;
import com.variedadesbyj.byj.servicio.IDetalleCompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("byj")
public class DetalleCompraControlador {
    @Autowired
    private IDetalleCompraServicio detalleCompraServicio;

    @GetMapping("/detallesDeCompras")
    public List<DetalleCompra> detallesDeCompras(){
        return detalleCompraServicio.listarDetalleCompras();
    }

    @PostMapping("/detallesDeCompras")
    public DetalleCompra guardarDetalleCompra(@RequestBody DetalleCompra detalleCompra){
        System.out.println(detalleCompra);
        return detalleCompraServicio.guardarDetalleCompra(detalleCompra);
    }
}
