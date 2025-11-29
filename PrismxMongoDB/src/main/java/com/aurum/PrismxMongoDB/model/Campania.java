package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
@Document(collection = "campanias")
public class Campania {
    @Id
    private String id;

    @JsonAlias({"Id"})
    private Long idLegado;

    @JsonAlias({"CampaniaId"})
    private Long campaniaId; // ID agrupador de la campaña

    @JsonAlias({"Titulo"})
    private String titulo;

    @JsonAlias({"Descripcion"})
    private String descripcion;

    @JsonAlias({"Inicio"})
    private String inicio; // Podrías cambiarlo a Date o LocalDateTime

    @JsonAlias({"Fin"})
    private String fin;

    @JsonAlias({"Contacto"})
    private String contacto;

    @JsonAlias({"DireccionInstituto"})
    private String direccionInstituto;

    @JsonAlias({"Cupo"})
    private Integer cupo;
}