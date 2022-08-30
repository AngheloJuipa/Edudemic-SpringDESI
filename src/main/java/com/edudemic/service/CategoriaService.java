package com.edudemic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Categoria;
import com.edudemic.repository.CategoriaRepository;

@Service
public class CategoriaService {
	private CategoriaRepository categoriaRepository;
	public CategoriaService(CategoriaRepository categoriaRepository) 
	{
		this.categoriaRepository=categoriaRepository;
	}
	public List<Categoria> listarCategoria() 
	{
		return categoriaRepository.findAll();
	}
	public Categoria registrarCategoria(Categoria c) 
	{
		return categoriaRepository.save(c);
	}
	public Categoria buscarPorId(Long id) {
		return categoriaRepository.findById(id).get();
	}
	public void deleteCategoriaById(Long id) {
		categoriaRepository.deleteById(id);
	}
}
