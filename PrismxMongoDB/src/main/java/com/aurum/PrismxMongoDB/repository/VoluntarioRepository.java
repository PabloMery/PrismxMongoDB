package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Voluntario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VoluntarioRepository extends MongoRepository<Voluntario, String> {
    
    // Búsqueda base para el RPA
    Voluntario findByIdLegado(Long idLegado);

    // Filtros básicos
    List<Voluntario> findByRegion(String region);
    List<Voluntario> findByRolSugerido(String rolSugerido);

    // ¡Filtro Avanzado para IA! 
    // Busca voluntarios aprobados con alta empatía (mayor a un valor X)
    @Query("{ 'aprobado': true, 'scoreEmpatia': { $gte: ?0 } }")
    List<Voluntario> findCandidatosPorEmpatia(Integer puntajeMinimo);

    // Busca voluntarios en riesgo de deserción (mayor a X probabilidad)
    @Query("{ 'probabilidadDesercion': { $gt: ?0 } }")
    List<Voluntario> findVoluntariosEnRiesgo(Double probabilidad);
}