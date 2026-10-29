package com.keralty.aesolicitudes.viewmodel.estadopersona.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.global.EstadoPersonaConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFEstadoPersonaCodigo {

    @JsonProperty("v_codigo")
    private Long vCodigo;

    public IFEstadoPersonaCodigo() {
        // Default constructor
    }

    @JsonIgnore
    public Long getVCodigo() {
        return this.vCodigo;
    }
    
    public void setVCodigo(Long vCodigo) {
        this.vCodigo = vCodigo;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(EstadoPersonaConstants.FILTER_NAME_IFESTADOPERSONACODIGO);
        filterRequest.addFilterVariable(EstadoPersonaConstants.VAR_NAME_IFESTADOPERSONACODIGO_VCODIGO, vCodigo);
        return filterRequest;
    }
}
