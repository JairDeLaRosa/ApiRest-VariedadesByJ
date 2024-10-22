package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Carrito;
import com.variedadesbyj.byj.repositorio.CarritoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServicio implements ICarritoServicio{

    @Autowired
    private CarritoRepositorio carritoRepositorio;

    @Override
    public List<Carrito> listarCarritos() {
        return carritoRepositorio.findAll();
    }

    @Override
    public Carrito buscarCarrito(Integer idCarrito) {
        return carritoRepositorio.findById(idCarrito).orElse(null);
    }

    @Override
    public boolean guardarCarrito(Carrito carrito) {
        boolean guardado=false;
        if (carrito!=null){
            carritoRepositorio.save(carrito);
            guardado=true;
        }
        return guardado;
    }

    @Override
    public boolean eliminarCarrito(Carrito carrito) {
        boolean eliminado=false;
        if (carrito!=null){
            carritoRepositorio.delete(carrito);
            eliminado=true;
        }
        return eliminado;
    }
}
