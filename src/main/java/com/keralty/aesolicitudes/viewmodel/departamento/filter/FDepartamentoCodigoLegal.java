package com.keralty.aesolicitudes.viewmodel.departamento.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.global.DepartamentoConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class FDepartamentoCodigoLegal {

    @JsonProperty("vfcodlegal")
    private String vfCodLegal;

    public FDepartamentoCodigoLegal() {
        // Default constructor
    }

    @JsonIgnore
    public String getVfCodLegal() {
        return this.vfCodLegal;
    }
    
    public void setVfCodLegal(String vfCodLegal) {
        this.vfCodLegal = vfCodLegal;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(DepartamentoConstants.FILTER_NAME_FDEPARTAMENTOCODIGOLEGAL);
        filterRequest.addFilterVariable(DepartamentoConstants.VAR_NAME_FDEPARTAMENTOCODIGOLEGAL_VFCODLEGAL, vfCodLegal);
        return filterRequest;
    }
}
