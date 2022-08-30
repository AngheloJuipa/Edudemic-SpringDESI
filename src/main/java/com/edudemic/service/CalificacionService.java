package com.edudemic.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Calificacion;
import com.edudemic.entities.Inscripcion;
import com.edudemic.repository.CalificacionRepository;
import com.edudemic.repository.InscripcionRepository;
@Service
public class CalificacionService {

	private CalificacionRepository calificacionRepository;
	public CalificacionService(CalificacionRepository calificacionRepository) 
	{
		this.calificacionRepository=calificacionRepository;
	}
	public List<Calificacion> listarCalificacion() 
	{
		return calificacionRepository.findAll();
	}
	public Calificacion registroCalificacion(Calificacion c) 
	{
		return calificacionRepository.save(c);
	}
	
	public Calificacion getCalificacionById(Long id) {
		return calificacionRepository.findById(id).get();
	}
	
	
	public int validarCalificacion(Calificacion calificacion)
	{
		
		int validar=0;
		List<Calificacion> listaAux=new ArrayList<>();
		listaAux=calificacionRepository.findAll();
		
		if(listaAux.size()>0)
		{
			for(int i=0;i<listaAux.size();i++)
			{
				if(calificacion.getEstudiante()==listaAux.get(i).getEstudiante() && calificacion.getLibro()==listaAux.get(i).getLibro())
					{validar=1;
					break;
					
					}
			}
		}
		else
			validar=0;
		
		
		return validar;
	
	}
	public List<Calificacion> listaCalificacionxLibro(Long id)
    {
        return calificacionRepository.listaCalificacionxLibro(id);
    }
	
}