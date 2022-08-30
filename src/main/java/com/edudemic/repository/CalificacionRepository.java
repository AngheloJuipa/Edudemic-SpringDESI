package com.edudemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Calificacion;




public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
	
	@Query("SELECT i FROM Calificacion i WHERE i.libro.id=?1")
    List<Calificacion> listaCalificacionxLibro(Long id);
	
	
}