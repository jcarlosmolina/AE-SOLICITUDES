package com.keralty.aesolicitudes.viewmodel.estadocivil.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.global.EstadoCivilConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFEstadoCivilCodigo {

    @JsonProperty("v_codigo")
    private Long vCodigo;

    public IFEstadoCivilCodigo() {
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
        filterRequest.setName(EstadoCivilConstants.FILTER_NAME_IFESTADOCIVILCODIGO);
        filterRequest.addFilterVariable(EstadoCivilConstants.VAR_NAME_IFESTADOCIVILCODIGO_VCODIGO, vCodigo);
        return filterRequest;
    }
}
