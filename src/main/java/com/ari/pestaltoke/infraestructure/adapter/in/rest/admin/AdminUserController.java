package com.ari.pestaltoke.infraestructure.adapter.in.rest.admin;

import com.ari.pestaltoke.application.port.in.rol.CrearRolUseCase;
import com.ari.pestaltoke.application.port.in.rol.EditarRolesUseCase;
import com.ari.pestaltoke.application.port.in.rol.ListarRolUseCase;
import com.ari.pestaltoke.application.port.in.usuario.RegistrarUsuarioUseCase;
import com.ari.pestaltoke.domain.model.rol.Rol;
import com.ari.pestaltoke.domain.model.user.User;
import com.ari.pestaltoke.infraestructure.adapter.in.rest.auth.AuthController;
import com.ari.pestaltoke.infraestructure.adapter.in.rest.dto.RolRequest;
import com.ari.pestaltoke.infraestructure.adapter.out.persistence.rol.RolEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminUserController {

    private final RegistrarUsuarioUseCase registrarUseCase;

    public AdminUserController(
            RegistrarUsuarioUseCase registrarUseCase) {
        this.registrarUseCase = registrarUseCase;
    }

    @PostMapping("/users")
    public ResponseEntity<Map<String, Object>> register(@RequestBody AuthController.AuthRequest req) {
        System.out.println("Email: " + req.email());
        System.out.println("Password: " + req.password());
        System.out.println("Nombre: " + req.nombre());
        System.out.println("Username: " + req.username());
        System.out.println("Rol: " + req.rol());
        User u = registrarUseCase.registrar(
                req.email(),
                req.password(),
                req.nombre(),
                req.username(),
                req.rol());

        return ResponseEntity.status(201).body(Map.of("id", u.getId(), "email", u.getEmail()));
    }



}