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
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCalificacion;

    Integer puntuacion;
    String comentario;

    @ManyToOne()
    @JoinColumn(name = "productoId", nullable = false)
    @JsonIgnore
    private Producto producto;

    @ManyToOne()
    @JoinColumn(name = "productoId", nullable = false)
    @JsonIgnore
    private Cliente cliente;


}
