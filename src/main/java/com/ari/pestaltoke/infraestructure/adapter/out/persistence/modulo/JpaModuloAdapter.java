package com.ari.pestaltoke.infraestructure.adapter.out.persistence.modulo;

import com.ari.pestaltoke.application.port.out.modulo.ModuloRepositoryPort;
import com.ari.pestaltoke.domain.model.modulo.Modulo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaModuloAdapter implements ModuloRepositoryPort {

    private final ModuloJpaRepository jpa;

    public JpaModuloAdapter(ModuloJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Modulo guardar(Modulo modulo) {
        ModuloEntity entity = new ModuloEntity();
        entity.setId(modulo.getId());
        entity.setNombre(modulo.getNombre());
        entity.setDescripcion(modulo.getDescripcion());
        entity.setEstado(modulo.getEstado());

        return toDomain(jpa.save(entity));
    }

    @Override
    public List<Modulo> listar() {
        return jpa.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public boolean existePorId(Long id) {
        return jpa.existsById(id);
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return jpa.existsByNombre(nombre);
    }

    private Modulo toDomain(ModuloEntity e) {
        return new Modulo(e.getId(), e.getNombre(), e.getDescripcion(), e.getEstado());
    }
}
