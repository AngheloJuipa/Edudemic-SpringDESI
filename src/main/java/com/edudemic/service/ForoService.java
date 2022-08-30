package com.edudemic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Foro;
import com.edudemic.repository.ForoRepository;

@Service
public class ForoService {
	private ForoRepository foroRepository;

	public ForoService(ForoRepository foroRepository) {
		this.foroRepository = foroRepository;

	}

	// listar
	public List<Foro> getAllForos() {
		return foroRepository.findAll();
	}

	// registrar
	public Foro saveForo(Foro foro) {
		return foroRepository.save(foro);
	}

	// modificar
	public Foro updateForo(Foro foro) {
		return foroRepository.save(foro);
	}

	public Foro getForoById(Long id) {
		return foroRepository.findById(id).get();
	}

	// eliminar
	public void deleteForoById(Long id) {
		foroRepository.deleteById(id);
	}
	public List<Foro> buscarForo(String titulo) {
		return foroRepository.buscarForoByTitulo(titulo);
	}
}
