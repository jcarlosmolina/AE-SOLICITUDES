package com.keralty.aesolicitudes.viewmodel.estadocontrato.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.global.EstadoContratoConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFEstadoContratoContrato {

    @JsonProperty("v_codigo")
    private Long vCodigo;

    public IFEstadoContratoContrato() {
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
        filterRequest.setName(EstadoContratoConstants.FILTER_NAME_IFESTADOCONTRATOCONTRATO);
        filterRequest.addFilterVariable(EstadoContratoConstants.VAR_NAME_IFESTADOCONTRATOCONTRATO_VCODIGO, vCodigo);
        return filterRequest;
    }
}
