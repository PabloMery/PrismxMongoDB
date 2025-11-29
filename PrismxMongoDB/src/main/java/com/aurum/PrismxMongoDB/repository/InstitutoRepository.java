package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Instituto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutoRepository extends MongoRepository<Instituto, String> {
    // Busca un instituto por el ID que viene en el JSON ("Id": "11")
    Instituto findByIdLegado(Long idLegado);
}