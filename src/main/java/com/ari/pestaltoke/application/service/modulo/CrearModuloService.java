package com.ari.pestaltoke.application.service.modulo;

import com.ari.pestaltoke.application.port.in.modulo.CrearModuloUseCase;
import com.ari.pestaltoke.application.port.out.modulo.ModuloRepositoryPort;
import com.ari.pestaltoke.domain.model.estados.Estado;
import com.ari.pestaltoke.domain.model.modulo.Modulo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CrearModuloService implements CrearModuloUseCase {

    private final ModuloRepositoryPort repo;

    public CrearModuloService(ModuloRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Modulo crear(String nombre, String descripcion, Estado estado) {
        if (nombre == null || nombre.isBlank() || descripcion == null || descripcion.isBlank() || estado == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Faltan parámetros: nombre, descripcion y estado son obligatorios");
        }

        if (repo.existePorNombre(nombre)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El módulo ya existe: " + nombre);
        }

        return repo.guardar(new Modulo(null, nombre, descripcion, estado));
    }
}
