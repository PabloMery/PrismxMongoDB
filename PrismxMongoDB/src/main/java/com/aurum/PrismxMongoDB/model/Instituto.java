package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "institutos")
public class Instituto {

    @Id
    private String id;

    // --- CAMBIO CLAVE: De Long a String ---
    @JsonAlias({"Id", "id", "idInstituto"})
    private String idLegado;

    @JsonAlias({"Nombre", "nombre"})
    private String nombre;

    @JsonAlias({"Codigo", "codigo"})
    private String codigo;

    @JsonAlias({"Descripcion", "descripcion"})
    private String descripcion;

    @JsonAlias({"DireccionInstituto", "direccion"})
    private String direccion;

    @JsonAlias({"TelefonoInstituto", "telefono"})
    private String telefono;

    @JsonAlias({"RegionId", "regionId"})
    private String regionId;
    
    @JsonAlias({"Activo", "activo"})
    private String activo;
}