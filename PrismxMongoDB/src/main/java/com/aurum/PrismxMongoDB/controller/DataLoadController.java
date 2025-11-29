package com.aurum.PrismxMongoDB.controller;

import com.aurum.PrismxMongoDB.model.*;
import com.aurum.PrismxMongoDB.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/load")
public class DataLoadController {

    @Autowired private InstitutoRepository institutoRepo;
    @Autowired private CampaniaRepository campaniaRepo;
    @Autowired private AsistenciaRepository asistenciaRepo;

    // --- CARGA DE INSTITUTOS ---
    @PostMapping("/institutos")
    public ResponseEntity<?> cargarInstitutos(@RequestBody List<Instituto> lista) {
        int count = 0;
        for (Instituto item : lista) {
            if (item.getIdLegado() != null) {
                Instituto existe = institutoRepo.findByIdLegado(item.getIdLegado());
                if (existe != null) {
                    item.setId(existe.getId()); // Mantiene el ID de Mongo para actualizar
                }
                institutoRepo.save(item);
                count++;
            }
        }
        return ResponseEntity.ok("Institutos procesados: " + count);
    }

    // --- CARGA DE CAMPAÑAS ---
    @PostMapping("/campanias")
    public ResponseEntity<?> cargarCampanias(@RequestBody List<Campania> lista) {
        int count = 0;
        for (Campania item : lista) {
            if (item.getIdLegado() != null) {
                Campania existe = campaniaRepo.findByIdLegado(item.getIdLegado());
                if (existe != null) {
                    item.setId(existe.getId());
                }
                campaniaRepo.save(item);
                count++;
            }
        }
        return ResponseEntity.ok("Campañas procesadas: " + count);
    }

    // --- CARGA DE ASISTENCIAS ---
    @PostMapping("/asistencias")
    public ResponseEntity<?> cargarAsistencias(@RequestBody List<Asistencia> lista) {
        int count = 0;
        for (Asistencia item : lista) {
            if (item.getIdLegado() != null) {
                Asistencia existe = asistenciaRepo.findByIdLegado(item.getIdLegado());
                if (existe != null) {
                    item.setId(existe.getId());
                }
                asistenciaRepo.save(item);
                count++;
            }
        }
        return ResponseEntity.ok("Asistencias procesadas: " + count);
    }
}