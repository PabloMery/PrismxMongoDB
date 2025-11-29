package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "asistencias")
public class Asistencia {
    @Id
    private String id;

    @JsonAlias({"Id"})
    private Long idLegado;

    @JsonAlias({"CapacitacionId"})
    private Long capacitacionId;

    @JsonAlias({"UsuarioId"})
    private Long usuarioId; // Relación con Voluntario (idLegado)

    @JsonAlias({"Asistencia"})
    private String asistencia; // "1" o "0"

    @JsonAlias({"FechaCreacion"})
    private String fechaCreacion;
}