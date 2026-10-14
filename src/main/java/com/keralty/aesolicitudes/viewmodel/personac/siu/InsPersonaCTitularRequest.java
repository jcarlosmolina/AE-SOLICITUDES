package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsPersonaCTitularRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCInsPersonaCTitularpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCInsPersonaCTitularpthisPersonaCInstance;

    @JsonProperty("p_evcfamiliac_oid")
    private FamiliaCOid personaCInsPersonaCTitularpevcFamiliaC;
    
    @JsonIgnore
    private FamiliaC personaCInsPersonaCTitularpevcFamiliaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCInsPersonaCTitularpthisPersonaC();
        checkPersonaCInsPersonaCTitularpevcFamiliaC();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCInsPersonaCTitularpthisPersonaC() {
        return this.personaCInsPersonaCTitularpthisPersonaC;
    }
    
    public void setPersonaCInsPersonaCTitularpthisPersonaC(PersonaCOid personaCInsPersonaCTitularpthisPersonaC) {
        this.personaCInsPersonaCTitularpthisPersonaC = personaCInsPersonaCTitularpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCInsPersonaCTitularpthisPersonaCInstance() {
        return this.personaCInsPersonaCTitularpthisPersonaCInstance;
    }
    
    public void setPersonaCInsPersonaCTitularpthisPersonaCInstance(PersonaC personaCInsPersonaCTitularpthisPersonaC) {
        this.personaCInsPersonaCTitularpthisPersonaCInstance = personaCInsPersonaCTitularpthisPersonaC;
        this.personaCInsPersonaCTitularpthisPersonaC = personaCInsPersonaCTitularpthisPersonaC != null ? personaCInsPersonaCTitularpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCInsPersonaCTitularpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCInsPersonaCTitularpthisPersonaCInstance() == null || this.getPersonaCInsPersonaCTitularpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSPERSONACTITULAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSPERSONACTITULAR_PERSONACINSPERSONACTITULARPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_INSPERSONACTITULAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSPERSONACTITULAR_PERSONACINSPERSONACTITULARPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public FamiliaCOid getPersonaCInsPersonaCTitularpevcFamiliaC() {
        return this.personaCInsPersonaCTitularpevcFamiliaC;
    }
    
    public void setPersonaCInsPersonaCTitularpevcFamiliaC(FamiliaCOid personaCInsPersonaCTitularpevcFamiliaC) {
        this.personaCInsPersonaCTitularpevcFamiliaC = personaCInsPersonaCTitularpevcFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getPersonaCInsPersonaCTitularpevcFamiliaCInstance() {
        return this.personaCInsPersonaCTitularpevcFamiliaCInstance;
    }
    
    public void setPersonaCInsPersonaCTitularpevcFamiliaCInstance(FamiliaC personaCInsPersonaCTitularpevcFamiliaC) {
        this.personaCInsPersonaCTitularpevcFamiliaCInstance = personaCInsPersonaCTitularpevcFamiliaC;
        this.personaCInsPersonaCTitularpevcFamiliaC = personaCInsPersonaCTitularpevcFamiliaC != null ? personaCInsPersonaCTitularpevcFamiliaC.getOid() : null;
    }

    private void checkPersonaCInsPersonaCTitularpevcFamiliaC() throws NotNullArgumentException {
        if(this.getPersonaCInsPersonaCTitularpevcFamiliaCInstance() == null || this.getPersonaCInsPersonaCTitularpevcFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSPERSONACTITULAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSPERSONACTITULAR_PERSONACINSPERSONACTITULARPEVCFAMILIAC, PersonaCConstants.SERV_ALIAS_INSPERSONACTITULAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSPERSONACTITULAR_PERSONACINSPERSONACTITULARPEVCFAMILIAC);
        }
    }
}
