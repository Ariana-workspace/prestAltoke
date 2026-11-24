package com.ari.pestaltoke.application.port.in.rol;

import com.ari.pestaltoke.domain.model.estados.Estado;
import com.ari.pestaltoke.domain.model.rol.Rol;

public interface CrearRolUseCase {
    Rol crearRol(String nombre, String descripcion, Estado estado);
}
