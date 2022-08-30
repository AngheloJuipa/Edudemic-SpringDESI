package com.edudemic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edudemic.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

	
}
