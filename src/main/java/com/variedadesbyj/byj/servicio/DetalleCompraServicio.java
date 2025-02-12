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
    public DetalleCompra guardarDetalleCompra(DetalleCompra detalleCompra) {
        return detalleCompraRepositorio.save(detalleCompra);
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

    @Override
    public boolean eliminarDetalleCompraPorCompraId(Integer compraId) {
        if(compraId!=null){
            detalleCompraRepositorio.eliminarPorCompraId(compraId);
            return true;
        }else {
            return false;
        }
    }
}
