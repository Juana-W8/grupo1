package com.SistemaMarticulas.Matriculas.service;

import java.util.List;
import java.util.Optional;

import com.SistemaMarticulas.Matriculas.model.Estudiante;



public interface EstudianteService {
	public List<Estudiante> getListaEstudiante();
	public Optional<Estudiante> getEstudianteById (Long id);
	public List<Estudiante> getEstudianteByCurso (String curso);
	public Estudiante crearEstudiante(Estudiante estudiante);
	public Estudiante actualizarEstudiante (Estudiante estudiante);
	public String eliminarEstudiante (Long id);
}
