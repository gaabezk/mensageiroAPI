package br.com.mensageiro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatModel {

    private List<MessageModel> message;
    private UsuarioModel pessoa1;
    private UsuarioModel pessoa2;

}
