package com.variedadesbyj.byj.repositorio;

import com.variedadesbyj.byj.modelo.Categoria;
import com.variedadesbyj.byj.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
    Categoria findByNombre(String nombre);
}
