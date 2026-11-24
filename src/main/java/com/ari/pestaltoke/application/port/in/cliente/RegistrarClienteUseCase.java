package com.ari.pestaltoke.application.port.in.cliente;

import com.ari.pestaltoke.domain.model.cliente.Cliente;

public interface RegistrarClienteUseCase {
    Cliente registrarCliente(String correo, String dni, String celular);
}
