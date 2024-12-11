package com.variedadesbyj.byj.controlador;

import com.variedadesbyj.byj.modelo.Imagen;

import com.variedadesbyj.byj.modelo.Producto;
import com.variedadesbyj.byj.servicio.CludinaryService;
import com.variedadesbyj.byj.servicio.IImagenServicio;
import com.variedadesbyj.byj.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("byj")
@CrossOrigin(value = "*")
public class ImagenControlador {
    @Autowired
    private IImagenServicio imagenServicio;

    @Autowired
    private CludinaryService cloudinaryService;

    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/imagenesProductos")
    public List<Imagen> imagenes(){
        return imagenServicio.listarImagenes();
    }
    @PostMapping("/imagenesProductos")
    public boolean guardarImagenes(@RequestParam("productoId") Integer productoId,
                                   @RequestPart("files") List<MultipartFile> files) {

        Boolean guardado=false;
        for (MultipartFile file: files){
            Imagen imagen = new Imagen();
            var producto = productoServicio.buscarProducto(productoId);
            imagen.setProducto(producto);
            try {
                String url=cloudinaryService.uploadFile(file);
                System.out.println(url);
                imagen.setUrl(url);
                guardado=imagenServicio.guardarImagen(imagen);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return guardado;
    }
}
