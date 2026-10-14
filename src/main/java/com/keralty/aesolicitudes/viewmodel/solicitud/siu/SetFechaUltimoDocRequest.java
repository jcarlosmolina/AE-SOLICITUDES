package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;
import java.sql.Timestamp;

public class SetFechaUltimoDocRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudsetFechaUltimoDocpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudsetFechaUltimoDocpthisSolicitudInstance;

    @JsonProperty("pefechahora")
    private Timestamp solicitudsetFechaUltimoDocpeFechaHora;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudsetFechaUltimoDocpthisSolicitud();
        checkSolicitudsetFechaUltimoDocpeFechaHora();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudsetFechaUltimoDocpthisSolicitud() {
        return this.solicitudsetFechaUltimoDocpthisSolicitud;
    }
    
    public void setSolicitudsetFechaUltimoDocpthisSolicitud(SolicitudOid solicitudsetFechaUltimoDocpthisSolicitud) {
        this.solicitudsetFechaUltimoDocpthisSolicitud = solicitudsetFechaUltimoDocpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudsetFechaUltimoDocpthisSolicitudInstance() {
        return this.solicitudsetFechaUltimoDocpthisSolicitudInstance;
    }
    
    public void setSolicitudsetFechaUltimoDocpthisSolicitudInstance(Solicitud solicitudsetFechaUltimoDocpthisSolicitud) {
        this.solicitudsetFechaUltimoDocpthisSolicitudInstance = solicitudsetFechaUltimoDocpthisSolicitud;
        this.solicitudsetFechaUltimoDocpthisSolicitud = solicitudsetFechaUltimoDocpthisSolicitud != null ? solicitudsetFechaUltimoDocpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudsetFechaUltimoDocpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudsetFechaUltimoDocpthisSolicitudInstance() == null || this.getSolicitudsetFechaUltimoDocpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_SETFECHAULTIMODOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_SETFECHAULTIMODOC_SOLICITUDSETFECHAULTIMODOCPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_SETFECHAULTIMODOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_SETFECHAULTIMODOC_SOLICITUDSETFECHAULTIMODOCPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Timestamp getSolicitudsetFechaUltimoDocpeFechaHora() {
        return this.solicitudsetFechaUltimoDocpeFechaHora;
    }
    
    public void setSolicitudsetFechaUltimoDocpeFechaHora(Timestamp solicitudsetFechaUltimoDocpeFechaHora) {
        this.solicitudsetFechaUltimoDocpeFechaHora = solicitudsetFechaUltimoDocpeFechaHora;
    }

    private void checkSolicitudsetFechaUltimoDocpeFechaHora() throws NotNullArgumentException {
        if(this.getSolicitudsetFechaUltimoDocpeFechaHora() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_SETFECHAULTIMODOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_SETFECHAULTIMODOC_SOLICITUDSETFECHAULTIMODOCPEFECHAHORA, SolicitudConstants.SERV_ALIAS_SETFECHAULTIMODOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_SETFECHAULTIMODOC_SOLICITUDSETFECHAULTIMODOCPEFECHAHORA);
        }
    }
}
