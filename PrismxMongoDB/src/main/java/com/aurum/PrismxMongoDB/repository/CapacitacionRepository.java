package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Capacitacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitacionRepository extends MongoRepository<Capacitacion, String> {
    Capacitacion findByIdLegado(String idLegado);
}