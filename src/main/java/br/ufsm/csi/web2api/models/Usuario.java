package br.ufsm.csi.web2api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @NotNull
    private String nome;
    @NotNull
    private String password;

    public Usuario() {
    }

    public Usuario(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

}
