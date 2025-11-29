package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "capacitaciones")
public class Capacitacion {

    @Id
    private String id;

    @JsonAlias({"Id", "id"})
    private String idLegado;

    @JsonAlias({"NombreCapacitacion", "nombre"})
    private String nombre;

    @JsonAlias({"FechaInicio", "fechaInicio"})
    private String fechaInicio;

    @JsonAlias({"FechaFin", "fechaFin"})
    private String fechaFin;

    @JsonAlias({"InstitutoId", "institutoId"})
    private String institutoId;

    @JsonAlias({"Activo", "activo"})
    private String activo;
    
    @JsonAlias({"Estado", "estado"})
    private String estado;
}