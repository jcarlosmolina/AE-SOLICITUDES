package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TENVIARDOCAUTORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTENVIARDOCAUTOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTENVIARDOCAUTOpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTENVIARDOCAUTOpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTENVIARDOCAUTOpthisSolicitud() {
        return this.solicitudTENVIARDOCAUTOpthisSolicitud;
    }
    
    public void setSolicitudTENVIARDOCAUTOpthisSolicitud(SolicitudOid solicitudTENVIARDOCAUTOpthisSolicitud) {
        this.solicitudTENVIARDOCAUTOpthisSolicitud = solicitudTENVIARDOCAUTOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTENVIARDOCAUTOpthisSolicitudInstance() {
        return this.solicitudTENVIARDOCAUTOpthisSolicitudInstance;
    }
    
    public void setSolicitudTENVIARDOCAUTOpthisSolicitudInstance(Solicitud solicitudTENVIARDOCAUTOpthisSolicitud) {
        this.solicitudTENVIARDOCAUTOpthisSolicitudInstance = solicitudTENVIARDOCAUTOpthisSolicitud;
        this.solicitudTENVIARDOCAUTOpthisSolicitud = solicitudTENVIARDOCAUTOpthisSolicitud != null ? solicitudTENVIARDOCAUTOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTENVIARDOCAUTOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCAUTOpthisSolicitudInstance() == null || this.getSolicitudTENVIARDOCAUTOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOCAUTO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOCAUTO_SOLICITUDTENVIARDOCAUTOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TENVIARDOCAUTO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOCAUTO_SOLICITUDTENVIARDOCAUTOPTHISSOLICITUD);
        }
    }
}
