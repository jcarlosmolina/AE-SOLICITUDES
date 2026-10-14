package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCAMBIARESTANULADORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCAMBIARESTANULADOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCAMBIARESTANULADOpthisSolicitudInstance;

    @JsonProperty("ptobservaciones")
    private String solicitudTCAMBIARESTANULADOptObservaciones;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCAMBIARESTANULADOpthisSolicitud();
        checkSolicitudTCAMBIARESTANULADOptObservaciones();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCAMBIARESTANULADOpthisSolicitud() {
        return this.solicitudTCAMBIARESTANULADOpthisSolicitud;
    }
    
    public void setSolicitudTCAMBIARESTANULADOpthisSolicitud(SolicitudOid solicitudTCAMBIARESTANULADOpthisSolicitud) {
        this.solicitudTCAMBIARESTANULADOpthisSolicitud = solicitudTCAMBIARESTANULADOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCAMBIARESTANULADOpthisSolicitudInstance() {
        return this.solicitudTCAMBIARESTANULADOpthisSolicitudInstance;
    }
    
    public void setSolicitudTCAMBIARESTANULADOpthisSolicitudInstance(Solicitud solicitudTCAMBIARESTANULADOpthisSolicitud) {
        this.solicitudTCAMBIARESTANULADOpthisSolicitudInstance = solicitudTCAMBIARESTANULADOpthisSolicitud;
        this.solicitudTCAMBIARESTANULADOpthisSolicitud = solicitudTCAMBIARESTANULADOpthisSolicitud != null ? solicitudTCAMBIARESTANULADOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCAMBIARESTANULADOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTANULADOpthisSolicitudInstance() == null || this.getSolicitudTCAMBIARESTANULADOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTANULADO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTANULADO_SOLICITUDTCAMBIARESTANULADOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCAMBIARESTANULADO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTANULADO_SOLICITUDTCAMBIARESTANULADOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTCAMBIARESTANULADOptObservaciones() {
        return this.solicitudTCAMBIARESTANULADOptObservaciones;
    }
    
    public void setSolicitudTCAMBIARESTANULADOptObservaciones(String solicitudTCAMBIARESTANULADOptObservaciones) {
        this.solicitudTCAMBIARESTANULADOptObservaciones = solicitudTCAMBIARESTANULADOptObservaciones;
    }

    private void checkSolicitudTCAMBIARESTANULADOptObservaciones() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTANULADOptObservaciones() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTANULADO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTANULADO_SOLICITUDTCAMBIARESTANULADOPTOBSERVACIONES, SolicitudConstants.SERV_ALIAS_TCAMBIARESTANULADO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTANULADO_SOLICITUDTCAMBIARESTANULADOPTOBSERVACIONES);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
