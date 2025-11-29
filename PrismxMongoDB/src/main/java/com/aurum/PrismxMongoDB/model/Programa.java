package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "programas")
public class Programa {

    @Id
    private String id;

    @JsonAlias({"Id", "id"})
    private String idLegado;

    @JsonAlias({"ProgramaVoluntario", "nombre"})
    private String nombre;

    @JsonAlias({"AreaId", "areaId"})
    private String areaId;

    @JsonAlias({"InstitutoId", "institutoId"})
    private String institutoId;
    
    @JsonAlias({"ResponsableId", "responsableId"})
    private String responsableId;

    @JsonAlias({"Activo", "activo"})
    private String activo;
}