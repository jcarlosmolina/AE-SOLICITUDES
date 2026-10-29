package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TNEWCONTRADESDEAERequest {

    @JsonProperty("ptsolicitud_oid")
    private SolicitudOid personaCTNEWCONTRADESDEAEptSolicitud;
    
    @JsonIgnore
    private Solicitud personaCTNEWCONTRADESDEAEptSolicitudInstance;

    @JsonProperty("ptcontrato_oid")
    private ContratoCOid personaCTNEWCONTRADESDEAEptContrato;
    
    @JsonIgnore
    private ContratoC personaCTNEWCONTRADESDEAEptContratoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCTNEWCONTRADESDEAEptSolicitud();
        checkPersonaCTNEWCONTRADESDEAEptContrato();
    }

    @JsonIgnore
    public SolicitudOid getPersonaCTNEWCONTRADESDEAEptSolicitud() {
        return this.personaCTNEWCONTRADESDEAEptSolicitud;
    }
    
    public void setPersonaCTNEWCONTRADESDEAEptSolicitud(SolicitudOid personaCTNEWCONTRADESDEAEptSolicitud) {
        this.personaCTNEWCONTRADESDEAEptSolicitud = personaCTNEWCONTRADESDEAEptSolicitud;
    }

    @JsonIgnore
    public Solicitud getPersonaCTNEWCONTRADESDEAEptSolicitudInstance() {
        return this.personaCTNEWCONTRADESDEAEptSolicitudInstance;
    }
    
    public void setPersonaCTNEWCONTRADESDEAEptSolicitudInstance(Solicitud personaCTNEWCONTRADESDEAEptSolicitud) {
        this.personaCTNEWCONTRADESDEAEptSolicitudInstance = personaCTNEWCONTRADESDEAEptSolicitud;
        this.personaCTNEWCONTRADESDEAEptSolicitud = personaCTNEWCONTRADESDEAEptSolicitud != null ? personaCTNEWCONTRADESDEAEptSolicitud.getOid() : null;
    }

    private void checkPersonaCTNEWCONTRADESDEAEptSolicitud() throws NotNullArgumentException {
        if(this.getPersonaCTNEWCONTRADESDEAEptSolicitudInstance() == null || this.getPersonaCTNEWCONTRADESDEAEptSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TNEWCONTRADESDEAE, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD, PersonaCConstants.SERV_ALIAS_TNEWCONTRADESDEAE, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD);
        }
    }

    @JsonIgnore
    public ContratoCOid getPersonaCTNEWCONTRADESDEAEptContrato() {
        return this.personaCTNEWCONTRADESDEAEptContrato;
    }
    
    public void setPersonaCTNEWCONTRADESDEAEptContrato(ContratoCOid personaCTNEWCONTRADESDEAEptContrato) {
        this.personaCTNEWCONTRADESDEAEptContrato = personaCTNEWCONTRADESDEAEptContrato;
    }

    @JsonIgnore
    public ContratoC getPersonaCTNEWCONTRADESDEAEptContratoInstance() {
        return this.personaCTNEWCONTRADESDEAEptContratoInstance;
    }
    
    public void setPersonaCTNEWCONTRADESDEAEptContratoInstance(ContratoC personaCTNEWCONTRADESDEAEptContrato) {
        this.personaCTNEWCONTRADESDEAEptContratoInstance = personaCTNEWCONTRADESDEAEptContrato;
        this.personaCTNEWCONTRADESDEAEptContrato = personaCTNEWCONTRADESDEAEptContrato != null ? personaCTNEWCONTRADESDEAEptContrato.getOid() : null;
    }

    private void checkPersonaCTNEWCONTRADESDEAEptContrato() throws NotNullArgumentException {
        if(this.getPersonaCTNEWCONTRADESDEAEptContratoInstance() == null || this.getPersonaCTNEWCONTRADESDEAEptContratoInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TNEWCONTRADESDEAE, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTCONTRATO, PersonaCConstants.SERV_ALIAS_TNEWCONTRADESDEAE, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTCONTRATO);
        }
    }
}
