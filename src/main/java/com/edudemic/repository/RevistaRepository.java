package com.edudemic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edudemic.entities.Revista;

public interface RevistaRepository extends JpaRepository<Revista, Long> {
	

}