package com.ari.pestaltoke.infraestructure.adapter.in.rest.admin;

import com.ari.pestaltoke.application.port.in.modulo.CrearModuloUseCase;
import com.ari.pestaltoke.application.port.in.modulo.ListarModuloUseCase;
import com.ari.pestaltoke.domain.model.modulo.Modulo;
import com.ari.pestaltoke.infraestructure.adapter.in.rest.dto.ModuloRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/modulos")
public class AdminModuloController {

    private final CrearModuloUseCase crearModuloUseCase;
    private final ListarModuloUseCase listarModuloUseCase;

    public AdminModuloController(CrearModuloUseCase crearModuloUseCase,
                                 ListarModuloUseCase listarModuloUseCase) {
        this.crearModuloUseCase = crearModuloUseCase;
        this.listarModuloUseCase = listarModuloUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Modulo>> listar() {
        return ResponseEntity.ok(listarModuloUseCase.listar());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> crear(@RequestBody ModuloRequest req) {
        Modulo modulo = crearModuloUseCase.crear(
                req.nombre(),
                req.descripcion(),
                req.estado()
        );

        return ResponseEntity.status(201).body(Map.of(
                "id", modulo.getId(),
                "nombre", modulo.getNombre(),
                "descripcion", modulo.getDescripcion(),
                "estado", modulo.getEstado()
        ));
    }
}
