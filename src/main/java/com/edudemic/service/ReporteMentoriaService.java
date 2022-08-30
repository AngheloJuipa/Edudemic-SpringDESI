package com.edudemic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Mentoria;
import com.edudemic.entities.Profesor;
import com.edudemic.entities.ReporteMentoria;
import com.edudemic.repository.MentoriaRepository;
import com.edudemic.repository.ProfesorRepository;

@Service
public class ReporteMentoriaService {

	private ProfesorRepository profesorRepository;
	private MentoriaRepository mentoriaRepository;
	public ReporteMentoriaService(ProfesorRepository profesorRepository, MentoriaRepository mentoriaRepository) 
	{
		this.profesorRepository=profesorRepository;
		this.mentoriaRepository=mentoriaRepository;
	}
	public List<ReporteMentoria> reporteM()
	{
		List<Profesor> listP =  profesorRepository.findAll();
		List<Mentoria> listM =  mentoriaRepository.findAll();
		List<ReporteMentoria> listPM = new ArrayList<>();
		for(int i=0; i <listP.size(); i++)
		{
			ReporteMentoria reporteMentoria = new ReporteMentoria();
			reporteMentoria.setProfesor(listP.get(i));	
			for(int j=0; j<listM.size(); j++)
			{
				if(listM.get(j).getProfesor().getId()==listP.get(i).getId())
				{
					reporteMentoria.setCantidad(reporteMentoria.getCantidad()+1);
				}
			}
			listPM.add(reporteMentoria);
		}
		return listPM;
	}
	
}
