package com.ari.pestaltoke.infraestructure.adapter.out.persistence.permisos;

import com.ari.pestaltoke.domain.model.permisos.Accion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisoJpaRepository extends JpaRepository<PermisoEntity, Long> {
    // Ojo: en PermisoEntity el campo se llama "submoduloId" (con m minúscula)
    boolean existsByRolIdAndModuloIdAndSubmoduloIdAndAccionesPermitidas(
            Long rolId, Long moduloId, Long submoduloId, Accion accionesPermitidas);
}
