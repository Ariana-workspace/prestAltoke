package com.ari.pestaltoke.infraestructure.config;

import com.ari.pestaltoke.application.port.in.usuario.LoginUseCase;
import com.ari.pestaltoke.application.port.in.usuario.RegistrarUsuarioUseCase;
import com.ari.pestaltoke.application.port.out.usuario.PasswordPort;
import com.ari.pestaltoke.application.port.out.usuario.TokenPort;
import com.ari.pestaltoke.application.port.out.usuario.UsuarioRepositoryPort;
import com.ari.pestaltoke.application.service.usuario.LoginService;
import com.ari.pestaltoke.application.service.usuario.RegistroService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    LoginUseCase loginUseCase(UsuarioRepositoryPort repo, PasswordPort passwords, TokenPort tokens) {
        return new LoginService(repo, passwords, tokens);
    }
    @Bean
    RegistrarUsuarioUseCase registrarUsuarioUseCase(UsuarioRepositoryPort repo, PasswordPort passwords) {
        return new RegistroService(repo, passwords);
    }
}