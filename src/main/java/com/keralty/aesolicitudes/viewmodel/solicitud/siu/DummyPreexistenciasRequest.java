package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DummyPreexistenciasRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicituddummyPreexistenciaspthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicituddummyPreexistenciaspthisSolicitudInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicituddummyPreexistenciaspthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicituddummyPreexistenciaspthisSolicitud() {
        return this.solicituddummyPreexistenciaspthisSolicitud;
    }
    
    public void setSolicituddummyPreexistenciaspthisSolicitud(SolicitudOid solicituddummyPreexistenciaspthisSolicitud) {
        this.solicituddummyPreexistenciaspthisSolicitud = solicituddummyPreexistenciaspthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicituddummyPreexistenciaspthisSolicitudInstance() {
        return this.solicituddummyPreexistenciaspthisSolicitudInstance;
    }
    
    public void setSolicituddummyPreexistenciaspthisSolicitudInstance(Solicitud solicituddummyPreexistenciaspthisSolicitud) {
        this.solicituddummyPreexistenciaspthisSolicitudInstance = solicituddummyPreexistenciaspthisSolicitud;
        this.solicituddummyPreexistenciaspthisSolicitud = solicituddummyPreexistenciaspthisSolicitud != null ? solicituddummyPreexistenciaspthisSolicitud.getOid() : null;
    }

    private void checkSolicituddummyPreexistenciaspthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicituddummyPreexistenciaspthisSolicitudInstance() == null || this.getSolicituddummyPreexistenciaspthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DUMMYPREEXISTENCIAS, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DUMMYPREEXISTENCIAS_SOLICITUDDUMMYPREEXISTENCIASPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DUMMYPREEXISTENCIAS, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DUMMYPREEXISTENCIAS_SOLICITUDDUMMYPREEXISTENCIASPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
