package com.ari.pestaltoke.application.service.rol;

import com.ari.pestaltoke.application.port.in.rol.ListarRolUseCase;
import com.ari.pestaltoke.application.port.out.rol.RolRepositoryPort;
import com.ari.pestaltoke.domain.model.rol.Rol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarRolesService implements ListarRolUseCase {

    private final RolRepositoryPort repo;

    ListarRolesService(RolRepositoryPort repo){
        this.repo = repo;
    }
    @Override
    public List<Rol> listar() {
        return repo.listar();
    }
}
