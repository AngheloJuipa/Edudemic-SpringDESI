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
import javax.validation.constraints.Size;
@Entity
@Table(name="mentoria")
public class Mentoria 
{
	//editado x joao
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "profesor_id", nullable = false)
	private Profesor profesor;

	@NotEmpty(message = "Selecciones una fecha")
	@Column(name = "fecha", nullable = false)
	private String fecha;

	@Size(max = 500, message = "La descripcion no puede contener más de 500 caracteres")
	@Column(name = "descripcion", nullable = true, length = 500)
	private String descripcion;
	
	@NotEmpty(message = "Selecciones una hora de inicio")
	@Column(name = "horaI", nullable = false)
	private String horaI;
	
	@NotEmpty(message = "Selecciones una hora final")
	@Column(name = "horaF", nullable = false)
	private String horaF;
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	
	public String getFecha() { return fecha; }
	public void setFecha(String fecha) { this.fecha = fecha; }
	
	public Profesor getProfesor() { return profesor; }
	public void setProfesor(Profesor profesor) { this.profesor = profesor; }
	
	public String getHoraI() { return horaI; }
	public void setHoraI(String horaI) { this.horaI = horaI; }
	
	public String getHoraF() { return horaF; }
	public void setHoraF(String horaF) { this.horaF = horaF;}
}
