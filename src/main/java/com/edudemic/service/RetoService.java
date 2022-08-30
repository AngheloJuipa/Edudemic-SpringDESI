package com.edudemic.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Reto;
import com.edudemic.repository.RetoRepository;
@Service
public class RetoService {
	private RetoRepository retoRepository;
	public RetoService(RetoRepository retoRepository) 
	{
		this.retoRepository=retoRepository;
	}
	public List<Reto> listarReto() 
	{
		return retoRepository.findAll();
	}
	public Reto registrarReto(Reto r) 
	{
		return retoRepository.save(r);
	}
	public Reto buscarPorId(Long id) 
	{
		return retoRepository.findById(id).get();
	}
	public List<Reto> notasReto(Long id)
	{
		return retoRepository.listaNotas(id);
	}

}
