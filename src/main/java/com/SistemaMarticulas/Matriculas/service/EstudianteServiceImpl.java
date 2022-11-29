package com.SistemaMarticulas.Matriculas.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaMarticulas.Matriculas.model.Estudiante;
import com.SistemaMarticulas.Matriculas.repository.EstudinateRepository;




@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudinateRepository repository;
	
	@Override
	public List<Estudiante> getListaEstudiante() {
		return repository.findAll();
	}

	@Override
	public Optional<Estudiante> getEstudianteById(Long id) {

		return repository.findById(id);
	}


	
	@Override
	public Estudiante crearEstudiante(Estudiante estudiante) {
		if (estudiante == null) {
			return null;
		}
		if (estudiante.getIdentificacion() == null) {
			return null;
		}
		Optional<Estudiante> estudianteConsulta= repository.findById(estudiante.getId());
		if (estudianteConsulta.isPresent()) {
			return estudianteConsulta.get();
		}
		return repository.insert(estudiante);

	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return repository.save(estudiante);
	}

	@Override
	public String eliminarEstudiante(Long id) {
		if (id == null) {
			return "El id es un campo obligatorio";
		}
		Optional<Estudiante> estudiante = repository.findById(id);
		if (estudiante.isPresent()) {
			repository.delete(estudiante.get());
			;
			return "El estudiante ha sido eleminado";
		}
		return "El estudiante no existe";

	}



}
