package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TENVIARDOCAUTOAUXRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTENVIARDOCAUTOAUXpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTENVIARDOCAUTOAUXpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTENVIARDOCAUTOAUXpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTENVIARDOCAUTOAUXpthisSolicitud() {
        return this.solicitudTENVIARDOCAUTOAUXpthisSolicitud;
    }
    
    public void setSolicitudTENVIARDOCAUTOAUXpthisSolicitud(SolicitudOid solicitudTENVIARDOCAUTOAUXpthisSolicitud) {
        this.solicitudTENVIARDOCAUTOAUXpthisSolicitud = solicitudTENVIARDOCAUTOAUXpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTENVIARDOCAUTOAUXpthisSolicitudInstance() {
        return this.solicitudTENVIARDOCAUTOAUXpthisSolicitudInstance;
    }
    
    public void setSolicitudTENVIARDOCAUTOAUXpthisSolicitudInstance(Solicitud solicitudTENVIARDOCAUTOAUXpthisSolicitud) {
        this.solicitudTENVIARDOCAUTOAUXpthisSolicitudInstance = solicitudTENVIARDOCAUTOAUXpthisSolicitud;
        this.solicitudTENVIARDOCAUTOAUXpthisSolicitud = solicitudTENVIARDOCAUTOAUXpthisSolicitud != null ? solicitudTENVIARDOCAUTOAUXpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTENVIARDOCAUTOAUXpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCAUTOAUXpthisSolicitudInstance() == null || this.getSolicitudTENVIARDOCAUTOAUXpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOCAUTOAUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOCAUTOAUX_SOLICITUDTENVIARDOCAUTOAUXPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TENVIARDOCAUTOAUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOCAUTOAUX_SOLICITUDTENVIARDOCAUTOAUXPTHISSOLICITUD);
        }
    }
}
