package br.com.mensageiro.controllers;

import br.com.mensageiro.exceptions.ErrorException;
import br.com.mensageiro.models.UsuarioModel;
import br.com.mensageiro.modelsDTO.UsuarioModelDTO;
import br.com.mensageiro.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/amigos")
    public ResponseEntity<List<?>> listarAmigos(@RequestParam String nickUser) throws ErrorException {
        return ResponseEntity.ok(usuarioService.listarAmigos(nickUser));
    }
    @PostMapping
    public ResponseEntity<UsuarioModel> listarTodos(@RequestBody UsuarioModel usuarioModel) throws ErrorException {
        return ResponseEntity.ok(usuarioService.cadastrar(usuarioModel));
    }
    @PutMapping
    public ResponseEntity adicionarAmigo(@RequestParam String nickUser, @RequestParam String nickAmigo) throws ErrorException {
        usuarioService.adicionarAmigo(nickUser,nickAmigo);
        return new ResponseEntity(HttpStatus.OK);
    }

}
