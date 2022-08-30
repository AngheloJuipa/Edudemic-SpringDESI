package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Categoria;
import com.edudemic.entities.Revista;
import com.edudemic.service.CategoriaService;
import com.edudemic.service.RevistaService;

@Controller
public class RevistaController {
	
	private RevistaService revistaService;
	private CategoriaService categoriaService;
	private List<Categoria>listaCategorias=new ArrayList<>();
	
	public RevistaController(RevistaService revistaService, CategoriaService categoriaService) 
	{
		this.revistaService=revistaService;
		this.categoriaService=categoriaService;
	}
	
	
	@GetMapping("/registro/revista")
	public String registrarRevistaForm(Model model) {
		
		Revista revista=new Revista();
		this.listaCategorias=categoriaService.listarCategoria();
		model.addAttribute("revista",revista);
		model.addAttribute("listaCategorias",listaCategorias);
		
		return "revista/registroR";
	}
	
	@GetMapping("/listar/revista")
	public String listarRevistas(Model model) {
		model.addAttribute("revistas",revistaService.listarRevista());
		
		return "revista/listR";
	}
	@GetMapping("/listar/revista/estudiante")
	public String listarRevistasEstudiante(Model model) {
		model.addAttribute("revistas",revistaService.listarRevista());
		
		return "revista/lista";
	}
	
	@PostMapping("/revistas")
	public String registrarLibro(@ModelAttribute("revista")Revista revista) {
		
		revistaService.registrarRevista(revista);
		return "redirect:/listar/revista";
	}
	
	
}
