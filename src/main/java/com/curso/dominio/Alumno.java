package com.curso.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="buscarPorId", query="SELECT a from Alumno a WHERE a.id=:id"),
	@NamedQuery(name="buscarTodos", query="SELECT a from Alumno a"),
	@NamedQuery(name="buscarPorNombre", query="SELECT a from Alumno a WHERE a.nombre LIKE :nombre"),
	@NamedQuery(name="buscarPorApellido", query="SELECT a from Alumno a WHERE a.apellido LIKE :apellido")
})
@Table(name = "alumno")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String curso;
	
	/**
	 * Constructor por defecto de Alumno
	 */
	public Alumno() {
		super();
	}
	
	/**
	 * Constructor de Alumno con todos los parametros
	 * @param id el id del alumno
	 * @param nombre el nombre del alumno
	 * @param apellido el apellido del alumno
	 * @param curso el curso en el que esta matriculado el alumno
	 */
	public Alumno(Integer id, String nombre, String apellido, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.curso = curso;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", curso=" + curso + "]";
	} 
	
	
}
