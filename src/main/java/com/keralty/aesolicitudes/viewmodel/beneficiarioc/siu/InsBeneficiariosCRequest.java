package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsBeneficiariosCRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCInsBeneficiariosCpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid beneficiarioCInsBeneficiariosCpevcPersonaC;
    
    @JsonIgnore
    private PersonaC beneficiarioCInsBeneficiariosCpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCInsBeneficiariosCpthisBeneficiarioC();
        checkBeneficiarioCInsBeneficiariosCpevcPersonaC();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCInsBeneficiariosCpthisBeneficiarioC() {
        return this.beneficiarioCInsBeneficiariosCpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCInsBeneficiariosCpthisBeneficiarioC(BeneficiarioCOid beneficiarioCInsBeneficiariosCpthisBeneficiarioC) {
        this.beneficiarioCInsBeneficiariosCpthisBeneficiarioC = beneficiarioCInsBeneficiariosCpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance() {
        return this.beneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCInsBeneficiariosCpthisBeneficiarioC) {
        this.beneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance = beneficiarioCInsBeneficiariosCpthisBeneficiarioC;
        this.beneficiarioCInsBeneficiariosCpthisBeneficiarioC = beneficiarioCInsBeneficiariosCpthisBeneficiarioC != null ? beneficiarioCInsBeneficiariosCpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCInsBeneficiariosCpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance() == null || this.getBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_INSBENEFICIARIOSC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_INSBENEFICIARIOSC_BENEFICIARIOCINSBENEFICIARIOSCPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_INSBENEFICIARIOSC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_INSBENEFICIARIOSC_BENEFICIARIOCINSBENEFICIARIOSCPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public PersonaCOid getBeneficiarioCInsBeneficiariosCpevcPersonaC() {
        return this.beneficiarioCInsBeneficiariosCpevcPersonaC;
    }
    
    public void setBeneficiarioCInsBeneficiariosCpevcPersonaC(PersonaCOid beneficiarioCInsBeneficiariosCpevcPersonaC) {
        this.beneficiarioCInsBeneficiariosCpevcPersonaC = beneficiarioCInsBeneficiariosCpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getBeneficiarioCInsBeneficiariosCpevcPersonaCInstance() {
        return this.beneficiarioCInsBeneficiariosCpevcPersonaCInstance;
    }
    
    public void setBeneficiarioCInsBeneficiariosCpevcPersonaCInstance(PersonaC beneficiarioCInsBeneficiariosCpevcPersonaC) {
        this.beneficiarioCInsBeneficiariosCpevcPersonaCInstance = beneficiarioCInsBeneficiariosCpevcPersonaC;
        this.beneficiarioCInsBeneficiariosCpevcPersonaC = beneficiarioCInsBeneficiariosCpevcPersonaC != null ? beneficiarioCInsBeneficiariosCpevcPersonaC.getOid() : null;
    }

    private void checkBeneficiarioCInsBeneficiariosCpevcPersonaC() throws NotNullArgumentException {
        if(this.getBeneficiarioCInsBeneficiariosCpevcPersonaCInstance() == null || this.getBeneficiarioCInsBeneficiariosCpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_INSBENEFICIARIOSC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_INSBENEFICIARIOSC_BENEFICIARIOCINSBENEFICIARIOSCPEVCPERSONAC, BeneficiarioCConstants.SERV_ALIAS_INSBENEFICIARIOSC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_INSBENEFICIARIOSC_BENEFICIARIOCINSBENEFICIARIOSCPEVCPERSONAC);
        }
    }
}
