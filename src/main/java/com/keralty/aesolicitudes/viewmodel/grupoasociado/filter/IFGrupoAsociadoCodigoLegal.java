package com.keralty.aesolicitudes.viewmodel.grupoasociado.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.global.GrupoAsociadoConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFGrupoAsociadoCodigoLegal {

    @JsonProperty("v_codigolegal")
    private String vCodigoLegal;

    public IFGrupoAsociadoCodigoLegal() {
        // Default constructor
    }

    @JsonIgnore
    public String getVCodigoLegal() {
        return this.vCodigoLegal;
    }
    
    public void setVCodigoLegal(String vCodigoLegal) {
        this.vCodigoLegal = vCodigoLegal;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(GrupoAsociadoConstants.FILTER_NAME_IFGRUPOASOCIADOCODIGOLEGAL);
        filterRequest.addFilterVariable(GrupoAsociadoConstants.VAR_NAME_IFGRUPOASOCIADOCODIGOLEGAL_VCODIGOLEGAL, vCodigoLegal);
        return filterRequest;
    }
}
