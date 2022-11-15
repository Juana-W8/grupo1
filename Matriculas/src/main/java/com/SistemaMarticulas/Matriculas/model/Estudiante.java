package com.SistemaMarticulas.Matriculas.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Estudiante {
	@Id
	private Long id;
	private String identificacion;
	private String nombre;
	private String apellido;
	private String curso;
	private String estadoMatricula;
	private String montoMatricula;
	private String estadoPago;
	
	public Estudiante() {
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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

	public String getEstadoMatricula() {
		return estadoMatricula;
	}

	public void setEstadoMatricula(String estadoMatricula) {
		this.estadoMatricula = estadoMatricula;
	}

	public String getMontoMatricula() {
		return montoMatricula;
	}

	public void setMontoMatricula(String montoMatricula) {
		this.montoMatricula = montoMatricula;
	}

	public String getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, curso, estadoMatricula, estadoPago, id, identificacion, montoMatricula, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(curso, other.curso)
				&& Objects.equals(estadoMatricula, other.estadoMatricula)
				&& Objects.equals(estadoPago, other.estadoPago) && id == other.id
				&& Objects.equals(identificacion, other.identificacion)
				&& Objects.equals(montoMatricula, other.montoMatricula) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", identificacion=" + identificacion + ", nombre=" + nombre + ", apellido="
				+ apellido + ", curso=" + curso + ", estadoMatricula=" + estadoMatricula + ", montoMatricula="
				+ montoMatricula + ", estadoPago=" + estadoPago + "]";
	}
	

	
	
	
}
