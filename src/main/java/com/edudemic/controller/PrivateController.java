package com.edudemic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edudemic.entities.Usuario;
import com.edudemic.repository.UsuarioRepository;
import com.edudemic.service.EstudianteService;
import com.edudemic.service.LibroService;
import com.edudemic.service.ProfesorService;
import com.edudemic.service.VideoService;

@Controller
@RequestMapping("/private")
public class PrivateController {
	@Autowired
	LibroService libroService;
	@Autowired
	ProfesorService profesorService;
	@Autowired
	EstudianteService estudianteService;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	VideoService videoService;
	@GetMapping("/index")
	public String indx(Authentication auth, HttpSession session, Model model) 
	{
		String username = auth.getName(); 
		if(session.getAttribute("usuario")==null) 
		{
			Usuario user = usuarioRepository.findByDni(username);
			user.setPassword(null);
			session.setAttribute("usuario", user);
		}
		model.addAttribute("libros", libroService.getAllLibros());
		model.addAttribute("estudiantes", estudianteService.listaEstudiantes());
		model.addAttribute("profesores", profesorService.listarProfesor());
		model.addAttribute("videos",videoService.getAllVideos());

		return "index";
	}
}
