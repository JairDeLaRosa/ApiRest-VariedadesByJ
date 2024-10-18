package com.variedadesbyj.byj.servicio;

import com.variedadesbyj.byj.modelo.Cliente;


import java.util.List;

public interface IClienteServicio {
    public List<Cliente> listarClientes();
    public Cliente buscarCliente(Integer idCliente);
    public boolean guardarCliente(Cliente cliente);
    public boolean eliminarCliente(Cliente cliente);
}
