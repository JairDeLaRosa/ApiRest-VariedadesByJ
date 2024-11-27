package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    public List<Producto> listarProductos();
    public Producto buscarProducto(Integer idProducto);
    public Producto guardarProcucto(Producto producto);
    public boolean eliminarProducto(Producto producto);
}
