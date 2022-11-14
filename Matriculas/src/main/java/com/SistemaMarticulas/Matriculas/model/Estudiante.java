package com.SistemaMarticulas.Matriculas.model;

import java.util.Objects;

public class Estudiante {
	
	private Long identificacion;
	private String nombre;
	private String apellido;
	private Long curso;
	private String estadoMatricula;
	private float montoMatricula;
	private String estadoPago;
	
	public Estudiante() {
		
	}
	
	public Estudiante(Long identificacion, String nombre, String apellido, Long curso, String estadoMatricula,
			float montoMatricula, String estadoPago) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.curso = curso;
		this.estadoMatricula = estadoMatricula;
		this.montoMatricula = montoMatricula;
		this.estadoPago = estadoPago;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
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

	public Long getCurso() {
		return curso;
	}

	public void setCurso(Long curso) {
		this.curso = curso;
	}

	public String getEstadoMatricula() {
		return estadoMatricula;
	}

	public void setEstadoMatricula(String estadoMatricula) {
		this.estadoMatricula = estadoMatricula;
	}

	public float getMontoMatricula() {
		return montoMatricula;
	}

	public void setMontoMatricula(float montoMatricula) {
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
		return Objects.hash(apellido, curso, estadoMatricula, estadoPago, identificacion, montoMatricula, nombre);
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
				&& Objects.equals(estadoPago, other.estadoPago) && Objects.equals(identificacion, other.identificacion)
				&& Float.floatToIntBits(montoMatricula) == Float.floatToIntBits(other.montoMatricula)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Estudiante [identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", curso=" + curso + ", estadoMatricula=" + estadoMatricula + ", montoMatricula=" + montoMatricula
				+ ", estadoPago=" + estadoPago + "]";
	}
	
	
}
