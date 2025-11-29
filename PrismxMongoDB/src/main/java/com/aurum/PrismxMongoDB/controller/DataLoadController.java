package com.aurum.PrismxMongoDB.controller;

import com.aurum.PrismxMongoDB.model.Asistencia;
import com.aurum.PrismxMongoDB.model.Campania;
import com.aurum.PrismxMongoDB.model.Instituto;
import com.aurum.PrismxMongoDB.repository.AsistenciaRepository;
import com.aurum.PrismxMongoDB.repository.CampaniaRepository;
import com.aurum.PrismxMongoDB.repository.InstitutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/load")
public class DataLoadController {

    @Autowired
    private InstitutoRepository institutoRepo;

    @Autowired
    private CampaniaRepository campaniaRepo;

    @Autowired
    private AsistenciaRepository asistenciaRepo;

    // --- 1. CARGA DE INSTITUTOS ---
    // URL: http://localhost:8080/api/load/institutos
    @PostMapping("/institutos")
    public ResponseEntity<?> cargarInstitutos(@RequestBody List<Instituto> lista) {
        try {
            System.out.println("Recibiendo solicitud para cargar " + lista.size() + " institutos...");
            int guardados = 0;
            
            for (Instituto item : lista) {
                // Validación básica: Si no tiene ID o Nombre, saltar
                if (item.getIdLegado() == null && item.getNombre() == null) continue;

                // Buscar si ya existe por su ID Legado (ej: "11")
                if (item.getIdLegado() != null) {
                    Instituto existente = institutoRepo.findByIdLegado(item.getIdLegado());
                    if (existente != null) {
                        item.setId(existente.getId()); // Mantener el ID de MongoDB para actualizar
                    }
                }
                institutoRepo.save(item);
                guardados++;
            }
            return ResponseEntity.ok("Proceso Institutos finalizado. Guardados: " + guardados);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error cargando institutos: " + e.getMessage());
        }
    }

    // --- 2. CARGA DE CAMPAÑAS (ENTREVISTAS) ---
    // URL: http://localhost:8080/api/load/campanias
    @PostMapping("/campanias")
    public ResponseEntity<?> cargarCampanias(@RequestBody List<Campania> lista) {
        try {
            System.out.println("Recibiendo solicitud para cargar " + lista.size() + " campañas...");
            int guardados = 0;

            for (Campania item : lista) {
                if (item.getIdLegado() == null) continue;

                Campania existente = campaniaRepo.findByIdLegado(item.getIdLegado());
                if (existente != null) {
                    item.setId(existente.getId());
                }
                campaniaRepo.save(item);
                guardados++;
            }
            return ResponseEntity.ok("Proceso Campañas finalizado. Guardados: " + guardados);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error cargando campañas: " + e.getMessage());
        }
    }

    // --- 3. CARGA DE ASISTENCIAS ---
    // URL: http://localhost:8080/api/load/asistencias
    @PostMapping("/asistencias")
    public ResponseEntity<?> cargarAsistencias(@RequestBody List<Asistencia> lista) {
        try {
            System.out.println("Recibiendo solicitud para cargar " + lista.size() + " asistencias...");
            int guardados = 0;

            for (Asistencia item : lista) {
                if (item.getIdLegado() == null) continue;

                Asistencia existente = asistenciaRepo.findByIdLegado(item.getIdLegado());
                if (existente != null) {
                    item.setId(existente.getId());
                }
                asistenciaRepo.save(item);
                guardados++;
            }
            return ResponseEntity.ok("Proceso Asistencias finalizado. Guardados: " + guardados);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error cargando asistencias: " + e.getMessage());
        }
    }
    @GetMapping("/institutos")
    public List<Instituto> listarInstitutos() {
        return institutoRepo.findAll();
    }

    // URL: http://localhost:8080/api/load/campanias
    @GetMapping("/campanias")
    public List<Campania> listarCampanias() {
        return campaniaRepo.findAll();
    }

    // URL: http://localhost:8080/api/load/asistencias
    @GetMapping("/asistencias")
    public List<Asistencia> listarAsistencias() {
        return asistenciaRepo.findAll();
    }       
}