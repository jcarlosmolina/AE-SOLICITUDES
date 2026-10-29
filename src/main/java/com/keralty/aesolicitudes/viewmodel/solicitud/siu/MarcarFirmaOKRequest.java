package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class MarcarFirmaOKRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudmarcarFirmaOKpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudmarcarFirmaOKpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudmarcarFirmaOKpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudmarcarFirmaOKpthisSolicitud() {
        return this.solicitudmarcarFirmaOKpthisSolicitud;
    }
    
    public void setSolicitudmarcarFirmaOKpthisSolicitud(SolicitudOid solicitudmarcarFirmaOKpthisSolicitud) {
        this.solicitudmarcarFirmaOKpthisSolicitud = solicitudmarcarFirmaOKpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudmarcarFirmaOKpthisSolicitudInstance() {
        return this.solicitudmarcarFirmaOKpthisSolicitudInstance;
    }
    
    public void setSolicitudmarcarFirmaOKpthisSolicitudInstance(Solicitud solicitudmarcarFirmaOKpthisSolicitud) {
        this.solicitudmarcarFirmaOKpthisSolicitudInstance = solicitudmarcarFirmaOKpthisSolicitud;
        this.solicitudmarcarFirmaOKpthisSolicitud = solicitudmarcarFirmaOKpthisSolicitud != null ? solicitudmarcarFirmaOKpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudmarcarFirmaOKpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudmarcarFirmaOKpthisSolicitudInstance() == null || this.getSolicitudmarcarFirmaOKpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_MARCARFIRMAOK, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_MARCARFIRMAOK_SOLICITUDMARCARFIRMAOKPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_MARCARFIRMAOK, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_MARCARFIRMAOK_SOLICITUDMARCARFIRMAOKPTHISSOLICITUD);
        }
    }
}
