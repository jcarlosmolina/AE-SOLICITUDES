package com.keralty.aesolicitudes.viewmodel.asesor.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.global.AsesorConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFAsesorPorUsuarioNoManual {

    @JsonProperty("vfusuario")
    private String vfUsuario;

    public IFAsesorPorUsuarioNoManual() {
        // Default constructor
    }

    @JsonIgnore
    public String getVfUsuario() {
        return this.vfUsuario;
    }
    
    public void setVfUsuario(String vfUsuario) {
        this.vfUsuario = vfUsuario;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(AsesorConstants.FILTER_NAME_IFASESORPORUSUARIONOMANUAL);
        filterRequest.addFilterVariable(AsesorConstants.VAR_NAME_IFASESORPORUSUARIONOMANUAL_VFUSUARIO, vfUsuario);
        return filterRequest;
    }
}
