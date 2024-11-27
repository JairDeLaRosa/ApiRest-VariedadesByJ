package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Categoria;

import java.util.List;

public interface ICategoriaServicio {
    public List<Categoria> listarCategoria();
    public Categoria buscarCategoria(Integer idCategoria);
    public Categoria buscarCategoriaByNombre(String nombre);
    public boolean guardarCategoria(Categoria categoria);
    public boolean eliminarCategoria(Categoria categoria);
}
