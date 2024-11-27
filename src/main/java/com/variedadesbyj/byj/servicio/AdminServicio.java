package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Admin;
import com.variedadesbyj.byj.objets.AdminResponse;
import com.variedadesbyj.byj.repositorio.AdminRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServicio implements IAdminServicio{
    @Autowired
    private AdminRepositorio adminRepositorio;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Admin> listarAdmins() {
        return adminRepositorio.findAll();
    }

    @Override
    public Admin buscarAdmin(Integer idAdmin) {
        return adminRepositorio.findById(idAdmin).orElse(null);
    }

    @Override
    public boolean guardarAdmin(Admin admin) {
        boolean guardado=false;
        if (admin!=null){
            String encryptedPassword = passwordEncoder.encode(admin.getContrasena());
            admin.setContrasena(encryptedPassword);
            adminRepositorio.save(admin);
            guardado=true;
        }
        return guardado;
    }

    @Override
    public ResponseEntity<?> buscarPorCorreoYContrasena(String email, String contrasena) {
        Admin admin=adminRepositorio.findByEmail(email);
        if (admin!=null){
            if (passwordEncoder.matches(contrasena,admin.getContrasena())){
                AdminResponse adminResponse=new AdminResponse(admin.getNombre(), admin.getApellido(), admin.getIdAdmin(), admin.getEmail(),"admin");
                return new ResponseEntity<>(adminResponse, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Contrasena invalida", HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>("Correo invalido", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public boolean eliminarAdmin(Admin admin) {
        boolean eliminado=false;
        if (admin!=null){
            adminRepositorio.delete(admin);
            eliminado=true;
        }
        return eliminado;
    }
}
