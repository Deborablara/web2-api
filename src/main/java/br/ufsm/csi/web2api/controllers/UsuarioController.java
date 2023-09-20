package br.ufsm.csi.web2api.controllers;


import br.ufsm.csi.web2api.models.Usuario;
import br.ufsm.csi.web2api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping()
    public ResponseEntity<?> newUsuario(@RequestBody Usuario values,
                                       UriComponentsBuilder uriComponentsBuilder) {
        return usuarioService.newUsuario(values, uriComponentsBuilder);
    }
}
