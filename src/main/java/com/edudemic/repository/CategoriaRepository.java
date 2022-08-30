package com.edudemic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edudemic.entities.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
