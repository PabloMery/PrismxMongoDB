package com.aurum.PrismxMongoDB.repository;

import com.aurum.PrismxMongoDB.model.Asistencia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsistenciaRepository extends MongoRepository<Asistencia, String> {
    // Busca un registro de asistencia por su ID único
    Asistencia findByIdLegado(Long idLegado);

    // Opcional: Buscar todas las asistencias de un voluntario específico
    List<Asistencia> findByUsuarioId(Long usuarioId);
}