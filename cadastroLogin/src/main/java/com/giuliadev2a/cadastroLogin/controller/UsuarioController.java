package com.giuliadev2a.cadastroLogin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.giuliadev2a.cadastroLogin.entities.Usuario;
import com.giuliadev2a.cadastroLogin.services.UsuarioService;

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

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long Id, @RequestBody Usuario user) {
        user.setId(Id); // isso aqui faltava pqp vai tomar no cu coida maldita desgraçada do crlh vai se fuder espero que que m inventou essa porra queime no inferno
        return Usuario.update(Id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}