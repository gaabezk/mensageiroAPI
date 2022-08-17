package br.com.mensageiro.modelsDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioModelDTO {

    private String nome;
    private String foto;
    private String status;
    private String nick;
    private String email;
    private Long idade;

}
