package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.exepciones.RecursoNoEncontrado;
import com.variedadesbyj.byj.modelo.Admin;
import com.variedadesbyj.byj.servicio.IAdminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("byj")
@CrossOrigin(value = "http://localhost:5173")
public class AdminControlador {
    @Autowired
    private IAdminServicio adminServicio;

    @GetMapping("admin")
    public List<Admin> listarAdminst(){
        return adminServicio.listarAdmins();
    }

    @PostMapping("/admin")
    public Boolean guardarAdmin(@RequestBody Admin admin){
        boolean guardado=false;
        if (admin!=null||admin.getNombre()!=null||admin.getApellido()!=null||admin.getEmail()!=null||admin.getContrasena()!=null){
            guardado=adminServicio.guardarAdmin(admin);
        }
        if (guardado==false){
            throw new RecursoNoEncontrado("No se pudo guardar el Cliente");
        }
        return guardado;
    }

}
