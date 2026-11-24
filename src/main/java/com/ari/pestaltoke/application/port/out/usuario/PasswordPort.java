package com.ari.pestaltoke.application.port.out.usuario;

public interface PasswordPort {
    String hashear(String passwordPlano);
    boolean coincide(String passwordPlano, String hash);
}

