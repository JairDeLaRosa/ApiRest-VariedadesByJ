package com.variedadesbyj.byj.repositorio;

import com.variedadesbyj.byj.modelo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositorio extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
}
