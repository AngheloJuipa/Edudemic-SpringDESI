package com.edudemic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "comentarios")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Ingrese una descripcion")
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	
	@Column(name = "hPublicacion", nullable = false)
	private Long hPublicacion;
	
	
	
	@ManyToOne
	@JoinColumn(name = "foro_id", nullable = false)
	private Foro foro;
	
	
	
	public Comentario() {
	}
	@Transient
	private List<Comentario> comentarios = new ArrayList<>();
	
	public Comentario(String descripcion, Long hPublicacion) {
		this.hPublicacion = hPublicacion;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long gethPublicacion() {
		return hPublicacion;
	}

	public void sethPublicacion(Long hPublicacion) {
		this.hPublicacion = hPublicacion;
	}

	public Foro getForo() {
		return foro;
	}

	public void setForo(Foro foro) {
		this.foro = foro;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	
	
	
}