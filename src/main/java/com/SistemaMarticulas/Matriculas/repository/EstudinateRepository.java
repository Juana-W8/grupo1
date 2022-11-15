package com.SistemaMarticulas.Matriculas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.SistemaMarticulas.Matriculas.model.Estudiante;


@Repository
public interface EstudinateRepository extends MongoRepository<Estudiante, Long>{
	@Query("{curso: ?0}")
	public List<Estudiante> FindByCruso(String curso);
}
