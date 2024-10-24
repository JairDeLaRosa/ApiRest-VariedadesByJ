package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Cliente;
import com.variedadesbyj.byj.objets.ClienteResponse;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface IClienteServicio {
    public List<ClienteResponse> listarClientes();
    public ClienteResponse buscarCliente(Integer idCliente);
    public ResponseEntity<?> buscarPorCorreoYContrasena(String email, String contrasena);
    public boolean guardarCliente(Cliente cliente);
    public boolean eliminarCliente(Cliente cliente);
}
