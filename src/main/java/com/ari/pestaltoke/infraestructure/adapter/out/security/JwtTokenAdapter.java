package com.ari.pestaltoke.infraestructure.adapter.out.security;

import com.ari.pestaltoke.application.port.out.usuario.TokenPort;
import com.ari.pestaltoke.domain.model.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenAdapter implements TokenPort {
    private final SecretKey key;
    private final long expiracionMs;

    public JwtTokenAdapter(@Value("${jwt.secret}") String secret,
                           @Value("${jwt.expiration-ms:3600000}") long expiracionMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expiracionMs = expiracionMs;
    }

    @Override
    public String generar(User u) {
        Date ahora = new Date();
        return Jwts.builder()
                .subject(u.getEmail())
                .claim("id", u.getId())
                .issuedAt(ahora)
                .expiration(new Date(ahora.getTime() + expiracionMs))
                .signWith(key)
                .compact();
    }


}