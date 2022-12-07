package com.SistemaMarticulas.Matriculas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.SistemaMarticulas.Matriculas.model.Usuario;
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
