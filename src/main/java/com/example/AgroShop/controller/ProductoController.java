package com.example.AgroShop.controller;


import com.example.AgroShop.model.Producto;
import com.example.AgroShop.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listarProductos(){
        return productoService.obtenerProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id){
        return productoService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarProducto(@RequestBody Producto producto){
        productoService.guardarProducto(producto);
        return ResponseEntity.ok("Producto agregado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
        productoService.actualizarProducto(id, producto);
        return ResponseEntity.ok("Producto editado con exito");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarProducto(@PathVariable Long id){
        productoService.borrarProducto(id);
        return ResponseEntity.ok("Producto borrado con exito");
    }
}
