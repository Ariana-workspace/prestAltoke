package com.ari.pestaltoke.domain.model.cliente;

import com.ari.pestaltoke.domain.model.canal_atencion.Canal_atencion;
import lombok.Data;

@Data
public class Cliente {
    private final Long id;
    private final String correo;
    private final String dni;
    private final String celular;


    public Cliente(Long id, String correo, String dni, String celular) {
        this.id = id;
        this.correo = correo;
        this.dni = dni;
        this.celular = celular;
    }
    public Long getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDni() {
        return dni;
    }

    public String getCelular() {
        return celular;
    }


}
