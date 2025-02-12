package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Compra;

import java.util.List;

public interface ICompraServicio {
    public List<Compra> listarCompras();
    public Compra buscarCompra(Integer idCompra);
    public Compra guardarCompra(Compra compra);
    public boolean eliminarCompra(Compra compra);
}
