package com.ari.pestaltoke.infraestructure.adapter.out.persistence.permisos;

import com.ari.pestaltoke.domain.model.permisos.Accion;
import jakarta.persistence.*;

@Entity
@Table(name = "permisos")
public class PermisoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long rolId;
    @Column(nullable = false)
    private Long moduloId;
    @Column(nullable = false)
    private Long submoduloId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Accion accionesPermitidas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public Long getModuloId() {
        return moduloId;
    }

    public void setModuloId(Long moduloId) {
        this.moduloId = moduloId;
    }

    public Long getSubmoduloId() {
        return submoduloId;
    }

    public void setSubmoduloId(Long submoduloId) {
        this.submoduloId = submoduloId;
    }

    public Accion getAccionesPermitidas() {
        return accionesPermitidas;
    }

    public void setAccionesPermitidas(Accion accionesPermitidas) {
        this.accionesPermitidas = accionesPermitidas;
    }
}
