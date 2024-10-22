package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Imagen;

import java.util.List;

public interface IImagenServicio {
    public List<Imagen> listarImagenes();
    public Imagen buscarImagen(Integer idImagen);
    public boolean guardarImagen(Imagen imagen);
    public boolean eliminarImagen(Imagen imagen);
}
