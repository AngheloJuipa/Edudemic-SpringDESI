package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.edudemic.entities.Estudiante;
import com.edudemic.entities.Foro;
import com.edudemic.service.EstudianteService;
import com.edudemic.service.ForoService;



@Controller
public class ForoController {

	private ForoService foroService;
	private EstudianteService estudianteService;
	private List<Estudiante> listaEstudiantes = new ArrayList<>();
	
	public ForoController(ForoService foroService, EstudianteService estudianteService) {
		this.foroService = foroService;
		this.estudianteService = estudianteService;
		
	}
	@GetMapping("/registro/foro")
	public String registrarForoForm(Model model) {
		this.listaEstudiantes = estudianteService.listaEstudiantes();

		model.addAttribute("foro", new Foro());
		model.addAttribute("listaEstudiantes", listaEstudiantes);
		return "foro/registroF";
	}
	
	@GetMapping("/listar/foro")
	public String listarForos(Model model) {
		model.addAttribute("foro", new Foro());
		model.addAttribute("foros", foroService.getAllForos());

		return "foro/listF";
	}
	
	@PostMapping("/foros")
	public String registrarForo(@Validated @ModelAttribute Foro foro, BindingResult result, Model model,
			SessionStatus status) {
			String titulo=foro.getTitulo();
		try {
			if (result.hasErrors()) {
				model.addAttribute("listaEstudiantes", listaEstudiantes);

				return "foro/registroF";
			}
			if(titulo.contains("drogas") || titulo.contains("Fiesta") || titulo.contains("fiesta") || titulo.contains("alcohol")
			|| titulo.contains("sexo") || titulo.contains("relaciones")	|| titulo.contains("estupidos")
					) {
				model.addAttribute("mensaje", "No se puede colocar ese titulo porque es inapropiado");
				return "foro/registroF";
			}
			if(titulo.contains("tarea")|| titulo.contains("reto")) {
						model.addAttribute("mensaje2", "No puede agregar este foro porque esta intentando copiar una tarea");
						return "foro/registroF";
					}
			foroService.saveForo(foro);
			status.setComplete();
		} 
		
		catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/listar/foro";
	}
	
	@PostMapping("/foros/buscar")
	public String buscarTituloForo(Model model, @ModelAttribute Foro foro) {
		try {
			model.addAttribute("foro", new Foro());
			model.addAttribute("foros", foroService.buscarForo(foro.getTitulo()));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "foro/listF";
	}
	
	@GetMapping("/foros/delete/{id}")
	public String deleteForo(@PathVariable Long id) {
		foroService.deleteForoById(id);
		return "redirect:/listar/foro";
	}
	
}
