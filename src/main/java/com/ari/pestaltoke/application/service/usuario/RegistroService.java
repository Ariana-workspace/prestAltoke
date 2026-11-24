package com.ari.pestaltoke.application.service.usuario;

import com.ari.pestaltoke.application.port.in.usuario.RegistrarUsuarioUseCase;
import com.ari.pestaltoke.application.port.out.usuario.PasswordPort;
import com.ari.pestaltoke.application.port.out.usuario.UsuarioRepositoryPort;
import com.ari.pestaltoke.domain.exception.EmailYaRegistradoException;
import com.ari.pestaltoke.domain.model.estados.EstadoUser;
import com.ari.pestaltoke.domain.model.user.User;


public class RegistroService implements RegistrarUsuarioUseCase {
    private final UsuarioRepositoryPort repo;
    private final PasswordPort passwords;

    public RegistroService(UsuarioRepositoryPort repo, PasswordPort passwords) {
        this.repo = repo;
        this.passwords = passwords;
    }

    @Override
    public User registrar(String email, String password, String nombre, String username, Long rol) {
        if (repo.existePorEmail(email)) {
            throw new EmailYaRegistradoException(email);
        }
        User nuevo = new User(null, email, passwords.hashear(password), EstadoUser.ACTIVADO, nombre, username, rol);
        return repo.guardar(nuevo);

    }
}
