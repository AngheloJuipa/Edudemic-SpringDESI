package com.edudemic.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edudemic.service.EstudianteService;
import com.edudemic.service.ReporteMentoriaService;

@Controller
public class ReporteController {
	private EstudianteService estudianteService;
	private ReporteMentoriaService reporteMentoriaService;
	public ReporteController(EstudianteService estudianteService,ReporteMentoriaService reporteMentoriaService) 
	{
		this.estudianteService = estudianteService;
		this.reporteMentoriaService=reporteMentoriaService;
	}
	@GetMapping("/reporte/estudiante/nota")
	public String reporteE(Model model){
		
		model.addAttribute("estudiantes",estudianteService.listaEstudiantes());

		return "reporte/estudianteR";
	}
	@GetMapping("/reporte/mentoria")
	public String reportPM (Model model)
	{
		model.addAttribute("reporteMentorias", reporteMentoriaService.reporteM());
		
		return "reporte/mentoriaR";
	}	
}
