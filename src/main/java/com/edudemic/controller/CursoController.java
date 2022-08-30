package com.edudemic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Curso;
import com.edudemic.service.CursoService;

@Controller
public class CursoController {
	private CursoService cursoService;
	public CursoController(CursoService cursoService) 
	{
		this.cursoService=cursoService;
	}

	@GetMapping("/registro/curso")
	public String registrarForm(Model model) 
	{
		Curso curso = new Curso();
		model.addAttribute("curso",curso);
		return "curso/registroC";
	}
	@PostMapping("/cursos")
	public String registrarCurso(@ModelAttribute("curso") Curso curso) 
	{
		cursoService.registrarCurso(curso);
		return "redirect:/lista/curso";
	}
	@GetMapping("/lista/curso")
	public String listarEstudiante(Model model) {
		model.addAttribute("cursos",cursoService.listarCurso());
		return "curso/listaC";
	}
}
