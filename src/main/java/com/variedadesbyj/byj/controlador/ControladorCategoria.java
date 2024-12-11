package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Categoria;
import com.variedadesbyj.byj.servicio.ICategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("byj")
@CrossOrigin(value = "*")
public class ControladorCategoria {
    @Autowired
    private ICategoriaServicio categoriaServicio;

        @GetMapping("/categorias")
    public List<Categoria> categorias(){
        return categoriaServicio.listarCategoria();
    }

    @GetMapping("/categorias/{nombre}")
    public Categoria categorias(@PathVariable String nombre){
        return categoriaServicio.buscarCategoriaByNombre(nombre);
    }
    @PostMapping("/categoria")
    public Boolean agregarCategoria(@RequestBody Categoria categoria){
        return categoriaServicio.guardarCategoria(categoria);
    }
}
