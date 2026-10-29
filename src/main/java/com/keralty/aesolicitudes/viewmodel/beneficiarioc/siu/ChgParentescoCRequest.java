package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.ParentescoOid;
import com.keralty.aesolicitudes.persistence.Parentesco;

public class ChgParentescoCRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCchgParentescoCpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCchgParentescoCpthisBeneficiarioCInstance;

    @JsonProperty("p_evcparentesco_oid")
    private ParentescoOid beneficiarioCchgParentescoCpevcParentesco;
    
    @JsonIgnore
    private Parentesco beneficiarioCchgParentescoCpevcParentescoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCchgParentescoCpthisBeneficiarioC();
        checkBeneficiarioCchgParentescoCpevcParentesco();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCchgParentescoCpthisBeneficiarioC() {
        return this.beneficiarioCchgParentescoCpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCchgParentescoCpthisBeneficiarioC(BeneficiarioCOid beneficiarioCchgParentescoCpthisBeneficiarioC) {
        this.beneficiarioCchgParentescoCpthisBeneficiarioC = beneficiarioCchgParentescoCpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCchgParentescoCpthisBeneficiarioCInstance() {
        return this.beneficiarioCchgParentescoCpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCchgParentescoCpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCchgParentescoCpthisBeneficiarioC) {
        this.beneficiarioCchgParentescoCpthisBeneficiarioCInstance = beneficiarioCchgParentescoCpthisBeneficiarioC;
        this.beneficiarioCchgParentescoCpthisBeneficiarioC = beneficiarioCchgParentescoCpthisBeneficiarioC != null ? beneficiarioCchgParentescoCpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCchgParentescoCpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCchgParentescoCpthisBeneficiarioCInstance() == null || this.getBeneficiarioCchgParentescoCpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_CHGPARENTESCOC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_CHGPARENTESCOC_BENEFICIARIOCCHGPARENTESCOCPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_CHGPARENTESCOC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_CHGPARENTESCOC_BENEFICIARIOCCHGPARENTESCOCPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public ParentescoOid getBeneficiarioCchgParentescoCpevcParentesco() {
        return this.beneficiarioCchgParentescoCpevcParentesco;
    }
    
    public void setBeneficiarioCchgParentescoCpevcParentesco(ParentescoOid beneficiarioCchgParentescoCpevcParentesco) {
        this.beneficiarioCchgParentescoCpevcParentesco = beneficiarioCchgParentescoCpevcParentesco;
    }

    @JsonIgnore
    public Parentesco getBeneficiarioCchgParentescoCpevcParentescoInstance() {
        return this.beneficiarioCchgParentescoCpevcParentescoInstance;
    }
    
    public void setBeneficiarioCchgParentescoCpevcParentescoInstance(Parentesco beneficiarioCchgParentescoCpevcParentesco) {
        this.beneficiarioCchgParentescoCpevcParentescoInstance = beneficiarioCchgParentescoCpevcParentesco;
        this.beneficiarioCchgParentescoCpevcParentesco = beneficiarioCchgParentescoCpevcParentesco != null ? beneficiarioCchgParentescoCpevcParentesco.getOid() : null;
    }

    private void checkBeneficiarioCchgParentescoCpevcParentesco() throws NotNullArgumentException {
        if(this.getBeneficiarioCchgParentescoCpevcParentescoInstance() == null || this.getBeneficiarioCchgParentescoCpevcParentescoInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_CHGPARENTESCOC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_CHGPARENTESCOC_BENEFICIARIOCCHGPARENTESCOCPEVCPARENTESCO, BeneficiarioCConstants.SERV_ALIAS_CHGPARENTESCOC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_CHGPARENTESCOC_BENEFICIARIOCCHGPARENTESCOCPEVCPARENTESCO);
        }
    }
}
