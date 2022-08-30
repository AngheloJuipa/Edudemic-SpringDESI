package com.edudemic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.CalificacionProfesor;
import com.edudemic.repository.CalificacionProfesorRepository;

@Service
public class CalificacionProfesorService {

	private CalificacionProfesorRepository calificacionProfesorRepository;
	public CalificacionProfesorService(CalificacionProfesorRepository calificacionProfesorRepository) 
	{
		this.calificacionProfesorRepository=calificacionProfesorRepository;
	}
	public List<CalificacionProfesor> listarCalificacionProfesor() 
	{
		return calificacionProfesorRepository.findAll();
	}
	public CalificacionProfesor registroCalificacion(CalificacionProfesor cp) 
	{
		return calificacionProfesorRepository.save(cp);
	}
	
	public CalificacionProfesor getCalificacionProfesorById(Long id) {
		return calificacionProfesorRepository.findById(id).get();
	}
	
}