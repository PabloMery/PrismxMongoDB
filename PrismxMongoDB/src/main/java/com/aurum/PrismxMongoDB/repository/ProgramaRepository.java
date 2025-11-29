package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Programa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaRepository extends MongoRepository<Programa, String> {
    Programa findByIdLegado(String idLegado);
}