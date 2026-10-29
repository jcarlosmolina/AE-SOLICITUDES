package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class MarcarCompletadaRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudmarcarCompletadapthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudmarcarCompletadapthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudmarcarCompletadapthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudmarcarCompletadapthisSolicitud() {
        return this.solicitudmarcarCompletadapthisSolicitud;
    }
    
    public void setSolicitudmarcarCompletadapthisSolicitud(SolicitudOid solicitudmarcarCompletadapthisSolicitud) {
        this.solicitudmarcarCompletadapthisSolicitud = solicitudmarcarCompletadapthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudmarcarCompletadapthisSolicitudInstance() {
        return this.solicitudmarcarCompletadapthisSolicitudInstance;
    }
    
    public void setSolicitudmarcarCompletadapthisSolicitudInstance(Solicitud solicitudmarcarCompletadapthisSolicitud) {
        this.solicitudmarcarCompletadapthisSolicitudInstance = solicitudmarcarCompletadapthisSolicitud;
        this.solicitudmarcarCompletadapthisSolicitud = solicitudmarcarCompletadapthisSolicitud != null ? solicitudmarcarCompletadapthisSolicitud.getOid() : null;
    }

    private void checkSolicitudmarcarCompletadapthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudmarcarCompletadapthisSolicitudInstance() == null || this.getSolicitudmarcarCompletadapthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_MARCARCOMPLETADA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_MARCARCOMPLETADA_SOLICITUDMARCARCOMPLETADAPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_MARCARCOMPLETADA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_MARCARCOMPLETADA_SOLICITUDMARCARCOMPLETADAPTHISSOLICITUD);
        }
    }
}
