package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Asistencia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends MongoRepository<Asistencia, String> {
    
    // CORREGIDO: Cambiado de Long a String
    Asistencia findByIdLegado(String idLegado);
}