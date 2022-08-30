package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Categoria;
import com.edudemic.entities.Video;
import com.edudemic.service.CategoriaService;
import com.edudemic.service.VideoService;

@Controller

public class VideoController {

	private VideoService videoService;
	private CategoriaService categoriaService;
	private List<Categoria>listaCategorias=new ArrayList<>();
	public VideoController(VideoService videoService,CategoriaService categoriaService) {
	
		this.videoService=videoService;
		this.categoriaService=categoriaService;
	}

	
	@GetMapping("/registro/video")
	public String registrarVideoForm(Model model) {
		
		Video video=new Video();
		this.listaCategorias=categoriaService.listarCategoria();
		
		model.addAttribute("video",video);
		model.addAttribute("listaCategorias",listaCategorias);
		return "video/registroV";
	}
	
	@GetMapping("/list/video")
	public String listarVideos(Model model) {
		model.addAttribute("videos",videoService.getAllVideos());
		
		return "video/list_videos";
	}
	@PostMapping("/videos")
	public String registrarVideo(@ModelAttribute("video")Video video) {
		
		videoService.saveVideo(video);
		return "redirect:/list/video";
	}
	
    @GetMapping("/videos/eliminar/{id}")
    public String eliminarVideo(@PathVariable Long id) {
        videoService.eliminarVideo(id);
        return "redirect:/list/video";
    }
    @GetMapping("/list/video/estudiante")
	public String listarVideosE(Model model) {
		model.addAttribute("videos",videoService.getAllVideos());
		
		return "video/lista";
	}
}
