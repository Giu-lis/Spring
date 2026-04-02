package com.devsenai2A.giulia.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenai2A.giulia.petshop.entities.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
	
	Produtos findByNome (String nome);

}
