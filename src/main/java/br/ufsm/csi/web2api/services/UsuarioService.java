package br.ufsm.csi.web2api.services;

import br.ufsm.csi.web2api.models.Usuario;
import br.ufsm.csi.web2api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<List<Usuario>> getUsuarios(){
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @Transactional
    public ResponseEntity<?> newUsuario(Usuario values,
                                       UriComponentsBuilder uriComponentsBuilder) {

        try {
            Usuario usuario = new Usuario(values.getNome(), values.getPassword());
            usuarioRepository.save(usuario);
            URI uri = uriComponentsBuilder.path("/clients/{id}").buildAndExpand(usuario.getId_usuario()).toUri();

            return ResponseEntity.created(uri).body(usuario);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Falha ao criar novo usuario");
        }

    }
}
