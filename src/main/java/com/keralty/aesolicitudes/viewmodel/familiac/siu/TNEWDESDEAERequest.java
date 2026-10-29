package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TNEWDESDEAERequest {

    @JsonProperty("ptcontratoc_oid")
    private ContratoCOid familiaCTNEWDESDEAEptContratoC;
    
    @JsonIgnore
    private ContratoC familiaCTNEWDESDEAEptContratoCInstance;

    @JsonProperty("ptsolicitud_oid")
    private SolicitudOid familiaCTNEWDESDEAEptSolicitud;
    
    @JsonIgnore
    private Solicitud familiaCTNEWDESDEAEptSolicitudInstance;

    @JsonProperty("ptnumfamiliacore")
    private String familiaCTNEWDESDEAEptNumFamiliaCORE;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCTNEWDESDEAEptContratoC();
        checkFamiliaCTNEWDESDEAEptSolicitud();
    }

    @JsonIgnore
    public ContratoCOid getFamiliaCTNEWDESDEAEptContratoC() {
        return this.familiaCTNEWDESDEAEptContratoC;
    }
    
    public void setFamiliaCTNEWDESDEAEptContratoC(ContratoCOid familiaCTNEWDESDEAEptContratoC) {
        this.familiaCTNEWDESDEAEptContratoC = familiaCTNEWDESDEAEptContratoC;
    }

    @JsonIgnore
    public ContratoC getFamiliaCTNEWDESDEAEptContratoCInstance() {
        return this.familiaCTNEWDESDEAEptContratoCInstance;
    }
    
    public void setFamiliaCTNEWDESDEAEptContratoCInstance(ContratoC familiaCTNEWDESDEAEptContratoC) {
        this.familiaCTNEWDESDEAEptContratoCInstance = familiaCTNEWDESDEAEptContratoC;
        this.familiaCTNEWDESDEAEptContratoC = familiaCTNEWDESDEAEptContratoC != null ? familiaCTNEWDESDEAEptContratoC.getOid() : null;
    }

    private void checkFamiliaCTNEWDESDEAEptContratoC() throws NotNullArgumentException {
        if(this.getFamiliaCTNEWDESDEAEptContratoCInstance() == null || this.getFamiliaCTNEWDESDEAEptContratoCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_TNEWDESDEAE, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_TNEWDESDEAE_FAMILIACTNEWDESDEAEPTCONTRATOC, FamiliaCConstants.SERV_ALIAS_TNEWDESDEAE, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_TNEWDESDEAE_FAMILIACTNEWDESDEAEPTCONTRATOC);
        }
    }

    @JsonIgnore
    public SolicitudOid getFamiliaCTNEWDESDEAEptSolicitud() {
        return this.familiaCTNEWDESDEAEptSolicitud;
    }
    
    public void setFamiliaCTNEWDESDEAEptSolicitud(SolicitudOid familiaCTNEWDESDEAEptSolicitud) {
        this.familiaCTNEWDESDEAEptSolicitud = familiaCTNEWDESDEAEptSolicitud;
    }

    @JsonIgnore
    public Solicitud getFamiliaCTNEWDESDEAEptSolicitudInstance() {
        return this.familiaCTNEWDESDEAEptSolicitudInstance;
    }
    
    public void setFamiliaCTNEWDESDEAEptSolicitudInstance(Solicitud familiaCTNEWDESDEAEptSolicitud) {
        this.familiaCTNEWDESDEAEptSolicitudInstance = familiaCTNEWDESDEAEptSolicitud;
        this.familiaCTNEWDESDEAEptSolicitud = familiaCTNEWDESDEAEptSolicitud != null ? familiaCTNEWDESDEAEptSolicitud.getOid() : null;
    }

    private void checkFamiliaCTNEWDESDEAEptSolicitud() throws NotNullArgumentException {
        if(this.getFamiliaCTNEWDESDEAEptSolicitudInstance() == null || this.getFamiliaCTNEWDESDEAEptSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_TNEWDESDEAE, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_TNEWDESDEAE_FAMILIACTNEWDESDEAEPTSOLICITUD, FamiliaCConstants.SERV_ALIAS_TNEWDESDEAE, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_TNEWDESDEAE_FAMILIACTNEWDESDEAEPTSOLICITUD);
        }
    }

    @JsonIgnore
    public String getFamiliaCTNEWDESDEAEptNumFamiliaCORE() {
        return this.familiaCTNEWDESDEAEptNumFamiliaCORE;
    }
    
    public void setFamiliaCTNEWDESDEAEptNumFamiliaCORE(String familiaCTNEWDESDEAEptNumFamiliaCORE) {
        this.familiaCTNEWDESDEAEptNumFamiliaCORE = familiaCTNEWDESDEAEptNumFamiliaCORE;
    }
}
