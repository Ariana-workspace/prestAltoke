package com.ari.pestaltoke.infraestructure.adapter.in.rest.dto;

public record CrearUsuarioRequest(
        String email,
        String password,
        String nombre,
        String username,
        Long rolId
) {}