package com.aurum.PrismxMongoDB.controller;

import com.aurum.PrismxMongoDB.model.Voluntario;
import com.aurum.PrismxMongoDB.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository repositorio;

    // MEJORA 1: Lógica inteligente de Guardado (Upsert)
    @PostMapping
    public ResponseEntity<Voluntario> guardar(@RequestBody Voluntario voluntarioEntrante) {
        try {
            // Buscamos si ya existe alguien con ese ID de Excel (idLegado)
            Voluntario existente = repositorio.findByIdLegado(voluntarioEntrante.getIdLegado());

            if (existente != null) {
                // SI EXISTE: Mantenemos su ID interno de MongoDB para no crear uno nuevo
                voluntarioEntrante.setId(existente.getId());
                // Al guardar, Spring detecta el ID y hace un UPDATE en vez de INSERT
                Voluntario actualizado = repositorio.save(voluntarioEntrante);
                return new ResponseEntity<>(actualizado, HttpStatus.OK);
            } else {
                // NO EXISTE: Lo creamos desde cero
                Voluntario nuevo = repositorio.save(voluntarioEntrante);
                return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // MEJORA 2: Endpoint para el Dashboard (Listar todos)
    @GetMapping
    public List<Voluntario> listarTodos() {
        return repositorio.findAll();
    }
    
    // MEJORA 3: Endpoint para filtrar (Ej: Dame todos los de la región "Metropolitana")
    // Url de uso: http://localhost:8080/api/voluntarios/region/Metropolitana
    @GetMapping("/region/{region}")
    public List<Voluntario> buscarPorRegion(@PathVariable String region) {
        return repositorio.findByRegion(region);
    }
}