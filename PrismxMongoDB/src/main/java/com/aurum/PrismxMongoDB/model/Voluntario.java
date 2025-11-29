package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "voluntarios_360")
public class Voluntario {

    @Id
    private String id; // ID interno de MongoDB (Auto-generado)

    // --- IDENTIFICACIÓN ÚNICA (La clave para unir todo) ---
    // Acepta "Id" (Usuario.csv), "IdUsuario" (Encuesta.csv) o "UsuarioId" (Inscripcion.csv)
    @JsonAlias({"Id", "IdUsuario", "UsuarioId", "idLegado"}) 
    private Long idLegado;

    // --- CAPA 1: DATOS PERSONALES (Usuario.csv) ---
    @JsonAlias({"Nombres", "nombres"})
    private String nombres;

    @JsonAlias({"ApellidoP", "apellidoPaterno"})
    private String apellidoPaterno;

    @JsonAlias({"ApellidoM", "apellidoMaterno"})
    private String apellidoMaterno;

    @JsonAlias({"FechaNacimiento", "fechaNacimiento"})
    private String fechaNacimiento;

    @JsonAlias({"RegionPostulante", "Instituto", "region"}) // "Instituto" a veces trae la región
    private String region;

    @JsonAlias({"ComunaPostulante", "comuna"})
    private String comuna;
    
    @JsonAlias({"InstitutoId", "institutoId"})
    private Integer institutoId;

    @JsonAlias({"Enfermedad", "enfermedad"})
    private String enfermedad;

    // --- CAPA 2: PERFIL (EncuestaCaracterizacion.csv) ---
    @JsonAlias({"Rango de edad. ", "rangoEdad"}) 
    private String rangoEdad;

    @JsonAlias({"Nivel de formación actual ", "nivelFormacion"})
    private String nivelFormacion;

    @JsonAlias({"En caso de estudiar, nombrar carrera (CON MAYUSCULA, SIN ACENTO) ", "carrera"})
    private String carrera;

    @JsonAlias({"Actividad Ocupacional ", "Ocupacion", "ocupacion"})
    private String ocupacion;
    
    @JsonAlias({"¿Cómo te enteraste del Voluntariado Teletón?  ", "fuenteReclutamiento"})
    private String fuenteReclutamiento;

    // --- CAPA 3: EVALUACIÓN (EvaluacionGrupal.csv) ---
    // Blue Prism debe enviar esto cruzado con Inscripción para tener el UsuarioId
    @JsonAlias({"EstadoEvaluacionGrupal", "aprobado"}) 
    private String estadoEvaluacion; 

    @JsonAlias({"Observacion", "observacion"}) 
    private String observacion;
    
    // --- EXTRAS (Para IA) ---
    private String resumenPerfil;
    private String sugerenciaRol;
}