package com.SistemaMarticulas.Matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaMarticulas.Matriculas.model.Usuario;
import com.SistemaMarticulas.Matriculas.service.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping
	public ResponseEntity<?> consultaUsuarios(){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarUsuario());
	}
	
	@GetMapping("/{usuario}")
	public ResponseEntity<?> consultaUsuariosById(@PathVariable String usuario){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarUsuarioByNombre(usuario));
	}
	
	@PostMapping
	public ResponseEntity<?> crearUsuarios(@RequestBody Usuario usuario){
		Usuario newUsuario = servicio.crearUsuario(usuario);
		if(newUsuario == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(newUsuario);
		}
		
	}
	
	@PutMapping
	public ResponseEntity<?> actualizarUsuarios(@RequestBody Usuario usuario){
		Usuario updateUsuario = servicio.crearUsuario(usuario);
		if(updateUsuario == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateUsuario);
		}
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> eliminarUsuarios(@PathVariable String usuario){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminarUsuario(usuario));
	}
	
}
