package com.ari.pestaltoke.domain.model.lead;

import com.ari.pestaltoke.domain.model.canal_atencion.Canal_atencion;
import com.ari.pestaltoke.domain.model.codigo_asesor.Asesor;
import lombok.Data;

@Data
public class Lead {
    private final Long id;
    private final String correo;
    private final String dni;
    private final String celular;
    private Long asesorId;
    private Canal_atencion canalAtencion;

    public Lead(Long id, String correo, String dni, String celular) {
        this.id = id;
        this.correo = correo;
        this.dni = dni;
        this.celular = celular;
    }

    public Lead(Long id, String correo, String dni, String celular, Long asesorId, Canal_atencion canalAtencion) {
        this.id = id;
        this.correo = correo;
        this.dni = dni;
        this.celular = celular;
        this.asesorId = asesorId;
        this.canalAtencion = canalAtencion;
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

    public Long getAsesorId() {
        return asesorId;
    }

    public Canal_atencion getCanalAtencion() {
        return canalAtencion;
    }
}
