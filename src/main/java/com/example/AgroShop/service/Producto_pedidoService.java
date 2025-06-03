package com.example.AgroShop.service;

import com.example.AgroShop.model.Producto_pedido;
import com.example.AgroShop.repository.IProducto_pedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Producto_pedidoService implements IProducto_pedidoService {

    private IProducto_pedidoRepository productoPedidoRepository;

    @Autowired
    public Producto_pedidoService(IProducto_pedidoRepository productoPedidoRepository) {
        this.productoPedidoRepository = productoPedidoRepository;
    }

    @Override
    public Producto_pedido guardarRelacion(Producto_pedido producto_pedido) {
        return productoPedidoRepository.save(producto_pedido);
    }

    @Override
    public List<Producto_pedido> listarTodas() {
        return productoPedidoRepository.findAll();
    }

    @Override
    public Producto_pedido buscarPorId(Long id) {
        return productoPedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
        productoPedidoRepository.deleteById(id);
    }

    @Override
    public Producto_pedido buscarPorIdPedido(Long idPedido) {
        return productoPedidoRepository.findById(idPedido).orElse(null);
    }

    @Override
    public Producto_pedido buscarPorIdProducto(Long idProducto) {
        return productoPedidoRepository.findById(idProducto).orElse(null);
    }
}
