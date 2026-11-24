package com.ari.pestaltoke.infraestructure.adapter.out.persistence.submodulo;

import com.ari.pestaltoke.application.port.out.submodulo.SubModuloRepositoryPort;
import com.ari.pestaltoke.domain.model.submodulo.Submodulo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaSubModuloAdapter implements SubModuloRepositoryPort {

    private final SubModuloJpaRepository jpa;

    public JpaSubModuloAdapter(SubModuloJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Submodulo guardar(Submodulo submodulo) {
        SubModuloEntity entity = new SubModuloEntity();
        entity.setId(submodulo.getId());
        entity.setNombre(submodulo.getNombre());
        entity.setDescripcion(submodulo.getDescripcion());
        entity.setEstado(submodulo.getEstado());
        entity.setModuloId(submodulo.getModuloId());

        return toDomain(jpa.save(entity));
    }

    @Override
    public Optional<Submodulo> buscarPorId(Long id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public boolean existePorNombreYModulo(String nombre, Long moduloId) {
        return jpa.existsByNombreAndModuloId(nombre, moduloId);
    }

    private Submodulo toDomain(SubModuloEntity e) {
        return new Submodulo(e.getId(), e.getNombre(), e.getDescripcion(), e.getEstado(), e.getModuloId());
    }
}
