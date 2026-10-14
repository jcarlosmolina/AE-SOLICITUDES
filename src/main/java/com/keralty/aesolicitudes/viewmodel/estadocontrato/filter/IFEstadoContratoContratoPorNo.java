package com.keralty.aesolicitudes.viewmodel.estadocontrato.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.global.EstadoContratoConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFEstadoContratoContratoPorNo {

    @JsonProperty("vnombre")
    private String vNombre;

    public IFEstadoContratoContratoPorNo() {
        // Default constructor
    }

    @JsonIgnore
    public String getVNombre() {
        return this.vNombre;
    }
    
    public void setVNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(EstadoContratoConstants.FILTER_NAME_IFESTADOCONTRATOCONTRATOPORNO);
        filterRequest.addFilterVariable(EstadoContratoConstants.VAR_NAME_IFESTADOCONTRATOCONTRATOPORNO_VNOMBRE, vNombre);
        return filterRequest;
    }
}
