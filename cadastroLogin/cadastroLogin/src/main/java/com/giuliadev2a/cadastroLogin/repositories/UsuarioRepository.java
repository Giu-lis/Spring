package com.giuliadev2a.cadastroLogin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giuliadev2a.cadastroLogin.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método para buscar usuário pelo email
    Usuario findByEmail(String email);
}
