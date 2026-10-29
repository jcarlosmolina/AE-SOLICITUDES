package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.EpsOid;

public class InsEPSCRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCInsEPSCpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCInsEPSCpthisBeneficiarioCInstance;

    @JsonProperty("p_evceps_oid")
    private EpsOid beneficiarioCInsEPSCpevcEps;
    
    @JsonIgnore
    private Eps beneficiarioCInsEPSCpevcEpsInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCInsEPSCpthisBeneficiarioC();
        checkBeneficiarioCInsEPSCpevcEps();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCInsEPSCpthisBeneficiarioC() {
        return this.beneficiarioCInsEPSCpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCInsEPSCpthisBeneficiarioC(BeneficiarioCOid beneficiarioCInsEPSCpthisBeneficiarioC) {
        this.beneficiarioCInsEPSCpthisBeneficiarioC = beneficiarioCInsEPSCpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCInsEPSCpthisBeneficiarioCInstance() {
        return this.beneficiarioCInsEPSCpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCInsEPSCpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCInsEPSCpthisBeneficiarioC) {
        this.beneficiarioCInsEPSCpthisBeneficiarioCInstance = beneficiarioCInsEPSCpthisBeneficiarioC;
        this.beneficiarioCInsEPSCpthisBeneficiarioC = beneficiarioCInsEPSCpthisBeneficiarioC != null ? beneficiarioCInsEPSCpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCInsEPSCpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCInsEPSCpthisBeneficiarioCInstance() == null || this.getBeneficiarioCInsEPSCpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_INSEPSC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_INSEPSC_BENEFICIARIOCINSEPSCPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_INSEPSC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_INSEPSC_BENEFICIARIOCINSEPSCPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public EpsOid getBeneficiarioCInsEPSCpevcEps() {
        return this.beneficiarioCInsEPSCpevcEps;
    }
    
    public void setBeneficiarioCInsEPSCpevcEps(EpsOid beneficiarioCInsEPSCpevcEps) {
        this.beneficiarioCInsEPSCpevcEps = beneficiarioCInsEPSCpevcEps;
    }

    @JsonIgnore
    public Eps getBeneficiarioCInsEPSCpevcEpsInstance() {
        return this.beneficiarioCInsEPSCpevcEpsInstance;
    }
    
    public void setBeneficiarioCInsEPSCpevcEpsInstance(Eps beneficiarioCInsEPSCpevcEps) {
        this.beneficiarioCInsEPSCpevcEpsInstance = beneficiarioCInsEPSCpevcEps;
        this.beneficiarioCInsEPSCpevcEps = beneficiarioCInsEPSCpevcEps != null ? beneficiarioCInsEPSCpevcEps.getOid() : null;
    }

    private void checkBeneficiarioCInsEPSCpevcEps() throws NotNullArgumentException {
        if(this.getBeneficiarioCInsEPSCpevcEpsInstance() == null || this.getBeneficiarioCInsEPSCpevcEpsInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_INSEPSC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_INSEPSC_BENEFICIARIOCINSEPSCPEVCEPS, BeneficiarioCConstants.SERV_ALIAS_INSEPSC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_INSEPSC_BENEFICIARIOCINSEPSCPEVCEPS);
        }
    }
}
