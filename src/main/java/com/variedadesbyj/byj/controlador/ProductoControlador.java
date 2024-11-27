package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Producto;
import com.variedadesbyj.byj.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/productos/{id}")
    public Producto producto(@PathVariable Integer id){
        return  productoServicio.buscarProducto(id);
    }
    @PostMapping("/producto")
    public Producto guardarProducto(@RequestBody Producto producto){
        return  productoServicio.guardarProcucto(producto);
    }
}
