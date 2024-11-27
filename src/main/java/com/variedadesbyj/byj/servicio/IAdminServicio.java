package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Admin;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAdminServicio {
    public List<Admin> listarAdmins();
    public Admin buscarAdmin(Integer idAdmin);
    public boolean guardarAdmin(Admin admin);
    public boolean eliminarAdmin(Admin admin);
    public ResponseEntity<?> buscarPorCorreoYContrasena(String email, String contrasena);
}
