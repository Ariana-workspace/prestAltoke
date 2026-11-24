package com.ari.pestaltoke.application.port.in.usuario;
import com.ari.pestaltoke.domain.model.user.User;

public interface RegistrarUsuarioUseCase {
    User registrar(String email, String password, String nombre, String username, Long rol);
}
