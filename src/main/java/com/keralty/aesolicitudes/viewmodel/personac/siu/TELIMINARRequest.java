package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class TELIMINARRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCTELIMINARpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCTELIMINARpthisPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCTELIMINARpthisPersonaC();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCTELIMINARpthisPersonaC() {
        return this.personaCTELIMINARpthisPersonaC;
    }
    
    public void setPersonaCTELIMINARpthisPersonaC(PersonaCOid personaCTELIMINARpthisPersonaC) {
        this.personaCTELIMINARpthisPersonaC = personaCTELIMINARpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCTELIMINARpthisPersonaCInstance() {
        return this.personaCTELIMINARpthisPersonaCInstance;
    }
    
    public void setPersonaCTELIMINARpthisPersonaCInstance(PersonaC personaCTELIMINARpthisPersonaC) {
        this.personaCTELIMINARpthisPersonaCInstance = personaCTELIMINARpthisPersonaC;
        this.personaCTELIMINARpthisPersonaC = personaCTELIMINARpthisPersonaC != null ? personaCTELIMINARpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCTELIMINARpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCTELIMINARpthisPersonaCInstance() == null || this.getPersonaCTELIMINARpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TELIMINAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TELIMINAR_PERSONACTELIMINARPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_TELIMINAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TELIMINAR_PERSONACTELIMINARPTHISPERSONAC);
        }
    }
}
