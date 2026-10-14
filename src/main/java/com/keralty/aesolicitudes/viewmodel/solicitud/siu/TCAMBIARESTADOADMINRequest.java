package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCAMBIARESTADOADMINRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCAMBIARESTADOADMINpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCAMBIARESTADOADMINpthisSolicitudInstance;

    @JsonProperty("pt_peestado")
    private Long solicitudTCAMBIARESTADOADMINptpeEstado;

    @JsonProperty("ptobservaciones")
    private String solicitudTCAMBIARESTADOADMINptObservaciones;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCAMBIARESTADOADMINpthisSolicitud();
        checkSolicitudTCAMBIARESTADOADMINptpeEstado();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCAMBIARESTADOADMINpthisSolicitud() {
        return this.solicitudTCAMBIARESTADOADMINpthisSolicitud;
    }
    
    public void setSolicitudTCAMBIARESTADOADMINpthisSolicitud(SolicitudOid solicitudTCAMBIARESTADOADMINpthisSolicitud) {
        this.solicitudTCAMBIARESTADOADMINpthisSolicitud = solicitudTCAMBIARESTADOADMINpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCAMBIARESTADOADMINpthisSolicitudInstance() {
        return this.solicitudTCAMBIARESTADOADMINpthisSolicitudInstance;
    }
    
    public void setSolicitudTCAMBIARESTADOADMINpthisSolicitudInstance(Solicitud solicitudTCAMBIARESTADOADMINpthisSolicitud) {
        this.solicitudTCAMBIARESTADOADMINpthisSolicitudInstance = solicitudTCAMBIARESTADOADMINpthisSolicitud;
        this.solicitudTCAMBIARESTADOADMINpthisSolicitud = solicitudTCAMBIARESTADOADMINpthisSolicitud != null ? solicitudTCAMBIARESTADOADMINpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCAMBIARESTADOADMINpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTADOADMINpthisSolicitudInstance() == null || this.getSolicitudTCAMBIARESTADOADMINpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTADOADMIN, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTADOADMIN_SOLICITUDTCAMBIARESTADOADMINPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCAMBIARESTADOADMIN, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTADOADMIN_SOLICITUDTCAMBIARESTADOADMINPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Long getSolicitudTCAMBIARESTADOADMINptpeEstado() {
        return this.solicitudTCAMBIARESTADOADMINptpeEstado;
    }
    
    public void setSolicitudTCAMBIARESTADOADMINptpeEstado(Long solicitudTCAMBIARESTADOADMINptpeEstado) {
        this.solicitudTCAMBIARESTADOADMINptpeEstado = solicitudTCAMBIARESTADOADMINptpeEstado;
    }

    private void checkSolicitudTCAMBIARESTADOADMINptpeEstado() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTADOADMINptpeEstado() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTADOADMIN, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTADOADMIN_SOLICITUDTCAMBIARESTADOADMINPTPEESTADO, SolicitudConstants.SERV_ALIAS_TCAMBIARESTADOADMIN, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTADOADMIN_SOLICITUDTCAMBIARESTADOADMINPTPEESTADO);
        }
    }

    @JsonIgnore
    public String getSolicitudTCAMBIARESTADOADMINptObservaciones() {
        return this.solicitudTCAMBIARESTADOADMINptObservaciones;
    }
    
    public void setSolicitudTCAMBIARESTADOADMINptObservaciones(String solicitudTCAMBIARESTADOADMINptObservaciones) {
        this.solicitudTCAMBIARESTADOADMINptObservaciones = solicitudTCAMBIARESTADOADMINptObservaciones;
    }
}
