package com.edudemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	@Query("FROM Libro l ORDER BY l.titulo ASC")
    public List<Libro> findAllSortByTittle();
	
	List<Libro> findByTituloContainingIgnoreCase(String titulo);
}
