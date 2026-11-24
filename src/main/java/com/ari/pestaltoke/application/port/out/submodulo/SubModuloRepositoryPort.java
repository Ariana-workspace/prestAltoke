package com.ari.pestaltoke.application.port.out.submodulo;

import com.ari.pestaltoke.domain.model.submodulo.Submodulo;

import java.util.Optional;

public interface SubModuloRepositoryPort {
    Submodulo guardar(Submodulo submodulo);

    Optional<Submodulo> buscarPorId(Long id);

    boolean existePorNombreYModulo(String nombre, Long moduloId);
}
