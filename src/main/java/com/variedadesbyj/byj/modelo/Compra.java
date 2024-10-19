package com.variedadesbyj.byj.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCompra;

    LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "clienteId", nullable = false)
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detalleCompras;
}
