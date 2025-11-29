package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "campanias")
public class Campania {

    @Id
    private String id;

    // "Id": "45007" (Identificador único de la fila)
    @JsonAlias({"Id", "id"})
    private String idLegado; 

    // "CampaniaId": "36" (Identificador de agrupación)
    @JsonAlias({"CampaniaId", "campaniaId"})
    private String campaniaId; 

    // "FechaCreacion": "2020-01-27 09:04:58.743" (NUEVO)
    @JsonAlias({"FechaCreacion", "fechaCreacion"})
    private String fechaCreacion;

    @JsonAlias({"Titulo", "titulo"})
    private String titulo;

    @JsonAlias({"Descripcion", "descripcion"})
    private String descripcion;

    @JsonAlias({"Inicio", "inicio"})
    private String inicio;

    @JsonAlias({"Fin", "fin"})
    private String fin;

    @JsonAlias({"Contacto", "contacto"})
    private String contacto;

    // "Tipo": "0" (NUEVO)
    @JsonAlias({"Tipo", "tipo"})
    private String tipo;

    // "PersonaId": "72733" (NUEVO)
    @JsonAlias({"PersonaId", "personaId"})
    private String personaId;

    @JsonAlias({"DireccionInstituto", "direccion"})
    private String direccionInstituto;

    @JsonAlias({"Cupo", "cupo"})
    private String cupo;

    @JsonAlias({"Activo", "activo"})
    private String activo;
}