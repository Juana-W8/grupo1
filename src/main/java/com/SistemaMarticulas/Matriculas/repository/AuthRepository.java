package com.SistemaMarticulas.Matriculas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.SistemaMarticulas.Matriculas.model.Usuario;

public interface AuthRepository extends MongoRepository<Usuario, String>{
	@Query("{usuario:'?0',clave:'?1'}")
	public Optional<Usuario> login(String ususario, String clave);		
}
