package com.ari.pestaltoke.infraestructure.adapter.out.persistence.permisos;

import com.ari.pestaltoke.application.port.out.permisos.PermisoRepositoryPort;
import com.ari.pestaltoke.domain.model.permisos.Accion;
import com.ari.pestaltoke.domain.model.permisos.Permisos;
import org.springframework.stereotype.Component;

@Component
public class JpaPermisoAdapter implements PermisoRepositoryPort {

    private final PermisoJpaRepository jpa;

    public JpaPermisoAdapter(PermisoJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Permisos guardar(Permisos permisos) {
        PermisoEntity entity = new PermisoEntity();
        entity.setId(permisos.getId());
        entity.setRolId(permisos.getRolId());
        entity.setModuloId(permisos.getModuloId());
        entity.setSubmoduloId(permisos.getSubModuloId());
        entity.setAccionesPermitidas(permisos.getAccionesPermitidas());

        return toDomain(jpa.save(entity));
    }

    @Override
    public boolean existeAsignacion(Long rolId, Long moduloId, Long subModuloId, Accion accion) {
        return jpa.existsByRolIdAndModuloIdAndSubmoduloIdAndAccionesPermitidas(rolId, moduloId, subModuloId, accion);
    }

    private Permisos toDomain(PermisoEntity e) {
        return new Permisos(e.getId(), e.getRolId(), e.getModuloId(), e.getSubmoduloId(), e.getAccionesPermitidas());
    }
}
