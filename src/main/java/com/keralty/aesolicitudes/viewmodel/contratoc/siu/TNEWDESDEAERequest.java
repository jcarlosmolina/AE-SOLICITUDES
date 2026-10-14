package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TNEWDESDEAERequest {

    @JsonProperty("ptsolicitud_oid")
    private SolicitudOid contratoCTNEWDESDEAEptSolicitud;
    
    @JsonIgnore
    private Solicitud contratoCTNEWDESDEAEptSolicitudInstance;

    @JsonProperty("ptnumfamiliacore")
    private String contratoCTNEWDESDEAEptNumFamiliaCORE;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCTNEWDESDEAEptSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getContratoCTNEWDESDEAEptSolicitud() {
        return this.contratoCTNEWDESDEAEptSolicitud;
    }
    
    public void setContratoCTNEWDESDEAEptSolicitud(SolicitudOid contratoCTNEWDESDEAEptSolicitud) {
        this.contratoCTNEWDESDEAEptSolicitud = contratoCTNEWDESDEAEptSolicitud;
    }

    @JsonIgnore
    public Solicitud getContratoCTNEWDESDEAEptSolicitudInstance() {
        return this.contratoCTNEWDESDEAEptSolicitudInstance;
    }
    
    public void setContratoCTNEWDESDEAEptSolicitudInstance(Solicitud contratoCTNEWDESDEAEptSolicitud) {
        this.contratoCTNEWDESDEAEptSolicitudInstance = contratoCTNEWDESDEAEptSolicitud;
        this.contratoCTNEWDESDEAEptSolicitud = contratoCTNEWDESDEAEptSolicitud != null ? contratoCTNEWDESDEAEptSolicitud.getOid() : null;
    }

    private void checkContratoCTNEWDESDEAEptSolicitud() throws NotNullArgumentException {
        if(this.getContratoCTNEWDESDEAEptSolicitudInstance() == null || this.getContratoCTNEWDESDEAEptSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TNEWDESDEAE, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TNEWDESDEAE_CONTRATOCTNEWDESDEAEPTSOLICITUD, ContratoCConstants.SERV_ALIAS_TNEWDESDEAE, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TNEWDESDEAE_CONTRATOCTNEWDESDEAEPTSOLICITUD);
        }
    }

    @JsonIgnore
    public String getContratoCTNEWDESDEAEptNumFamiliaCORE() {
        return this.contratoCTNEWDESDEAEptNumFamiliaCORE;
    }
    
    public void setContratoCTNEWDESDEAEptNumFamiliaCORE(String contratoCTNEWDESDEAEptNumFamiliaCORE) {
        this.contratoCTNEWDESDEAEptNumFamiliaCORE = contratoCTNEWDESDEAEptNumFamiliaCORE;
    }
}
