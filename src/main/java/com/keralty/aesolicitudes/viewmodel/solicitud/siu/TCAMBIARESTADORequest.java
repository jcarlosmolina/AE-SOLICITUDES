package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCAMBIARESTADORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCAMBIARESTADOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCAMBIARESTADOpthisSolicitudInstance;

    @JsonProperty("pt_peestado")
    private Long solicitudTCAMBIARESTADOptpeEstado;

    @JsonProperty("ptobservaciones")
    private String solicitudTCAMBIARESTADOptObservaciones;

    @JsonProperty("ptmotdevolucion")
    private String solicitudTCAMBIARESTADOptMotDevolucion;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCAMBIARESTADOpthisSolicitud();
        checkSolicitudTCAMBIARESTADOptpeEstado();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCAMBIARESTADOpthisSolicitud() {
        return this.solicitudTCAMBIARESTADOpthisSolicitud;
    }
    
    public void setSolicitudTCAMBIARESTADOpthisSolicitud(SolicitudOid solicitudTCAMBIARESTADOpthisSolicitud) {
        this.solicitudTCAMBIARESTADOpthisSolicitud = solicitudTCAMBIARESTADOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCAMBIARESTADOpthisSolicitudInstance() {
        return this.solicitudTCAMBIARESTADOpthisSolicitudInstance;
    }
    
    public void setSolicitudTCAMBIARESTADOpthisSolicitudInstance(Solicitud solicitudTCAMBIARESTADOpthisSolicitud) {
        this.solicitudTCAMBIARESTADOpthisSolicitudInstance = solicitudTCAMBIARESTADOpthisSolicitud;
        this.solicitudTCAMBIARESTADOpthisSolicitud = solicitudTCAMBIARESTADOpthisSolicitud != null ? solicitudTCAMBIARESTADOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCAMBIARESTADOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTADOpthisSolicitudInstance() == null || this.getSolicitudTCAMBIARESTADOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTADO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTADO_SOLICITUDTCAMBIARESTADOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCAMBIARESTADO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTADO_SOLICITUDTCAMBIARESTADOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Long getSolicitudTCAMBIARESTADOptpeEstado() {
        return this.solicitudTCAMBIARESTADOptpeEstado;
    }
    
    public void setSolicitudTCAMBIARESTADOptpeEstado(Long solicitudTCAMBIARESTADOptpeEstado) {
        this.solicitudTCAMBIARESTADOptpeEstado = solicitudTCAMBIARESTADOptpeEstado;
    }

    private void checkSolicitudTCAMBIARESTADOptpeEstado() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTADOptpeEstado() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTADO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTADO_SOLICITUDTCAMBIARESTADOPTPEESTADO, SolicitudConstants.SERV_ALIAS_TCAMBIARESTADO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTADO_SOLICITUDTCAMBIARESTADOPTPEESTADO);
        }
    }

    @JsonIgnore
    public String getSolicitudTCAMBIARESTADOptObservaciones() {
        return this.solicitudTCAMBIARESTADOptObservaciones;
    }
    
    public void setSolicitudTCAMBIARESTADOptObservaciones(String solicitudTCAMBIARESTADOptObservaciones) {
        this.solicitudTCAMBIARESTADOptObservaciones = solicitudTCAMBIARESTADOptObservaciones;
    }

    @JsonIgnore
    public String getSolicitudTCAMBIARESTADOptMotDevolucion() {
        return this.solicitudTCAMBIARESTADOptMotDevolucion;
    }
    
    public void setSolicitudTCAMBIARESTADOptMotDevolucion(String solicitudTCAMBIARESTADOptMotDevolucion) {
        this.solicitudTCAMBIARESTADOptMotDevolucion = solicitudTCAMBIARESTADOptMotDevolucion;
    }
}
