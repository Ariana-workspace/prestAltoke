package com.ari.pestaltoke.infraestructure.adapter.out.persistence.submodulo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubModuloJpaRepository extends JpaRepository<SubModuloEntity, Long> {
    boolean existsByNombreAndModuloId(String nombre, Long moduloId);
}
