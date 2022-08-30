package com.edudemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Comentario;



public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
	
	@Query("SELECT r FROM Comentario r WHERE r.foro.id=?1")
	List<Comentario> listaComentarios(Long id);
}
