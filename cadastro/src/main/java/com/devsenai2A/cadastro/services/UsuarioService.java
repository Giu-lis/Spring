package com.devsenai2A.cadastro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsenai2A.cadastro.entities.Usuario;
import com.devsenai2A.cadastro.repositories.UsuarioRepository;

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
}