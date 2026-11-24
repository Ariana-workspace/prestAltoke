package com.ari.pestaltoke.application.service.modulo;

import com.ari.pestaltoke.application.port.in.modulo.ListarModuloUseCase;
import com.ari.pestaltoke.application.port.out.modulo.ModuloRepositoryPort;
import com.ari.pestaltoke.domain.model.modulo.Modulo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarModuloService implements ListarModuloUseCase {

    private final ModuloRepositoryPort repo;

    public ListarModuloService(ModuloRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public List<Modulo> listar() {
        return repo.listar();
    }
}
