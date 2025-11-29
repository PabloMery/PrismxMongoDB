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
    private Long idLegado; // ID de la entrevista específica

    @JsonAlias({"CampaniaId", "campaniaId"})
    private Long campaniaId; // ID del tipo de campaña

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

    @JsonAlias({"PersonaId", "personaId"})
    private Long personaId; // Link con el Voluntario

    @JsonAlias({"DireccionInstituto", "direccion"})
    private String direccionInstituto;

    @JsonAlias({"Cupo", "cupo"})
    private Integer cupo;

    @JsonAlias({"Activo", "activo"})
    private String activo;

    // --- GETTERS Y SETTERS MANUALES ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getIdLegado() { return idLegado; }
    public void setIdLegado(Long idLegado) { this.idLegado = idLegado; }

    public Long getCampaniaId() { return campaniaId; }
    public void setCampaniaId(Long campaniaId) { this.campaniaId = campaniaId; }

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

    public Long getPersonaId() { return personaId; }
    public void setPersonaId(Long personaId) { this.personaId = personaId; }

    public String getDireccionInstituto() { return direccionInstituto; }
    public void setDireccionInstituto(String direccionInstituto) { this.direccionInstituto = direccionInstituto; }

    public Integer getCupo() { return cupo; }
    public void setCupo(Integer cupo) { this.cupo = cupo; }

    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
}