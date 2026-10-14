package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TADDTITULARUSUARIORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTADDTITULARUSUARIOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTADDTITULARUSUARIOpthisSolicitudInstance;

    @JsonProperty("ptpersona_oid")
    private PersonaOid solicitudTADDTITULARUSUARIOptPersona;
    
    @JsonIgnore
    private Persona solicitudTADDTITULARUSUARIOptPersonaInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTADDTITULARUSUARIOpthisSolicitud();
        checkSolicitudTADDTITULARUSUARIOptPersona();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTADDTITULARUSUARIOpthisSolicitud() {
        return this.solicitudTADDTITULARUSUARIOpthisSolicitud;
    }
    
    public void setSolicitudTADDTITULARUSUARIOpthisSolicitud(SolicitudOid solicitudTADDTITULARUSUARIOpthisSolicitud) {
        this.solicitudTADDTITULARUSUARIOpthisSolicitud = solicitudTADDTITULARUSUARIOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTADDTITULARUSUARIOpthisSolicitudInstance() {
        return this.solicitudTADDTITULARUSUARIOpthisSolicitudInstance;
    }
    
    public void setSolicitudTADDTITULARUSUARIOpthisSolicitudInstance(Solicitud solicitudTADDTITULARUSUARIOpthisSolicitud) {
        this.solicitudTADDTITULARUSUARIOpthisSolicitudInstance = solicitudTADDTITULARUSUARIOpthisSolicitud;
        this.solicitudTADDTITULARUSUARIOpthisSolicitud = solicitudTADDTITULARUSUARIOpthisSolicitud != null ? solicitudTADDTITULARUSUARIOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTADDTITULARUSUARIOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTADDTITULARUSUARIOpthisSolicitudInstance() == null || this.getSolicitudTADDTITULARUSUARIOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TADDTITULARUSUARIO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TADDTITULARUSUARIO_SOLICITUDTADDTITULARUSUARIOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TADDTITULARUSUARIO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TADDTITULARUSUARIO_SOLICITUDTADDTITULARUSUARIOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public PersonaOid getSolicitudTADDTITULARUSUARIOptPersona() {
        return this.solicitudTADDTITULARUSUARIOptPersona;
    }
    
    public void setSolicitudTADDTITULARUSUARIOptPersona(PersonaOid solicitudTADDTITULARUSUARIOptPersona) {
        this.solicitudTADDTITULARUSUARIOptPersona = solicitudTADDTITULARUSUARIOptPersona;
    }

    @JsonIgnore
    public Persona getSolicitudTADDTITULARUSUARIOptPersonaInstance() {
        return this.solicitudTADDTITULARUSUARIOptPersonaInstance;
    }
    
    public void setSolicitudTADDTITULARUSUARIOptPersonaInstance(Persona solicitudTADDTITULARUSUARIOptPersona) {
        this.solicitudTADDTITULARUSUARIOptPersonaInstance = solicitudTADDTITULARUSUARIOptPersona;
        this.solicitudTADDTITULARUSUARIOptPersona = solicitudTADDTITULARUSUARIOptPersona != null ? solicitudTADDTITULARUSUARIOptPersona.getOid() : null;
    }

    private void checkSolicitudTADDTITULARUSUARIOptPersona() throws NotNullArgumentException {
        if(this.getSolicitudTADDTITULARUSUARIOptPersonaInstance() == null || this.getSolicitudTADDTITULARUSUARIOptPersonaInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TADDTITULARUSUARIO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TADDTITULARUSUARIO_SOLICITUDTADDTITULARUSUARIOPTPERSONA, SolicitudConstants.SERV_ALIAS_TADDTITULARUSUARIO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TADDTITULARUSUARIO_SOLICITUDTADDTITULARUSUARIOPTPERSONA);
        }
    }
}
