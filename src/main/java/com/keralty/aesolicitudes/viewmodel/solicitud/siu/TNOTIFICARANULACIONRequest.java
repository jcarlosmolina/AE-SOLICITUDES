package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TNOTIFICARANULACIONRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTNOTIFICARANULACIONpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTNOTIFICARANULACIONpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTNOTIFICARANULACIONpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTNOTIFICARANULACIONpthisSolicitud() {
        return this.solicitudTNOTIFICARANULACIONpthisSolicitud;
    }
    
    public void setSolicitudTNOTIFICARANULACIONpthisSolicitud(SolicitudOid solicitudTNOTIFICARANULACIONpthisSolicitud) {
        this.solicitudTNOTIFICARANULACIONpthisSolicitud = solicitudTNOTIFICARANULACIONpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTNOTIFICARANULACIONpthisSolicitudInstance() {
        return this.solicitudTNOTIFICARANULACIONpthisSolicitudInstance;
    }
    
    public void setSolicitudTNOTIFICARANULACIONpthisSolicitudInstance(Solicitud solicitudTNOTIFICARANULACIONpthisSolicitud) {
        this.solicitudTNOTIFICARANULACIONpthisSolicitudInstance = solicitudTNOTIFICARANULACIONpthisSolicitud;
        this.solicitudTNOTIFICARANULACIONpthisSolicitud = solicitudTNOTIFICARANULACIONpthisSolicitud != null ? solicitudTNOTIFICARANULACIONpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTNOTIFICARANULACIONpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTNOTIFICARANULACIONpthisSolicitudInstance() == null || this.getSolicitudTNOTIFICARANULACIONpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TNOTIFICARANULACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TNOTIFICARANULACION_SOLICITUDTNOTIFICARANULACIONPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TNOTIFICARANULACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TNOTIFICARANULACION_SOLICITUDTNOTIFICARANULACIONPTHISSOLICITUD);
        }
    }
}
