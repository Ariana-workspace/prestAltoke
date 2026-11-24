package com.ari.pestaltoke.infraestructure.adapter.out.persistence.usuario;


import com.ari.pestaltoke.infraestructure.adapter.out.persistence.rol.RolEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String username;
    @Column(name = "rol_id", nullable = false)
    private Long rol;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public Long getRol() {
        return rol;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRol(Long rol) {
        this.rol = rol;
    }
}
