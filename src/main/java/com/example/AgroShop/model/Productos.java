package com.example.AgroShop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false)
    @Min(value = 0, message = "El precio no puede ser negativo")
    private double precio;
    @Column(nullable = false, length = 254)
    private String descripcion;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(nullable = false, length = 100)
    private String imagen;

    @OneToMany(mappedBy = "productos", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "producto-ref")
    private List<Producto_pedido> producto_pedido;

}