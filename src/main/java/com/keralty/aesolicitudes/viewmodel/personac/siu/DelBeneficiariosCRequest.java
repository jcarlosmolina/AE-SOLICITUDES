package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class DelBeneficiariosCRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCDelBeneficiariosCpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCDelBeneficiariosCpthisPersonaCInstance;

    @JsonProperty("p_evcbeneficiarioc_oid")
    private BeneficiarioCOid personaCDelBeneficiariosCpevcBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC personaCDelBeneficiariosCpevcBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCDelBeneficiariosCpthisPersonaC();
        checkPersonaCDelBeneficiariosCpevcBeneficiarioC();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCDelBeneficiariosCpthisPersonaC() {
        return this.personaCDelBeneficiariosCpthisPersonaC;
    }
    
    public void setPersonaCDelBeneficiariosCpthisPersonaC(PersonaCOid personaCDelBeneficiariosCpthisPersonaC) {
        this.personaCDelBeneficiariosCpthisPersonaC = personaCDelBeneficiariosCpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCDelBeneficiariosCpthisPersonaCInstance() {
        return this.personaCDelBeneficiariosCpthisPersonaCInstance;
    }
    
    public void setPersonaCDelBeneficiariosCpthisPersonaCInstance(PersonaC personaCDelBeneficiariosCpthisPersonaC) {
        this.personaCDelBeneficiariosCpthisPersonaCInstance = personaCDelBeneficiariosCpthisPersonaC;
        this.personaCDelBeneficiariosCpthisPersonaC = personaCDelBeneficiariosCpthisPersonaC != null ? personaCDelBeneficiariosCpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCDelBeneficiariosCpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCDelBeneficiariosCpthisPersonaCInstance() == null || this.getPersonaCDelBeneficiariosCpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_DELBENEFICIARIOSC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_DELBENEFICIARIOSC_PERSONACDELBENEFICIARIOSCPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_DELBENEFICIARIOSC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_DELBENEFICIARIOSC_PERSONACDELBENEFICIARIOSCPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getPersonaCDelBeneficiariosCpevcBeneficiarioC() {
        return this.personaCDelBeneficiariosCpevcBeneficiarioC;
    }
    
    public void setPersonaCDelBeneficiariosCpevcBeneficiarioC(BeneficiarioCOid personaCDelBeneficiariosCpevcBeneficiarioC) {
        this.personaCDelBeneficiariosCpevcBeneficiarioC = personaCDelBeneficiariosCpevcBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getPersonaCDelBeneficiariosCpevcBeneficiarioCInstance() {
        return this.personaCDelBeneficiariosCpevcBeneficiarioCInstance;
    }
    
    public void setPersonaCDelBeneficiariosCpevcBeneficiarioCInstance(BeneficiarioC personaCDelBeneficiariosCpevcBeneficiarioC) {
        this.personaCDelBeneficiariosCpevcBeneficiarioCInstance = personaCDelBeneficiariosCpevcBeneficiarioC;
        this.personaCDelBeneficiariosCpevcBeneficiarioC = personaCDelBeneficiariosCpevcBeneficiarioC != null ? personaCDelBeneficiariosCpevcBeneficiarioC.getOid() : null;
    }

    private void checkPersonaCDelBeneficiariosCpevcBeneficiarioC() throws NotNullArgumentException {
        if(this.getPersonaCDelBeneficiariosCpevcBeneficiarioCInstance() == null || this.getPersonaCDelBeneficiariosCpevcBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_DELBENEFICIARIOSC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_DELBENEFICIARIOSC_PERSONACDELBENEFICIARIOSCPEVCBENEFICIARIOC, PersonaCConstants.SERV_ALIAS_DELBENEFICIARIOSC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_DELBENEFICIARIOSC_PERSONACDELBENEFICIARIOSCPEVCBENEFICIARIOC);
        }
    }
}
