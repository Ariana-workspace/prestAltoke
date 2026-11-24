package com.ari.pestaltoke.domain.model.codigo_asesor;

public class Asesor {
    private final Long id;
    private final String nombre;

    public Asesor(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
