package com.edudemic.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Reto;



public interface RetoRepository extends JpaRepository<Reto, Long> {
	@Query("SELECT r FROM Reto r WHERE r.mentoria.id=?1")
	List<Reto> listaNotas(Long id);
}
