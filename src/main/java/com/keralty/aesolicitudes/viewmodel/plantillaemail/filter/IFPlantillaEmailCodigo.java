package com.keralty.aesolicitudes.viewmodel.plantillaemail.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.global.PlantillaEmailConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFPlantillaEmailCodigo {

    @JsonProperty("v_codigo")
    private Long vCodigo;

    public IFPlantillaEmailCodigo() {
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
        filterRequest.setName(PlantillaEmailConstants.FILTER_NAME_IFPLANTILLAEMAILCODIGO);
        filterRequest.addFilterVariable(PlantillaEmailConstants.VAR_NAME_IFPLANTILLAEMAILCODIGO_VCODIGO, vCodigo);
        return filterRequest;
    }
}
