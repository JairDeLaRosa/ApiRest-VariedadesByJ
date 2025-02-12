package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Compra;
import com.variedadesbyj.byj.servicio.ICompraServicio;
import com.variedadesbyj.byj.servicio.IDetalleCompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("byj")
public class CompraControlador {
    @Autowired
    private ICompraServicio compraServicio;

    @Autowired
    private IDetalleCompraServicio detalleCompraServicio;

    @GetMapping("/compras")
    public List<Compra> imagenes(){
        return compraServicio.listarCompras();
    }

    @PostMapping("/compras")
    public Compra guardarCompra(@RequestBody Compra compra){
        System.out.println(compra);
        return compraServicio.guardarCompra(compra);
    }
    @DeleteMapping("/compras/{id}")
    public boolean eliminarCompra(@PathVariable Integer id){
        boolean eliminado=false;
        Compra compra=compraServicio.buscarCompra(id);
        if(compra!=null){
            eliminado=detalleCompraServicio.eliminarDetalleCompraPorCompraId(id);
            eliminado=compraServicio.eliminarCompra(compra);
        }
        return eliminado;
    }
}
