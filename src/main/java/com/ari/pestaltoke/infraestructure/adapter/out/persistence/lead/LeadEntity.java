package com.ari.pestaltoke.infraestructure.adapter.out.persistence.lead;

import com.ari.pestaltoke.domain.model.canal_atencion.Canal_atencion;
import com.ari.pestaltoke.domain.model.codigo_asesor.Asesor;
import jakarta.persistence.*;


@Entity
@Table(name = "lead")
public class LeadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String dni;
    @Column(nullable = false)
    private String celular;
    @Column(name = "asesor_id", nullable = false)
    private Long asesorId;
    @Column(nullable = false)
    private Canal_atencion canalAtencion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Long getAsesor() {
        return asesorId;
    }

    public void setAsesor(Long asesorId) {
        this.asesorId = asesorId;
    }

    public Canal_atencion getCanalAtencion() {
        return canalAtencion;
    }

    public void setCanalAtencion(Canal_atencion canalAtencion) {
        this.canalAtencion = canalAtencion;
    }
}
