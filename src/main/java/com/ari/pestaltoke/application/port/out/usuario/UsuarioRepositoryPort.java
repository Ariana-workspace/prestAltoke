package com.ari.pestaltoke.application.port.out.usuario;


import com.ari.pestaltoke.domain.model.estados.EstadoUser;
import com.ari.pestaltoke.domain.model.user.User;

import java.util.Optional;

public interface UsuarioRepositoryPort {
    Optional<User> buscarPorEmail(String email);

    Optional<String> buscarPorEstado(EstadoUser estado);

    boolean existePorEmail(String email);
    User guardar(User user);
}
