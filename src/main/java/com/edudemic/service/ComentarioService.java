package com.edudemic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Comentario;
import com.edudemic.repository.ComentarioRepository;

@Service
public class ComentarioService {
	private ComentarioRepository comentarioRepository;

	public ComentarioService(ComentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;

	}
	// listar
		public List<Comentario> getAllComentarios() {
			return comentarioRepository.findAll();
		}

		// registrar
		public Comentario saveComentario(Comentario comentario) {
			return comentarioRepository.save(comentario);
		}

		// modificar
		public Comentario updateComentario(Comentario comentario) {
			return comentarioRepository.save(comentario);
		}

		public Comentario getComentarioById(Long id) {
			return comentarioRepository.findById(id).get();
		}

		// eliminar
		public void deleteComentarioById(Long id) {
			comentarioRepository.deleteById(id);
		}
		
	
	
}
