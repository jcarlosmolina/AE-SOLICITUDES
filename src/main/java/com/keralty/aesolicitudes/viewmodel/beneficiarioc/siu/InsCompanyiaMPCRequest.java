package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.CompanyiaOid;

public class InsCompanyiaMPCRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCInsCompanyiaMPCpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCInsCompanyiaMPCpthisBeneficiarioCInstance;

    @JsonProperty("p_evccompanyia_oid")
    private CompanyiaOid beneficiarioCInsCompanyiaMPCpevcCompanyia;
    
    @JsonIgnore
    private Companyia beneficiarioCInsCompanyiaMPCpevcCompanyiaInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCInsCompanyiaMPCpthisBeneficiarioC();
        checkBeneficiarioCInsCompanyiaMPCpevcCompanyia();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCInsCompanyiaMPCpthisBeneficiarioC() {
        return this.beneficiarioCInsCompanyiaMPCpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCInsCompanyiaMPCpthisBeneficiarioC(BeneficiarioCOid beneficiarioCInsCompanyiaMPCpthisBeneficiarioC) {
        this.beneficiarioCInsCompanyiaMPCpthisBeneficiarioC = beneficiarioCInsCompanyiaMPCpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCInsCompanyiaMPCpthisBeneficiarioCInstance() {
        return this.beneficiarioCInsCompanyiaMPCpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCInsCompanyiaMPCpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCInsCompanyiaMPCpthisBeneficiarioC) {
        this.beneficiarioCInsCompanyiaMPCpthisBeneficiarioCInstance = beneficiarioCInsCompanyiaMPCpthisBeneficiarioC;
        this.beneficiarioCInsCompanyiaMPCpthisBeneficiarioC = beneficiarioCInsCompanyiaMPCpthisBeneficiarioC != null ? beneficiarioCInsCompanyiaMPCpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCInsCompanyiaMPCpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCInsCompanyiaMPCpthisBeneficiarioCInstance() == null || this.getBeneficiarioCInsCompanyiaMPCpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_INSCOMPANYIAMPC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_INSCOMPANYIAMPC_BENEFICIARIOCINSCOMPANYIAMPCPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_INSCOMPANYIAMPC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_INSCOMPANYIAMPC_BENEFICIARIOCINSCOMPANYIAMPCPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public CompanyiaOid getBeneficiarioCInsCompanyiaMPCpevcCompanyia() {
        return this.beneficiarioCInsCompanyiaMPCpevcCompanyia;
    }
    
    public void setBeneficiarioCInsCompanyiaMPCpevcCompanyia(CompanyiaOid beneficiarioCInsCompanyiaMPCpevcCompanyia) {
        this.beneficiarioCInsCompanyiaMPCpevcCompanyia = beneficiarioCInsCompanyiaMPCpevcCompanyia;
    }

    @JsonIgnore
    public Companyia getBeneficiarioCInsCompanyiaMPCpevcCompanyiaInstance() {
        return this.beneficiarioCInsCompanyiaMPCpevcCompanyiaInstance;
    }
    
    public void setBeneficiarioCInsCompanyiaMPCpevcCompanyiaInstance(Companyia beneficiarioCInsCompanyiaMPCpevcCompanyia) {
        this.beneficiarioCInsCompanyiaMPCpevcCompanyiaInstance = beneficiarioCInsCompanyiaMPCpevcCompanyia;
        this.beneficiarioCInsCompanyiaMPCpevcCompanyia = beneficiarioCInsCompanyiaMPCpevcCompanyia != null ? beneficiarioCInsCompanyiaMPCpevcCompanyia.getOid() : null;
    }

    private void checkBeneficiarioCInsCompanyiaMPCpevcCompanyia() throws NotNullArgumentException {
        if(this.getBeneficiarioCInsCompanyiaMPCpevcCompanyiaInstance() == null || this.getBeneficiarioCInsCompanyiaMPCpevcCompanyiaInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_INSCOMPANYIAMPC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_INSCOMPANYIAMPC_BENEFICIARIOCINSCOMPANYIAMPCPEVCCOMPANYIA, BeneficiarioCConstants.SERV_ALIAS_INSCOMPANYIAMPC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_INSCOMPANYIAMPC_BENEFICIARIOCINSCOMPANYIAMPCPEVCCOMPANYIA);
        }
    }
}
