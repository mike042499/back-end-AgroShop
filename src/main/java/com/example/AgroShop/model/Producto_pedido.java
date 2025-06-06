package com.example.AgroShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto_pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_pedido")
    private Long idProductoPedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    @JsonBackReference(value = "producto-ref")
    private Productos productos;

    @ManyToOne
    @JoinColumn(name = "id_pedidos", nullable = false)
    @JsonBackReference(value = "pedido-ref")
    private Pedidos pedidos;

    @Column(nullable = false)
    private Integer cantidad;
}