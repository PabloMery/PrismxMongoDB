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

    // "Id": "62"
    @JsonAlias({"Id", "id"})
    private String idLegado;

    // "CapacitacionId": "118"
    @JsonAlias({"CapacitacionId", "capacitacionId"})
    private String capacitacionId;

    // "UsuarioId": "2646" (Relación con Voluntario)
    @JsonAlias({"UsuarioId", "usuarioId"})
    private String usuarioId; 

    // "Asistencia": "1"
    @JsonAlias({"Asistencia", "asistencia"})
    private String asistencia; 

    // "FechaCreacion": "16-06-2020"
    @JsonAlias({"FechaCreacion", "fechaCreacion"})
    private String fechaCreacion;

    // "Activo": "1" (NUEVO)
    @JsonAlias({"Activo", "activo"})
    private String activo;

    // "Reserva": "NULL" o "0" (NUEVO)
    @JsonAlias({"Reserva", "reserva"})
    private String reserva;
}