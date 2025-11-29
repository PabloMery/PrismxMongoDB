package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Campania;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaniaRepository extends MongoRepository<Campania, String> {
    Campania findByIdLegado(Long idLegado);
}