package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TPOSTGENERAREXITORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTPOSTGENERAREXITOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTPOSTGENERAREXITOpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTPOSTGENERAREXITOpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTPOSTGENERAREXITOpthisSolicitud() {
        return this.solicitudTPOSTGENERAREXITOpthisSolicitud;
    }
    
    public void setSolicitudTPOSTGENERAREXITOpthisSolicitud(SolicitudOid solicitudTPOSTGENERAREXITOpthisSolicitud) {
        this.solicitudTPOSTGENERAREXITOpthisSolicitud = solicitudTPOSTGENERAREXITOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTPOSTGENERAREXITOpthisSolicitudInstance() {
        return this.solicitudTPOSTGENERAREXITOpthisSolicitudInstance;
    }
    
    public void setSolicitudTPOSTGENERAREXITOpthisSolicitudInstance(Solicitud solicitudTPOSTGENERAREXITOpthisSolicitud) {
        this.solicitudTPOSTGENERAREXITOpthisSolicitudInstance = solicitudTPOSTGENERAREXITOpthisSolicitud;
        this.solicitudTPOSTGENERAREXITOpthisSolicitud = solicitudTPOSTGENERAREXITOpthisSolicitud != null ? solicitudTPOSTGENERAREXITOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTPOSTGENERAREXITOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTPOSTGENERAREXITOpthisSolicitudInstance() == null || this.getSolicitudTPOSTGENERAREXITOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TPOSTGENERAREXITO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TPOSTGENERAREXITO_SOLICITUDTPOSTGENERAREXITOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TPOSTGENERAREXITO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TPOSTGENERAREXITO_SOLICITUDTPOSTGENERAREXITOPTHISSOLICITUD);
        }
    }
}
