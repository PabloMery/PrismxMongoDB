package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.NoArgsConstructor;

@NoArgsConstructor
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

    // CAMBIO: De Integer a String para soportar "NULL"
    @JsonAlias({"RegionId", "regionId"})
    private String regionId;
    
    @JsonAlias({"Activo", "activo"})
    private String activo;

    // --- GETTERS Y SETTERS ---
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

    public String getRegionId() { return regionId; }
    public void setRegionId(String regionId) { this.regionId = regionId; }

    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
}