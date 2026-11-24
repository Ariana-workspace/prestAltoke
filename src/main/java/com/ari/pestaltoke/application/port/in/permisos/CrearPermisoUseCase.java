package com.ari.pestaltoke.application.port.in.permisos;

import com.ari.pestaltoke.domain.model.permisos.Accion;
import com.ari.pestaltoke.domain.model.permisos.Permisos;

public interface CrearPermisoUseCase {
    Permisos crear(Long rolId, Long moduloId, Long subModuloId, Accion accion);
}
