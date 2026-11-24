package com.ari.pestaltoke.infraestructure.adapter.in.rest.admin;

import com.ari.pestaltoke.application.port.in.permisos.CrearPermisoUseCase;
import com.ari.pestaltoke.domain.model.permisos.Permisos;
import com.ari.pestaltoke.infraestructure.adapter.in.rest.dto.PermisoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/permisos")
public class AdminPermisoController {

    private final CrearPermisoUseCase crearPermisoUseCase;

    public AdminPermisoController(CrearPermisoUseCase crearPermisoUseCase) {
        this.crearPermisoUseCase = crearPermisoUseCase;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> crear(@RequestBody PermisoRequest req) {
        Permisos permiso = crearPermisoUseCase.crear(
                req.rolId(),
                req.moduloId(),
                req.subModuloId(),
                req.accion()
        );

        return ResponseEntity.status(201).body(Map.of(
                "id", permiso.getId(),
                "rolId", permiso.getRolId(),
                "moduloId", permiso.getModuloId(),
                "subModuloId", permiso.getSubModuloId(),
                "accion", permiso.getAccionesPermitidas()
        ));
    }
}
