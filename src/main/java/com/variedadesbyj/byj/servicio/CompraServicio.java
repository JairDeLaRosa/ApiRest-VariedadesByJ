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
    public Compra guardarCompra(Compra compra) {
        return  compraRepositorio.save(compra);
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
