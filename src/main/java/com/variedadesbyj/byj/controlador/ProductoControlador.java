package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Imagen;
import com.variedadesbyj.byj.modelo.Producto;
import com.variedadesbyj.byj.servicio.CludinaryService;
import com.variedadesbyj.byj.servicio.IImagenServicio;
import com.variedadesbyj.byj.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("byj")
public class ProductoControlador {

    @Autowired
    private IProductoServicio productoServicio;

    @Autowired
    private CludinaryService cludinaryService;

    @Autowired
    private IImagenServicio imagenServicio;

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
    @DeleteMapping("/productos/{id}")
    public boolean eliminarProducto(@PathVariable Integer id){
        List<String> urls= new ArrayList<>();
        Producto producto = productoServicio.buscarProducto(id);
        for (Imagen imagen: producto.getImagenes()){
            System.out.println(imagen.getUrl());
            urls.add(imagen.getUrl());
        }
        cludinaryService.eliminarImagenesPorUrls(urls);
        imagenServicio.eliminarImagen(id);
        productoServicio.eliminarProducto(producto);
        return true;
    }

}
