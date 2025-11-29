package com.aurum.PrismxMongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "voluntarios_360")
public class Voluntario {

    @Id
    private String id; // ID interno de Mongo

    // --- 1. IDENTIDAD (Fuente: Voluntariado.Usuario.csv) ---
    private Long idLegado;           // Columna "Id"
    private String nombres;          // "Nombres"
    private String apellidoPaterno;  // "ApellidoP"
    private String apellidoMaterno;  // "ApellidoM"
    private String fechaNacimiento;  // "FechaNacimiento"
    private String genero;           // "Sexo" (Nuevo)
    private String nacionalidad;     // "Nacionalidad" (Nuevo)
    private String region;           // "RegionPostulante"
    private String comuna;           // "ComunaPostulante"
    private Integer institutoId;     // "InstitutoId"

    // --- 2. PERFIL SOCIODEMOGRÁFICO (Fuente: EncuestaCaracterizacion.csv) ---
    private String rangoEdad;            // "Rango de edad"
    private String nivelFormacion;       // "Nivel de formación actual"
    private String carrera;              // "En caso de estudiar..."
    private String ocupacion;            // "Actividad Ocupacional"
    private String tiempoPermanencia;    // "Tiempo de permanencia..." (Clave para fidelización)
    private String experienciaPrevia;    // "¿Has participado en otro Voluntariado?"

    // --- 3. EVALUACIÓN DE COMPETENCIAS (Fuente: EvaluacionGrupal.csv) ---
    // Estos valores numéricos son vitales para que la IA recomiende roles
    private Integer scoreTrabajoEquipo;  // Promedio de columnas "TrabajoEnEquipo"
    private Integer scoreProactividad;   // Promedio de columnas "Proactividad"
    private Integer scoreEmpatia;        // Promedio de columnas "Empatia"
    
    private Boolean aprobado;            // "EstadoEvaluacionGrupal"
    private String observacionEvaluador; // "Observacion"

    // --- 4. DATA ENRIQUECIDA (OUTPUT DE TU IA/RPA) ---
    // Estos campos los llenarás con la IA después de procesar la data anterior
    private String resumenPerfil;            // Resumen narrativo generado por IA
    private String rolSugerido;              // Ej: "Líder de Cuadrilla", "Apoyo Logístico"
    private Double probabilidadDesercion;    // % de riesgo de que abandone (0.0 a 1.0)
    private String segmentoFidelizacion;     // Ej: "Héroe", "Comprometido", "Esporádico"
}