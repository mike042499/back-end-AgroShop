package com.example.AgroShop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;


@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false)
    @Min(value = 0, message = "El precio no puede ser negativo")
    private double precio;
    @Column(nullable = false, length = 80)
    private String descripcion;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(nullable = false, length = 100)
    private String imagen;

    public Producto() {
    }

    public Producto(Long id_producto, String nombre, double precio, String descripcion, int cantidad, String imagen) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
