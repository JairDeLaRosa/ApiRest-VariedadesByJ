package com.variedadesbyj.byj.repositorio;

import com.variedadesbyj.byj.modelo.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface ImagenRepositorio extends JpaRepository<Imagen,Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Imagen i WHERE i.producto.id = :productoId")
    void eliminarPorProductoId(Integer productoId);
}
