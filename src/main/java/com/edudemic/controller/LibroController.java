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

import com.edudemic.entities.Calificacion;
import com.edudemic.entities.Categoria;
import com.edudemic.entities.Libro;
import com.edudemic.service.CalificacionService;
import com.edudemic.service.CategoriaService;
import com.edudemic.service.LibroService;

@Controller
public class LibroController {

	private LibroService libroService;
	private CategoriaService categoriaService;
	private List<Categoria> listaCategorias = new ArrayList<>();
	private CalificacionService calificacionService;

	public LibroController(LibroService libroService, CategoriaService categoriaService, CalificacionService calificacionService) {

		this.libroService = libroService;
		this.categoriaService = categoriaService;
		this.calificacionService = calificacionService;
	}

	@GetMapping("/registro/libro")
	public String registrarLibroForm(Model model) {

		Libro libro = new Libro();
		this.listaCategorias = categoriaService.listarCategoria();

		model.addAttribute("libro", libro);
		model.addAttribute("listaCategorias", listaCategorias);
		return "libro/registroL";
	}

	@GetMapping("/listar/libro")
	public String listarLibros(Model model) {
		model.addAttribute("libros", libroService.getAllLibros());

		return "libro/listL";
	}

	@PostMapping("/libros")
	public String registrarLibro(@Validated @ModelAttribute Libro libro, BindingResult result, Model model,
			SessionStatus status) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("listaCategorias", listaCategorias);

				return "libro/registroL";
			}
			libroService.saveLibro(libro);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/listar/libro";
	}

	@GetMapping("/libros/edit/{id}")
	public String editLibroForm(@PathVariable Long id, Model model) {
		Libro st = libroService.getLibroById(id);

		model.addAttribute("libro", st);
		model.addAttribute("listaCategorias", categoriaService.listarCategoria());

		return "libro/update";
	}

	@PostMapping("/libros/{id}")
	public String updateLibro(@PathVariable Long id, @ModelAttribute("libro") Libro libro, Model model) {
		// sacar al libro de la b.d. por el id
		Libro existentLibro = libroService.getLibroById(id);
		// cargarlo
		existentLibro.setId(id);
		existentLibro.setTitulo(libro.getTitulo());
		existentLibro.setfPublicacion(libro.getfPublicacion());
		existentLibro.setDescripcion(libro.getDescripcion());
		existentLibro.setAutor(libro.getAutor());
		existentLibro.setEnlace(libro.getEnlace());
		existentLibro.setLibros(libro.getLibros());
		// guardar el libro actualizado
		libroService.updateLibro(existentLibro);

		return "redirect:/listar/libro";

	}

	@GetMapping("/lista/libro/estudiante")
	public String showAllLibros(Model model) {
		Libro libro = new Libro();
		model.addAttribute("libro", libro);
		model.addAttribute("libros", libroService.getAllLibros());
		return "libro/lista";
	}

	@GetMapping("/libros/delete/{id}")
	public String deleteLibro(@PathVariable Long id) {
		libroService.deleteLibroById(id);
		return "redirect:/listar/libro";
	}

	@PostMapping("/libros/buscar")
	public String buscarTituloLibro(Model model, @ModelAttribute Libro libro) {
		try {
			model.addAttribute("libros", libroService.buscarLibro(libro.getTitulo()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "libro/lista";
	}
	
	@GetMapping("/libros/detalle/{id}")
    public String vertLibroForm2(@PathVariable Long id, Model model) {
        Libro st = libroService.getLibroById(id);
        List<Calificacion> calificaciones=calificacionService.listaCalificacionxLibro(id);

        model.addAttribute("libro", st);
        model.addAttribute("calificaciones", calificaciones);


        return "calificacion/registroCali";
    }
	

}
