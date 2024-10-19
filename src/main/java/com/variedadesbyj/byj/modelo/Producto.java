package com.variedadesbyj.byj.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProducto;

    String nombre;
    Integer cantidad;
    boolean costo;
    String descripcion;

    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompras;

    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagenes;

    @OneToMany(mappedBy = "producto")
    private List<Calificacion> calificaciones;
}
