package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.CuestionarioP;
import com.keralty.aesolicitudes.persistence.oid.CuestionarioPOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class TCREAROCUESDEAERequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCTCREAROCUESDEAEpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCTCREAROCUESDEAEpthisPersonaCInstance;

    @JsonProperty("p_cuestionariop_oid")
    private CuestionarioPOid personaCTCREAROCUESDEAEpCuestionarioP;
    
    @JsonIgnore
    private CuestionarioP personaCTCREAROCUESDEAEpCuestionarioPInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCTCREAROCUESDEAEpthisPersonaC();
        checkPersonaCTCREAROCUESDEAEpCuestionarioP();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCTCREAROCUESDEAEpthisPersonaC() {
        return this.personaCTCREAROCUESDEAEpthisPersonaC;
    }
    
    public void setPersonaCTCREAROCUESDEAEpthisPersonaC(PersonaCOid personaCTCREAROCUESDEAEpthisPersonaC) {
        this.personaCTCREAROCUESDEAEpthisPersonaC = personaCTCREAROCUESDEAEpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCTCREAROCUESDEAEpthisPersonaCInstance() {
        return this.personaCTCREAROCUESDEAEpthisPersonaCInstance;
    }
    
    public void setPersonaCTCREAROCUESDEAEpthisPersonaCInstance(PersonaC personaCTCREAROCUESDEAEpthisPersonaC) {
        this.personaCTCREAROCUESDEAEpthisPersonaCInstance = personaCTCREAROCUESDEAEpthisPersonaC;
        this.personaCTCREAROCUESDEAEpthisPersonaC = personaCTCREAROCUESDEAEpthisPersonaC != null ? personaCTCREAROCUESDEAEpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCTCREAROCUESDEAEpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCTCREAROCUESDEAEpthisPersonaCInstance() == null || this.getPersonaCTCREAROCUESDEAEpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TCREAROCUESDEAE, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TCREAROCUESDEAE_PERSONACTCREAROCUESDEAEPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_TCREAROCUESDEAE, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TCREAROCUESDEAE_PERSONACTCREAROCUESDEAEPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public CuestionarioPOid getPersonaCTCREAROCUESDEAEpCuestionarioP() {
        return this.personaCTCREAROCUESDEAEpCuestionarioP;
    }
    
    public void setPersonaCTCREAROCUESDEAEpCuestionarioP(CuestionarioPOid personaCTCREAROCUESDEAEpCuestionarioP) {
        this.personaCTCREAROCUESDEAEpCuestionarioP = personaCTCREAROCUESDEAEpCuestionarioP;
    }

    @JsonIgnore
    public CuestionarioP getPersonaCTCREAROCUESDEAEpCuestionarioPInstance() {
        return this.personaCTCREAROCUESDEAEpCuestionarioPInstance;
    }
    
    public void setPersonaCTCREAROCUESDEAEpCuestionarioPInstance(CuestionarioP personaCTCREAROCUESDEAEpCuestionarioP) {
        this.personaCTCREAROCUESDEAEpCuestionarioPInstance = personaCTCREAROCUESDEAEpCuestionarioP;
        this.personaCTCREAROCUESDEAEpCuestionarioP = personaCTCREAROCUESDEAEpCuestionarioP != null ? personaCTCREAROCUESDEAEpCuestionarioP.getOid() : null;
    }

    private void checkPersonaCTCREAROCUESDEAEpCuestionarioP() throws NotNullArgumentException {
        if(this.getPersonaCTCREAROCUESDEAEpCuestionarioPInstance() == null || this.getPersonaCTCREAROCUESDEAEpCuestionarioPInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TCREAROCUESDEAE, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TCREAROCUESDEAE_PERSONACTCREAROCUESDEAEPCUESTIONARIOP, PersonaCConstants.SERV_ALIAS_TCREAROCUESDEAE, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TCREAROCUESDEAE_PERSONACTCREAROCUESDEAEPCUESTIONARIOP);
        }
    }
}
