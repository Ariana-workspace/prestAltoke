package com.ari.pestaltoke.infraestructure.adapter.in.rest.dto;

import com.ari.pestaltoke.domain.model.estados.Estado;

public record SubModuloRequest(String nombre, String descripcion, Estado estado, Long moduloId) {
}
