package com.example.AgroShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String localidad;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String contraseña;

}