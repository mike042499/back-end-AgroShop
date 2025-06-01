package com.example.AgroShop.service;

import com.example.AgroShop.model.Usuario;

import java.util.List;

public interface iUsuarioService {
    List <Usuario> obtenerUsuarios();
    Usuario obtenerUsuario(Long id);
    void guardarUsuario(Usuario usuario);
    void deleteUsuario(Long id);
    void editarUsuario(Long id, Usuario usuarioActualizado);
}
