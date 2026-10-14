package com.keralty.aesolicitudes.viewmodel.tiposucursalc.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.TipoSucursalC;
public class AutoDS {

    @JsonProperty("codigo")
    private Long autoDSCodigo;

    @JsonProperty("descripcion")
    private String autoDSDescripcion;

    public AutoDS() {
    
    }

    public AutoDS(TipoSucursalC instance) {
        if (instance != null) {
            this.autoDSCodigo = instance.getTipoSucursalCCodigo();
            this.autoDSDescripcion = instance.getTipoSucursalCDescripcion();
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
    public String getAutoDSDescripcion() {
        return this.autoDSDescripcion;
    }
    
    public void setAutoDSDescripcion(String autoDSDescripcion) {
        this.autoDSDescripcion = autoDSDescripcion;
    }
}
