package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsBeneficiariosCRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCInsBeneficiariosCpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCInsBeneficiariosCpthisPersonaCInstance;

    @JsonProperty("p_evcbeneficiarioc_oid")
    private BeneficiarioCOid personaCInsBeneficiariosCpevcBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC personaCInsBeneficiariosCpevcBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCInsBeneficiariosCpthisPersonaC();
        checkPersonaCInsBeneficiariosCpevcBeneficiarioC();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCInsBeneficiariosCpthisPersonaC() {
        return this.personaCInsBeneficiariosCpthisPersonaC;
    }
    
    public void setPersonaCInsBeneficiariosCpthisPersonaC(PersonaCOid personaCInsBeneficiariosCpthisPersonaC) {
        this.personaCInsBeneficiariosCpthisPersonaC = personaCInsBeneficiariosCpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCInsBeneficiariosCpthisPersonaCInstance() {
        return this.personaCInsBeneficiariosCpthisPersonaCInstance;
    }
    
    public void setPersonaCInsBeneficiariosCpthisPersonaCInstance(PersonaC personaCInsBeneficiariosCpthisPersonaC) {
        this.personaCInsBeneficiariosCpthisPersonaCInstance = personaCInsBeneficiariosCpthisPersonaC;
        this.personaCInsBeneficiariosCpthisPersonaC = personaCInsBeneficiariosCpthisPersonaC != null ? personaCInsBeneficiariosCpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCInsBeneficiariosCpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCInsBeneficiariosCpthisPersonaCInstance() == null || this.getPersonaCInsBeneficiariosCpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSBENEFICIARIOSC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSBENEFICIARIOSC_PERSONACINSBENEFICIARIOSCPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_INSBENEFICIARIOSC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSBENEFICIARIOSC_PERSONACINSBENEFICIARIOSCPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getPersonaCInsBeneficiariosCpevcBeneficiarioC() {
        return this.personaCInsBeneficiariosCpevcBeneficiarioC;
    }
    
    public void setPersonaCInsBeneficiariosCpevcBeneficiarioC(BeneficiarioCOid personaCInsBeneficiariosCpevcBeneficiarioC) {
        this.personaCInsBeneficiariosCpevcBeneficiarioC = personaCInsBeneficiariosCpevcBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getPersonaCInsBeneficiariosCpevcBeneficiarioCInstance() {
        return this.personaCInsBeneficiariosCpevcBeneficiarioCInstance;
    }
    
    public void setPersonaCInsBeneficiariosCpevcBeneficiarioCInstance(BeneficiarioC personaCInsBeneficiariosCpevcBeneficiarioC) {
        this.personaCInsBeneficiariosCpevcBeneficiarioCInstance = personaCInsBeneficiariosCpevcBeneficiarioC;
        this.personaCInsBeneficiariosCpevcBeneficiarioC = personaCInsBeneficiariosCpevcBeneficiarioC != null ? personaCInsBeneficiariosCpevcBeneficiarioC.getOid() : null;
    }

    private void checkPersonaCInsBeneficiariosCpevcBeneficiarioC() throws NotNullArgumentException {
        if(this.getPersonaCInsBeneficiariosCpevcBeneficiarioCInstance() == null || this.getPersonaCInsBeneficiariosCpevcBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSBENEFICIARIOSC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSBENEFICIARIOSC_PERSONACINSBENEFICIARIOSCPEVCBENEFICIARIOC, PersonaCConstants.SERV_ALIAS_INSBENEFICIARIOSC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSBENEFICIARIOSC_PERSONACINSBENEFICIARIOSCPEVCBENEFICIARIOC);
        }
    }
}
