package com.example.AgroShop.service;

import com.example.AgroShop.model.Usuario;
import com.example.AgroShop.repository.iUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements iUsuarioService{
    private final iUsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(iUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void editarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);

        if (usuarioExistente != null){
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
            usuarioExistente.setLocalidad(usuarioActualizado.getLocalidad());
            usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
            usuarioExistente.setContraseña(usuarioActualizado.getContraseña());

            usuarioRepository.save(usuarioExistente);
        } else {
            throw new RuntimeException("Usuario no encontrado con el id: " + id);
        }
    }

    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public Usuario registerUser(Usuario user) {
        Usuario userLogin = new Usuario();
        userLogin.setNombre(user.getNombre());
        userLogin.setContraseña(passwordEncoder.encode(user.getContraseña()));
        userLogin.setDireccion(user.getDireccion());
        userLogin.setLocalidad(user.getLocalidad());
        userLogin.setTelefono(user.getTelefono());
        userLogin.setCorreo(user.getCorreo());
        // Encriptar la contraseña
        return usuarioRepository.save(userLogin);
    }

    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByCorreo(correo);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new org.springframework.security.core.userdetails.User(user.getCorreo(), user.getContraseña(), new ArrayList<>());
    }
}
