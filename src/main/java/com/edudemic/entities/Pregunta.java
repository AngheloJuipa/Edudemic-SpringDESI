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
@Table(name="preguntas")
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Debe ingresar la descripcion*")
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	private double valor;
	private String respuesta;
	@ManyToOne
	@JoinColumn(name = "reto_id", nullable = false)
	private Reto reto;
	public Pregunta() {
	}
	public Pregunta(Long id, String descripcion,double valor,String respuesta) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.valor=valor;
		this.respuesta=respuesta;
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
	public Reto getReto() {
		return reto;
	}
	public void setReto(Reto reto) {
		this.reto = reto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
}
