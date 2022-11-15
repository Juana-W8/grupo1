package com.SistemaMarticulas.Matriculas.controller;

import java.util.Optional;

import org.json.JSONObject;
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

import com.SistemaMarticulas.Matriculas.model.Estudiante;
import com.SistemaMarticulas.Matriculas.service.EstudianteService;





@RequestMapping("/api/estudiantes")
@RestController
public class EstudianteController {
	@Autowired
	private EstudianteService servicio;
	
	@GetMapping
	public ResponseEntity<?> getListaEstudiante (){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.getListaEstudiante());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEstudianteById (@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.getEstudianteById(id));
	}
	
	@GetMapping("/{curso}")
	public ResponseEntity<?> getEstudianteByCurso (@PathVariable String curso){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.getEstudianteByCurso(curso));
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Estudiante estudiante){
		Estudiante resultado = servicio.crearEstudiante(estudiante);
		if (resultado == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar al estudiante");
		}
		return ResponseEntity.status(HttpStatus.OK).body(resultado);
		//return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearEstudiante(estudiante));
		

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPersona (@PathVariable Long id){
		Optional<Estudiante> respuesta = servicio.getEstudianteById(id);
		if (! respuesta.isPresent()) {
			JSONObject mensajeError = new JSONObject();
			mensajeError.put("mensaje", "El id no fue encontrado: "+ id);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeError);
		}else {
			servicio.eliminarEstudiante(id);
			JSONObject mensajeOk = new  JSONObject();
			mensajeOk.put("mensaje", "Eliminación completa");
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarPersona (@PathVariable Long id, @RequestBody Estudiante estudiante){
		Optional<Estudiante> respuesta = servicio.getEstudianteById(id);
		if (! respuesta.isPresent()) {
			JSONObject mensajeError = new JSONObject();
			mensajeError.put("mensaje", "El id no fue encontrado: "+ id);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeError);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarEstudiante(estudiante));
		}
	}
}
