package com.variedadesbyj.byj.repositorio;

import com.variedadesbyj.byj.modelo.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {
    Cliente findByEmail(String email);
}
