package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.CarritoProducto;

import java.util.List;

public interface ICarritoProductoServicio {
    public List<CarritoProducto> listarCarritoProductos();
    public CarritoProducto buscarCarritoProducto(Integer idCarritoProducto);
    public boolean guardarCarritoProducto(CarritoProducto carritoProducto);
    public boolean eliminarCarritoProducto(CarritoProducto carritoProducto);
}
