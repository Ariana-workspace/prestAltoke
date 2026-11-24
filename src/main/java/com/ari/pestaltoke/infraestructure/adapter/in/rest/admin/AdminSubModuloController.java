package com.ari.pestaltoke.infraestructure.adapter.in.rest.admin;

import com.ari.pestaltoke.application.port.in.submodulo.CrearSubModuloUseCase;
import com.ari.pestaltoke.domain.model.submodulo.Submodulo;
import com.ari.pestaltoke.infraestructure.adapter.in.rest.dto.SubModuloRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/submodulos")
public class AdminSubModuloController {

    private final CrearSubModuloUseCase crearSubModuloUseCase;

    public AdminSubModuloController(CrearSubModuloUseCase crearSubModuloUseCase) {
        this.crearSubModuloUseCase = crearSubModuloUseCase;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> crear(@RequestBody SubModuloRequest req) {
        Submodulo sub = crearSubModuloUseCase.crear(
                req.nombre(),
                req.descripcion(),
                req.estado(),
                req.moduloId()
        );

        return ResponseEntity.status(201).body(Map.of(
                "id", sub.getId(),
                "nombre", sub.getNombre(),
                "descripcion", sub.getDescripcion(),
                "estado", sub.getEstado(),
                "moduloId", sub.getModuloId()
        ));
    }
}
