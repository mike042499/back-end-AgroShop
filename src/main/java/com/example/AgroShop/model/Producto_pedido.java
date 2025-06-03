package com.example.AgroShop.model;

import jakarta.persistence.*;

@Entity
public class Producto_pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto_pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos productos;

    @ManyToOne
    @JoinColumn(name = "id_pedidos", nullable = false)
    private Pedidos pedidos;

    public Producto_pedido() {

    }

    public Producto_pedido(Long id_producto_pedido, Productos productos, Pedidos pedidos) {
        this.id_producto_pedido = id_producto_pedido;
        this.productos = productos;
        this.pedidos = pedidos;
    }

    public Long getId_producto_pedido() {
        return id_producto_pedido;
    }

    public void setId_producto_pedido(Long id_producto_pedido) {
        this.id_producto_pedido = id_producto_pedido;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
}