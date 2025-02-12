package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Imagen;
import com.variedadesbyj.byj.repositorio.ImagenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenServicio implements IImagenServicio{
    @Autowired
    private ImagenRepositorio imagenRepositorio;

    @Override
    public List<Imagen> listarImagenes() {
        return imagenRepositorio.findAll();
    }

    @Override
    public boolean guardarImagen(Imagen imagen) {
        boolean guardado=false;
        if (imagen!=null){
            imagenRepositorio.save(imagen);
            guardado=true;
        }
        return guardado;
    }

    @Override
    public boolean eliminarImagen(Integer productoId) {
        boolean eliminado=false;
        if (productoId!=null){
            imagenRepositorio.eliminarPorProductoId(productoId);
            eliminado=true;
        }
        return eliminado;
    }
}
