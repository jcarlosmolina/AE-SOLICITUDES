package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class AsignarFUGRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudasignarFUGpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudasignarFUGpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudasignarFUGpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudasignarFUGpthisSolicitud() {
        return this.solicitudasignarFUGpthisSolicitud;
    }
    
    public void setSolicitudasignarFUGpthisSolicitud(SolicitudOid solicitudasignarFUGpthisSolicitud) {
        this.solicitudasignarFUGpthisSolicitud = solicitudasignarFUGpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudasignarFUGpthisSolicitudInstance() {
        return this.solicitudasignarFUGpthisSolicitudInstance;
    }
    
    public void setSolicitudasignarFUGpthisSolicitudInstance(Solicitud solicitudasignarFUGpthisSolicitud) {
        this.solicitudasignarFUGpthisSolicitudInstance = solicitudasignarFUGpthisSolicitud;
        this.solicitudasignarFUGpthisSolicitud = solicitudasignarFUGpthisSolicitud != null ? solicitudasignarFUGpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudasignarFUGpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudasignarFUGpthisSolicitudInstance() == null || this.getSolicitudasignarFUGpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ASIGNARFUG, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ASIGNARFUG_SOLICITUDASIGNARFUGPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_ASIGNARFUG, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ASIGNARFUG_SOLICITUDASIGNARFUGPTHISSOLICITUD);
        }
    }
}
