package com.ari.pestaltoke.domain.model.submodulo;

import com.ari.pestaltoke.domain.model.estados.Estado;
import lombok.Data;

@Data
public class Submodulo {
    private final Long id;
    private final String nombre;
    private final String descripcion;
    private final Estado estado;
    private final Long moduloId;

    public Submodulo(Long id, String nombre, String descripcion, Estado estado, Long moduloId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.moduloId = moduloId;
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

    public Long getModuloId() {
        return moduloId;
    }
}
