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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPedido;

    String nombre;
    double preco;

    @ManyToOne
    @JoinColumn(name = "clienteId", nullable = false)
    @JsonIgnore
    private Cliente cliente;
}
