package com.ari.pestaltoke.infraestructure.adapter.in.rest.auth;

import com.ari.pestaltoke.application.port.in.usuario.LoginUseCase;
import com.ari.pestaltoke.application.port.in.usuario.RegistrarUsuarioUseCase;
import com.ari.pestaltoke.domain.model.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final LoginUseCase loginUseCase;
    private final RegistrarUsuarioUseCase registrarUseCase;

    public AuthController(LoginUseCase loginUseCase, RegistrarUsuarioUseCase registrarUseCase) {
        this.loginUseCase = loginUseCase;
        this.registrarUseCase = registrarUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest req) {
        String token = loginUseCase.login(req.email(), req.password());
        return ResponseEntity.ok(Map.of("token", token));
    }

    public record AuthRequest(String email, String password, String nombre, String username, Long rol) {}
}