package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Material;
import com.edudemic.entities.Mentoria;
import com.edudemic.service.MaterialService;
import com.edudemic.service.MentoriaService;

@Controller
public class MaterialController {

	private MaterialService materialService;
	private MentoriaService mentoriaService;
	private List<Mentoria>listaMentorias=new ArrayList<>();
	
	public MaterialController(MaterialService materialService,MentoriaService mentoriaService) {
		this.materialService=materialService;
		this.mentoriaService=mentoriaService;
		
		
	}
	@GetMapping("/registro/material")
	public String registrarMaterialForm(Model model) {
		Material material=new Material();
		this.listaMentorias=mentoriaService.listarMentoria();
		
		model.addAttribute("material",material);
		model.addAttribute("listaMentorias",listaMentorias);
		
		return "material/registroM";
	}
	
	@PostMapping("/materiales")
	public String registrarMaterial(@ModelAttribute("material")Material material) {
		materialService.registrarMaterial(material);
		return "redirect:/listar/material";
	}
	@GetMapping("/listar/material")
	public String listaMentoria(Model model) {
		model.addAttribute("materiales",materialService.listarMaterial());
		return "material/listaM";
	}
	
	@GetMapping("/lista/mentoria/material/{id}")
	public String listaMaterialesMentoria(@PathVariable Long id,Model model) {
		model.addAttribute("materiales",materialService.listarMaterialesMentoria(id));
        return "material/listaM";
		
	}
	
}
