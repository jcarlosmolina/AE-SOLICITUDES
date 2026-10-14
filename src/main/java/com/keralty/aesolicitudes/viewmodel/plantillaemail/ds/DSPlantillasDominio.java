package com.keralty.aesolicitudes.viewmodel.plantillaemail.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
public class DSPlantillasDominio {

    @JsonProperty("codigo")
    private Long dSPlantillasDominioCodigo;

    @JsonProperty("descripcion")
    private String dSPlantillasDominioDescripcion;

    @JsonProperty("asunto")
    private String dSPlantillasDominioAsunto;

    @JsonProperty("emailconf")
    private String dSPlantillasDominioEmailConf;

    public DSPlantillasDominio() {
    
    }

    public DSPlantillasDominio(PlantillaEmail instance) {
        if (instance != null) {
            this.dSPlantillasDominioCodigo = instance.getPlantillaEmailCodigo();
            this.dSPlantillasDominioDescripcion = instance.getPlantillaEmailDescripcion();
            this.dSPlantillasDominioAsunto = instance.getPlantillaEmailAsunto();
            this.dSPlantillasDominioEmailConf = instance.getPlantillaEmailEmailConf();
        }
    }

    @JsonIgnore
    public Long getDSPlantillasDominioCodigo() {
        return this.dSPlantillasDominioCodigo;
    }
    
    public void setDSPlantillasDominioCodigo(Long dSPlantillasDominioCodigo) {
        this.dSPlantillasDominioCodigo = dSPlantillasDominioCodigo;
    }

    @JsonIgnore
    public String getDSPlantillasDominioDescripcion() {
        return this.dSPlantillasDominioDescripcion;
    }
    
    public void setDSPlantillasDominioDescripcion(String dSPlantillasDominioDescripcion) {
        this.dSPlantillasDominioDescripcion = dSPlantillasDominioDescripcion;
    }

    @JsonIgnore
    public String getDSPlantillasDominioAsunto() {
        return this.dSPlantillasDominioAsunto;
    }
    
    public void setDSPlantillasDominioAsunto(String dSPlantillasDominioAsunto) {
        this.dSPlantillasDominioAsunto = dSPlantillasDominioAsunto;
    }

    @JsonIgnore
    public String getDSPlantillasDominioEmailConf() {
        return this.dSPlantillasDominioEmailConf;
    }
    
    public void setDSPlantillasDominioEmailConf(String dSPlantillasDominioEmailConf) {
        this.dSPlantillasDominioEmailConf = dSPlantillasDominioEmailConf;
    }
}
