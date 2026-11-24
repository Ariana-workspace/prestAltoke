package com.ari.pestaltoke.infraestructure.adapter.out.persistence.rol;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RolJpaRepository extends JpaRepository<RolEntity, Long> {
    @Override
    Optional<RolEntity> findById(Long aLong);

    boolean findByNombre(String nombre);
}
