package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.DetalleCompra;

import java.util.List;

public interface IDetalleCompraServicio {
    public List<DetalleCompra> listarDetalleCompras();
    public DetalleCompra buscarDetalleCompra(Integer idDetalleCompra);
    public DetalleCompra guardarDetalleCompra(DetalleCompra detalleCompra);
    public boolean eliminarDetalleCompra(DetalleCompra detalleCompra);
    public boolean eliminarDetalleCompraPorCompraId(Integer compraId);
}
