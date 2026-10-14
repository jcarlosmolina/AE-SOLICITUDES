package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class CambiarEstadoRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudcambiarEstadopthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudcambiarEstadopthisSolicitudInstance;

    @JsonProperty("peestado")
    private Long solicitudcambiarEstadopeEstado;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudcambiarEstadopthisSolicitud();
        checkSolicitudcambiarEstadopeEstado();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudcambiarEstadopthisSolicitud() {
        return this.solicitudcambiarEstadopthisSolicitud;
    }
    
    public void setSolicitudcambiarEstadopthisSolicitud(SolicitudOid solicitudcambiarEstadopthisSolicitud) {
        this.solicitudcambiarEstadopthisSolicitud = solicitudcambiarEstadopthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudcambiarEstadopthisSolicitudInstance() {
        return this.solicitudcambiarEstadopthisSolicitudInstance;
    }
    
    public void setSolicitudcambiarEstadopthisSolicitudInstance(Solicitud solicitudcambiarEstadopthisSolicitud) {
        this.solicitudcambiarEstadopthisSolicitudInstance = solicitudcambiarEstadopthisSolicitud;
        this.solicitudcambiarEstadopthisSolicitud = solicitudcambiarEstadopthisSolicitud != null ? solicitudcambiarEstadopthisSolicitud.getOid() : null;
    }

    private void checkSolicitudcambiarEstadopthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudcambiarEstadopthisSolicitudInstance() == null || this.getSolicitudcambiarEstadopthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CAMBIARESTADO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CAMBIARESTADO_SOLICITUDCAMBIARESTADOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_CAMBIARESTADO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CAMBIARESTADO_SOLICITUDCAMBIARESTADOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Long getSolicitudcambiarEstadopeEstado() {
        return this.solicitudcambiarEstadopeEstado;
    }
    
    public void setSolicitudcambiarEstadopeEstado(Long solicitudcambiarEstadopeEstado) {
        this.solicitudcambiarEstadopeEstado = solicitudcambiarEstadopeEstado;
    }

    private void checkSolicitudcambiarEstadopeEstado() throws NotNullArgumentException {
        if(this.getSolicitudcambiarEstadopeEstado() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CAMBIARESTADO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CAMBIARESTADO_SOLICITUDCAMBIARESTADOPEESTADO, SolicitudConstants.SERV_ALIAS_CAMBIARESTADO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CAMBIARESTADO_SOLICITUDCAMBIARESTADOPEESTADO);
        }
    }
}
