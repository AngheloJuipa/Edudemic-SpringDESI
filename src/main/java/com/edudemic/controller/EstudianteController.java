package com.edudemic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Estudiante;
import com.edudemic.entities.Rol;
import com.edudemic.service.EstudianteService;
import com.edudemic.service.RolService;
import com.edudemic.service.UsuarioService;

@Controller
public class EstudianteController {
	private EstudianteService estudianteService;
	private RolService rolService;
	private Estudiante estudianteSeleccionado;
	@Autowired 
	private UsuarioService usuarioService;
	public EstudianteController(EstudianteService estudianteService,RolService rolService) 
	{
		this.estudianteService = estudianteService;
		this.rolService=rolService;
		this.estudianteSeleccionado=new Estudiante();
	}
	@GetMapping("/lista")
	public String lista(){
		return "estudiante/listaE";
	}
	@GetMapping("/registro/estudiante")
	public String registrarEstudianteForm(Model model) 
	{
		Estudiante estudiante = new Estudiante();
		model.addAttribute("estudiante",estudiante);
		model.addAttribute("roles", rolService.listarRoles());

		return "estudiante/registroE";
	}
	@PostMapping("/estudiantes")
	public String registrarEstudiante(@Valid @ModelAttribute("estudiante") Estudiante estudiante, BindingResult result) 
	{
		if(result.hasErrors() || usuarioService.validar(estudiante.getDni())) 
		{
			return "redirect:/registro/estudiante";
		}else 
		{
			List<Rol> nuevoList = rolService.listarStudent("ROLE_STUDENT");
			
			estudiante.setRol(nuevoList.get(0));
			estudianteService.registrarEstudiante(estudiante);
			return "redirect:/lista/estudiante";
		}
	}
	@GetMapping("/lista/estudiante")
	public String listarEstudiante(Model model) {
		model.addAttribute("estudiantes",estudianteService.listaEstudiantes());
		return "estudiante/listaE";
	}
	@GetMapping("/estudiante/edit/{id}")
	public String editEstudianteForm( @PathVariable("id") Long id, Estudiante estudiante,Model model) {

		try {
			estudiante = estudianteService.buscarPorId(id);
			model.addAttribute("estudiante", estudiante);
			estudianteSeleccionado=estudiante;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "estudiante/editarE";
	}
	
	@GetMapping("/estudiante/guardar")
	public String guardarEstudiante(@Validated @ModelAttribute("estudiante") Estudiante estudiante,BindingResult result,Model model) {

			try {
	    			estudianteSeleccionado.setId(estudiante.getId());
	    			estudianteSeleccionado.setApellidos(estudiante.getApellidos());
	    			estudianteSeleccionado.setDni(estudiante.getDni());
	    			estudianteSeleccionado.setEdad(estudiante.getEdad());
	    			estudianteSeleccionado.setNombres(estudiante.getNombres());
	    			estudianteSeleccionado.setGrado(estudiante.getGrado());

	    			estudianteService.editarEstudiante(estudianteSeleccionado);
				    model.addAttribute("estudiante",estudianteSeleccionado);
	    			model.addAttribute("mensaje", "El estudiante se modificó correctamente");

	        }catch (Exception e) {
	        	System.out.println(e.getMessage());
				model.addAttribute("mensaje", "El estudiante no se modificó correctamente");
	        }
		return "estudiante/editarE";
	
	}
}
