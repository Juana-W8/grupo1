package com.SistemaMarticulas.Matriculas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaMarticulas.Matriculas.model.Usuario;
import com.SistemaMarticulas.Matriculas.repository.AuthRepository;
import com.SistemaMarticulas.Matriculas.util.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthRepository repositorio;
	
	@Override
	public String autenticar(Usuario usuario) {
		Optional<Usuario> consulta=repositorio.login(usuario.getUsuario(), usuario.getClave());
		if(consulta.isPresent()) {
			if(usuario.getUsuario().equals("prueba")) {
				return JwtUtil.crearToken(usuario.getUsuario(), "admin");
			}
			return JwtUtil.crearToken(usuario.getUsuario(), "usuario");
		}
		return null;
	}

}
