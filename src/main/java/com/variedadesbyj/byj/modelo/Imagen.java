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
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idImagen;

    String url;

    @ManyToOne
    @JoinColumn(name = "productoId", nullable = false)
    @JsonIgnore
    private Producto producto;

    public Integer getIdImagen() {
        return idImagen;
    }

    public String getUrl() {
        return url;
    }

    public Producto getProducto() {
        return producto;
    }
}
