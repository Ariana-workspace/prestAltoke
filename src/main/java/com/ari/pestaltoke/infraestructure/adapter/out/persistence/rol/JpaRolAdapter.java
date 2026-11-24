package com.ari.pestaltoke.infraestructure.adapter.out.persistence.rol;

import com.ari.pestaltoke.application.port.out.rol.RolRepositoryPort;
import com.ari.pestaltoke.domain.model.estados.Estado;
import com.ari.pestaltoke.domain.model.rol.Rol;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaRolAdapter implements RolRepositoryPort {
    private final RolJpaRepository jpa;

    public JpaRolAdapter(RolJpaRepository jpa){
        this.jpa = jpa;
    }
    @Override
    public Optional<Rol> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Rol> findByNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return jpa.findByNombre(nombre);
    }

    @Override
    public Rol crearRol(Rol rol) {
        RolEntity r = new RolEntity();
        r.setId(rol.getId());
        r.setNombre(rol.getNombre());
        r.setDescripcion(rol.getDescripcion());
        r.setEstado(rol.getEstado().name());
        return aDominio(jpa.save(r));
    }

    @Override
    public Rol editar(Rol rol) {
        RolEntity editarRol = jpa.findById(rol.getId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + rol.getId()));
        editarRol.setNombre(rol.getNombre());
        editarRol.setDescripcion(rol.getDescripcion());
        editarRol.setEstado(rol.getEstado().name());

        RolEntity guardado = jpa.save(editarRol);

        return new Rol(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getDescripcion(),
                Estado.valueOf(guardado.getEstado())
        );
    }

    @Override
    public List<Rol> listar() {
        return jpa.findAll().stream()
                .map(e -> new Rol(
                        e.getId(),
                        e.getNombre(),
                        e.getDescripcion(),
                        Estado.valueOf(e.getEstado())
                ))
                .toList();
    }

    private Rol aDominio(RolEntity e){
        return new Rol(
                e.getId(),
                e.getNombre(),
                e.getDescripcion(),
                Estado.valueOf(e.getEstado())
        );
    }
}
