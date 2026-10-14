package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class AsignarNumContratoRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudasignarNumContratopthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudasignarNumContratopthisSolicitudInstance;

    @JsonProperty("p_numcontrato")
    private String solicitudasignarNumContratopNumContrato;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudasignarNumContratopthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudasignarNumContratopthisSolicitud() {
        return this.solicitudasignarNumContratopthisSolicitud;
    }
    
    public void setSolicitudasignarNumContratopthisSolicitud(SolicitudOid solicitudasignarNumContratopthisSolicitud) {
        this.solicitudasignarNumContratopthisSolicitud = solicitudasignarNumContratopthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudasignarNumContratopthisSolicitudInstance() {
        return this.solicitudasignarNumContratopthisSolicitudInstance;
    }
    
    public void setSolicitudasignarNumContratopthisSolicitudInstance(Solicitud solicitudasignarNumContratopthisSolicitud) {
        this.solicitudasignarNumContratopthisSolicitudInstance = solicitudasignarNumContratopthisSolicitud;
        this.solicitudasignarNumContratopthisSolicitud = solicitudasignarNumContratopthisSolicitud != null ? solicitudasignarNumContratopthisSolicitud.getOid() : null;
    }

    private void checkSolicitudasignarNumContratopthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudasignarNumContratopthisSolicitudInstance() == null || this.getSolicitudasignarNumContratopthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ASIGNARNUMCONTRATO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ASIGNARNUMCONTRATO_SOLICITUDASIGNARNUMCONTRATOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_ASIGNARNUMCONTRATO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ASIGNARNUMCONTRATO_SOLICITUDASIGNARNUMCONTRATOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudasignarNumContratopNumContrato() {
        return this.solicitudasignarNumContratopNumContrato;
    }
    
    public void setSolicitudasignarNumContratopNumContrato(String solicitudasignarNumContratopNumContrato) {
        this.solicitudasignarNumContratopNumContrato = solicitudasignarNumContratopNumContrato;
    }
}
