package com.edudemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Foro;


public interface ForoRepository extends JpaRepository<Foro, Long>{
	@Query("FROM Foro l ORDER BY l.titulo ASC")
    public List<Foro> findAllSortByTittle();
	
	@Query("SELECT l FROM Foro l  WHERE l.titulo=?1")
	List<Foro> buscarForoByTitulo(String titulo);
	
	
	
}
