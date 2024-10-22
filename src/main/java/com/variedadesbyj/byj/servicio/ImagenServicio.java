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
    public Imagen buscarImagen(Integer idImagen) {
        return imagenRepositorio.findById(idImagen).orElse(null);
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
    public boolean eliminarImagen(Imagen imagen) {
        boolean eliminado=false;
        if (imagen!=null){
            imagenRepositorio.delete(imagen);
            eliminado=true;
        }
        return eliminado;
    }
}
