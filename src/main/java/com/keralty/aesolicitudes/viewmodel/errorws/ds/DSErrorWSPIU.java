package com.keralty.aesolicitudes.viewmodel.errorws.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.ErrorWS;
public class DSErrorWSPIU {

    @JsonProperty("descripcion")
    private String dSErrorWSPIUDescripcion;

    public DSErrorWSPIU() {
    
    }

    public DSErrorWSPIU(ErrorWS instance) {
        if (instance != null) {
            this.dSErrorWSPIUDescripcion = instance.getErrorWSDescripcion();
        }
    }

    @JsonIgnore
    public String getDSErrorWSPIUDescripcion() {
        return this.dSErrorWSPIUDescripcion;
    }
    
    public void setDSErrorWSPIUDescripcion(String dSErrorWSPIUDescripcion) {
        this.dSErrorWSPIUDescripcion = dSErrorWSPIUDescripcion;
    }
}
