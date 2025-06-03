package com.example.AgroShop.service;

import com.example.AgroShop.model.Producto_pedido;

import java.util.List;

public interface IProducto_pedidoService {

    Producto_pedido guardarRelacion (Producto_pedido producto_pedido);

    List<Producto_pedido> listarTodas();

    Producto_pedido buscarPorId(Long id);

    void eliminarPorId(Long id);

    Producto_pedido buscarPorIdPedido(Long idPedido);

    Producto_pedido buscarPorIdProducto(Long idProducto);
}
