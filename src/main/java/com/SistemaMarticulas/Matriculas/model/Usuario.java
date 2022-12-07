package com.SistemaMarticulas.Matriculas.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class Usuario {

	@Id
	private String usuario;
	private String clave;
	
	public Usuario() {
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clave, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(clave, other.clave) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", clave=" + clave + "]";
	}
	
	
}
