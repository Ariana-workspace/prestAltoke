package com.ari.pestaltoke.infraestructure.adapter.out.security;

import com.ari.pestaltoke.application.port.out.usuario.PasswordPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BcryptPasswordAdapter implements PasswordPort {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String hashear(String passwordPlano) { return encoder.encode(passwordPlano); }

    @Override
    public boolean coincide(String passwordPlano, String hash) {
        return encoder.matches(passwordPlano, hash);
    }
}
