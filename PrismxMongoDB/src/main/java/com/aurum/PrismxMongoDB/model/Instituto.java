package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
@Document(collection = "institutos")
public class Instituto {
    @Id
    private String id;

    @JsonAlias({"Id"})
    private Long idLegado;

    @JsonAlias({"Nombre"})
    private String nombre;

    @JsonAlias({"Codigo"})
    private String codigo;

    @JsonAlias({"Descripcion"})
    private String descripcion;

    @JsonAlias({"DireccionInstituto"})
    private String direccion;

    @JsonAlias({"TelefonoInstituto"})
    private String telefono;

    @JsonAlias({"RegionId"})
    private Integer regionId;
    
    @JsonAlias({"Activo"})
    private String activo;
}