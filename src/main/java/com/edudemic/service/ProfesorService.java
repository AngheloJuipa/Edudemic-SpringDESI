package com.edudemic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edudemic.entities.Profesor;
import com.edudemic.repository.ProfesorRepository;

@Service
public class ProfesorService {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	private ProfesorRepository profesorRepository;
	public ProfesorService(ProfesorRepository profesorRepository) 
	{
		this.profesorRepository=profesorRepository;
		}
	public Profesor registrarProfesor(Profesor p) 
	{
		p.setPassword(passwordEncoder.encode(p.getPassword()));

		return profesorRepository.save(p);
	}
	public List<Profesor> listarProfesor()
	{
		return profesorRepository.findAll();
	}
}
