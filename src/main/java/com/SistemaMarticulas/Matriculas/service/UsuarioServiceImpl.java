package com.SistemaMarticulas.Matriculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaMarticulas.Matriculas.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private com.SistemaMarticulas.Matriculas.repository.UsuarioRepository repository;
	
	@Override
	public List<Usuario> consultarUsuario() {
		return repository.findAll();
	}

	@Override
	public Optional<Usuario> consultarUsuarioByNombre(String usuario) {
		if(usuario == null) {
			return Optional.empty();
		}else {
			return repository.findById(usuario);
		}
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		if(usuario == null) {
			return null;
		}
		Optional<Usuario> usuarioConsulta = repository.findById(usuario.getUsuario());
		if(usuarioConsulta.isPresent()) {
			return usuarioConsulta.get();
		}else {
			return repository.insert(usuario);
		}
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		if(usuario == null) {
			return null;
		}
		Optional<Usuario> usuarioConsulta = repository.findById(usuario.getUsuario());
		if(usuarioConsulta.isPresent()) {
			return repository.save(usuario);
		}else {
			return repository.insert(usuario);
		}
	}

	@Override
	public String eliminarUsuario(String usuario) {
		if(usuario == null) {
			return "El usuarion no existe, no se puede eliminar";
		}
		Optional<Usuario> usuarioConsulta = repository.findById(usuario);
		if(usuarioConsulta.isPresent()) {
			repository.deleteById(usuario);
			return "El usuario se elimino exitosamente";
		}else {
			return "El usuarion no existe, no se puede eliminar";
		}

	}
}
