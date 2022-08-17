package br.com.mensageiro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_completo",nullable = false)
    @NotNull
    private String nome;
    @Column(name = "foto_url",nullable = false)
    @NotNull
    private String fotoUrl;
    @Column(name = "data_nascimento",nullable = false)
    @NotNull
    private Date dataNascimento;
    @Column(name = "nickname",nullable = false,unique = true)
    @NotNull
    private String nickname;
    @Column(name = "email",nullable = false,unique = true)
    @NotNull
    private String email;
    @Column(name = "senha",nullable = false)
    @NotNull
    private String senha;
    @OneToMany
    @JsonIgnore
    private List<UsuarioModel> amigos;
}
