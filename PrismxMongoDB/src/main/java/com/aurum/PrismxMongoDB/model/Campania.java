package com.aurum.PrismxMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Document(collection = "campanias")
public class Campania {

    @Id
    private String id;

    @JsonAlias({"Id", "id"})
    private Long idLegado; 

    // CAMBIO: String por seguridad
    @JsonAlias({"CampaniaId", "campaniaId"})
    private String campaniaId; 

    @JsonAlias({"Titulo", "titulo"})
    private String titulo;

    @JsonAlias({"Descripcion", "descripcion"})
    private String descripcion;

    @JsonAlias({"Inicio", "inicio"})
    private String inicio;

    @JsonAlias({"Fin", "fin"})
    private String fin;

    @JsonAlias({"Contacto", "contacto"})
    private String contacto;

    // CAMBIO: String para soportar "NULL"
    @JsonAlias({"PersonaId", "personaId"})
    private String personaId; 

    @JsonAlias({"DireccionInstituto", "direccion"})
    private String direccionInstituto;

    // CAMBIO: String por seguridad
    @JsonAlias({"Cupo", "cupo"})
    private String cupo;

    @JsonAlias({"Activo", "activo"})
    private String activo;

    // --- GETTERS Y SETTERS ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getIdLegado() { return idLegado; }
    public void setIdLegado(Long idLegado) { this.idLegado = idLegado; }

    public String getCampaniaId() { return campaniaId; }
    public void setCampaniaId(String campaniaId) { this.campaniaId = campaniaId; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getInicio() { return inicio; }
    public void setInicio(String inicio) { this.inicio = inicio; }

    public String getFin() { return fin; }
    public void setFin(String fin) { this.fin = fin; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getPersonaId() { return personaId; }
    public void setPersonaId(String personaId) { this.personaId = personaId; }

    public String getDireccionInstituto() { return direccionInstituto; }
    public void setDireccionInstituto(String direccionInstituto) { this.direccionInstituto = direccionInstituto; }

    public String getCupo() { return cupo; }
    public void setCupo(String cupo) { this.cupo = cupo; }

    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
}