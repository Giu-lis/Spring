package com.giuliadev2a.cadastroLogin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giuliadev2a.cadastroLogin.entities.Usuario;
import com.giuliadev2a.cadastroLogin.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Usuario cadastrar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario login(String email, String senha) {

        Usuario usuario = repository.findByEmail(email);

        if (usuario == null) {
            return null;
        }

        if (usuario.getSenha().equals(senha)) {
            return usuario;
        }

        return null;
    }
}