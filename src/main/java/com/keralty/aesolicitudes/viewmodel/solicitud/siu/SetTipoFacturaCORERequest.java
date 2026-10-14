package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class SetTipoFacturaCORERequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudsetTipoFacturaCOREpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudsetTipoFacturaCOREpthisSolicitudInstance;

    @JsonProperty("pttipofact")
    private String solicitudsetTipoFacturaCOREptTipoFact;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudsetTipoFacturaCOREpthisSolicitud();
        checkSolicitudsetTipoFacturaCOREptTipoFact();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudsetTipoFacturaCOREpthisSolicitud() {
        return this.solicitudsetTipoFacturaCOREpthisSolicitud;
    }
    
    public void setSolicitudsetTipoFacturaCOREpthisSolicitud(SolicitudOid solicitudsetTipoFacturaCOREpthisSolicitud) {
        this.solicitudsetTipoFacturaCOREpthisSolicitud = solicitudsetTipoFacturaCOREpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudsetTipoFacturaCOREpthisSolicitudInstance() {
        return this.solicitudsetTipoFacturaCOREpthisSolicitudInstance;
    }
    
    public void setSolicitudsetTipoFacturaCOREpthisSolicitudInstance(Solicitud solicitudsetTipoFacturaCOREpthisSolicitud) {
        this.solicitudsetTipoFacturaCOREpthisSolicitudInstance = solicitudsetTipoFacturaCOREpthisSolicitud;
        this.solicitudsetTipoFacturaCOREpthisSolicitud = solicitudsetTipoFacturaCOREpthisSolicitud != null ? solicitudsetTipoFacturaCOREpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudsetTipoFacturaCOREpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudsetTipoFacturaCOREpthisSolicitudInstance() == null || this.getSolicitudsetTipoFacturaCOREpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_SETTIPOFACTURACORE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_SETTIPOFACTURACORE_SOLICITUDSETTIPOFACTURACOREPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_SETTIPOFACTURACORE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_SETTIPOFACTURACORE_SOLICITUDSETTIPOFACTURACOREPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudsetTipoFacturaCOREptTipoFact() {
        return this.solicitudsetTipoFacturaCOREptTipoFact;
    }
    
    public void setSolicitudsetTipoFacturaCOREptTipoFact(String solicitudsetTipoFacturaCOREptTipoFact) {
        this.solicitudsetTipoFacturaCOREptTipoFact = solicitudsetTipoFacturaCOREptTipoFact;
    }

    private void checkSolicitudsetTipoFacturaCOREptTipoFact() throws NotNullArgumentException {
        if(this.getSolicitudsetTipoFacturaCOREptTipoFact() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_SETTIPOFACTURACORE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_SETTIPOFACTURACORE_SOLICITUDSETTIPOFACTURACOREPTTIPOFACT, SolicitudConstants.SERV_ALIAS_SETTIPOFACTURACORE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_SETTIPOFACTURACORE_SOLICITUDSETTIPOFACTURACOREPTTIPOFACT);
        }
    }
}
