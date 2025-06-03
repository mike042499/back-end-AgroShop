package com.example.AgroShop.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedidos;

    @Column(nullable = false)
    private LocalDate fechaPedido;

    @Column(nullable = false)
    private LocalDate fechaSalida;

    @Column(nullable = false)
    private String direccionEntrega;

    @Column(nullable = false)
    private double valorTotal;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL)
    private List<Producto_pedido> productosPedidos;


    public Pedidos() {
    }

    public Pedidos(Long id_pedidos, LocalDate fechaPedido, LocalDate fechaSalida, String direccionEntrega, double valorTotal, Usuario usuario, List<Producto_pedido> productosPedidos) {
        this.id_pedidos = id_pedidos;
        this.fechaPedido = fechaPedido;
        this.fechaSalida = fechaSalida;
        this.direccionEntrega = direccionEntrega;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
        this.productosPedidos = productosPedidos;
    }

    public Long getId_pedidos() {
        return id_pedidos;
    }

    public void setId_pedidos(Long id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Producto_pedido> getProductosPedidos() {
        return productosPedidos;
    }

    public void setProductosPedidos(List<Producto_pedido> productosPedidos) {
        this.productosPedidos = productosPedidos;
    }
}