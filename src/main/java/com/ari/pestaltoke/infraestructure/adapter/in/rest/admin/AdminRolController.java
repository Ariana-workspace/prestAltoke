package com.ari.pestaltoke.infraestructure.adapter.in.rest.admin;

import com.ari.pestaltoke.application.port.in.rol.CrearRolUseCase;
import com.ari.pestaltoke.application.port.in.rol.EditarRolesUseCase;
import com.ari.pestaltoke.application.port.in.rol.ListarRolUseCase;
import com.ari.pestaltoke.domain.model.rol.Rol;
import com.ari.pestaltoke.infraestructure.adapter.in.rest.dto.RolRequest;
import com.ari.pestaltoke.infraestructure.adapter.out.persistence.rol.RolEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/roles")
public class AdminRolController {
    private final CrearRolUseCase crearRolUseCase;
    private final EditarRolesUseCase editarRolUseCase;
    private final ListarRolUseCase listarRolUseCase;

    public AdminRolController(CrearRolUseCase crearRolUseCase, EditarRolesUseCase editarRolUseCase, ListarRolUseCase listarRolUseCase) {
        this.crearRolUseCase = crearRolUseCase;
        this.editarRolUseCase = editarRolUseCase;
        this.listarRolUseCase = listarRolUseCase;
    }

    @GetMapping("/")
    public ResponseEntity<List<RolEntity>> listar() {
        List<RolEntity> roles = listarRolUseCase.listar()
                .stream()
                .map(r -> new RolEntity(r.getId(), r.getNombre(), r.getDescripcion(), r.getEstado().name()))
                .toList();

        return ResponseEntity.ok(roles);
    }
    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crear(@RequestBody RolRequest req) {
        Rol rol = crearRolUseCase.crearRol(
                req.nombre(),
                req.descripcion(),
                req.estado()
        );

        return ResponseEntity.status(201).body(Map.of("id", rol.getId(),"nombre",rol.getNombre() ,"descripcion", rol.getDescripcion(), "estado", rol.getEstado()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> editar(
            @PathVariable Long id,
            @RequestBody RolRequest req) {

        Rol rol = editarRolUseCase.editar(
                id,
                req.nombre(),
                req.descripcion(),
                req.estado()
        );

        return ResponseEntity.ok(Map.of(
                "id", rol.getId(),
                "nombre", rol.getNombre(),
                "descripcion", rol.getDescripcion(),
                "estado", rol.getEstado()
        ));
    }

}
