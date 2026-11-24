package com.ari.pestaltoke.infraestructure.adapter.out.persistence.modulo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuloJpaRepository extends JpaRepository<ModuloEntity, Long> {
    boolean existsByNombre(String nombre);
}
