package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class DelPersonaCTitularRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCDelPersonaCTitularpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCDelPersonaCTitularpthisPersonaCInstance;

    @JsonProperty("p_evcfamiliac_oid")
    private FamiliaCOid personaCDelPersonaCTitularpevcFamiliaC;
    
    @JsonIgnore
    private FamiliaC personaCDelPersonaCTitularpevcFamiliaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCDelPersonaCTitularpthisPersonaC();
        checkPersonaCDelPersonaCTitularpevcFamiliaC();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCDelPersonaCTitularpthisPersonaC() {
        return this.personaCDelPersonaCTitularpthisPersonaC;
    }
    
    public void setPersonaCDelPersonaCTitularpthisPersonaC(PersonaCOid personaCDelPersonaCTitularpthisPersonaC) {
        this.personaCDelPersonaCTitularpthisPersonaC = personaCDelPersonaCTitularpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCDelPersonaCTitularpthisPersonaCInstance() {
        return this.personaCDelPersonaCTitularpthisPersonaCInstance;
    }
    
    public void setPersonaCDelPersonaCTitularpthisPersonaCInstance(PersonaC personaCDelPersonaCTitularpthisPersonaC) {
        this.personaCDelPersonaCTitularpthisPersonaCInstance = personaCDelPersonaCTitularpthisPersonaC;
        this.personaCDelPersonaCTitularpthisPersonaC = personaCDelPersonaCTitularpthisPersonaC != null ? personaCDelPersonaCTitularpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCDelPersonaCTitularpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCDelPersonaCTitularpthisPersonaCInstance() == null || this.getPersonaCDelPersonaCTitularpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_DELPERSONACTITULAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_DELPERSONACTITULAR_PERSONACDELPERSONACTITULARPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_DELPERSONACTITULAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_DELPERSONACTITULAR_PERSONACDELPERSONACTITULARPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public FamiliaCOid getPersonaCDelPersonaCTitularpevcFamiliaC() {
        return this.personaCDelPersonaCTitularpevcFamiliaC;
    }
    
    public void setPersonaCDelPersonaCTitularpevcFamiliaC(FamiliaCOid personaCDelPersonaCTitularpevcFamiliaC) {
        this.personaCDelPersonaCTitularpevcFamiliaC = personaCDelPersonaCTitularpevcFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getPersonaCDelPersonaCTitularpevcFamiliaCInstance() {
        return this.personaCDelPersonaCTitularpevcFamiliaCInstance;
    }
    
    public void setPersonaCDelPersonaCTitularpevcFamiliaCInstance(FamiliaC personaCDelPersonaCTitularpevcFamiliaC) {
        this.personaCDelPersonaCTitularpevcFamiliaCInstance = personaCDelPersonaCTitularpevcFamiliaC;
        this.personaCDelPersonaCTitularpevcFamiliaC = personaCDelPersonaCTitularpevcFamiliaC != null ? personaCDelPersonaCTitularpevcFamiliaC.getOid() : null;
    }

    private void checkPersonaCDelPersonaCTitularpevcFamiliaC() throws NotNullArgumentException {
        if(this.getPersonaCDelPersonaCTitularpevcFamiliaCInstance() == null || this.getPersonaCDelPersonaCTitularpevcFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_DELPERSONACTITULAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_DELPERSONACTITULAR_PERSONACDELPERSONACTITULARPEVCFAMILIAC, PersonaCConstants.SERV_ALIAS_DELPERSONACTITULAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_DELPERSONACTITULAR_PERSONACDELPERSONACTITULARPEVCFAMILIAC);
        }
    }
}
