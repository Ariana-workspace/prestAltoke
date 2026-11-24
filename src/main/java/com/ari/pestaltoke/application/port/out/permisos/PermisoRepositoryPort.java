package com.ari.pestaltoke.application.port.out.permisos;

import com.ari.pestaltoke.domain.model.permisos.Accion;
import com.ari.pestaltoke.domain.model.permisos.Permisos;

public interface PermisoRepositoryPort {
    Permisos guardar(Permisos permisos);

    boolean existeAsignacion(Long rolId, Long moduloId, Long subModuloId, Accion accion);
}
