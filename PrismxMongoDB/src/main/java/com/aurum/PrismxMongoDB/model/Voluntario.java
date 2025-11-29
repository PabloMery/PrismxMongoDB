package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonAlias({"Id", "IdUsuario", "UsuarioId", "idLegado"}) 
    private Long idLegado;

    // --- DATOS PERSONALES ---
    
    // AQUÍ ESTABA EL ERROR: Agregamos "Nombre" (singular) a la lista de alias
    @JsonAlias({"Nombres", "nombres", "Nombre", "nombre"})
    private String nombres;

    // Campo auxiliar por si el JSON trae el segundo nombre separado
    @JsonAlias({"SegundoNombre", "segundoNombre"})
    private String segundoNombre;

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
    private String salud;

    // --- UBICACIÓN ---
    @JsonAlias({"RegionPostulante", "Instituto", "region"}) 
    private String region;

    @JsonAlias({"ComunaPostulante", "comuna"})
    private String comuna;
    
    @JsonAlias({"InstitutoId", "institutoId"})
    private Integer institutoId;

    // --- PERFIL ---
    @JsonAlias({"Ocupacion", "ocupacion"})
    private String ocupacion;

    @JsonAlias({"DetalleOcupacion", "detalleOcupacion"})
    private String detalleOcupacion;

    @JsonAlias({"Rango de edad. ", "rangoEdad"}) 
    private String rangoEdad;

    @JsonAlias({"Nivel de formación actual ", "nivelFormacion"})
    private String nivelFormacion;

    @JsonAlias({"En caso de estudiar, nombrar carrera (CON MAYUSCULA, SIN ACENTO) ", "carrera"})
    private String carrera;

    @JsonAlias({"¿Cómo te enteraste del Voluntariado Teletón?  ", "fuenteReclutamiento"})
    private String fuenteReclutamiento;

    // --- EVALUACIÓN Y ESTADO ---
    @JsonAlias({"Estado", "estado"})
    private String estado;

    @JsonAlias({"EstadoEvaluacionGrupal", "aprobado", "estadoEvaluacion"}) 
    private String estadoEvaluacion; 

    @JsonAlias({"Observacion", "observacion"}) 
    private String observacion;

    @JsonAlias({"Activo", "activo"})
    private String activo;

    // --- EXTRAS IA ---
    private String resumenPerfil;
    private String sugerenciaRol;

    public String getNombre() {
        String nombreCompleto = (nombres != null ? nombres : "");
        if (apellidoPaterno != null) {
            nombreCompleto += " " + apellidoPaterno;
        }
        return nombreCompleto.trim();
    }
    
}