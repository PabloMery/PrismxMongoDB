package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Voluntario;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends MongoRepository<Voluntario, String> {
    Voluntario findByIdLegado(Long idLegado);

    List<Voluntario> findByRegion(String region);
}