package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Categoria;
import com.variedadesbyj.byj.servicio.ICategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("byj")
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
    @GetMapping("/categoriasPorId/{id}")
    public Categoria buscarCategorias(@PathVariable Integer id){
        return categoriaServicio.buscarCategoria(id);
    }
    @PostMapping("/categoria")
    public Boolean agregarCategoria(@RequestBody Categoria categoria){
        return categoriaServicio.guardarCategoria(categoria);
    }
    @DeleteMapping("/categoriaEliminar/{id}")
    public Boolean eliminar(@PathVariable Integer id){
        Categoria categoria=categoriaServicio.buscarCategoria(id);
        return categoriaServicio.eliminarCategoria(categoria);
    }
}
