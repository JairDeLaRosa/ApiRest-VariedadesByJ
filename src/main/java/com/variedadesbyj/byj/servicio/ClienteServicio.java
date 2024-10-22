package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Cliente;
import com.variedadesbyj.byj.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarCliente(Integer idCliente) {

        return clienteRepositorio.findById(idCliente).orElse(null);
    }

    @Override
    public boolean guardarCliente(Cliente cliente) {
        boolean guardado=false;
        if (cliente!=null){
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
