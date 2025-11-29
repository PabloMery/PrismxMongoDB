package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
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

    // "Id": "427"
    @JsonAlias({"Id", "id", "IdUsuario", "idLegado"}) 
    private String idLegado;

    // "Nombre": "Susana Veronica"
    @JsonAlias({"Nombre", "nombre", "Nombres", "nombres"})
    private String nombres;

    // "SegundoNombre": ""
    @JsonAlias({"SegundoNombre", "segundoNombre"})
    private String segundoNombre;

    // "ApellidoP": "Torres"
    @JsonAlias({"ApellidoP", "apellidoPaterno"})
    private String apellidoPaterno;

    // "ApellidoM": "Yañez"
    @JsonAlias({"ApellidoM", "apellidoMaterno"})
    private String apellidoMaterno;

    // "Activo": "0"
    @JsonAlias({"Activo", "activo"})
    private String activo;

    // "Vigencia": "0" (NUEVO)
    @JsonAlias({"Vigencia", "vigencia"})
    private String vigencia;

    // --- Otros campos que tenías antes (mantenlos por si cargas otros archivos) ---
    @JsonAlias({"FechaNacimiento", "fechaNacimiento"}) private String fechaNacimiento;
    @JsonAlias({"Sexo", "sexo"}) private String sexo;
    @JsonAlias({"Nacionalidad", "nacionalidad"}) private String nacionalidad;
    @JsonAlias({"RegionPostulante", "region"}) private String region;
    @JsonAlias({"ComunaPostulante", "comuna"}) private String comuna;
    @JsonAlias({"Ocupacion", "ocupacion"}) private String ocupacion;
    @JsonAlias({"DetalleOcupacion", "detalleOcupacion"}) private String detalleOcupacion;
    @JsonAlias({"Rango de edad. ", "rangoEdad"}) private String rangoEdad;
    @JsonAlias({"Nivel de formación actual ", "nivelFormacion"}) private String nivelFormacion;
    @JsonAlias({"En caso de estudiar, nombrar carrera (CON MAYUSCULA, SIN ACENTO) ", "carrera"}) private String carrera;
    
    // Extras IA
    private String resumenPerfil;
    private String sugerenciaRol;

    // Método auxiliar para concatenar nombre completo
    public String getNombreCompleto() {
        return (nombres != null ? nombres : "") + " " + 
               (apellidoPaterno != null ? apellidoPaterno : "") + " " + 
               (apellidoMaterno != null ? apellidoMaterno : "");
    }
}