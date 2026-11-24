package com.ari.pestaltoke.application.service.permisos;

import com.ari.pestaltoke.application.port.in.permisos.CrearPermisoUseCase;
import com.ari.pestaltoke.application.port.out.modulo.ModuloRepositoryPort;
import com.ari.pestaltoke.application.port.out.permisos.PermisoRepositoryPort;
import com.ari.pestaltoke.application.port.out.rol.RolRepositoryPort;
import com.ari.pestaltoke.application.port.out.submodulo.SubModuloRepositoryPort;
import com.ari.pestaltoke.domain.model.permisos.Accion;
import com.ari.pestaltoke.domain.model.permisos.Permisos;
import com.ari.pestaltoke.domain.model.submodulo.Submodulo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CrearPermisoService implements CrearPermisoUseCase {

    private final PermisoRepositoryPort repo;
    private final RolRepositoryPort rolRepo;
    private final ModuloRepositoryPort moduloRepo;
    private final SubModuloRepositoryPort subModuloRepo;

    public CrearPermisoService(PermisoRepositoryPort repo,
                               RolRepositoryPort rolRepo,
                               ModuloRepositoryPort moduloRepo,
                               SubModuloRepositoryPort subModuloRepo) {
        this.repo = repo;
        this.rolRepo = rolRepo;
        this.moduloRepo = moduloRepo;
        this.subModuloRepo = subModuloRepo;
    }

    @Override
    public Permisos crear(Long rolId, Long moduloId, Long subModuloId, Accion accion) {
        if (rolId == null || moduloId == null || subModuloId == null || accion == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Faltan parámetros: rolId, moduloId, subModuloId y accion son obligatorios");
        }

        // 404 si no existe el rol o el módulo (HU.006)
        // OJO: asume que tu RolRepositoryPort tiene findById(Long) que devuelve Optional<Rol>
        if (rolRepo.findById(rolId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el rol con id: " + rolId);
        }
        if (!moduloRepo.existePorId(moduloId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el módulo con id: " + moduloId);
        }

        // Extra (no lo pide el documento): el submódulo debe existir y pertenecer a ese módulo
        Submodulo sub = subModuloRepo.buscarPorId(subModuloId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No existe el submódulo con id: " + subModuloId));
        if (!sub.getModuloId().equals(moduloId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "El submódulo " + subModuloId + " no pertenece al módulo " + moduloId);
        }

        // 409 si ya existe la asignación
        if (repo.existeAsignacion(rolId, moduloId, subModuloId, accion)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe esa asignación de permisos");
        }

        return repo.guardar(new Permisos(null, rolId, moduloId, subModuloId, accion));
    }
}
