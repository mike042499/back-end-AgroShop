package com.example.AgroShop.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
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

    //Constructores
    public Usuario() {
    }
    public Usuario(Long id_usuario, String nombre, String direccion, String localidad, String telefono, String correo, String contraseña) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    //Getters y Setters
    public Long getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
