package com.edudemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Material;
import com.edudemic.entities.Reto;



public interface MaterialRepository extends JpaRepository<Material, Long>{

	@Query("SELECT m FROM Material m WHERE m.id=?1")
	List<Material> listaMateriales(Long id);
	
	@Query("SELECT m FROM Material m WHERE m.mentoria.id=?1")
	List<Material> listaMaterialesMentoria(Long id);
	
	@Query("SELECT m FROM Material m WHERE m.id=?1")
	Material objetoM(Long id);
}
