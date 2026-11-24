package com.ari.pestaltoke.domain.model.rol;

import com.ari.pestaltoke.domain.model.estados.Estado;
import lombok.Data;

@Data
public class Rol {
    private final Long id;
    private final String nombre;
    private final String descripcion;
    private final Estado estado;

    public Rol(Long id, String nombre, String descripcion, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }
}

