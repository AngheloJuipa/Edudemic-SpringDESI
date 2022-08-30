package com.edudemic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Curso;
import com.edudemic.repository.CursoRepository;
@Service
public class CursoService {
	private CursoRepository cursoRepository;
	public CursoService(CursoRepository cursoRepository) 
	{
		this.cursoRepository=cursoRepository;
	}
	public List<Curso> listarCurso() 
	{
		return cursoRepository.findAll();
	}
	public Curso registrarCurso(Curso c) 
	{
		return cursoRepository.save(c);
	}
	public Curso buscarPorId(Long id) 
	{
		return cursoRepository.findById(id).get();
	}
}
