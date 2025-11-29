package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "institutos")
public class Instituto {

    @Id
    private String id;

    @JsonAlias({"Id", "id"})
    private Long idLegado;

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
    private Integer regionId;
    
    @JsonAlias({"Activo", "activo"})
    private String activo;

    // --- GETTERS Y SETTERS MANUALES (Obligatorios si falla Lombok) ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getIdLegado() { return idLegado; }
    public void setIdLegado(Long idLegado) { this.idLegado = idLegado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Integer getRegionId() { return regionId; }
    public void setRegionId(Integer regionId) { this.regionId = regionId; }

    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
}