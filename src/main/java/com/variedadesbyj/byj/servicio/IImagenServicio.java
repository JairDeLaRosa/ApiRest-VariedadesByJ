package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Imagen;

import java.util.List;

public interface IImagenServicio {
    public List<Imagen> listarImagenes();
    public boolean guardarImagen(Imagen imagen);
    public boolean eliminarImagen(Integer productoId);
}
