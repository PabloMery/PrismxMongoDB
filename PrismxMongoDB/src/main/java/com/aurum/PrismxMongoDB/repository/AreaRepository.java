package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Area;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends MongoRepository<Area, String> {
    Area findByIdLegado(String idLegado);
}