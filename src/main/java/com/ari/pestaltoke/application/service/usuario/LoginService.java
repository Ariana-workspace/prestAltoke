package com.ari.pestaltoke.application.service.usuario;

import com.ari.pestaltoke.application.port.in.usuario.LoginUseCase;
import com.ari.pestaltoke.application.port.out.usuario.PasswordPort;
import com.ari.pestaltoke.application.port.out.usuario.TokenPort;
import com.ari.pestaltoke.application.port.out.usuario.UsuarioRepositoryPort;
import com.ari.pestaltoke.domain.exception.CredencialesInvalidasException;
import com.ari.pestaltoke.domain.exception.UsuarioBloqueadoException;
import com.ari.pestaltoke.domain.model.estados.EstadoUser;
import com.ari.pestaltoke.domain.model.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

public class LoginService implements LoginUseCase {
    private final UsuarioRepositoryPort repo;
    private final PasswordPort passwords;
    private final TokenPort tokens;

    public LoginService(UsuarioRepositoryPort repo, PasswordPort passwords, TokenPort tokens) {
        this.repo = repo;
        this.passwords = passwords;
        this.tokens = tokens;
    }

    @Override
    public String login(String email, String password) {
        User u = repo.buscarPorEmail(email)
                .filter(x -> passwords.coincide(password, x.getPasswordHash()))
                .orElseThrow(CredencialesInvalidasException::new);
        if (u.getEstado() != EstadoUser.ACTIVADO) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "USUARIO BLOQUEADO");
        }
        return tokens.generar(u);
    }
}
