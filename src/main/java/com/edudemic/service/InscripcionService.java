package com.edudemic.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edudemic.entities.Inscripcion;
import com.edudemic.entities.Mentoria;
import com.edudemic.repository.InscripcionRepository;
@Service
public class InscripcionService {
	private InscripcionRepository inscripcionRepository;
	public InscripcionService(InscripcionRepository inscripcionRepository) 
	{
		this.inscripcionRepository=inscripcionRepository;
	}
	public List<Inscripcion> listarInscripcion() 
	{
		return inscripcionRepository.findAll();
	}
	public Inscripcion registrarInscripcion(Inscripcion c) 
	{
		return inscripcionRepository.save(c);
	}
	public List<Inscripcion> listaIns(Long id)
	{
		return inscripcionRepository.listaIns(id);
	}
	public Inscripcion getInscripcionById(Long id) {
		return inscripcionRepository.findById(id).get();
	}
	
	public int validarInscripción(Inscripcion inscripcion)
	{
		int validar=0;
		int contador=0;
		List<Inscripcion> listaAux=new ArrayList<>();
		listaAux=inscripcionRepository.findAll();
		if(listaAux.size()>0)
		{for(int i=0;i<listaAux.size();i++)
		{
			if(inscripcion.getEstudiante().getId()==listaAux.get(i).getEstudiante().getId() && inscripcion.getMentoria().getFecha()==listaAux.get(i).getMentoria().getFecha())
			{
				contador++;
			}
			
			if(contador==3)
			{
				validar=1;
				break;
			}
		}
		}
		else
			validar=0;
		contador=0;
		return validar;
	}
}
