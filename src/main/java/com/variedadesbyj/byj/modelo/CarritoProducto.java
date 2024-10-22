package com.variedadesbyj.byj.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarritoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCarritoProducto;
    Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "carritoId")
    @JsonIgnore
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "prductoId")
    @JsonIgnore
    private Producto producto;

}
