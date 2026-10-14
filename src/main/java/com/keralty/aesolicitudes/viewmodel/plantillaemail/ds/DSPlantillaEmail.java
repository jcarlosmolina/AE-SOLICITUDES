package com.keralty.aesolicitudes.viewmodel.plantillaemail.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
public class DSPlantillaEmail {

    @JsonProperty("idplantilla")
    private Long dSPlantillaEmailIdPlantilla;

    @JsonProperty("codigo")
    private Long dSPlantillaEmailCodigo;

    @JsonProperty("descripcion")
    private String dSPlantillaEmailDescripcion;

    @JsonProperty("asunto")
    private String dSPlantillaEmailAsunto;

    @JsonProperty("emailconf")
    private String dSPlantillaEmailEmailConf;

    @JsonProperty("textomensaje")
    private String dSPlantillaEmailTextoMensaje;

    public DSPlantillaEmail() {
    
    }

    public DSPlantillaEmail(PlantillaEmail instance) {
        if (instance != null) {
            this.dSPlantillaEmailIdPlantilla = instance.getPlantillaEmailIdPlantilla();
            this.dSPlantillaEmailCodigo = instance.getPlantillaEmailCodigo();
            this.dSPlantillaEmailDescripcion = instance.getPlantillaEmailDescripcion();
            this.dSPlantillaEmailAsunto = instance.getPlantillaEmailAsunto();
            this.dSPlantillaEmailEmailConf = instance.getPlantillaEmailEmailConf();
            this.dSPlantillaEmailTextoMensaje = instance.getPlantillaEmailTextoMensaje();
        }
    }

    @JsonIgnore
    public Long getDSPlantillaEmailIdPlantilla() {
        return this.dSPlantillaEmailIdPlantilla;
    }
    
    public void setDSPlantillaEmailIdPlantilla(Long dSPlantillaEmailIdPlantilla) {
        this.dSPlantillaEmailIdPlantilla = dSPlantillaEmailIdPlantilla;
    }

    @JsonIgnore
    public Long getDSPlantillaEmailCodigo() {
        return this.dSPlantillaEmailCodigo;
    }
    
    public void setDSPlantillaEmailCodigo(Long dSPlantillaEmailCodigo) {
        this.dSPlantillaEmailCodigo = dSPlantillaEmailCodigo;
    }

    @JsonIgnore
    public String getDSPlantillaEmailDescripcion() {
        return this.dSPlantillaEmailDescripcion;
    }
    
    public void setDSPlantillaEmailDescripcion(String dSPlantillaEmailDescripcion) {
        this.dSPlantillaEmailDescripcion = dSPlantillaEmailDescripcion;
    }

    @JsonIgnore
    public String getDSPlantillaEmailAsunto() {
        return this.dSPlantillaEmailAsunto;
    }
    
    public void setDSPlantillaEmailAsunto(String dSPlantillaEmailAsunto) {
        this.dSPlantillaEmailAsunto = dSPlantillaEmailAsunto;
    }

    @JsonIgnore
    public String getDSPlantillaEmailEmailConf() {
        return this.dSPlantillaEmailEmailConf;
    }
    
    public void setDSPlantillaEmailEmailConf(String dSPlantillaEmailEmailConf) {
        this.dSPlantillaEmailEmailConf = dSPlantillaEmailEmailConf;
    }

    @JsonIgnore
    public String getDSPlantillaEmailTextoMensaje() {
        return this.dSPlantillaEmailTextoMensaje;
    }
    
    public void setDSPlantillaEmailTextoMensaje(String dSPlantillaEmailTextoMensaje) {
        this.dSPlantillaEmailTextoMensaje = dSPlantillaEmailTextoMensaje;
    }
}
