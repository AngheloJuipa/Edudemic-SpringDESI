package com.edudemic.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Pregunta;
import com.edudemic.repository.PreguntaRepository;

@Service
public class PreguntaService {
	private PreguntaRepository preguntaRepository;
	public PreguntaService(PreguntaRepository preguntaRepository) 
	{
		this.preguntaRepository=preguntaRepository;
	}
	public List<Pregunta> listarPregunta() 
	{
		return preguntaRepository.findAll();
	}
	public Pregunta registrarPregunta(Pregunta p) 
	{
		return preguntaRepository.save(p);
	}
	public List<Pregunta> buscarPreguntaReto(Long id) 
	{
		return preguntaRepository.listaPorReto(id);
	}
	public int registrarNuevo(Pregunta p) 
	{
		int existe = preguntaRepository.verificarExistencia(p.getDescripcion());
		if(existe ==0) 
		{
			preguntaRepository.save(p);
		}
		return existe;
	}
}
