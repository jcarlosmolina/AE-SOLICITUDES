package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.persistence.oid.EstadoCivilOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class DelEstadoCivilCRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCDelEstadoCivilCpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCDelEstadoCivilCpthisPersonaCInstance;

    @JsonProperty("p_evcestadocivil_oid")
    private EstadoCivilOid personaCDelEstadoCivilCpevcEstadoCivil;
    
    @JsonIgnore
    private EstadoCivil personaCDelEstadoCivilCpevcEstadoCivilInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCDelEstadoCivilCpthisPersonaC();
        checkPersonaCDelEstadoCivilCpevcEstadoCivil();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCDelEstadoCivilCpthisPersonaC() {
        return this.personaCDelEstadoCivilCpthisPersonaC;
    }
    
    public void setPersonaCDelEstadoCivilCpthisPersonaC(PersonaCOid personaCDelEstadoCivilCpthisPersonaC) {
        this.personaCDelEstadoCivilCpthisPersonaC = personaCDelEstadoCivilCpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCDelEstadoCivilCpthisPersonaCInstance() {
        return this.personaCDelEstadoCivilCpthisPersonaCInstance;
    }
    
    public void setPersonaCDelEstadoCivilCpthisPersonaCInstance(PersonaC personaCDelEstadoCivilCpthisPersonaC) {
        this.personaCDelEstadoCivilCpthisPersonaCInstance = personaCDelEstadoCivilCpthisPersonaC;
        this.personaCDelEstadoCivilCpthisPersonaC = personaCDelEstadoCivilCpthisPersonaC != null ? personaCDelEstadoCivilCpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCDelEstadoCivilCpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCDelEstadoCivilCpthisPersonaCInstance() == null || this.getPersonaCDelEstadoCivilCpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_DELESTADOCIVILC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_DELESTADOCIVILC_PERSONACDELESTADOCIVILCPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_DELESTADOCIVILC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_DELESTADOCIVILC_PERSONACDELESTADOCIVILCPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public EstadoCivilOid getPersonaCDelEstadoCivilCpevcEstadoCivil() {
        return this.personaCDelEstadoCivilCpevcEstadoCivil;
    }
    
    public void setPersonaCDelEstadoCivilCpevcEstadoCivil(EstadoCivilOid personaCDelEstadoCivilCpevcEstadoCivil) {
        this.personaCDelEstadoCivilCpevcEstadoCivil = personaCDelEstadoCivilCpevcEstadoCivil;
    }

    @JsonIgnore
    public EstadoCivil getPersonaCDelEstadoCivilCpevcEstadoCivilInstance() {
        return this.personaCDelEstadoCivilCpevcEstadoCivilInstance;
    }
    
    public void setPersonaCDelEstadoCivilCpevcEstadoCivilInstance(EstadoCivil personaCDelEstadoCivilCpevcEstadoCivil) {
        this.personaCDelEstadoCivilCpevcEstadoCivilInstance = personaCDelEstadoCivilCpevcEstadoCivil;
        this.personaCDelEstadoCivilCpevcEstadoCivil = personaCDelEstadoCivilCpevcEstadoCivil != null ? personaCDelEstadoCivilCpevcEstadoCivil.getOid() : null;
    }

    private void checkPersonaCDelEstadoCivilCpevcEstadoCivil() throws NotNullArgumentException {
        if(this.getPersonaCDelEstadoCivilCpevcEstadoCivilInstance() == null || this.getPersonaCDelEstadoCivilCpevcEstadoCivilInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_DELESTADOCIVILC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_DELESTADOCIVILC_PERSONACDELESTADOCIVILCPEVCESTADOCIVIL, PersonaCConstants.SERV_ALIAS_DELESTADOCIVILC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_DELESTADOCIVILC_PERSONACDELESTADOCIVILCPEVCESTADOCIVIL);
        }
    }
}
