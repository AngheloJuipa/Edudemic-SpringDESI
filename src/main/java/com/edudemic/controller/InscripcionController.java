package com.edudemic.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.sql.Insert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.pattern.Converter;

import java.util.ArrayList;
import java.util.List;

import com.edudemic.entities.Estudiante;
import com.edudemic.entities.Inscripcion;
import com.edudemic.entities.Libro;
import com.edudemic.entities.Mentoria;
import com.edudemic.service.EstudianteService;
import com.edudemic.service.InscripcionService;
import com.edudemic.service.MentoriaService;

@Controller
public class InscripcionController {
	private InscripcionService inscripcionService;
	private EstudianteService estudianteService;
	private List<Estudiante> listaEstudiantes = new ArrayList<>();
	private MentoriaService mentoriaService;
	private List<Mentoria> listaMentorias=new ArrayList<>();
	public Long uxment;
	
	public InscripcionController(InscripcionService inscripcionService, EstudianteService estudianteService, MentoriaService mentoriaService) 
	{
		this.inscripcionService=inscripcionService;
		this.estudianteService=estudianteService;
		this.mentoriaService=mentoriaService;
	}
	@GetMapping("/lista/inscripcion")
	public String listarInscripciones(Model model) {
		
		model.addAttribute("inscripciones",inscripcionService.listarInscripcion());
		return "inscripcion/listaI";
	}
	@GetMapping("/lista/inscripcion/estudiante/{id}")
	public String listarNotas(@PathVariable Long id,Model model) {
	
		model.addAttribute("inscripcionE",inscripcionService.listaIns(id));
		return "estudiante/notasE";
	}
	
	@GetMapping("/registro/inscripciones/{id}")
	public String registrarInscripcionesForm(@PathVariable Long id,Model model, RedirectAttributes attribute) 
	{
		
		Inscripcion inscripcion = new Inscripcion();
		this.listaEstudiantes = estudianteService.listaEstudiantes();
		this.listaMentorias = mentoriaService.listarMentoria();
		
		
		Mentoria st = mentoriaService.getMentoriaById(id);
		
	
		
		model.addAttribute("mentoria", st);
		model.addAttribute("inscripciones",inscripcion);
		model.addAttribute("listaEstudiantes",listaEstudiantes);
		model.addAttribute("listaMentorias",listaMentorias);
		System.out.println("Error: El id del cliente no existe");
		attribute.addFlashAttribute("error", "Error: El id del cliente no existe");
		
		
		return "inscripcion/registroI";
	}
	
	@PostMapping("/inscripciones")
	public String registrarInscripcion( @ModelAttribute("mentoria") Mentoria mentoria,@ModelAttribute("inscripcion") Inscripcion inscripcion, RedirectAttributes attribute, Model model) 
	{
		if(inscripcionService.validarInscripción(inscripcion)==0)
		{inscripcionService.registrarInscripcion(inscripcion);
		  return "index";
		}
		else
		{
			model.addAttribute("mensaje", "El estudiante ya se inscribió en mentorias 3 veces");
			return "inscripcion/registroI";
		}
		
	}
	@GetMapping("/lista/inscripcion/estudiante2/{id}")
    public String listar(@PathVariable Long id,Model model) {

        model.addAttribute("inscripcionE",inscripcionService.listaIns(id));
        return "inscripcion/listaIE";
    }

}
