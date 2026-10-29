package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.EstadoPersona;
import com.keralty.aesolicitudes.persistence.oid.EstadoPersonaOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsEstadoPersonaCRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCInsEstadoPersonaCpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCInsEstadoPersonaCpthisPersonaCInstance;

    @JsonProperty("p_evcestadopersona_oid")
    private EstadoPersonaOid personaCInsEstadoPersonaCpevcEstadoPersona;
    
    @JsonIgnore
    private EstadoPersona personaCInsEstadoPersonaCpevcEstadoPersonaInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCInsEstadoPersonaCpthisPersonaC();
        checkPersonaCInsEstadoPersonaCpevcEstadoPersona();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCInsEstadoPersonaCpthisPersonaC() {
        return this.personaCInsEstadoPersonaCpthisPersonaC;
    }
    
    public void setPersonaCInsEstadoPersonaCpthisPersonaC(PersonaCOid personaCInsEstadoPersonaCpthisPersonaC) {
        this.personaCInsEstadoPersonaCpthisPersonaC = personaCInsEstadoPersonaCpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCInsEstadoPersonaCpthisPersonaCInstance() {
        return this.personaCInsEstadoPersonaCpthisPersonaCInstance;
    }
    
    public void setPersonaCInsEstadoPersonaCpthisPersonaCInstance(PersonaC personaCInsEstadoPersonaCpthisPersonaC) {
        this.personaCInsEstadoPersonaCpthisPersonaCInstance = personaCInsEstadoPersonaCpthisPersonaC;
        this.personaCInsEstadoPersonaCpthisPersonaC = personaCInsEstadoPersonaCpthisPersonaC != null ? personaCInsEstadoPersonaCpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCInsEstadoPersonaCpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCInsEstadoPersonaCpthisPersonaCInstance() == null || this.getPersonaCInsEstadoPersonaCpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSESTADOPERSONAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSESTADOPERSONAC_PERSONACINSESTADOPERSONACPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_INSESTADOPERSONAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSESTADOPERSONAC_PERSONACINSESTADOPERSONACPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public EstadoPersonaOid getPersonaCInsEstadoPersonaCpevcEstadoPersona() {
        return this.personaCInsEstadoPersonaCpevcEstadoPersona;
    }
    
    public void setPersonaCInsEstadoPersonaCpevcEstadoPersona(EstadoPersonaOid personaCInsEstadoPersonaCpevcEstadoPersona) {
        this.personaCInsEstadoPersonaCpevcEstadoPersona = personaCInsEstadoPersonaCpevcEstadoPersona;
    }

    @JsonIgnore
    public EstadoPersona getPersonaCInsEstadoPersonaCpevcEstadoPersonaInstance() {
        return this.personaCInsEstadoPersonaCpevcEstadoPersonaInstance;
    }
    
    public void setPersonaCInsEstadoPersonaCpevcEstadoPersonaInstance(EstadoPersona personaCInsEstadoPersonaCpevcEstadoPersona) {
        this.personaCInsEstadoPersonaCpevcEstadoPersonaInstance = personaCInsEstadoPersonaCpevcEstadoPersona;
        this.personaCInsEstadoPersonaCpevcEstadoPersona = personaCInsEstadoPersonaCpevcEstadoPersona != null ? personaCInsEstadoPersonaCpevcEstadoPersona.getOid() : null;
    }

    private void checkPersonaCInsEstadoPersonaCpevcEstadoPersona() throws NotNullArgumentException {
        if(this.getPersonaCInsEstadoPersonaCpevcEstadoPersonaInstance() == null || this.getPersonaCInsEstadoPersonaCpevcEstadoPersonaInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSESTADOPERSONAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSESTADOPERSONAC_PERSONACINSESTADOPERSONACPEVCESTADOPERSONA, PersonaCConstants.SERV_ALIAS_INSESTADOPERSONAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSESTADOPERSONAC_PERSONACINSESTADOPERSONACPEVCESTADOPERSONA);
        }
    }
}
