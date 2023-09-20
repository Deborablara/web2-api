package br.ufsm.csi.web2api.repository;

import br.ufsm.csi.web2api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
