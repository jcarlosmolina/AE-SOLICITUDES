package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class ModMarcaCarnetRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudmodMarcaCarnetpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudmodMarcaCarnetpthisSolicitudInstance;

    @JsonProperty("pemarcacarnet")
    private Boolean solicitudmodMarcaCarnetpeMarcaCarnet;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudmodMarcaCarnetpthisSolicitud();
        checkSolicitudmodMarcaCarnetpeMarcaCarnet();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudmodMarcaCarnetpthisSolicitud() {
        return this.solicitudmodMarcaCarnetpthisSolicitud;
    }
    
    public void setSolicitudmodMarcaCarnetpthisSolicitud(SolicitudOid solicitudmodMarcaCarnetpthisSolicitud) {
        this.solicitudmodMarcaCarnetpthisSolicitud = solicitudmodMarcaCarnetpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudmodMarcaCarnetpthisSolicitudInstance() {
        return this.solicitudmodMarcaCarnetpthisSolicitudInstance;
    }
    
    public void setSolicitudmodMarcaCarnetpthisSolicitudInstance(Solicitud solicitudmodMarcaCarnetpthisSolicitud) {
        this.solicitudmodMarcaCarnetpthisSolicitudInstance = solicitudmodMarcaCarnetpthisSolicitud;
        this.solicitudmodMarcaCarnetpthisSolicitud = solicitudmodMarcaCarnetpthisSolicitud != null ? solicitudmodMarcaCarnetpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudmodMarcaCarnetpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudmodMarcaCarnetpthisSolicitudInstance() == null || this.getSolicitudmodMarcaCarnetpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_MODMARCACARNET, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_MODMARCACARNET_SOLICITUDMODMARCACARNETPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_MODMARCACARNET, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_MODMARCACARNET_SOLICITUDMODMARCACARNETPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudmodMarcaCarnetpeMarcaCarnet() {
        return this.solicitudmodMarcaCarnetpeMarcaCarnet;
    }
    
    public void setSolicitudmodMarcaCarnetpeMarcaCarnet(Boolean solicitudmodMarcaCarnetpeMarcaCarnet) {
        this.solicitudmodMarcaCarnetpeMarcaCarnet = solicitudmodMarcaCarnetpeMarcaCarnet;
    }

    private void checkSolicitudmodMarcaCarnetpeMarcaCarnet() throws NotNullArgumentException {
        if(this.getSolicitudmodMarcaCarnetpeMarcaCarnet() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_MODMARCACARNET, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_MODMARCACARNET_SOLICITUDMODMARCACARNETPEMARCACARNET, SolicitudConstants.SERV_ALIAS_MODMARCACARNET, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_MODMARCACARNET_SOLICITUDMODMARCACARNETPEMARCACARNET);
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
