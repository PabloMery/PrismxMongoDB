package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Voluntario;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends MongoRepository<Voluntario, String> {
    
    // CORREGIDO: Cambiado de Long a String
    Voluntario findByIdLegado(String idLegado);

    // Buscar por Región
    List<Voluntario> findByRegion(String region);

    // Buscar por Rol Sugerido
    List<Voluntario> findBySugerenciaRol(String sugerenciaRol);
}