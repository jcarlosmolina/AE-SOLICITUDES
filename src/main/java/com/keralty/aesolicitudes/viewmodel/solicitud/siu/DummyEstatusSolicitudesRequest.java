package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DummyEstatusSolicitudesRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicituddummyEstatusSolicitudespthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicituddummyEstatusSolicitudespthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicituddummyEstatusSolicitudespthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicituddummyEstatusSolicitudespthisSolicitud() {
        return this.solicituddummyEstatusSolicitudespthisSolicitud;
    }
    
    public void setSolicituddummyEstatusSolicitudespthisSolicitud(SolicitudOid solicituddummyEstatusSolicitudespthisSolicitud) {
        this.solicituddummyEstatusSolicitudespthisSolicitud = solicituddummyEstatusSolicitudespthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicituddummyEstatusSolicitudespthisSolicitudInstance() {
        return this.solicituddummyEstatusSolicitudespthisSolicitudInstance;
    }
    
    public void setSolicituddummyEstatusSolicitudespthisSolicitudInstance(Solicitud solicituddummyEstatusSolicitudespthisSolicitud) {
        this.solicituddummyEstatusSolicitudespthisSolicitudInstance = solicituddummyEstatusSolicitudespthisSolicitud;
        this.solicituddummyEstatusSolicitudespthisSolicitud = solicituddummyEstatusSolicitudespthisSolicitud != null ? solicituddummyEstatusSolicitudespthisSolicitud.getOid() : null;
    }

    private void checkSolicituddummyEstatusSolicitudespthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicituddummyEstatusSolicitudespthisSolicitudInstance() == null || this.getSolicituddummyEstatusSolicitudespthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DUMMYESTATUSSOLICITUDES, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DUMMYESTATUSSOLICITUDES_SOLICITUDDUMMYESTATUSSOLICITUDESPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DUMMYESTATUSSOLICITUDES, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DUMMYESTATUSSOLICITUDES_SOLICITUDDUMMYESTATUSSOLICITUDESPTHISSOLICITUD);
        }
    }
}
