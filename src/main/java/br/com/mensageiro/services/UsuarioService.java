package br.com.mensageiro.services;

import br.com.mensageiro.models.UsuarioModel;
import br.com.mensageiro.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepo usuarioRepo;

    public List<UsuarioModel> listarTodos() {
        UsuarioModel usuarioModel = new UsuarioModel();
        return usuarioRepo.findAll();
    }
}
