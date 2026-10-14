package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;

public class TELIMINARRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCTELIMINARpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCTELIMINARpthisBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCTELIMINARpthisBeneficiarioC();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCTELIMINARpthisBeneficiarioC() {
        return this.beneficiarioCTELIMINARpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCTELIMINARpthisBeneficiarioC(BeneficiarioCOid beneficiarioCTELIMINARpthisBeneficiarioC) {
        this.beneficiarioCTELIMINARpthisBeneficiarioC = beneficiarioCTELIMINARpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCTELIMINARpthisBeneficiarioCInstance() {
        return this.beneficiarioCTELIMINARpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCTELIMINARpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCTELIMINARpthisBeneficiarioC) {
        this.beneficiarioCTELIMINARpthisBeneficiarioCInstance = beneficiarioCTELIMINARpthisBeneficiarioC;
        this.beneficiarioCTELIMINARpthisBeneficiarioC = beneficiarioCTELIMINARpthisBeneficiarioC != null ? beneficiarioCTELIMINARpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCTELIMINARpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCTELIMINARpthisBeneficiarioCInstance() == null || this.getBeneficiarioCTELIMINARpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TELIMINAR, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TELIMINAR_BENEFICIARIOCTELIMINARPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_TELIMINAR, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TELIMINAR_BENEFICIARIOCTELIMINARPTHISBENEFICIARIOC);
        }
    }
}
