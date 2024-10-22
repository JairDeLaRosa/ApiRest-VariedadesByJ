package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Carrito;

import java.util.List;

public interface ICarritoServicio {
    public List<Carrito> listarCarritos();
    public Carrito buscarCarrito(Integer idCarrito);
    public boolean guardarCarrito(Carrito carrito);
    public boolean eliminarCarrito(Carrito carrito);
}
