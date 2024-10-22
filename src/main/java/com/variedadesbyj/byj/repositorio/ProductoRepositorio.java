package com.variedadesbyj.byj.repositorio;

import com.variedadesbyj.byj.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto,Integer> {
}
