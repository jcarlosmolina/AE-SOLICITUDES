package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class ValidarAtributosUsuarioRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudvalidarAtributosUsuariopthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudvalidarAtributosUsuariopthisSolicitudInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudvalidarAtributosUsuariopthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudvalidarAtributosUsuariopthisSolicitud() {
        return this.solicitudvalidarAtributosUsuariopthisSolicitud;
    }
    
    public void setSolicitudvalidarAtributosUsuariopthisSolicitud(SolicitudOid solicitudvalidarAtributosUsuariopthisSolicitud) {
        this.solicitudvalidarAtributosUsuariopthisSolicitud = solicitudvalidarAtributosUsuariopthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudvalidarAtributosUsuariopthisSolicitudInstance() {
        return this.solicitudvalidarAtributosUsuariopthisSolicitudInstance;
    }
    
    public void setSolicitudvalidarAtributosUsuariopthisSolicitudInstance(Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) {
        this.solicitudvalidarAtributosUsuariopthisSolicitudInstance = solicitudvalidarAtributosUsuariopthisSolicitud;
        this.solicitudvalidarAtributosUsuariopthisSolicitud = solicitudvalidarAtributosUsuariopthisSolicitud != null ? solicitudvalidarAtributosUsuariopthisSolicitud.getOid() : null;
    }

    private void checkSolicitudvalidarAtributosUsuariopthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudvalidarAtributosUsuariopthisSolicitudInstance() == null || this.getSolicitudvalidarAtributosUsuariopthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_VALIDARATRIBUTOSUSUARIO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_VALIDARATRIBUTOSUSUARIO_SOLICITUDVALIDARATRIBUTOSUSUARIOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_VALIDARATRIBUTOSUSUARIO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_VALIDARATRIBUTOSUSUARIO_SOLICITUDVALIDARATRIBUTOSUSUARIOPTHISSOLICITUD);
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
