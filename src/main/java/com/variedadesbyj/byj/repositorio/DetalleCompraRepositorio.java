package com.variedadesbyj.byj.repositorio;

import com.variedadesbyj.byj.modelo.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DetalleCompraRepositorio extends JpaRepository<DetalleCompra, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM DetalleCompra i WHERE i.compra.id = :compraId")
    void eliminarPorCompraId(Integer compraId);
}
