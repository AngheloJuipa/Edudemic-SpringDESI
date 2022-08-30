package com.edudemic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Mentoria;

import com.edudemic.repository.MentoriaRepository;


@Service
public class MentoriaService {
	
	
	private MentoriaRepository mentoriaRepository;
	private RetoService retoService;
	private InscripcionService inscripcionService;
	public MentoriaService(MentoriaRepository mentoriaRepository,RetoService retoService,InscripcionService inscripcionService) 
	{
		this.mentoriaRepository=mentoriaRepository;
		this.retoService=retoService;
		this.inscripcionService=inscripcionService;
	}
	public Mentoria registrarMentoria(Mentoria m) 
	{
		return mentoriaRepository.save(m);
	}
	public List<Mentoria> listarMentoria() 
	{
		return mentoriaRepository.findAll();
	}
	public Mentoria mentoriaObjeto(Long id) 
	{
		return mentoriaRepository.objetoM(id);
	}
	public Mentoria getMentoriaById(Long id) {
		return mentoriaRepository.findById(id).get();
	}
	public List<Mentoria> otraLista() 
	{
		List<Mentoria> listaM = new ArrayList<>();
		List<Mentoria> listaO = mentoriaRepository.findAll();
			for(int j=0;j<retoService.listarReto().size();j++) 
			{

				if(retoService.listarReto().get(j).getMentoria().getId()!=mentoriaRepository.findAll().get(j).getId()) 
				{

				}else 
				{
					listaM.add(mentoriaRepository.findAll().get(j));

				}

			}
			listaO.removeAll(listaM);
		return listaO;
	}
	public List<Mentoria> buscarMentoria(String fecha)
	{
		return mentoriaRepository.findByFechaContainingIgnoreCase(fecha);
	}
	public List<Mentoria> mentoriasInscripciones() 
	{
		List<Mentoria> listaM = new ArrayList<>();
		List<Mentoria> listaO = mentoriaRepository.findAll();
			for(int j=0;j<inscripcionService.listarInscripcion().size();j++) 
			{

				if(inscripcionService.listarInscripcion().get(j).getMentoria().getId()!=mentoriaRepository.findAll().get(j).getId()) 
				{

				}else 
				{
					listaM.add(mentoriaRepository.findAll().get(j));

				}

			}
			listaO.removeAll(listaM);
		return listaO;
	}
	public List<Mentoria> listaMentoriaxProfesor(Long id)
	{
		return mentoriaRepository.listaMentoriasxProfesor(id);
	}
}
