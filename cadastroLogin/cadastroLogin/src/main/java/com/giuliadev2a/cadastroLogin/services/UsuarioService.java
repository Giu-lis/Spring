package com.giuliadev2a.cadastroLogin.services;

import java.util.List;
import java.util.Optional;

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


    public boolean deletar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    public Usuario atualizar(Long id, Usuario usuario) {

        Optional<Usuario> usuarioExistente = repository.findById(id);

        if (usuarioExistente.isEmpty()) {
            return null;
        }

        Usuario u = usuarioExistente.get();

        u.setNome(usuario.getNome());
        u.setEmail(usuario.getEmail());
        u.setSenha(usuario.getSenha());
        u.setPerfil(usuario.getPerfil());
        u.setEndereco(usuario.getEndereco());
        u.setBairro(usuario.getBairro());
        u.setComplemento(usuario.getComplemento());
        u.setCep(usuario.getCep());
        u.setCidade(usuario.getCidade());
        u.setEstado(usuario.getEstado());

        return repository.save(u);
    }
}