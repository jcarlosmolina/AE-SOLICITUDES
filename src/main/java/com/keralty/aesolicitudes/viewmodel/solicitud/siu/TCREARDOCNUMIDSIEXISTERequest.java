package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCREARDOCNUMIDSIEXISTERequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitudInstance;

    @JsonProperty("p_numidentificacion")
    private String solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion;

    @JsonProperty("p_persona_oid")
    private PersonaOid solicitudTCREARDOCNUMIDSIEXISTEpPersona;
    
    @JsonIgnore
    private Persona solicitudTCREARDOCNUMIDSIEXISTEpPersonaInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud();
        checkSolicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion();
        checkSolicitudTCREARDOCNUMIDSIEXISTEpPersona();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud() {
        return this.solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud;
    }
    
    public void setSolicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud(SolicitudOid solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud) {
        this.solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud = solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCREARDOCNUMIDSIEXISTEpthisSolicitudInstance() {
        return this.solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitudInstance;
    }
    
    public void setSolicitudTCREARDOCNUMIDSIEXISTEpthisSolicitudInstance(Solicitud solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud) {
        this.solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitudInstance = solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud;
        this.solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud = solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud != null ? solicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCREARDOCNUMIDSIEXISTEpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCREARDOCNUMIDSIEXISTEpthisSolicitudInstance() == null || this.getSolicitudTCREARDOCNUMIDSIEXISTEpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCREARDOCNUMIDSIEXISTE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCREARDOCNUMIDSIEXISTE_SOLICITUDTCREARDOCNUMIDSIEXISTEPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCREARDOCNUMIDSIEXISTE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCREARDOCNUMIDSIEXISTE_SOLICITUDTCREARDOCNUMIDSIEXISTEPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion() {
        return this.solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion;
    }
    
    public void setSolicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion(String solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion) {
        this.solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion = solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion;
    }

    private void checkSolicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCREARDOCNUMIDSIEXISTE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCREARDOCNUMIDSIEXISTE_SOLICITUDTCREARDOCNUMIDSIEXISTEPNUMIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TCREARDOCNUMIDSIEXISTE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCREARDOCNUMIDSIEXISTE_SOLICITUDTCREARDOCNUMIDSIEXISTEPNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public PersonaOid getSolicitudTCREARDOCNUMIDSIEXISTEpPersona() {
        return this.solicitudTCREARDOCNUMIDSIEXISTEpPersona;
    }
    
    public void setSolicitudTCREARDOCNUMIDSIEXISTEpPersona(PersonaOid solicitudTCREARDOCNUMIDSIEXISTEpPersona) {
        this.solicitudTCREARDOCNUMIDSIEXISTEpPersona = solicitudTCREARDOCNUMIDSIEXISTEpPersona;
    }

    @JsonIgnore
    public Persona getSolicitudTCREARDOCNUMIDSIEXISTEpPersonaInstance() {
        return this.solicitudTCREARDOCNUMIDSIEXISTEpPersonaInstance;
    }
    
    public void setSolicitudTCREARDOCNUMIDSIEXISTEpPersonaInstance(Persona solicitudTCREARDOCNUMIDSIEXISTEpPersona) {
        this.solicitudTCREARDOCNUMIDSIEXISTEpPersonaInstance = solicitudTCREARDOCNUMIDSIEXISTEpPersona;
        this.solicitudTCREARDOCNUMIDSIEXISTEpPersona = solicitudTCREARDOCNUMIDSIEXISTEpPersona != null ? solicitudTCREARDOCNUMIDSIEXISTEpPersona.getOid() : null;
    }

    private void checkSolicitudTCREARDOCNUMIDSIEXISTEpPersona() throws NotNullArgumentException {
        if(this.getSolicitudTCREARDOCNUMIDSIEXISTEpPersonaInstance() == null || this.getSolicitudTCREARDOCNUMIDSIEXISTEpPersonaInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCREARDOCNUMIDSIEXISTE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCREARDOCNUMIDSIEXISTE_SOLICITUDTCREARDOCNUMIDSIEXISTEPPERSONA, SolicitudConstants.SERV_ALIAS_TCREARDOCNUMIDSIEXISTE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCREARDOCNUMIDSIEXISTE_SOLICITUDTCREARDOCNUMIDSIEXISTEPPERSONA);
        }
    }
}
