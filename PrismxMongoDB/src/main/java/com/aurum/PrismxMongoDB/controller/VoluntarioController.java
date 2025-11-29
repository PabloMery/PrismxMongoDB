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

    // --- NUEVO MÉTODO: Crear o actualizar un solo voluntario ---
    // URL: http://localhost:8080/api/voluntarios (acepta UN SOLO objeto JSON)
    @PostMapping
    public ResponseEntity<Voluntario> crearOActualizarVoluntario(@RequestBody Voluntario entrante) {
        if (entrante.getIdLegado() == null) {
            // Si el ID Legado es nulo, no podemos procesarlo (error 400 Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // Buscamos si el voluntario ya existe en la BD
        Voluntario existente = repositorio.findByIdLegado(entrante.getIdLegado());

        if (existente != null) {
            // --- UPDATE INTELIGENTE (Solo campos nuevos) ---
            if (entrante.getNombres() != null) existente.setNombres(entrante.getNombres());
            if (entrante.getApellidoPaterno() != null) existente.setApellidoPaterno(entrante.getApellidoPaterno());
            if (entrante.getRangoEdad() != null) existente.setRangoEdad(entrante.getRangoEdad());
            if (entrante.getNivelFormacion() != null) existente.setNivelFormacion(entrante.getNivelFormacion());
            if (entrante.getCarrera() != null) existente.setCarrera(entrante.getCarrera());
            if (entrante.getOcupacion() != null) existente.setOcupacion(entrante.getOcupacion());
            
            // Lógica simple para Resumen (simulando IA)
            if (entrante.getOcupacion() != null && existente.getResumenPerfil() == null) {
                existente.setResumenPerfil("Perfil ingresado: " + entrante.getOcupacion());
            }

            Voluntario actualizado = repositorio.save(existente);
            return ResponseEntity.ok(actualizado); // Retorna 200 OK
        } else {
            // --- CREAR NUEVO ---
            Voluntario nuevo = repositorio.save(entrante);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo); // Retorna 201 Created
        }
    }

    // --- CARGA MASIVA (BATCH) ---
    // URL: http://localhost:8080/api/voluntarios/batch
    @PostMapping("/batch")
    public ResponseEntity<?> guardarLote(@RequestBody List<Voluntario> listaVoluntarios) {
        try {
            int actualizados = 0;
            int nuevos = 0;

            for (Voluntario entrante : listaVoluntarios) {
                if (entrante.getIdLegado() == null) continue; // Si no tiene ID, lo saltamos

                // Buscamos si el voluntario ya existe en la BD
                Voluntario existente = repositorio.findByIdLegado(entrante.getIdLegado());

                if (existente != null) {
                    // --- UPDATE INTELIGENTE (Solo campos nuevos) ---
                    if (entrante.getNombres() != null) existente.setNombres(entrante.getNombres());
                    if (entrante.getApellidoPaterno() != null) existente.setApellidoPaterno(entrante.getApellidoPaterno());
                    if (entrante.getRangoEdad() != null) existente.setRangoEdad(entrante.getRangoEdad());
                    if (entrante.getNivelFormacion() != null) existente.setNivelFormacion(entrante.getNivelFormacion());
                    if (entrante.getCarrera() != null) existente.setCarrera(entrante.getCarrera());
                    if (entrante.getOcupacion() != null) existente.setOcupacion(entrante.getOcupacion());
                    
                    // Lógica simple para Resumen (simulando IA)
                    if (entrante.getOcupacion() != null && existente.getResumenPerfil() == null) {
                        existente.setResumenPerfil("Perfil ingresado: " + entrante.getOcupacion());
                    }

                    repositorio.save(existente);
                    actualizados++;
                } else {
                    // --- CREAR NUEVO ---
                    repositorio.save(entrante);
                    nuevos++;
                }
            }
            return ResponseEntity.ok("Proceso terminado. Actualizados: " + actualizados + ". Nuevos: " + nuevos);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en carga masiva: " + e.getMessage());
        }
    }

    // Listar todos (para verificar)
    @GetMapping
    public List<Voluntario> listarTodos() {
        return repositorio.findAll();
    }
}