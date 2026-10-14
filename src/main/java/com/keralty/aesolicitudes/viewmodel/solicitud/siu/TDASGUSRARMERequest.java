package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TDASGUSRARMERequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTDASGUSRARMEpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTDASGUSRARMEpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTDASGUSRARMEpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTDASGUSRARMEpthisSolicitud() {
        return this.solicitudTDASGUSRARMEpthisSolicitud;
    }
    
    public void setSolicitudTDASGUSRARMEpthisSolicitud(SolicitudOid solicitudTDASGUSRARMEpthisSolicitud) {
        this.solicitudTDASGUSRARMEpthisSolicitud = solicitudTDASGUSRARMEpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTDASGUSRARMEpthisSolicitudInstance() {
        return this.solicitudTDASGUSRARMEpthisSolicitudInstance;
    }
    
    public void setSolicitudTDASGUSRARMEpthisSolicitudInstance(Solicitud solicitudTDASGUSRARMEpthisSolicitud) {
        this.solicitudTDASGUSRARMEpthisSolicitudInstance = solicitudTDASGUSRARMEpthisSolicitud;
        this.solicitudTDASGUSRARMEpthisSolicitud = solicitudTDASGUSRARMEpthisSolicitud != null ? solicitudTDASGUSRARMEpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTDASGUSRARMEpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTDASGUSRARMEpthisSolicitudInstance() == null || this.getSolicitudTDASGUSRARMEpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TDASGUSRARME, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TDASGUSRARME_SOLICITUDTDASGUSRARMEPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TDASGUSRARME, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TDASGUSRARME_SOLICITUDTDASGUSRARMEPTHISSOLICITUD);
        }
    }
}
