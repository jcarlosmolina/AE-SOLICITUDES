package com.keralty.aesolicitudes.viewmodel.usuario.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFUsuarioSinCuesMed {

    @JsonProperty("vo_solicitud")
    private SolicitudOid voSolicitud;

    public IFUsuarioSinCuesMed() {
        // Default constructor
    }

    @JsonIgnore
    public SolicitudOid getVoSolicitud() {
        return this.voSolicitud;
    }
    
    public void setVoSolicitud(SolicitudOid voSolicitud) {
        this.voSolicitud = voSolicitud;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(UsuarioConstants.FILTER_NAME_IFUSUARIOSINCUESMED);
        filterRequest.addFilterVariable(UsuarioConstants.VAR_NAME_IFUSUARIOSINCUESMED_VOSOLICITUD, voSolicitud);
        return filterRequest;
    }
}
