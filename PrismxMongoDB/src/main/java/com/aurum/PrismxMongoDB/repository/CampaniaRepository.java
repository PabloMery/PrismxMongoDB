package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Campania;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaniaRepository extends MongoRepository<Campania, String> {
    // Busca una campaña/entrevista específica por su ID único del JSON
    Campania findByIdLegado(Long idLegado);

    // Opcional: Buscar todas las entrevistas de una campaña específica (CampaniaId)
    List<Campania> findByCampaniaId(Long campaniaId);
}