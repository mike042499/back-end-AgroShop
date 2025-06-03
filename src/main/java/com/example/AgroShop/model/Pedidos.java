package com.example.AgroShop.model;

import jakarta.persistence.*;
import java.time.LocalDate;

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

    public Pedidos() {
    }

    public Pedidos(Long id_pedidos, LocalDate fechaPedido, LocalDate fechaSalida,
                   String direccionEntrega, double valorTotal, Usuario usuario) {
        this.id_pedidos = id_pedidos;
        this.fechaPedido = fechaPedido;
        this.fechaSalida = fechaSalida;
        this.direccionEntrega = direccionEntrega;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
    }

    public Long getId_pedido() {
        return id_pedidos;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedidos = id_pedido;
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
}
