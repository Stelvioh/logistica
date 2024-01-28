package com.casa.logistica.controller;

import com.casa.logistica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.casa.logistica.domain.Usuario;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String usuario() {
        return "usuarios";
    }

    // Método criar um novo usuário atraves do objeto usuario
    // usar responsebody para retornar o objeto criado

    @PostMapping("/criar")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        // Aqui chamamos o serviço de criação de usuário
        Usuario usuarioCriado = usuarioService.criarUsuario(usuario);
        // Aqui retornamos o usuário criado com o status 201
        return ResponseEntity.status(201).body(usuarioCriado);
    }

}