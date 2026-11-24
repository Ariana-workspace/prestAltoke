package com.ari.pestaltoke.application.port.in.modulo;

import com.ari.pestaltoke.domain.model.estados.Estado;
import com.ari.pestaltoke.domain.model.modulo.Modulo;

public interface CrearModuloUseCase {
    Modulo crear(String nombre, String descripcion, Estado estado);
}
