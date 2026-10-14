package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.persistence.oid.EstadoCivilOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsEstadoCivilCRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCInsEstadoCivilCpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCInsEstadoCivilCpthisPersonaCInstance;

    @JsonProperty("p_evcestadocivil_oid")
    private EstadoCivilOid personaCInsEstadoCivilCpevcEstadoCivil;
    
    @JsonIgnore
    private EstadoCivil personaCInsEstadoCivilCpevcEstadoCivilInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCInsEstadoCivilCpthisPersonaC();
        checkPersonaCInsEstadoCivilCpevcEstadoCivil();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCInsEstadoCivilCpthisPersonaC() {
        return this.personaCInsEstadoCivilCpthisPersonaC;
    }
    
    public void setPersonaCInsEstadoCivilCpthisPersonaC(PersonaCOid personaCInsEstadoCivilCpthisPersonaC) {
        this.personaCInsEstadoCivilCpthisPersonaC = personaCInsEstadoCivilCpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCInsEstadoCivilCpthisPersonaCInstance() {
        return this.personaCInsEstadoCivilCpthisPersonaCInstance;
    }
    
    public void setPersonaCInsEstadoCivilCpthisPersonaCInstance(PersonaC personaCInsEstadoCivilCpthisPersonaC) {
        this.personaCInsEstadoCivilCpthisPersonaCInstance = personaCInsEstadoCivilCpthisPersonaC;
        this.personaCInsEstadoCivilCpthisPersonaC = personaCInsEstadoCivilCpthisPersonaC != null ? personaCInsEstadoCivilCpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCInsEstadoCivilCpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCInsEstadoCivilCpthisPersonaCInstance() == null || this.getPersonaCInsEstadoCivilCpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSESTADOCIVILC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSESTADOCIVILC_PERSONACINSESTADOCIVILCPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_INSESTADOCIVILC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSESTADOCIVILC_PERSONACINSESTADOCIVILCPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public EstadoCivilOid getPersonaCInsEstadoCivilCpevcEstadoCivil() {
        return this.personaCInsEstadoCivilCpevcEstadoCivil;
    }
    
    public void setPersonaCInsEstadoCivilCpevcEstadoCivil(EstadoCivilOid personaCInsEstadoCivilCpevcEstadoCivil) {
        this.personaCInsEstadoCivilCpevcEstadoCivil = personaCInsEstadoCivilCpevcEstadoCivil;
    }

    @JsonIgnore
    public EstadoCivil getPersonaCInsEstadoCivilCpevcEstadoCivilInstance() {
        return this.personaCInsEstadoCivilCpevcEstadoCivilInstance;
    }
    
    public void setPersonaCInsEstadoCivilCpevcEstadoCivilInstance(EstadoCivil personaCInsEstadoCivilCpevcEstadoCivil) {
        this.personaCInsEstadoCivilCpevcEstadoCivilInstance = personaCInsEstadoCivilCpevcEstadoCivil;
        this.personaCInsEstadoCivilCpevcEstadoCivil = personaCInsEstadoCivilCpevcEstadoCivil != null ? personaCInsEstadoCivilCpevcEstadoCivil.getOid() : null;
    }

    private void checkPersonaCInsEstadoCivilCpevcEstadoCivil() throws NotNullArgumentException {
        if(this.getPersonaCInsEstadoCivilCpevcEstadoCivilInstance() == null || this.getPersonaCInsEstadoCivilCpevcEstadoCivilInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSESTADOCIVILC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSESTADOCIVILC_PERSONACINSESTADOCIVILCPEVCESTADOCIVIL, PersonaCConstants.SERV_ALIAS_INSESTADOCIVILC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSESTADOCIVILC_PERSONACINSESTADOCIVILCPEVCESTADOCIVIL);
        }
    }
}
