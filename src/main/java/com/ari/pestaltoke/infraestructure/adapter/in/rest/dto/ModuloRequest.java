package com.ari.pestaltoke.infraestructure.adapter.in.rest.dto;

import com.ari.pestaltoke.domain.model.estados.Estado;

public record ModuloRequest(String nombre, String descripcion, Estado estado) {
}
