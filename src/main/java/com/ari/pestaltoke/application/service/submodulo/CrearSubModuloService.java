package com.ari.pestaltoke.application.service.submodulo;

import com.ari.pestaltoke.application.port.in.submodulo.CrearSubModuloUseCase;
import com.ari.pestaltoke.application.port.out.modulo.ModuloRepositoryPort;
import com.ari.pestaltoke.application.port.out.submodulo.SubModuloRepositoryPort;
import com.ari.pestaltoke.domain.model.estados.Estado;
import com.ari.pestaltoke.domain.model.submodulo.Submodulo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CrearSubModuloService implements CrearSubModuloUseCase {

    private final SubModuloRepositoryPort repo;
    private final ModuloRepositoryPort moduloRepo;

    public CrearSubModuloService(SubModuloRepositoryPort repo, ModuloRepositoryPort moduloRepo) {
        this.repo = repo;
        this.moduloRepo = moduloRepo;
    }

    @Override
    public Submodulo crear(String nombre, String descripcion, Estado estado, Long moduloId) {
        if (nombre == null || nombre.isBlank() || descripcion == null || descripcion.isBlank()
                || estado == null || moduloId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Faltan parámetros: nombre, descripcion, estado y moduloId son obligatorios");
        }

        // El módulo padre debe existir
        if (!moduloRepo.existePorId(moduloId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el módulo con id: " + moduloId);
        }

        // No puede repetirse el submódulo dentro del mismo módulo
        if (repo.existePorNombreYModulo(nombre, moduloId)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "El submódulo '" + nombre + "' ya existe en el módulo " + moduloId);
        }

        return repo.guardar(new Submodulo(null, nombre, descripcion, estado, moduloId));
    }
}
