package com.devsenai2A.giulia.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenai2A.giulia.petshop.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	Categoria findByNome(String nome);
}