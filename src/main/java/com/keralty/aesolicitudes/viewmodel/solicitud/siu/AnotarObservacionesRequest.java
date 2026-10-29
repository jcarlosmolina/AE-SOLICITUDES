package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class AnotarObservacionesRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudanotarObservacionespthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudanotarObservacionespthisSolicitudInstance;

    @JsonProperty("p_observaciones")
    private String solicitudanotarObservacionespObservaciones;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudanotarObservacionespthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudanotarObservacionespthisSolicitud() {
        return this.solicitudanotarObservacionespthisSolicitud;
    }
    
    public void setSolicitudanotarObservacionespthisSolicitud(SolicitudOid solicitudanotarObservacionespthisSolicitud) {
        this.solicitudanotarObservacionespthisSolicitud = solicitudanotarObservacionespthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudanotarObservacionespthisSolicitudInstance() {
        return this.solicitudanotarObservacionespthisSolicitudInstance;
    }
    
    public void setSolicitudanotarObservacionespthisSolicitudInstance(Solicitud solicitudanotarObservacionespthisSolicitud) {
        this.solicitudanotarObservacionespthisSolicitudInstance = solicitudanotarObservacionespthisSolicitud;
        this.solicitudanotarObservacionespthisSolicitud = solicitudanotarObservacionespthisSolicitud != null ? solicitudanotarObservacionespthisSolicitud.getOid() : null;
    }

    private void checkSolicitudanotarObservacionespthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudanotarObservacionespthisSolicitudInstance() == null || this.getSolicitudanotarObservacionespthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ANOTAROBSERVACIONES, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ANOTAROBSERVACIONES_SOLICITUDANOTAROBSERVACIONESPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_ANOTAROBSERVACIONES, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ANOTAROBSERVACIONES_SOLICITUDANOTAROBSERVACIONESPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudanotarObservacionespObservaciones() {
        return this.solicitudanotarObservacionespObservaciones;
    }
    
    public void setSolicitudanotarObservacionespObservaciones(String solicitudanotarObservacionespObservaciones) {
        this.solicitudanotarObservacionespObservaciones = solicitudanotarObservacionespObservaciones;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
