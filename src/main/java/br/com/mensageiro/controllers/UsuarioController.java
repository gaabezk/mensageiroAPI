package br.com.mensageiro.controllers;

import br.com.mensageiro.exceptions.ErrorException;
import br.com.mensageiro.models.UsuarioModel;
import br.com.mensageiro.modelsDTO.UsuarioModelDTO;
import br.com.mensageiro.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioModelDTO>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }
    @PostMapping
    public ResponseEntity<UsuarioModel> listarTodos(@RequestBody UsuarioModel usuarioModel) throws ErrorException {
        return ResponseEntity.ok(usuarioService.cadastrar(usuarioModel));
    }


}
