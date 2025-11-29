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
    private String id; // ID interno de MongoDB

    // --- IDENTIFICACIÓN ---
    @JsonAlias({"Id", "idLegado", "UsuarioId"}) 
    private Long idLegado;

    // --- DATOS PERSONALES ---
    @JsonAlias({"Nombres", "nombres"})
    private String nombres;

    @JsonAlias({"ApellidoP", "apellidoPaterno"})
    private String apellidoPaterno;

    @JsonAlias({"ApellidoM", "apellidoMaterno"})
    private String apellidoMaterno;

    @JsonAlias({"FechaNacimiento", "fechaNacimiento"})
    private String fechaNacimiento;

    @JsonAlias({"Sexo", "sexo"})
    private String sexo;

    @JsonAlias({"Nacionalidad", "nacionalidad"})
    private String nacionalidad;

    @JsonAlias({"Enfermedad", "enfermedad"})
    private String enfermedad;
    
    @JsonAlias({"Salud", "salud"})
    private String salud; // Nuevo del JSON

    // --- UBICACIÓN ---
    @JsonAlias({"RegionPostulante", "region"})
    private String region;

    @JsonAlias({"ComunaPostulante", "comuna"})
    private String comuna;
    
    @JsonAlias({"InstitutoId", "institutoId"})
    private Integer institutoId;

    // --- PERFIL Y OCUPACIÓN ---
    @JsonAlias({"Ocupacion", "ocupacion"})
    private String ocupacion;

    @JsonAlias({"DetalleOcupacion", "detalleOcupacion"})
    private String detalleOcupacion;

    // --- ESTADO Y GESTIÓN ---
    @JsonAlias({"Estado", "estado"})
    private String estado; // Ej: "0", "1", "8"

    @JsonAlias({"Activo", "activo"})
    private String activo; // Ej: "1", "0"

    // Campos antiguos que quizás quieras mantener o descartar si no vienen en el nuevo JSON
    private String rangoEdad;
    private String nivelFormacion;
    private String carrera;
    private String resumenPerfil;
}