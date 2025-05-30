package com.example.AgroShop.service;

import com.example.AgroShop.model.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> obtenerProductos();
    Producto obtenerPorId(Long id);
    void guardarProducto(Producto producto);
    void actualizarProducto(Long id, Producto producto);
    void borrarProducto(Long id);
}
