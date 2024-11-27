package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Cliente;
import com.variedadesbyj.byj.objets.ClienteResponse;
import com.variedadesbyj.byj.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<ClienteResponse> listarClientes() {
        List<Cliente> clientes=clienteRepositorio.findAll();
        List<ClienteResponse> clienteResponses=new ArrayList<>();
        clientes.forEach(cliente -> {
            ClienteResponse clienteResponse=new ClienteResponse(cliente.getIdCliente(),cliente.getNombre(),cliente.getApellido(),cliente.getEmail(),cliente.getDepartamento(),cliente.getMunicipio(),cliente.getDireccion(),cliente.getTelefono(),"cliente");
            clienteResponses.add(clienteResponse);
        });
        return clienteResponses;
    }

    @Override
    public ClienteResponse buscarCliente(Integer idCliente) {
        Cliente cliente=clienteRepositorio.findById(idCliente).orElse(null);
        ClienteResponse clienteResponse=new ClienteResponse(cliente.getIdCliente(),cliente.getNombre(),cliente.getApellido(),cliente.getEmail(),cliente.getDepartamento(),cliente.getMunicipio(),cliente.getDireccion(),cliente.getTelefono(),"cliente");
        return clienteResponse;
    }

    @Override
    public ResponseEntity<?> buscarPorCorreoYContrasena(String email, String contrasena) {
        Cliente cliente=clienteRepositorio.findByEmail(email);
        if (cliente!=null){
            if (passwordEncoder.matches(contrasena,cliente.getContrasena())){
                ClienteResponse clienteResponse=new ClienteResponse(cliente.getIdCliente(),cliente.getNombre(),cliente.getApellido(),cliente.getEmail(),cliente.getDepartamento(),cliente.getMunicipio(),cliente.getDireccion(),cliente.getTelefono(), "cliente");
                return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Contrasena invalida", HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>("Correo invalido", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public boolean guardarCliente(Cliente cliente) {
        boolean guardado=false;
        if (cliente!=null){
            String encryptedPassword = passwordEncoder.encode(cliente.getContrasena());
            cliente.setContrasena(encryptedPassword);
            clienteRepositorio.save(cliente);
            guardado=true;
        }
        return guardado;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        boolean eliminado=false;
        if (cliente!=null){
            clienteRepositorio.delete(cliente);
            eliminado=true;
        }
        return eliminado;
    }
}
