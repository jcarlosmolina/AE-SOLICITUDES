package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCAMBIARESTADOERRORRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCAMBIARESTADOERRORpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCAMBIARESTADOERRORpthisSolicitudInstance;

    @JsonProperty("ptobservaciones")
    private String solicitudTCAMBIARESTADOERRORptObservaciones;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCAMBIARESTADOERRORpthisSolicitud();
        checkSolicitudTCAMBIARESTADOERRORptObservaciones();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCAMBIARESTADOERRORpthisSolicitud() {
        return this.solicitudTCAMBIARESTADOERRORpthisSolicitud;
    }
    
    public void setSolicitudTCAMBIARESTADOERRORpthisSolicitud(SolicitudOid solicitudTCAMBIARESTADOERRORpthisSolicitud) {
        this.solicitudTCAMBIARESTADOERRORpthisSolicitud = solicitudTCAMBIARESTADOERRORpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCAMBIARESTADOERRORpthisSolicitudInstance() {
        return this.solicitudTCAMBIARESTADOERRORpthisSolicitudInstance;
    }
    
    public void setSolicitudTCAMBIARESTADOERRORpthisSolicitudInstance(Solicitud solicitudTCAMBIARESTADOERRORpthisSolicitud) {
        this.solicitudTCAMBIARESTADOERRORpthisSolicitudInstance = solicitudTCAMBIARESTADOERRORpthisSolicitud;
        this.solicitudTCAMBIARESTADOERRORpthisSolicitud = solicitudTCAMBIARESTADOERRORpthisSolicitud != null ? solicitudTCAMBIARESTADOERRORpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCAMBIARESTADOERRORpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTADOERRORpthisSolicitudInstance() == null || this.getSolicitudTCAMBIARESTADOERRORpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTADOERROR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTADOERROR_SOLICITUDTCAMBIARESTADOERRORPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCAMBIARESTADOERROR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTADOERROR_SOLICITUDTCAMBIARESTADOERRORPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTCAMBIARESTADOERRORptObservaciones() {
        return this.solicitudTCAMBIARESTADOERRORptObservaciones;
    }
    
    public void setSolicitudTCAMBIARESTADOERRORptObservaciones(String solicitudTCAMBIARESTADOERRORptObservaciones) {
        this.solicitudTCAMBIARESTADOERRORptObservaciones = solicitudTCAMBIARESTADOERRORptObservaciones;
    }

    private void checkSolicitudTCAMBIARESTADOERRORptObservaciones() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTADOERRORptObservaciones() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTADOERROR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTADOERROR_SOLICITUDTCAMBIARESTADOERRORPTOBSERVACIONES, SolicitudConstants.SERV_ALIAS_TCAMBIARESTADOERROR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTADOERROR_SOLICITUDTCAMBIARESTADOERRORPTOBSERVACIONES);
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
