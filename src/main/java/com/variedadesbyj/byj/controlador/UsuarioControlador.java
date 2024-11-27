package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.exepciones.RecursoNoEncontrado;
import com.variedadesbyj.byj.modelo.Cliente;
import com.variedadesbyj.byj.objets.ClienteResponse;
import com.variedadesbyj.byj.objets.LoginRequest;
import com.variedadesbyj.byj.servicio.IAdminServicio;
import com.variedadesbyj.byj.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("byj")
@CrossOrigin(value = "http://localhost:5173")
public class UsuarioControlador {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);

    @Autowired
    private IClienteServicio clienteServicio;

    @Autowired
    private IAdminServicio adminServicio;

    @GetMapping("/clientes")
    public List<ClienteResponse> optenerEmpleados(){
        return clienteServicio.listarClientes();
    }
    @PostMapping("/check-usuario")
    public ResponseEntity<?> optenrClienteByEmailAndPasword(@RequestBody LoginRequest loginRequest){
        ResponseEntity<?> responseCliente= clienteServicio.buscarPorCorreoYContrasena(loginRequest.getEmail(),loginRequest.getContrasena());
        ResponseEntity<?> responseAdmin= adminServicio.buscarPorCorreoYContrasena(loginRequest.getEmail(),loginRequest.getContrasena());
        if (responseAdmin.getStatusCode()==HttpStatus.OK){
            return responseAdmin;
        }else {
            return responseCliente;
        }
    }
    @GetMapping("/clientes/{id}")
    public ClienteResponse optenerCliente(@PathVariable Integer id){
        var Cliente=clienteServicio.buscarCliente(id);
        if (Cliente==null){
            throw new RecursoNoEncontrado("Cliente no encontrado.");
        }
        return clienteServicio.buscarCliente(id);
    }
    @PostMapping("/clientes")
    public boolean guardarCliente(@RequestBody Cliente cliente){
        boolean guardado=false;
        if (cliente!=null||cliente.getNombre()!=null||cliente.getApellido()!=null||cliente.getEmail()!=null||cliente.getContrasena()!=null){
            guardado=clienteServicio.guardarCliente(cliente);
        }
        if (guardado==false){
            throw new RecursoNoEncontrado("No se pudo guardar el Cliente");
        }
        return guardado;
    }
}
