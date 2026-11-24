package com.ari.pestaltoke.infraestructure.adapter.in.rest.dto;

public record LoginRequest(
        String email,
        String password
) {}