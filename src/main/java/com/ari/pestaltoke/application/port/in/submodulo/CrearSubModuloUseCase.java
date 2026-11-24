package com.ari.pestaltoke.application.port.in.submodulo;

import com.ari.pestaltoke.domain.model.estados.Estado;
import com.ari.pestaltoke.domain.model.submodulo.Submodulo;

public interface CrearSubModuloUseCase {
    Submodulo crear(String nombre, String descripcion, Estado estado, Long moduloId);
}
