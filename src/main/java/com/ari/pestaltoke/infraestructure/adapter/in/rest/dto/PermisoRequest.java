package com.ari.pestaltoke.infraestructure.adapter.in.rest.dto;

import com.ari.pestaltoke.domain.model.permisos.Accion;

public record PermisoRequest(Long rolId, Long moduloId, Long subModuloId, Accion accion) {
}
