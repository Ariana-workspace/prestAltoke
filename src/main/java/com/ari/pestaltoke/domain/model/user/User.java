package com.ari.pestaltoke.domain.model.user;

import com.ari.pestaltoke.domain.model.estados.EstadoUser;
import com.ari.pestaltoke.domain.model.rol.Rol;
import lombok.Data;


@Data
public class User{
    private final Long id;
    private final String email;
    private final String passwordHash;
    private EstadoUser estado;
    private String nombre;
    private String username;
    private Long rol;

    public User(Long id, String email, String passwordHash) {
        this(id, email, passwordHash, EstadoUser.ACTIVADO);
    }

    public User(Long id, String email, String passwordHash, EstadoUser estado) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.estado = estado;
    }

    public User(Long id, String email, String passwordHash, EstadoUser estado, String nombre, String username, Long rol) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.estado = estado;
        this.nombre = nombre;
        this.username = username;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public EstadoUser getEstado() {
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
}
