package com.keralty.aesolicitudes.viewmodel.pais.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.global.PaisConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFPaisCodigo {

    @JsonProperty("v_codigo")
    private String vCodigo;

    public IFPaisCodigo() {
        // Default constructor
    }

    @JsonIgnore
    public String getVCodigo() {
        return this.vCodigo;
    }
    
    public void setVCodigo(String vCodigo) {
        this.vCodigo = vCodigo;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(PaisConstants.FILTER_NAME_IFPAISCODIGO);
        filterRequest.addFilterVariable(PaisConstants.VAR_NAME_IFPAISCODIGO_VCODIGO, vCodigo);
        return filterRequest;
    }
}
