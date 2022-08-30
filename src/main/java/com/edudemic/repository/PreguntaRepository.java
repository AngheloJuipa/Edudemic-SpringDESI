package com.edudemic.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long>{
	@Query("SELECT p FROM Pregunta p WHERE p.reto.id=?1")
	List<Pregunta> listaPorReto(Long id);
	
	@Query("SELECT count(p) FROM Pregunta p  WHERE p.descripcion=?1")
	int verificarExistencia(String descripcion);
}
