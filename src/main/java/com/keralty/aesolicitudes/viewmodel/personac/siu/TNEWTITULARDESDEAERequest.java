package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TNEWTITULARDESDEAERequest {

    @JsonProperty("ptsolicitud_oid")
    private SolicitudOid personaCTNEWTITULARDESDEAEptSolicitud;
    
    @JsonIgnore
    private Solicitud personaCTNEWTITULARDESDEAEptSolicitudInstance;

    @JsonProperty("ptfamiliac_oid")
    private FamiliaCOid personaCTNEWTITULARDESDEAEptFamiliaC;
    
    @JsonIgnore
    private FamiliaC personaCTNEWTITULARDESDEAEptFamiliaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCTNEWTITULARDESDEAEptSolicitud();
        checkPersonaCTNEWTITULARDESDEAEptFamiliaC();
    }

    @JsonIgnore
    public SolicitudOid getPersonaCTNEWTITULARDESDEAEptSolicitud() {
        return this.personaCTNEWTITULARDESDEAEptSolicitud;
    }
    
    public void setPersonaCTNEWTITULARDESDEAEptSolicitud(SolicitudOid personaCTNEWTITULARDESDEAEptSolicitud) {
        this.personaCTNEWTITULARDESDEAEptSolicitud = personaCTNEWTITULARDESDEAEptSolicitud;
    }

    @JsonIgnore
    public Solicitud getPersonaCTNEWTITULARDESDEAEptSolicitudInstance() {
        return this.personaCTNEWTITULARDESDEAEptSolicitudInstance;
    }
    
    public void setPersonaCTNEWTITULARDESDEAEptSolicitudInstance(Solicitud personaCTNEWTITULARDESDEAEptSolicitud) {
        this.personaCTNEWTITULARDESDEAEptSolicitudInstance = personaCTNEWTITULARDESDEAEptSolicitud;
        this.personaCTNEWTITULARDESDEAEptSolicitud = personaCTNEWTITULARDESDEAEptSolicitud != null ? personaCTNEWTITULARDESDEAEptSolicitud.getOid() : null;
    }

    private void checkPersonaCTNEWTITULARDESDEAEptSolicitud() throws NotNullArgumentException {
        if(this.getPersonaCTNEWTITULARDESDEAEptSolicitudInstance() == null || this.getPersonaCTNEWTITULARDESDEAEptSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TNEWTITULARDESDEAE, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD, PersonaCConstants.SERV_ALIAS_TNEWTITULARDESDEAE, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD);
        }
    }

    @JsonIgnore
    public FamiliaCOid getPersonaCTNEWTITULARDESDEAEptFamiliaC() {
        return this.personaCTNEWTITULARDESDEAEptFamiliaC;
    }
    
    public void setPersonaCTNEWTITULARDESDEAEptFamiliaC(FamiliaCOid personaCTNEWTITULARDESDEAEptFamiliaC) {
        this.personaCTNEWTITULARDESDEAEptFamiliaC = personaCTNEWTITULARDESDEAEptFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getPersonaCTNEWTITULARDESDEAEptFamiliaCInstance() {
        return this.personaCTNEWTITULARDESDEAEptFamiliaCInstance;
    }
    
    public void setPersonaCTNEWTITULARDESDEAEptFamiliaCInstance(FamiliaC personaCTNEWTITULARDESDEAEptFamiliaC) {
        this.personaCTNEWTITULARDESDEAEptFamiliaCInstance = personaCTNEWTITULARDESDEAEptFamiliaC;
        this.personaCTNEWTITULARDESDEAEptFamiliaC = personaCTNEWTITULARDESDEAEptFamiliaC != null ? personaCTNEWTITULARDESDEAEptFamiliaC.getOid() : null;
    }

    private void checkPersonaCTNEWTITULARDESDEAEptFamiliaC() throws NotNullArgumentException {
        if(this.getPersonaCTNEWTITULARDESDEAEptFamiliaCInstance() == null || this.getPersonaCTNEWTITULARDESDEAEptFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TNEWTITULARDESDEAE, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTFAMILIAC, PersonaCConstants.SERV_ALIAS_TNEWTITULARDESDEAE, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTFAMILIAC);
        }
    }
}
