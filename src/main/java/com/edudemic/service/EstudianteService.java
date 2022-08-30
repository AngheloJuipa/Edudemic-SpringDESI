package com.edudemic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edudemic.entities.Estudiante;
import com.edudemic.repository.EstudianteRepository;

@Service
public class EstudianteService {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	private EstudianteRepository estudianteRepository;
	public EstudianteService(EstudianteRepository estudianteRepository) 
	{
		this.estudianteRepository=estudianteRepository;
	}
	public List<Estudiante> listaEstudiantes()
	{
		return estudianteRepository.findAll();
	}
	public Estudiante registrarEstudiante(Estudiante e) 
	{
		e.setPassword(passwordEncoder.encode(e.getPassword()));

		return estudianteRepository.save(e);
	}
	public Estudiante buscarPorId(Long id) {
        return estudianteRepository.findById(id).get();
    }
    public Estudiante editarEstudiante(Estudiante e) 
    {
        return estudianteRepository.save(e);
    }
}
