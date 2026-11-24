package com.ari.pestaltoke.domain.model.permisos;

import lombok.Data;

@Data
public class Permisos {
    private final Long id;
    private final Long rolId;
    private final Long moduloId;
    private final Long subModuloId;
    private final Accion accionesPermitidas;

    public Permisos(Long id, Long rolId, Long moduloId, Long subModuloId, Accion accionesPermitidas) {
        this.id = id;
        this.rolId = rolId;
        this.moduloId = moduloId;
        this.subModuloId = subModuloId;
        this.accionesPermitidas = accionesPermitidas;
    }

    public Long getId() {
        return id;
    }

    public Long getRolId() {
        return rolId;
    }

    public Long getModuloId() {
        return moduloId;
    }

    public Long getSubModuloId() {
        return subModuloId;
    }

    public Accion getAccionesPermitidas() {
        return accionesPermitidas;
    }
}
