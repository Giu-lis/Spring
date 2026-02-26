package com.devsenai2A.cadastro.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenai2A.cadastro.entities.Usuario;
import com.devsenai2A.cadastro.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;
   
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return service.listarTodos();
    }
   
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.cadastrar(usuario));
    }

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Map<String, String> dados) {

    String email = dados.get("email");
    String senha = dados.get("senha");

    Usuario usuario = service.login(email, senha);

    if (usuario == null) {
        return ResponseEntity.status(401).body("Email ou senha inválidos");
    }

    return ResponseEntity.ok(usuario);
}
}