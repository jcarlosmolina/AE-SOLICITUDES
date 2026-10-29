package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DummyValidacionesFInicioContRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicituddummyValidacionesFInicioContpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicituddummyValidacionesFInicioContpthisSolicitudInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicituddummyValidacionesFInicioContpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicituddummyValidacionesFInicioContpthisSolicitud() {
        return this.solicituddummyValidacionesFInicioContpthisSolicitud;
    }
    
    public void setSolicituddummyValidacionesFInicioContpthisSolicitud(SolicitudOid solicituddummyValidacionesFInicioContpthisSolicitud) {
        this.solicituddummyValidacionesFInicioContpthisSolicitud = solicituddummyValidacionesFInicioContpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicituddummyValidacionesFInicioContpthisSolicitudInstance() {
        return this.solicituddummyValidacionesFInicioContpthisSolicitudInstance;
    }
    
    public void setSolicituddummyValidacionesFInicioContpthisSolicitudInstance(Solicitud solicituddummyValidacionesFInicioContpthisSolicitud) {
        this.solicituddummyValidacionesFInicioContpthisSolicitudInstance = solicituddummyValidacionesFInicioContpthisSolicitud;
        this.solicituddummyValidacionesFInicioContpthisSolicitud = solicituddummyValidacionesFInicioContpthisSolicitud != null ? solicituddummyValidacionesFInicioContpthisSolicitud.getOid() : null;
    }

    private void checkSolicituddummyValidacionesFInicioContpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicituddummyValidacionesFInicioContpthisSolicitudInstance() == null || this.getSolicituddummyValidacionesFInicioContpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DUMMYVALIDACIONESFINICIOCONT, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DUMMYVALIDACIONESFINICIOCONT_SOLICITUDDUMMYVALIDACIONESFINICIOCONTPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DUMMYVALIDACIONESFINICIOCONT, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DUMMYVALIDACIONESFINICIOCONT_SOLICITUDDUMMYVALIDACIONESFINICIOCONTPTHISSOLICITUD);
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
