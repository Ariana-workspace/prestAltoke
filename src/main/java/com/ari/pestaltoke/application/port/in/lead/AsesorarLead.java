package com.ari.pestaltoke.application.port.in.lead;

import com.ari.pestaltoke.domain.model.canal_atencion.Canal_atencion;
import com.ari.pestaltoke.domain.model.codigo_asesor.Asesor;
import com.ari.pestaltoke.domain.model.lead.Lead;

public interface AsesorarLead {
    Lead asesorar(
            Long idLead,
            Asesor asesor,
            Canal_atencion canalAtencion
    );
}
