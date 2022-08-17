package br.com.mensageiro.controllers;

import br.com.mensageiro.models.UsuarioModel;
import br.com.mensageiro.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }


}
