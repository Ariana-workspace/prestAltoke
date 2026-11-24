package com.ari.pestaltoke.application.port.out.usuario;

import com.ari.pestaltoke.domain.model.user.User;

public interface TokenPort {
    String generar(User user);
}
