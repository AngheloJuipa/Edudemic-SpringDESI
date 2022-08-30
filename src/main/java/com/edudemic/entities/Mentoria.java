package com.edudemic.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="mentoria")
public class Mentoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public String getHoraI() {
		return horaI;
	}
	public void setHoraI(String horaI) {
		this.horaI = horaI;
	}
	public String getHoraF() {
		return horaF;
	}
	public void setHoraF(String horaF) {
		this.horaF = horaF;
	}
	private String fecha;
	@ManyToOne
	@JoinColumn(name = "profesor_id", nullable = false)
	private Profesor profesor;
	
	private String horaI;
	private String horaF;
	
	
}
