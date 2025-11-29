package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "areas")
public class Area {

    @Id
    private String id;

    @JsonAlias({"Id", "id"})
    private String idLegado;

    @JsonAlias({"NombreCategoria", "nombre"})
    private String nombre;

    @JsonAlias({"AreaTrabajoId", "areaTrabajoId"})
    private String areaTrabajoId;

    @JsonAlias({"InstitutoId", "institutoId"})
    private String institutoId;

    @JsonAlias({"Activo", "activo"})
    private String activo;
}