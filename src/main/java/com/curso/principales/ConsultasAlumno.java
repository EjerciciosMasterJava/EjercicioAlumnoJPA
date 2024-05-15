package com.curso.principales;

import java.util.List;
import java.util.Random;

import com.curso.dominio.Alumno;
import com.curso.service.AlumnoService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ConsultasAlumno {
	public static void main(String[] args) {
		
		// Crear la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("instituto");
		EntityManager em = emf.createEntityManager();
		
		// Instanciar el servicio para la gestion de alumnos
		AlumnoService service = new AlumnoService();
		
		// Mostrar todos los alumnos
		service.printAlumnos("Todos los alumnos:", service.getAlumnos(em));
		
		
		// Mostrar el alumno cuyo id = 1
		System.out.println("Alumno con id 1:");
		System.out.println(service.getAlumnoPorId(em, 1));
		
		
		// Mostrar los alumnos que se llamen Pepe
		service.printAlumnos("Alumnos nombre Pepe:", service.getAlumnosPorNombre(em, "Pepe"));
		
		
		// Mostrar los alumnos que se apelliden Garcia
		service.printAlumnos("Alumnos apellido Garcia:", service.getAlumnosPorApellido(em, "Garcia"));
	
		
		
	}

	
}
