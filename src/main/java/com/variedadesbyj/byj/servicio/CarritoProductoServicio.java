package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.CarritoProducto;
import com.variedadesbyj.byj.repositorio.CarritoProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoProductoServicio implements ICarritoProductoServicio{
    @Autowired
    private CarritoProductoRepositorio carritoProductoRepositorio;


    @Override
    public List<CarritoProducto> listarCarritoProductos() {
        return carritoProductoRepositorio.findAll();
    }

    @Override
    public CarritoProducto buscarCarritoProducto(Integer idCarritoProducto) {
        return carritoProductoRepositorio.findById(idCarritoProducto).orElse(null);
    }

    @Override
    public boolean guardarCarritoProducto(CarritoProducto carritoProducto) {
        boolean guardado=false;
        if (carritoProducto!=null){
            carritoProductoRepositorio.save(carritoProducto);
            guardado=true;
        }
        return guardado;
    }

    @Override
    public boolean eliminarCarritoProducto(CarritoProducto carritoProducto) {
        boolean eliminado=false;
        if (carritoProducto!=null){
            carritoProductoRepositorio.delete(carritoProducto);
            eliminado=true;
        }
        return eliminado;
    }
}
