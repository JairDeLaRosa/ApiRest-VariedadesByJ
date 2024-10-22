package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Compra;
import com.variedadesbyj.byj.repositorio.CompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServicio implements ICompraServicio{
    @Autowired
    private CompraRepositorio compraRepositorio;

    @Override
    public List<Compra> listarCompras() {
        return compraRepositorio.findAll();
    }

    @Override
    public Compra buscarCompra(Integer idCompra) {
        return compraRepositorio.findById(idCompra).orElse(null);
    }

    @Override
    public boolean guardarCompra(Compra compra) {
        boolean guardado=false;
        if (compra!=null){
            compraRepositorio.save(compra);
            guardado=true;
        }
        return guardado;
    }

    @Override
    public boolean eliminarCompra(Compra compra) {
        boolean eliminado=false;
        if (compra!=null){
            compraRepositorio.delete(compra);
            eliminado=true;
        }
        return eliminado;
    }
}
