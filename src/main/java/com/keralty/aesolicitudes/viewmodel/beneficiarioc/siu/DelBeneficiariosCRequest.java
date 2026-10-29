package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class DelBeneficiariosCRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCDelBeneficiariosCpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCDelBeneficiariosCpthisBeneficiarioCInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid beneficiarioCDelBeneficiariosCpevcPersonaC;
    
    @JsonIgnore
    private PersonaC beneficiarioCDelBeneficiariosCpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCDelBeneficiariosCpthisBeneficiarioC();
        checkBeneficiarioCDelBeneficiariosCpevcPersonaC();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCDelBeneficiariosCpthisBeneficiarioC() {
        return this.beneficiarioCDelBeneficiariosCpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCDelBeneficiariosCpthisBeneficiarioC(BeneficiarioCOid beneficiarioCDelBeneficiariosCpthisBeneficiarioC) {
        this.beneficiarioCDelBeneficiariosCpthisBeneficiarioC = beneficiarioCDelBeneficiariosCpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCDelBeneficiariosCpthisBeneficiarioCInstance() {
        return this.beneficiarioCDelBeneficiariosCpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCDelBeneficiariosCpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCDelBeneficiariosCpthisBeneficiarioC) {
        this.beneficiarioCDelBeneficiariosCpthisBeneficiarioCInstance = beneficiarioCDelBeneficiariosCpthisBeneficiarioC;
        this.beneficiarioCDelBeneficiariosCpthisBeneficiarioC = beneficiarioCDelBeneficiariosCpthisBeneficiarioC != null ? beneficiarioCDelBeneficiariosCpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCDelBeneficiariosCpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCDelBeneficiariosCpthisBeneficiarioCInstance() == null || this.getBeneficiarioCDelBeneficiariosCpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_DELBENEFICIARIOSC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_DELBENEFICIARIOSC_BENEFICIARIOCDELBENEFICIARIOSCPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_DELBENEFICIARIOSC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_DELBENEFICIARIOSC_BENEFICIARIOCDELBENEFICIARIOSCPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public PersonaCOid getBeneficiarioCDelBeneficiariosCpevcPersonaC() {
        return this.beneficiarioCDelBeneficiariosCpevcPersonaC;
    }
    
    public void setBeneficiarioCDelBeneficiariosCpevcPersonaC(PersonaCOid beneficiarioCDelBeneficiariosCpevcPersonaC) {
        this.beneficiarioCDelBeneficiariosCpevcPersonaC = beneficiarioCDelBeneficiariosCpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getBeneficiarioCDelBeneficiariosCpevcPersonaCInstance() {
        return this.beneficiarioCDelBeneficiariosCpevcPersonaCInstance;
    }
    
    public void setBeneficiarioCDelBeneficiariosCpevcPersonaCInstance(PersonaC beneficiarioCDelBeneficiariosCpevcPersonaC) {
        this.beneficiarioCDelBeneficiariosCpevcPersonaCInstance = beneficiarioCDelBeneficiariosCpevcPersonaC;
        this.beneficiarioCDelBeneficiariosCpevcPersonaC = beneficiarioCDelBeneficiariosCpevcPersonaC != null ? beneficiarioCDelBeneficiariosCpevcPersonaC.getOid() : null;
    }

    private void checkBeneficiarioCDelBeneficiariosCpevcPersonaC() throws NotNullArgumentException {
        if(this.getBeneficiarioCDelBeneficiariosCpevcPersonaCInstance() == null || this.getBeneficiarioCDelBeneficiariosCpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_DELBENEFICIARIOSC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_DELBENEFICIARIOSC_BENEFICIARIOCDELBENEFICIARIOSCPEVCPERSONAC, BeneficiarioCConstants.SERV_ALIAS_DELBENEFICIARIOSC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_DELBENEFICIARIOSC_BENEFICIARIOCDELBENEFICIARIOSCPEVCPERSONAC);
        }
    }
}
