package com.SistemaMarticulas.Matriculas.service;

import java.util.List;
import java.util.Optional;

import com.SistemaMarticulas.Matriculas.model.Usuario;


public interface UsuarioService {
	public List<Usuario> consultarUsuario();
	public Optional<Usuario> consultarUsuarioByNombre (String usuario);
	public Usuario crearUsuario(Usuario usuario);
	public Usuario actualizarUsuario (Usuario usuario);
	public String eliminarUsuario (String usuario);
}
