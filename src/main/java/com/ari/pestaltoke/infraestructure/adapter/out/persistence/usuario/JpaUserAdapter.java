package com.ari.pestaltoke.infraestructure.adapter.out.persistence.usuario;

import com.ari.pestaltoke.application.port.out.usuario.UsuarioRepositoryPort;
import com.ari.pestaltoke.domain.model.estados.EstadoUser;
import com.ari.pestaltoke.domain.model.user.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaUserAdapter implements UsuarioRepositoryPort {
    private final UserJpaRepository jpa;

    public JpaUserAdapter(UserJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<User> buscarPorEmail(String email) {
        return jpa.findByEmail(email).map(this::aDominio);
    }

    @Override
    public Optional<String> buscarPorEstado(EstadoUser estado) {
        return Optional.empty();
    }

    @Override
    public boolean existePorEmail(String email) {
        return jpa.existsByEmail(email);
    }

    @Override
    public User guardar(User u) {
        UserEntity e = new UserEntity();
        e.setId(u.getId());
        e.setEmail(u.getEmail());
        e.setPassword(u.getPasswordHash());
        e.setEstado(u.getEstado().name());
        e.setNombre(u.getNombre());
        e.setUsername(u.getUsername());
        e.setRol(u.getRol());
        return aDominio(jpa.save(e));
    }

    private User aDominio(UserEntity e) {
        return new User(
                e.getId(),
                e.getEmail(),
                e.getPassword(),
                EstadoUser.valueOf(e.getEstado()),
                e.getNombre(),
                e.getUsername(),
                e.getRol()
        );
    }
}