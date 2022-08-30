package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Curso;
import com.edudemic.entities.Profesor;
import com.edudemic.entities.Rol;
import com.edudemic.service.CursoService;
import com.edudemic.service.ProfesorService;
import com.edudemic.service.RolService;
import com.edudemic.service.UsuarioService;


@Controller
public class ProfesorController {
	private ProfesorService profesorService;
	private CursoService cursoService;
	private RolService rolService;
	@Autowired 
	private UsuarioService usuarioService;
	private List<Curso> listaCursos =new ArrayList<>();
	public ProfesorController(ProfesorService profesorService,CursoService cursoService,RolService rolService) 
	{
		this.profesorService=profesorService;
		this.cursoService = cursoService;
		this.rolService = rolService;
	}
	
	@GetMapping("/registro/profesor")
	public String registrarProfesorForm(Model model) 
	{
		Profesor profesor = new Profesor();
		this.listaCursos = cursoService.listarCurso();

		model.addAttribute("profesor",profesor);
		model.addAttribute("listaCursos",listaCursos);
		model.addAttribute("roles", rolService.listarRoles());
		return "profesor/registroP";
	}
	@PostMapping("/profesores")
	public String registrarProfesor(@Valid @ModelAttribute("profesor") Profesor profesor, BindingResult result) 
	{
		if(result.hasErrors() || usuarioService.validar(profesor.getDni())) 
		{
			return "redirect:/registro/profesor";
		}else 
		{
			List<Rol> nuevoList = rolService.listarStudent("ROLE_PROFESOR");
			profesor.setRol(nuevoList.get(0));
		profesorService.registrarProfesor(profesor);
		return "redirect:/lista/profesor";
		}
	}
	@GetMapping("/lista/profesor")
	public String listarEstudiante(Model model) {
		model.addAttribute("profesores",profesorService.listarProfesor());
		return "profesor/listaP";
	}
}
