package com.keralty.aesolicitudes.viewmodel.tipoinstitucionc.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.TipoInstitucionC;
public class AutoDS {

    @JsonProperty("codigo")
    private Long autoDSCodigo;

    @JsonProperty("nombre")
    private String autoDSNombre;

    public AutoDS() {
    
    }

    public AutoDS(TipoInstitucionC instance) {
        if (instance != null) {
            this.autoDSCodigo = instance.getTipoInstitucionCCodigo();
            this.autoDSNombre = instance.getTipoInstitucionCNombre();
        }
    }

    @JsonIgnore
    public Long getAutoDSCodigo() {
        return this.autoDSCodigo;
    }
    
    public void setAutoDSCodigo(Long autoDSCodigo) {
        this.autoDSCodigo = autoDSCodigo;
    }

    @JsonIgnore
    public String getAutoDSNombre() {
        return this.autoDSNombre;
    }
    
    public void setAutoDSNombre(String autoDSNombre) {
        this.autoDSNombre = autoDSNombre;
    }
}
