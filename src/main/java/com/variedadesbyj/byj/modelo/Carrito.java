package com.variedadesbyj.byj.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCarrito;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clienteId", referencedColumnName = "idCliente")
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(mappedBy = "carrito",cascade = CascadeType.ALL, orphanRemoval = true)
    List<CarritoProducto> carritoProductos;

}
