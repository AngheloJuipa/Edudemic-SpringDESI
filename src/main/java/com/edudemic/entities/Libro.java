package com.edudemic.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Ingrese un titulo")
	@Column(name = "titulo", nullable = false, length = 70)
	private String titulo;
	
	@Past(message = "Fecha de publicacion no correcta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fPublicacion", nullable = false)
	private Date fPublicacion;
	
	@NotEmpty(message = "Ingrese una descripcion")
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@NotEmpty(message = "Ingrese un autor")
	@Column(name = "autor", nullable = false,length = 70)
	private String autor;
	
	private String enlace;

	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	public Libro() {
	}
	@Transient
	private List<Libro> libros = new ArrayList<>();

	public Libro(String titulo, Date fPublicacion, String descripcion, String autor, String enlace) {
		this.titulo = titulo;
		this.fPublicacion = fPublicacion;
		this.descripcion = descripcion;
		this.autor = autor;
		this.enlace = enlace;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getfPublicacion() {
		return fPublicacion;
	}

	public void setfPublicacion(Date fPublicacion) {
		this.fPublicacion = fPublicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
}
