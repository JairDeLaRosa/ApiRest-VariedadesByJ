package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Compra;
import com.variedadesbyj.byj.modelo.DetalleCompra;
import com.variedadesbyj.byj.servicio.ICompraServicio;
import com.variedadesbyj.byj.servicio.IDetalleCompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("byj")
@CrossOrigin(value = "*")
public class DetalleCompraControlador {
    @Autowired
    private IDetalleCompraServicio detalleCompraServicio;

    @GetMapping("/detallesDeCompras")
    public List<DetalleCompra> detallesDeCompras(){
        return detalleCompraServicio.listarDetalleCompras();
    }
}
