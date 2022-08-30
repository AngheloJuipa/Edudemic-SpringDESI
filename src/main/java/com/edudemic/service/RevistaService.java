package com.edudemic.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.edudemic.entities.Revista;

import com.edudemic.repository.RevistaRepository;
@Service
public class RevistaService {
	
	private RevistaRepository revistaRepository;
	public RevistaService(RevistaRepository revistaRepository) 
	{
		this.revistaRepository=revistaRepository;
	}
	public List<Revista> listarRevista() 
	{
		return revistaRepository.findAll();
	}
	public Revista registrarRevista(Revista r) 
	{
		return revistaRepository.save(r);
	}
	public Revista buscarPorId(Long id) 
	{
		return revistaRepository.findById(id).get();
	}
	

}
