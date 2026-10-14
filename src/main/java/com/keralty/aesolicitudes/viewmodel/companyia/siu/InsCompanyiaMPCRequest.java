package com.keralty.aesolicitudes.viewmodel.companyia.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.CompanyiaConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.CompanyiaOid;

public class InsCompanyiaMPCRequest {

    @JsonProperty("p_thiscompanyia_oid")
    private CompanyiaOid companyiaInsCompanyiaMPCpthisCompanyia;
    
    @JsonIgnore
    private Companyia companyiaInsCompanyiaMPCpthisCompanyiaInstance;

    @JsonProperty("p_evcbeneficiarioc_oid")
    private BeneficiarioCOid companyiaInsCompanyiaMPCpevcBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC companyiaInsCompanyiaMPCpevcBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkCompanyiaInsCompanyiaMPCpthisCompanyia();
        checkCompanyiaInsCompanyiaMPCpevcBeneficiarioC();
    }

    @JsonIgnore
    public CompanyiaOid getCompanyiaInsCompanyiaMPCpthisCompanyia() {
        return this.companyiaInsCompanyiaMPCpthisCompanyia;
    }
    
    public void setCompanyiaInsCompanyiaMPCpthisCompanyia(CompanyiaOid companyiaInsCompanyiaMPCpthisCompanyia) {
        this.companyiaInsCompanyiaMPCpthisCompanyia = companyiaInsCompanyiaMPCpthisCompanyia;
    }

    @JsonIgnore
    public Companyia getCompanyiaInsCompanyiaMPCpthisCompanyiaInstance() {
        return this.companyiaInsCompanyiaMPCpthisCompanyiaInstance;
    }
    
    public void setCompanyiaInsCompanyiaMPCpthisCompanyiaInstance(Companyia companyiaInsCompanyiaMPCpthisCompanyia) {
        this.companyiaInsCompanyiaMPCpthisCompanyiaInstance = companyiaInsCompanyiaMPCpthisCompanyia;
        this.companyiaInsCompanyiaMPCpthisCompanyia = companyiaInsCompanyiaMPCpthisCompanyia != null ? companyiaInsCompanyiaMPCpthisCompanyia.getOid() : null;
    }

    private void checkCompanyiaInsCompanyiaMPCpthisCompanyia() throws NotNullArgumentException {
        if(this.getCompanyiaInsCompanyiaMPCpthisCompanyiaInstance() == null || this.getCompanyiaInsCompanyiaMPCpthisCompanyiaInstance().isNull()) {
            throw new NotNullArgumentException(CompanyiaConstants.SERV_ID_INSCOMPANYIAMPC, CompanyiaConstants.CLASS_ID, CompanyiaConstants.ARG_ID_INSCOMPANYIAMPC_COMPANYIAINSCOMPANYIAMPCPTHISCOMPANYIA, CompanyiaConstants.SERV_ALIAS_INSCOMPANYIAMPC, CompanyiaConstants.CLASS_ALIAS, CompanyiaConstants.ARG_ALIAS_INSCOMPANYIAMPC_COMPANYIAINSCOMPANYIAMPCPTHISCOMPANYIA);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getCompanyiaInsCompanyiaMPCpevcBeneficiarioC() {
        return this.companyiaInsCompanyiaMPCpevcBeneficiarioC;
    }
    
    public void setCompanyiaInsCompanyiaMPCpevcBeneficiarioC(BeneficiarioCOid companyiaInsCompanyiaMPCpevcBeneficiarioC) {
        this.companyiaInsCompanyiaMPCpevcBeneficiarioC = companyiaInsCompanyiaMPCpevcBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getCompanyiaInsCompanyiaMPCpevcBeneficiarioCInstance() {
        return this.companyiaInsCompanyiaMPCpevcBeneficiarioCInstance;
    }
    
    public void setCompanyiaInsCompanyiaMPCpevcBeneficiarioCInstance(BeneficiarioC companyiaInsCompanyiaMPCpevcBeneficiarioC) {
        this.companyiaInsCompanyiaMPCpevcBeneficiarioCInstance = companyiaInsCompanyiaMPCpevcBeneficiarioC;
        this.companyiaInsCompanyiaMPCpevcBeneficiarioC = companyiaInsCompanyiaMPCpevcBeneficiarioC != null ? companyiaInsCompanyiaMPCpevcBeneficiarioC.getOid() : null;
    }

    private void checkCompanyiaInsCompanyiaMPCpevcBeneficiarioC() throws NotNullArgumentException {
        if(this.getCompanyiaInsCompanyiaMPCpevcBeneficiarioCInstance() == null || this.getCompanyiaInsCompanyiaMPCpevcBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(CompanyiaConstants.SERV_ID_INSCOMPANYIAMPC, CompanyiaConstants.CLASS_ID, CompanyiaConstants.ARG_ID_INSCOMPANYIAMPC_COMPANYIAINSCOMPANYIAMPCPEVCBENEFICIARIOC, CompanyiaConstants.SERV_ALIAS_INSCOMPANYIAMPC, CompanyiaConstants.CLASS_ALIAS, CompanyiaConstants.ARG_ALIAS_INSCOMPANYIAMPC_COMPANYIAINSCOMPANYIAMPCPEVCBENEFICIARIOC);
        }
    }
}
