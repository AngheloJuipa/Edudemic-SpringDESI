package com.edudemic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Libro;
import com.edudemic.repository.LibroRepository;

@Service
public class LibroService {

	private LibroRepository libroRepository;

	public LibroService(LibroRepository libroRepository) {
		this.libroRepository = libroRepository;

	}

	// listar
	public List<Libro> getAllLibros() {
		return libroRepository.findAll();
	}

	// registrar
	public Libro saveLibro(Libro libro) {
		return libroRepository.save(libro);
	}

	// modificar
	public Libro updateLibro(Libro libro) {
		return libroRepository.save(libro);
	}

	public Libro getLibroById(Long id) {
		return libroRepository.findById(id).get();
	}

	// eliminar
	public void deleteLibroById(Long id) {
		libroRepository.deleteById(id);
	}
	public List<Libro> buscarLibro(String titulo) {
		return libroRepository.findByTituloContainingIgnoreCase(titulo);
	}
}
