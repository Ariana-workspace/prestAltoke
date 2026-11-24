package com.ari.pestaltoke.application.port.out.rol;

import com.ari.pestaltoke.domain.model.rol.Rol;

import java.util.List;
import java.util.Optional;

public interface RolRepositoryPort {
    Optional<Rol> findById(Long aLong);
    Optional<Rol> findByNombre(String nombre);
    boolean existePorNombre(String nombre);
    Rol crearRol(Rol rol);
    Rol editar(Rol rol);
    List<Rol> listar();
}
