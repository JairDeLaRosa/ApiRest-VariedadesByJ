package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Categoria;
import com.variedadesbyj.byj.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio implements ICategoriaServicio{
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public List<Categoria> listarCategoria() {
        return categoriaRepositorio.findAll();
    }

    @Override
    public Categoria buscarCategoria(Integer idCategoria) {
        return categoriaRepositorio.findById(idCategoria).orElse(null);
    }

    @Override
    public Categoria buscarCategoriaByNombre(String nombre) {
        return categoriaRepositorio.findByNombre(nombre);
    }

    @Override
    public boolean guardarCategoria(Categoria categoria) {
        boolean guardado=false;
        if (categoria!=null){
            categoriaRepositorio.save(categoria);
            guardado=true;
        }
        return guardado;
    }

    @Override
    public boolean eliminarCategoria(Categoria categoria) {
        boolean eliminado=false;
        if (categoria!=null){
            categoriaRepositorio.delete(categoria);
            eliminado=true;
        }
        return eliminado;
    }
}
