package com.edudemic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="calificacionProfesores")
public class CalificacionProfesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "profesor_id", nullable = false)
	private Profesor profesor;
	@ManyToOne
	@JoinColumn(name = "estudiante_id", nullable = false)
	private Estudiante estudiante;
	
	@NotEmpty(message = "Ingrese un comentario")
	@Column(name = "comentario", nullable = false, length = 100)
	String comentario;	
	

	@Column(name = "actitud", nullable = false)
	int actitud;

	@Column(name = "ensenanza", nullable = false)
	int ensenanza;

	@Column(name = "metodologia", nullable = false)
	int metodologia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getActitud() {
		return actitud;
	}
	public void setActitud(int actitud) {
		this.actitud = actitud;
	}
	public int getEnsenanza() {
		return ensenanza;
	}
	public void setEnsenanza(int ensenanza) {
		this.ensenanza = ensenanza;
	}
	public int getMetodologia() {
		return metodologia;
	}
	public void setMetodologia(int metodologia) {
		this.metodologia = metodologia;
	}
}