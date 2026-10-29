package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class MarcarExentoIVARequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudmarcarExentoIVApthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudmarcarExentoIVApthisSolicitudInstance;

    @JsonProperty("p_exentoiva")
    private String solicitudmarcarExentoIVApExentoIVA;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudmarcarExentoIVApthisSolicitud();
        checkSolicitudmarcarExentoIVApExentoIVA();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudmarcarExentoIVApthisSolicitud() {
        return this.solicitudmarcarExentoIVApthisSolicitud;
    }
    
    public void setSolicitudmarcarExentoIVApthisSolicitud(SolicitudOid solicitudmarcarExentoIVApthisSolicitud) {
        this.solicitudmarcarExentoIVApthisSolicitud = solicitudmarcarExentoIVApthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudmarcarExentoIVApthisSolicitudInstance() {
        return this.solicitudmarcarExentoIVApthisSolicitudInstance;
    }
    
    public void setSolicitudmarcarExentoIVApthisSolicitudInstance(Solicitud solicitudmarcarExentoIVApthisSolicitud) {
        this.solicitudmarcarExentoIVApthisSolicitudInstance = solicitudmarcarExentoIVApthisSolicitud;
        this.solicitudmarcarExentoIVApthisSolicitud = solicitudmarcarExentoIVApthisSolicitud != null ? solicitudmarcarExentoIVApthisSolicitud.getOid() : null;
    }

    private void checkSolicitudmarcarExentoIVApthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudmarcarExentoIVApthisSolicitudInstance() == null || this.getSolicitudmarcarExentoIVApthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_MARCAREXENTOIVA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_MARCAREXENTOIVA_SOLICITUDMARCAREXENTOIVAPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_MARCAREXENTOIVA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_MARCAREXENTOIVA_SOLICITUDMARCAREXENTOIVAPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudmarcarExentoIVApExentoIVA() {
        return this.solicitudmarcarExentoIVApExentoIVA;
    }
    
    public void setSolicitudmarcarExentoIVApExentoIVA(String solicitudmarcarExentoIVApExentoIVA) {
        this.solicitudmarcarExentoIVApExentoIVA = solicitudmarcarExentoIVApExentoIVA;
    }

    private void checkSolicitudmarcarExentoIVApExentoIVA() throws NotNullArgumentException {
        if(this.getSolicitudmarcarExentoIVApExentoIVA() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_MARCAREXENTOIVA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_MARCAREXENTOIVA_SOLICITUDMARCAREXENTOIVAPEXENTOIVA, SolicitudConstants.SERV_ALIAS_MARCAREXENTOIVA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_MARCAREXENTOIVA_SOLICITUDMARCAREXENTOIVAPEXENTOIVA);
        }
    }
}
