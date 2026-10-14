package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TGETPLANTILLAREPORTERequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTGETPLANTILLAREPORTEpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTGETPLANTILLAREPORTEpthisSolicitudInstance;

    @JsonProperty("pttipo")
    private Long solicitudTGETPLANTILLAREPORTEptTipo;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTGETPLANTILLAREPORTEpthisSolicitud();
        checkSolicitudTGETPLANTILLAREPORTEptTipo();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTGETPLANTILLAREPORTEpthisSolicitud() {
        return this.solicitudTGETPLANTILLAREPORTEpthisSolicitud;
    }
    
    public void setSolicitudTGETPLANTILLAREPORTEpthisSolicitud(SolicitudOid solicitudTGETPLANTILLAREPORTEpthisSolicitud) {
        this.solicitudTGETPLANTILLAREPORTEpthisSolicitud = solicitudTGETPLANTILLAREPORTEpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTGETPLANTILLAREPORTEpthisSolicitudInstance() {
        return this.solicitudTGETPLANTILLAREPORTEpthisSolicitudInstance;
    }
    
    public void setSolicitudTGETPLANTILLAREPORTEpthisSolicitudInstance(Solicitud solicitudTGETPLANTILLAREPORTEpthisSolicitud) {
        this.solicitudTGETPLANTILLAREPORTEpthisSolicitudInstance = solicitudTGETPLANTILLAREPORTEpthisSolicitud;
        this.solicitudTGETPLANTILLAREPORTEpthisSolicitud = solicitudTGETPLANTILLAREPORTEpthisSolicitud != null ? solicitudTGETPLANTILLAREPORTEpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTGETPLANTILLAREPORTEpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTGETPLANTILLAREPORTEpthisSolicitudInstance() == null || this.getSolicitudTGETPLANTILLAREPORTEpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TGETPLANTILLAREPORTE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TGETPLANTILLAREPORTE_SOLICITUDTGETPLANTILLAREPORTEPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TGETPLANTILLAREPORTE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TGETPLANTILLAREPORTE_SOLICITUDTGETPLANTILLAREPORTEPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Long getSolicitudTGETPLANTILLAREPORTEptTipo() {
        return this.solicitudTGETPLANTILLAREPORTEptTipo;
    }
    
    public void setSolicitudTGETPLANTILLAREPORTEptTipo(Long solicitudTGETPLANTILLAREPORTEptTipo) {
        this.solicitudTGETPLANTILLAREPORTEptTipo = solicitudTGETPLANTILLAREPORTEptTipo;
    }

    private void checkSolicitudTGETPLANTILLAREPORTEptTipo() throws NotNullArgumentException {
        if(this.getSolicitudTGETPLANTILLAREPORTEptTipo() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TGETPLANTILLAREPORTE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TGETPLANTILLAREPORTE_SOLICITUDTGETPLANTILLAREPORTEPTTIPO, SolicitudConstants.SERV_ALIAS_TGETPLANTILLAREPORTE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TGETPLANTILLAREPORTE_SOLICITUDTGETPLANTILLAREPORTEPTTIPO);
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
