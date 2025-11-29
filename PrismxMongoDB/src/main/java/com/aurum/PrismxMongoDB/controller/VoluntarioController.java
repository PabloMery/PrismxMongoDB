package com.aurum.PrismxMongoDB.controller;

import com.aurum.PrismxMongoDB.model.Voluntario;
import com.aurum.PrismxMongoDB.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository repositorio;

    // Blue Prism llamará a este LINK: http://localhost:8080/api/voluntarios
    // Método: POST
    @PostMapping
    public Voluntario guardar(@RequestBody Voluntario voluntario) {
        // 1. Buscamos si ya existe por su ID del Excel
        Voluntario existente = repositorio.findByIdLegado(voluntario.getIdLegado());
        
        if (existente != null) {
            // Si existe, actualizamos su ID de Mongo para sobrescribirlo y no duplicar
            voluntario.setId(existente.getId());
        }
        
        // 2. Guardamos (Save funciona como "Upsert")
        return repositorio.save(voluntario);
    }

    // Para ver los datos desde tu navegador
    @GetMapping
    public List<Voluntario> listarTodos() {
        return repositorio.findAll();
    }
}