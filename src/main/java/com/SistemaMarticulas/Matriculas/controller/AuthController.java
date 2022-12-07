package com.SistemaMarticulas.Matriculas.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaMarticulas.Matriculas.model.Usuario;
import com.SistemaMarticulas.Matriculas.service.AuthService;


@RestController
@RequestMapping("/api/token")
public class AuthController {
	
	@Autowired
	private AuthService servicio;
	
	@PostMapping
	public ResponseEntity<?> autenticarUsuario(@RequestBody Usuario usuario){
		String resultado=servicio.autenticar(usuario);
		if (resultado == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(new JSONObject().put("token",resultado).toString());
		}
	}
}
