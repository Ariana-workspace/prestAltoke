package com.ari.pestaltoke.application.service.rol;

import com.ari.pestaltoke.application.port.in.rol.CrearRolUseCase;
import com.ari.pestaltoke.application.port.out.rol.RolRepositoryPort;
import com.ari.pestaltoke.domain.model.estados.Estado;
import com.ari.pestaltoke.domain.model.rol.Rol;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CrearRolService implements CrearRolUseCase {
    private final RolRepositoryPort repo;

    public CrearRolService(RolRepositoryPort repo){
        this.repo = repo;
    }

    @Override
    public Rol crearRol(String nombre, String descripcion, Estado estado) {
        Optional<Rol> rolExistente = repo.findByNombre(nombre);

        if (rolExistente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        Rol rol = new Rol(null, nombre, descripcion, estado);

        return repo.crearRol(rol);
    }
}
