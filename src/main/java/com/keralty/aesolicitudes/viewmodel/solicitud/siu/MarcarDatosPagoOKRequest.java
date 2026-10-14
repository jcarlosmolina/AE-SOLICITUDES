package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class MarcarDatosPagoOKRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudmarcarDatosPagoOKpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudmarcarDatosPagoOKpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudmarcarDatosPagoOKpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudmarcarDatosPagoOKpthisSolicitud() {
        return this.solicitudmarcarDatosPagoOKpthisSolicitud;
    }
    
    public void setSolicitudmarcarDatosPagoOKpthisSolicitud(SolicitudOid solicitudmarcarDatosPagoOKpthisSolicitud) {
        this.solicitudmarcarDatosPagoOKpthisSolicitud = solicitudmarcarDatosPagoOKpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudmarcarDatosPagoOKpthisSolicitudInstance() {
        return this.solicitudmarcarDatosPagoOKpthisSolicitudInstance;
    }
    
    public void setSolicitudmarcarDatosPagoOKpthisSolicitudInstance(Solicitud solicitudmarcarDatosPagoOKpthisSolicitud) {
        this.solicitudmarcarDatosPagoOKpthisSolicitudInstance = solicitudmarcarDatosPagoOKpthisSolicitud;
        this.solicitudmarcarDatosPagoOKpthisSolicitud = solicitudmarcarDatosPagoOKpthisSolicitud != null ? solicitudmarcarDatosPagoOKpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudmarcarDatosPagoOKpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudmarcarDatosPagoOKpthisSolicitudInstance() == null || this.getSolicitudmarcarDatosPagoOKpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_MARCARDATOSPAGOOK, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_MARCARDATOSPAGOOK_SOLICITUDMARCARDATOSPAGOOKPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_MARCARDATOSPAGOOK, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_MARCARDATOSPAGOOK_SOLICITUDMARCARDATOSPAGOOKPTHISSOLICITUD);
        }
    }
}
