package com.keralty.aesolicitudes.viewmodel.estadocontrato.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
public class ICEstadoContrato {

    @JsonProperty("descripcion")
    private String iCEstadoContratoDescripcion;

    public ICEstadoContrato() {
    
    }

    public ICEstadoContrato(EstadoContrato instance) {
        if (instance != null) {
            this.iCEstadoContratoDescripcion = instance.getEstadoContratoDescripcion();
        }
    }

    @JsonIgnore
    public String getICEstadoContratoDescripcion() {
        return this.iCEstadoContratoDescripcion;
    }
    
    public void setICEstadoContratoDescripcion(String iCEstadoContratoDescripcion) {
        this.iCEstadoContratoDescripcion = iCEstadoContratoDescripcion;
    }
}
