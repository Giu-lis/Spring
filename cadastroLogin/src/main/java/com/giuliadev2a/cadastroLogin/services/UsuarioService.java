package com.giuliadev2a.cadastroLogin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.giuliadev2a.cadastroLogin.entities.Usuario;
import com.giuliadev2a.cadastroLogin.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;

    }

    public void delete(Long Id) {
        repository.deleteById(Id);
    }

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

    public Usuario save(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }
}