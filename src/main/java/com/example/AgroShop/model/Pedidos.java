package com.example.AgroShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidos")
    private Long Id;

    @Column(nullable = false)
    private LocalDate fechaPedido;

    @Column(nullable = false)
    private LocalDate fechaSalida;

    @Column(nullable = false)
    private String direccionEntrega;

    @Column(nullable = false)
    private double valorTotal;

    @ManyToOne
    @JoinColumn(name = "id_Usuario", nullable = false)
    @JsonBackReference(value = "usuario-pedido")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "pedido-ref")
    private List<Producto_pedido> productosPedidos;

}
