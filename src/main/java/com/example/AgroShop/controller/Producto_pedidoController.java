package com.example.AgroShop.controller;

import com.example.AgroShop.model.Producto_pedido;
import com.example.AgroShop.service.IProducto_pedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productopedido")
public class Producto_pedidoController {

    private final IProducto_pedidoService productoPedidoService;

    @Autowired
    public Producto_pedidoController(IProducto_pedidoService productoPedidoService) {
        this.productoPedidoService = productoPedidoService;
    }

    @PostMapping
    public Producto_pedido guardarRelacion(@RequestBody Producto_pedido producto_pedido){
        return productoPedidoService.guardarRelacion(producto_pedido);
    }

    public List<Producto_pedido> obtenerTodas(){
        return productoPedidoService.listarTodas();
    }

}
