package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class EvalPostNotificarRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCevalPostNotificarpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCevalPostNotificarpthisPersonaCInstance;

    @JsonProperty("penombrecompleto")
    private String personaCevalPostNotificarpeNombreCompleto;

    @JsonProperty("penumident")
    private String personaCevalPostNotificarpeNumIdent;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCevalPostNotificarpthisPersonaC();
        checkPersonaCevalPostNotificarpeNumIdent();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCevalPostNotificarpthisPersonaC() {
        return this.personaCevalPostNotificarpthisPersonaC;
    }
    
    public void setPersonaCevalPostNotificarpthisPersonaC(PersonaCOid personaCevalPostNotificarpthisPersonaC) {
        this.personaCevalPostNotificarpthisPersonaC = personaCevalPostNotificarpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCevalPostNotificarpthisPersonaCInstance() {
        return this.personaCevalPostNotificarpthisPersonaCInstance;
    }
    
    public void setPersonaCevalPostNotificarpthisPersonaCInstance(PersonaC personaCevalPostNotificarpthisPersonaC) {
        this.personaCevalPostNotificarpthisPersonaCInstance = personaCevalPostNotificarpthisPersonaC;
        this.personaCevalPostNotificarpthisPersonaC = personaCevalPostNotificarpthisPersonaC != null ? personaCevalPostNotificarpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCevalPostNotificarpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCevalPostNotificarpthisPersonaCInstance() == null || this.getPersonaCevalPostNotificarpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_EVALPOSTNOTIFICAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_EVALPOSTNOTIFICAR_PERSONACEVALPOSTNOTIFICARPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_EVALPOSTNOTIFICAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_EVALPOSTNOTIFICAR_PERSONACEVALPOSTNOTIFICARPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public String getPersonaCevalPostNotificarpeNombreCompleto() {
        return this.personaCevalPostNotificarpeNombreCompleto;
    }
    
    public void setPersonaCevalPostNotificarpeNombreCompleto(String personaCevalPostNotificarpeNombreCompleto) {
        this.personaCevalPostNotificarpeNombreCompleto = personaCevalPostNotificarpeNombreCompleto;
    }

    @JsonIgnore
    public String getPersonaCevalPostNotificarpeNumIdent() {
        return this.personaCevalPostNotificarpeNumIdent;
    }
    
    public void setPersonaCevalPostNotificarpeNumIdent(String personaCevalPostNotificarpeNumIdent) {
        this.personaCevalPostNotificarpeNumIdent = personaCevalPostNotificarpeNumIdent;
    }

    private void checkPersonaCevalPostNotificarpeNumIdent() throws NotNullArgumentException {
        if(this.getPersonaCevalPostNotificarpeNumIdent() == null) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_EVALPOSTNOTIFICAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_EVALPOSTNOTIFICAR_PERSONACEVALPOSTNOTIFICARPENUMIDENT, PersonaCConstants.SERV_ALIAS_EVALPOSTNOTIFICAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_EVALPOSTNOTIFICAR_PERSONACEVALPOSTNOTIFICARPENUMIDENT);
        }
    }
}
