package com.example.AgroShop.controller;

import com.example.AgroShop.JwtUtil;
import com.example.AgroShop.model.Usuario;
import com.example.AgroShop.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listaUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping ("/{id}")
    public Usuario obtenerPorId(@PathVariable Long id){
        return usuarioService.obtenerUsuario(id);
    }

//    @PostMapping("/registrar")
//    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario){
//        usuarioService.guardarUsuario(usuario);
//        return ResponseEntity.ok("Registro realizado con éxito!");
//    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Usuario user) {
        usuarioService.registerUser(user);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario user) {
        UserDetails userDetails = usuarioService.loadUserByUsername(user.getCorreo());
        if (userDetails != null && passwordEncoder.matches(user.getContraseña(), userDetails.getPassword())) {
            String token = jwtUtil.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok("Usuario eliminado con éxito!");
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity<String> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        usuarioService.editarUsuario(id, usuarioActualizado);
        return ResponseEntity.ok("Usuario actualizado con éxito!");
    }

    @GetMapping ("/correo/{correo}")
    public Usuario obtenerPorCorreo(@PathVariable String correo){
        return usuarioService.findByCorreo(correo);
    }
}
