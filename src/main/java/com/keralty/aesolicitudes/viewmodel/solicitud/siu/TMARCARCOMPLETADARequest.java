package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TMARCARCOMPLETADARequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTMARCARCOMPLETADApthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTMARCARCOMPLETADApthisSolicitudInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTMARCARCOMPLETADApthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTMARCARCOMPLETADApthisSolicitud() {
        return this.solicitudTMARCARCOMPLETADApthisSolicitud;
    }
    
    public void setSolicitudTMARCARCOMPLETADApthisSolicitud(SolicitudOid solicitudTMARCARCOMPLETADApthisSolicitud) {
        this.solicitudTMARCARCOMPLETADApthisSolicitud = solicitudTMARCARCOMPLETADApthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTMARCARCOMPLETADApthisSolicitudInstance() {
        return this.solicitudTMARCARCOMPLETADApthisSolicitudInstance;
    }
    
    public void setSolicitudTMARCARCOMPLETADApthisSolicitudInstance(Solicitud solicitudTMARCARCOMPLETADApthisSolicitud) {
        this.solicitudTMARCARCOMPLETADApthisSolicitudInstance = solicitudTMARCARCOMPLETADApthisSolicitud;
        this.solicitudTMARCARCOMPLETADApthisSolicitud = solicitudTMARCARCOMPLETADApthisSolicitud != null ? solicitudTMARCARCOMPLETADApthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTMARCARCOMPLETADApthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTMARCARCOMPLETADApthisSolicitudInstance() == null || this.getSolicitudTMARCARCOMPLETADApthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMARCARCOMPLETADA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMARCARCOMPLETADA_SOLICITUDTMARCARCOMPLETADAPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TMARCARCOMPLETADA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMARCARCOMPLETADA_SOLICITUDTMARCARCOMPLETADAPTHISSOLICITUD);
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
