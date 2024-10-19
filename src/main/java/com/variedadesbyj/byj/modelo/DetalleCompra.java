package com.variedadesbyj.byj.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idDetalleCompra;

    String cantidad;
    boolean precioUnitario;

    @ManyToOne
    @JoinColumn(name = "compraId", nullable = false)
    @JsonIgnore
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "productoId", nullable = false)
    @JsonIgnore
    private Producto producto;
}
