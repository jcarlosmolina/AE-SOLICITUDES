package com.keralty.aesolicitudes.viewmodel.companyia.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.CompanyiaConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.CompanyiaOid;

public class DelCompanyiaMPCRequest {

    @JsonProperty("p_thiscompanyia_oid")
    private CompanyiaOid companyiaDelCompanyiaMPCpthisCompanyia;
    
    @JsonIgnore
    private Companyia companyiaDelCompanyiaMPCpthisCompanyiaInstance;

    @JsonProperty("p_evcbeneficiarioc_oid")
    private BeneficiarioCOid companyiaDelCompanyiaMPCpevcBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC companyiaDelCompanyiaMPCpevcBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkCompanyiaDelCompanyiaMPCpthisCompanyia();
        checkCompanyiaDelCompanyiaMPCpevcBeneficiarioC();
    }

    @JsonIgnore
    public CompanyiaOid getCompanyiaDelCompanyiaMPCpthisCompanyia() {
        return this.companyiaDelCompanyiaMPCpthisCompanyia;
    }
    
    public void setCompanyiaDelCompanyiaMPCpthisCompanyia(CompanyiaOid companyiaDelCompanyiaMPCpthisCompanyia) {
        this.companyiaDelCompanyiaMPCpthisCompanyia = companyiaDelCompanyiaMPCpthisCompanyia;
    }

    @JsonIgnore
    public Companyia getCompanyiaDelCompanyiaMPCpthisCompanyiaInstance() {
        return this.companyiaDelCompanyiaMPCpthisCompanyiaInstance;
    }
    
    public void setCompanyiaDelCompanyiaMPCpthisCompanyiaInstance(Companyia companyiaDelCompanyiaMPCpthisCompanyia) {
        this.companyiaDelCompanyiaMPCpthisCompanyiaInstance = companyiaDelCompanyiaMPCpthisCompanyia;
        this.companyiaDelCompanyiaMPCpthisCompanyia = companyiaDelCompanyiaMPCpthisCompanyia != null ? companyiaDelCompanyiaMPCpthisCompanyia.getOid() : null;
    }

    private void checkCompanyiaDelCompanyiaMPCpthisCompanyia() throws NotNullArgumentException {
        if(this.getCompanyiaDelCompanyiaMPCpthisCompanyiaInstance() == null || this.getCompanyiaDelCompanyiaMPCpthisCompanyiaInstance().isNull()) {
            throw new NotNullArgumentException(CompanyiaConstants.SERV_ID_DELCOMPANYIAMPC, CompanyiaConstants.CLASS_ID, CompanyiaConstants.ARG_ID_DELCOMPANYIAMPC_COMPANYIADELCOMPANYIAMPCPTHISCOMPANYIA, CompanyiaConstants.SERV_ALIAS_DELCOMPANYIAMPC, CompanyiaConstants.CLASS_ALIAS, CompanyiaConstants.ARG_ALIAS_DELCOMPANYIAMPC_COMPANYIADELCOMPANYIAMPCPTHISCOMPANYIA);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getCompanyiaDelCompanyiaMPCpevcBeneficiarioC() {
        return this.companyiaDelCompanyiaMPCpevcBeneficiarioC;
    }
    
    public void setCompanyiaDelCompanyiaMPCpevcBeneficiarioC(BeneficiarioCOid companyiaDelCompanyiaMPCpevcBeneficiarioC) {
        this.companyiaDelCompanyiaMPCpevcBeneficiarioC = companyiaDelCompanyiaMPCpevcBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getCompanyiaDelCompanyiaMPCpevcBeneficiarioCInstance() {
        return this.companyiaDelCompanyiaMPCpevcBeneficiarioCInstance;
    }
    
    public void setCompanyiaDelCompanyiaMPCpevcBeneficiarioCInstance(BeneficiarioC companyiaDelCompanyiaMPCpevcBeneficiarioC) {
        this.companyiaDelCompanyiaMPCpevcBeneficiarioCInstance = companyiaDelCompanyiaMPCpevcBeneficiarioC;
        this.companyiaDelCompanyiaMPCpevcBeneficiarioC = companyiaDelCompanyiaMPCpevcBeneficiarioC != null ? companyiaDelCompanyiaMPCpevcBeneficiarioC.getOid() : null;
    }

    private void checkCompanyiaDelCompanyiaMPCpevcBeneficiarioC() throws NotNullArgumentException {
        if(this.getCompanyiaDelCompanyiaMPCpevcBeneficiarioCInstance() == null || this.getCompanyiaDelCompanyiaMPCpevcBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(CompanyiaConstants.SERV_ID_DELCOMPANYIAMPC, CompanyiaConstants.CLASS_ID, CompanyiaConstants.ARG_ID_DELCOMPANYIAMPC_COMPANYIADELCOMPANYIAMPCPEVCBENEFICIARIOC, CompanyiaConstants.SERV_ALIAS_DELCOMPANYIAMPC, CompanyiaConstants.CLASS_ALIAS, CompanyiaConstants.ARG_ALIAS_DELCOMPANYIAMPC_COMPANYIADELCOMPANYIAMPCPEVCBENEFICIARIOC);
        }
    }
}
