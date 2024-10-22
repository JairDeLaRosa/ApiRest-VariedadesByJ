package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.DetalleCompra;
import com.variedadesbyj.byj.repositorio.DetalleCompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCompraServicio implements IDetalleCompraServicio{

    @Autowired
    private DetalleCompraRepositorio detalleCompraRepositorio;

    @Override
    public List<DetalleCompra> listarDetalleCompras() {
        return detalleCompraRepositorio.findAll();
    }

    @Override
    public DetalleCompra buscarDetalleCompra(Integer idDetalleCompra) {
        return detalleCompraRepositorio.findById(idDetalleCompra).orElse(null);
    }

    @Override
    public boolean guardarDetalleCompra(DetalleCompra detalleCompra) {
        boolean guardado=false;
        if (detalleCompra!=null){
            detalleCompraRepositorio.save(detalleCompra);
            guardado=true;
        }
        return guardado;
    }

    @Override
    public boolean eliminarDetalleCompra(DetalleCompra detalleCompra) {
        boolean eliminado=false;
        if (detalleCompra!=null){
            detalleCompraRepositorio.delete(detalleCompra);
            eliminado=true;
        }
        return eliminado;
    }
}
