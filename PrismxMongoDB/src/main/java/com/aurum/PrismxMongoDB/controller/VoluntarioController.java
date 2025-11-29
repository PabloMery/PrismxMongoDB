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
@CrossOrigin(origins = "*") // Permite que cualquier frontend (React/Angular/PowerBI) consuma la API
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository repositorio;

    // --- 1. INGESTIÓN DE DATOS (Usado por tu RPA Blue Prism) ---
    
    @PostMapping
    public ResponseEntity<Voluntario> guardarInteligente(@RequestBody Voluntario voluntarioEntrante) {
        try {
            // Lógica de "Upsert": Verifica si existe por el ID del Excel (Legacy)
            Voluntario existente = repositorio.findByIdLegado(voluntarioEntrante.getIdLegado());

            if (existente != null) {
                // Si existe, actualizamos los datos manteniendo el ID de Mongo
                voluntarioEntrante.setId(existente.getId());
                Voluntario actualizado = repositorio.save(voluntarioEntrante);
                return new ResponseEntity<>(actualizado, HttpStatus.OK);
            } else {
                // Si es nuevo, lo creamos
                Voluntario nuevo = repositorio.save(voluntarioEntrante);
                return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // --- 2. ENDPOINTS BÁSICOS ---

    @GetMapping
    public List<Voluntario> listarTodos() {
        return repositorio.findAll();
    }

    @GetMapping("/region/{region}")
    public List<Voluntario> buscarPorRegion(@PathVariable String region) {
        return repositorio.findByRegion(region);
    }

    // --- 3. ENDPOINTS DE INTELIGENCIA (Para el Dashboard 360°) ---

    // CASO DE USO 1: Reclutamiento Inteligente
    // "Muéstrame los candidatos con empatía superior a 5 para el rol de Acompañamiento"
    // URL: GET /api/voluntarios/sugerencias/empatia/5
    @GetMapping("/sugerencias/empatia/{puntajeMinimo}")
    public List<Voluntario> buscarTalentosPorEmpatia(@PathVariable Integer puntajeMinimo) {
        return repositorio.findCandidatosPorEmpatia(puntajeMinimo);
    }

    // CASO DE USO 2: Alerta Temprana de Deserción
    // "Alértame de todos los voluntarios con más del 70% (0.7) de probabilidad de irse"
    // URL: GET /api/voluntarios/riesgo/0.7
    @GetMapping("/riesgo/{probabilidad}")
    public List<Voluntario> buscarRiesgoDesercion(@PathVariable Double probabilidad) {
        return repositorio.findVoluntariosEnRiesgo(probabilidad);
    }

    // CASO DE USO 3: Filtrar por Rol Sugerido por la IA
    // "Dame todos los que la IA sugirió como 'Líder de Cuadrilla'"
    // URL: GET /api/voluntarios/rol/Lider
    @GetMapping("/rol/{rolSugerido}")
    public List<Voluntario> buscarPorRolSugerido(@PathVariable String rolSugerido) {
        return repositorio.findByRolSugerido(rolSugerido);
    }
}