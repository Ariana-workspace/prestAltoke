package com.ari.pestaltoke.application.port.out.modulo;

import com.ari.pestaltoke.domain.model.modulo.Modulo;

import java.util.List;

public interface ModuloRepositoryPort {
    Modulo guardar(Modulo modulo);

    List<Modulo> listar();

    boolean existePorId(Long id);

    boolean existePorNombre(String nombre);
}
