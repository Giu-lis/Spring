package com.devsenai2A.giulia.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devsenai2A.giulia.petshop.entities.Categoria;
import com.devsenai2A.giulia.petshop.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	private final  CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Optional<Categoria> findById(Integer id) {
		return repository.findById(id);
	}
	
	public Categoria save(Categoria categoria) {
		return repository.save(categoria);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}


}