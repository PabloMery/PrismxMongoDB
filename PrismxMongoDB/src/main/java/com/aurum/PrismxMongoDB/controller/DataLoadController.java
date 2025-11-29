package com.aurum.PrismxMongoDB.controller;

import com.aurum.PrismxMongoDB.model.Area;
import com.aurum.PrismxMongoDB.model.Asistencia;
import com.aurum.PrismxMongoDB.model.Campania;
import com.aurum.PrismxMongoDB.model.Capacitacion;
import com.aurum.PrismxMongoDB.model.Instituto;
import com.aurum.PrismxMongoDB.model.Programa;
import com.aurum.PrismxMongoDB.repository.AreaRepository;
import com.aurum.PrismxMongoDB.repository.AsistenciaRepository;
import com.aurum.PrismxMongoDB.repository.CampaniaRepository;
import com.aurum.PrismxMongoDB.repository.CapacitacionRepository;
import com.aurum.PrismxMongoDB.repository.InstitutoRepository;
import com.aurum.PrismxMongoDB.repository.ProgramaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/load")
@CrossOrigin(origins = "*") // <--- ¡CRÍTICO! Esto permite que React lea los datos
public class DataLoadController {

    @Autowired private InstitutoRepository institutoRepo;
    @Autowired private CampaniaRepository campaniaRepo;
    @Autowired private AsistenciaRepository asistenciaRepo;

    // --- 1. CARGA DE INSTITUTOS ---
    @PostMapping("/institutos")
    public ResponseEntity<?> cargarInstitutos(@RequestBody List<Instituto> lista) {
        try {
            System.out.println("--> Recibidos " + lista.size() + " institutos.");
            if (!lista.isEmpty()) System.out.println("Ejemplo item 0: " + lista.get(0).toString()); // Ver qué llega

            int guardados = 0;
            for (Instituto item : lista) {
                // Validación robusta: Ignorar si ID es nulo, vacío o "NULL" texto
                if (item.getIdLegado() == null || item.getIdLegado().trim().isEmpty() || item.getIdLegado().equalsIgnoreCase("NULL")) {
                    System.out.println("Saltando registro sin ID válido: " + item.getNombre());
                    continue;
                }

                Instituto existente = institutoRepo.findByIdLegado(item.getIdLegado());
                if (existente != null) {
                    item.setId(existente.getId());
                }
                institutoRepo.save(item);
                guardados++;
            }
            return ResponseEntity.ok("Institutos procesados. Recibidos: " + lista.size() + ". Guardados: " + guardados);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    // --- 2. CARGA DE CAMPAÑAS ---
    @PostMapping("/campanias")
    public ResponseEntity<?> cargarCampanias(@RequestBody List<Campania> lista) {
        try {
            System.out.println("--> Recibidas " + lista.size() + " campañas.");
            int guardados = 0;
            for (Campania item : lista) {
                if (item.getIdLegado() == null) continue;
                Campania existente = campaniaRepo.findByIdLegado(item.getIdLegado());
                if (existente != null) item.setId(existente.getId());
                campaniaRepo.save(item);
                guardados++;
            }
            return ResponseEntity.ok("Campañas procesadas: " + guardados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    // --- 3. CARGA DE ASISTENCIAS ---
    @PostMapping("/asistencias")
    public ResponseEntity<?> cargarAsistencias(@RequestBody List<Asistencia> lista) {
        try {
            System.out.println("--> Recibidas " + lista.size() + " asistencias.");
            if (!lista.isEmpty()) System.out.println("Ejemplo item 0: " + lista.get(0).toString());

            int guardados = 0;
            for (Asistencia item : lista) {
                // Validación para Asistencia
                if (item.getIdLegado() == null) {
                    System.out.println("Saltando asistencia sin ID.");
                    continue;
                }
                
                Asistencia existente = asistenciaRepo.findByIdLegado(item.getIdLegado());
                if (existente != null) item.setId(existente.getId());
                
                asistenciaRepo.save(item);
                guardados++;
            }
            return ResponseEntity.ok("Asistencias procesadas: " + guardados);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    // --- GETTERS (Para el Dashboard) ---
    @GetMapping("/institutos")
    public List<Instituto> listarInstitutos() { return institutoRepo.findAll(); }

    @GetMapping("/campanias")
    public List<Campania> listarCampanias() { return campaniaRepo.findAll(); }

    @GetMapping("/asistencias")
    public List<Asistencia> listarAsistencias() { return asistenciaRepo.findAll(); }       

    // --- INYECCIONES (Agregar al principio de la clase junto a los otros Autowired) ---
    @Autowired private CapacitacionRepository capacitacionRepo;
    @Autowired private ProgramaRepository programaRepo;
    @Autowired private AreaRepository areaRepo;

    // --- 4. CARGA DE CAPACITACIONES ---
    @PostMapping("/capacitaciones")
    public ResponseEntity<?> cargarCapacitaciones(@RequestBody List<Capacitacion> lista) {
        try {
            int guardados = 0;
            for (Capacitacion item : lista) {
                if (item.getIdLegado() == null) continue;
                Capacitacion existente = capacitacionRepo.findByIdLegado(item.getIdLegado());
                if (existente != null) item.setId(existente.getId());
                capacitacionRepo.save(item);
                guardados++;
            }
            return ResponseEntity.ok("Capacitaciones procesadas: " + guardados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // --- 5. CARGA DE PROGRAMAS ---
    @PostMapping("/programas")
    public ResponseEntity<?> cargarProgramas(@RequestBody List<Programa> lista) {
        try {
            int guardados = 0;
            for (Programa item : lista) {
                if (item.getIdLegado() == null) continue;
                Programa existente = programaRepo.findByIdLegado(item.getIdLegado());
                if (existente != null) item.setId(existente.getId());
                programaRepo.save(item);
                guardados++;
            }
            return ResponseEntity.ok("Programas procesados: " + guardados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // --- 6. CARGA DE ÁREAS ---
    @PostMapping("/areas")
    public ResponseEntity<?> cargarAreas(@RequestBody List<Area> lista) {
        try {
            int guardados = 0;
            for (Area item : lista) {
                if (item.getIdLegado() == null) continue;
                Area existente = areaRepo.findByIdLegado(item.getIdLegado());
                if (existente != null) item.setId(existente.getId());
                areaRepo.save(item);
                guardados++;
            }
            return ResponseEntity.ok("Áreas procesadas: " + guardados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // --- GETTERS NUEVOS ---
    @GetMapping("/capacitaciones")
    public List<Capacitacion> listarCapacitaciones() { return capacitacionRepo.findAll(); }

    @GetMapping("/programas")
    public List<Programa> listarProgramas() { return programaRepo.findAll(); }

    @GetMapping("/areas")
    public List<Area> listarAreas() { return areaRepo.findAll(); }

}