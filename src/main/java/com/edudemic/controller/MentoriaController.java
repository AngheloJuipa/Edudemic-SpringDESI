package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.edudemic.entities.Profesor;
import com.edudemic.entities.Mentoria;
import com.edudemic.service.ProfesorService;
import com.edudemic.service.MentoriaService;

@Controller
public class MentoriaController {

	private MentoriaService mentoriaService;
	private ProfesorService profesorService;
	private List<Profesor> listaProfesores =new ArrayList<>();
	
	public MentoriaController(MentoriaService mentoriaService,ProfesorService profesorService) 
	{
		this.mentoriaService=mentoriaService;
		this.profesorService = profesorService;
	}
	
	@GetMapping("/registro/mentoria")
	public String registrarMentoriaForm(Model model) 
	{
		Mentoria mentoria = new Mentoria();
		this.listaProfesores = profesorService.listarProfesor();

		model.addAttribute("mentoria",mentoria);
		model.addAttribute("listaProfesores",listaProfesores);
		return "mentoria/registroM";
	
	}
	
	@PostMapping("/mentorias")
	public String registrarMentoria(@ModelAttribute("mentoria") Mentoria mentoria) 
	{
		
		mentoriaService.registrarMentoria(mentoria);
		return "redirect:/private/index";
	}
	
	@GetMapping("/listar/mentoria/{id}")
	public String listaMentoria(@PathVariable Long id,Model model) 
	{

		model.addAttribute("mentorias",mentoriaService.listaMentoriaxProfesor(id));
		return "mentoria/listaM";
	
	}
	@GetMapping("/listar/mentoria2")
	public String listaMentoria2(Model model) 
	{

		model.addAttribute("mentorias",mentoriaService.listarMentoria());
		return "mentoria/listaME";
	
	}
	@GetMapping("/mentoria/estudiante/{id}")
	public String objetoMentoria(@PathVariable Long id,Model model) {
	
		model.addAttribute("mentoriaE",mentoriaService.mentoriaObjeto(id));
		return "estudiante/mentoriaE";
	}
	@GetMapping("/listar/mentoria/estudiante")
	public String listaHorario(Model model) 
	{
		Mentoria mentoria = new Mentoria();
		model.addAttribute("mentoria", mentoria);
		model.addAttribute("mentorias", mentoriaService.mentoriasInscripciones());
		return "mentoria/listaH";
	}
	
	@PostMapping("/mentorias/buscar")
	public String buscarFecha(Model model, @ModelAttribute Mentoria mentoria) {
		try {
			model.addAttribute("mentorias", mentoriaService.buscarMentoria(mentoria.getFecha()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		
		return "mentoria/listaH";
	}
}
