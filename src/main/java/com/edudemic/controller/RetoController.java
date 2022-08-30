package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Mentoria;
import com.edudemic.entities.Reto;
import com.edudemic.service.MentoriaService;
import com.edudemic.service.PreguntaService;
import com.edudemic.service.RetoService;
@Controller
public class RetoController {
	private RetoService retoService;
	private List<Mentoria> listaMentorias = new ArrayList<>();
	private MentoriaService mentoriaService;
	private PreguntaService preguntaService;
	public RetoController(RetoService retoService,MentoriaService mentoriaService,PreguntaService preguntaService) 
	{
		this.retoService=retoService;
		this.mentoriaService=mentoriaService;
		this.preguntaService=preguntaService;
	}
	@GetMapping("/registro/reto")
	public String registrarForm(Model model) 
	{
		
		Reto reto = new Reto();
		this.listaMentorias= mentoriaService.otraLista();
		model.addAttribute("reto",reto);
		model.addAttribute("listaMentorias",listaMentorias);
		return "reto/registroR";
	}
	@PostMapping("/retos/nuevo")
	public String registrarRetoNuevo(@ModelAttribute("reto") Reto reto,BindingResult result,Model model) 
	{
		if(result.hasErrors()) {
			this.listaMentorias= mentoriaService.otraLista();
			model.addAttribute("listaMentorias",listaMentorias);
			return "reto/registroR";
		}else 
		{
			retoService.registrarReto(reto);
			reto = new Reto();
			this.listaMentorias= mentoriaService.otraLista();
			model.addAttribute("listaMentorias",listaMentorias);
			model.addAttribute("mensaje", "Se registro el reto");
			return "reto/registroR";
		}

	}
	@PostMapping("/retos")
	public String registrarReto(@ModelAttribute("reto") Reto reto) 
	{
		
			retoService.registrarReto(reto);
			return "redirect:/lista/reto";
		
	}
	@GetMapping("/lista/reto")
	public String listarReto(Model model) {
		model.addAttribute("retos",retoService.listarReto());
		return "reto/listaR";
	}
	@GetMapping("/lista/preguntas/opciones/{id}")
	public String listarPreguntasO(@PathVariable Long id,Model model) {
		
		
		
		//enviar solo las preguntas de los retos
		//son las preguntas de un reto
		model.addAttribute("preguntaReto",preguntaService.buscarPreguntaReto(id));
		//enviar solo las opciones de la pregunta
		return "reto/preguntasReto";
	}
	@GetMapping("/lista/reto/nota/{id}")
	public String listarNotas(@PathVariable Long id,Model model) {
	
		model.addAttribute("notaReto",retoService.notasReto(id));
		return "reto/notaReto";
	}
	@GetMapping("/listaRxProfesor/reto")
	public String listarRetoxProfesor(Model model) {
		model.addAttribute("retos",retoService.listarReto());
		return "reto/listaRxProfesor";
	}
	
}
