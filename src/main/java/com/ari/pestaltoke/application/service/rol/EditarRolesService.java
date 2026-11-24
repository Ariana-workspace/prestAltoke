package com.ari.pestaltoke.application.service.rol;

import com.ari.pestaltoke.application.port.in.rol.EditarRolesUseCase;
import com.ari.pestaltoke.application.port.out.rol.RolRepositoryPort;
import com.ari.pestaltoke.domain.model.estados.Estado;
import com.ari.pestaltoke.domain.model.rol.Rol;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditarRolesService implements EditarRolesUseCase {
    private final RolRepositoryPort repo;
    public EditarRolesService(RolRepositoryPort repo){
        this.repo = repo;

    }

    @Override
    public Rol editar(Long id, String nombre, String descripcion, Estado estado) {
        repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + id));

        Rol rol = new Rol(id, nombre, descripcion, estado);
        return repo.editar(rol);
    }
}
