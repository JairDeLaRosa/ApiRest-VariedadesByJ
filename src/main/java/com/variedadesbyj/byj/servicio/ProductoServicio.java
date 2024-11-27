package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Producto;
import com.variedadesbyj.byj.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProducto(Integer idProducto) {
        return productoRepositorio.findById(idProducto).orElse(null);
    }

    @Override
    public Producto guardarProcucto(Producto producto) {
            productoRepositorio.save(producto);
            return productoRepositorio.findByNombre(producto.getNombre());
    }

    @Override
    public boolean eliminarProducto(Producto producto) {
        boolean eliminado=false;
        if (producto!=null){
            productoRepositorio.delete(producto);
            eliminado=true;
        }
        return eliminado;
    }
}
