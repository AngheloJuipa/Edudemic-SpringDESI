package com.edudemic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Video;
import com.edudemic.repository.VideoRepository;

@Service
public class VideoService {

	private VideoRepository videoRepository;
	
	public VideoService(VideoRepository videoRepository) {
		this.videoRepository=videoRepository;
		
	}
	
	//listar
	public List<Video>getAllVideos(){
		return videoRepository.findAll();
	}
	//registrar
	public Video saveVideo(Video video) {
		return videoRepository.save(video);
	}
	
	public void eliminarVideo(Long id) 
	{
		videoRepository.deleteById(id);
	}
}
