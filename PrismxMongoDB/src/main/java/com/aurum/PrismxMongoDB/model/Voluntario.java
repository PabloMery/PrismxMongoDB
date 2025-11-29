package com.aurum.PrismxMongoDB.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "voluntarios_360") // Nombre de la colección en Atlas
public class Voluntario {

    @Id
    private String id; // ID interno de Mongo

    // --- 1. DATOS PERSONALES (Usuario.csv) ---
    private Long idLegado;           // Columna "Id" del Excel
    private String nombres;          // Columna "Nombres"
    private String apellidoPaterno;  // Columna "ApellidoP"
    private String apellidoMaterno;  // Columna "ApellidoM"
    private String fechaNacimiento;  // Columna "FechaNacimiento"
    private String region;           // "RegionPostulante"
    private String comuna;           // "ComunaPostulante"
    private Integer institutoId;     // Para filtrar por sede

    // --- 2. PERFIL (EncuestaCaracterizacion.csv) ---
    private String rangoEdad;        // "Rango de edad"
    private String nivelFormacion;   // "Nivel de formación actual"
    private String carrera;          // "En caso de estudiar..."
    private String ocupacion;        // "Actividad Ocupacional"

    // --- 3. EVALUACIÓN (EvaluacionGrupal.csv) ---
    // Blue Prism debe decidir si aprueba o no y enviar true/false
    private Boolean aprobado;        
    private String observacion;      // Comentarios del evaluador
    
    // --- 4. DATA ENRIQUECIDA (IA) ---
    private String resumenPerfil;    // Para que la IA escriba un resumen
    private String sugerenciaRol;    // Rol sugerido por IA (Líder, Apoyo, etc.)
}