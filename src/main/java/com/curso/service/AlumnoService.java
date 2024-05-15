package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import com.curso.dominio.Alumno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AlumnoService {

	public void printAlumnos(String mensaje, List<Alumno> alumno) {
		System.out.println(mensaje);
		for (Alumno a : alumno) {
			System.out.println(a);
		}
	}

	/**
	 * Obtener la lista completa alumnos del instituto
	 * @param em el gestor EntityManager para la gestion de la base de datos
	 * @return la lista de los alumnos
	 */
	public List<Alumno> getAlumnos(EntityManager em){
		TypedQuery<Alumno> queryAlumno = em.createNamedQuery("buscarTodos", Alumno.class);
		List<Alumno> alumnos = queryAlumno.getResultList();
		return alumnos;
	}
	
	/**
	 * Obtener un alumno a partir de su Id
	 * @param em el gestor EntityManager para la gestion de la base de datos
	 * @param id el id del alumno
	 * @return el alumno si lo encuentra, null en caso contrario
	 */
	public Alumno getAlumnoPorId(EntityManager em, Integer id){
		Alumno alumno = null;
		if(em != null) {
			if(id != null && id > 0) {
				try {
					TypedQuery<Alumno> queryAlumno = em.createNamedQuery("buscarPorId", Alumno.class);
					queryAlumno.setParameter("id", id);
					alumno = queryAlumno.getSingleResult();
				} catch (Exception e) {
					System.out.println(String.format("Error en la obtencion del alumno con id %s", id));
					e.printStackTrace();
				}
			}else {
				System.out.println("Error. El id no puede ser null ni menor a 0.");
			}
		}else {
			System.out.println("Error. EntityManager no puede ser null.");
		}
		return alumno;
	}
	
	/**
	 * Obtener una lista de alumnos cuyo nombre completo contenga la palabra a buscar
	 * @param em  el gestor EntityManager para la gestion de la base de datos
	 * @param nombre el nombre a buscar
	 * @return una lista con los alumnos que coincidan con la busqueda, una lista vacia en caso de que no haya coincidencias
	 */
	public List<Alumno> getAlumnosPorNombre(EntityManager em, String nombre){
		List<Alumno> alumnos = new ArrayList();
		if(em != null) {
			if(!nombre.isEmpty()) {
			try {
				TypedQuery<Alumno> queryAlumno = em.createNamedQuery("buscarPorNombre", Alumno.class);
				queryAlumno.setParameter("nombre", nombre);
				alumnos = queryAlumno.getResultList();
			} catch (Exception e) {
				System.out.println("Error en la consulta en la base de datos.");
				e.printStackTrace();
			}
			}else {
				System.out.println("Error. El nombre no puede estar vacio.");
			}
		}else {
			System.out.println("Error. EntityManager no puede ser null.");
		}

		return alumnos;
	}
	
	/**
	 * Obtener una lista de alumnos por su apellido
	 * @param em el gestor EntityManager para la gestion de la base de datos
	 * @param apellido el apellido a buscar en la base de datos
	 * @return una lista con los alumnos que coincidan con la busqueda, una lista vacia en caso de que no haya coincidencias
	 */
	public List<Alumno> getAlumnosPorApellido(EntityManager em, String apellido){
		List<Alumno> alumnos = new ArrayList();
		if(em != null) {
			if(!apellido.isEmpty()) {
			try {
				TypedQuery<Alumno> queryAlumno = em.createNamedQuery("buscarPorApellido", Alumno.class);
				queryAlumno.setParameter("apellido", apellido);
				alumnos = queryAlumno.getResultList();
			} catch (Exception e) {
				System.out.println("Error en la consulta en la base de datos.");
				e.printStackTrace();
			}
			}else {
				System.out.println("Error. El apellido no puede estar vacio.");
			}
		}else {
			System.out.println("Error. EntityManager no puede ser null.");
		}
		return alumnos;
	}
}
