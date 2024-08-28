package br.com.rochadev.dto.controller;

import br.com.rochadev.dto.domain.dto.UsuarioRequest;
import br.com.rochadev.dto.services.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public ResponseEntity salvar(@RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuarioRequest));

    }
    @GetMapping("/")
    public ResponseEntity listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.usuarioResponses());
    }
}
