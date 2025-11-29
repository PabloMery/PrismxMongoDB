package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Voluntario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends MongoRepository<Voluntario, String> {
    Voluntario findByIdLegado(Long idLegado);
}