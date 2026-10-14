package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoBeneficiarioOid;

public class DelEstadoBeneficiarioCRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance;

    @JsonProperty("p_evcestadobeneficiario_oid")
    private EstadoBeneficiarioOid beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario;
    
    @JsonIgnore
    private EstadoBeneficiario beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC();
        checkBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC() {
        return this.beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC(BeneficiarioCOid beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC) {
        this.beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC = beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance() {
        return this.beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC) {
        this.beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance = beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC;
        this.beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC = beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC != null ? beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance() == null || this.getBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_DELESTADOBENEFICIARIOC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_DELESTADOBENEFICIARIOC_BENEFICIARIOCDELESTADOBENEFICIARIOCPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_DELESTADOBENEFICIARIOC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_DELESTADOBENEFICIARIOC_BENEFICIARIOCDELESTADOBENEFICIARIOCPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario() {
        return this.beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario;
    }
    
    public void setBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario(EstadoBeneficiarioOid beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario) {
        this.beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario = beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario;
    }

    @JsonIgnore
    public EstadoBeneficiario getBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance() {
        return this.beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance;
    }
    
    public void setBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(EstadoBeneficiario beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario) {
        this.beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance = beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario;
        this.beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario = beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario != null ? beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario.getOid() : null;
    }

    private void checkBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario() throws NotNullArgumentException {
        if(this.getBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance() == null || this.getBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_DELESTADOBENEFICIARIOC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_DELESTADOBENEFICIARIOC_BENEFICIARIOCDELESTADOBENEFICIARIOCPEVCESTADOBENEFICIARIO, BeneficiarioCConstants.SERV_ALIAS_DELESTADOBENEFICIARIOC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_DELESTADOBENEFICIARIOC_BENEFICIARIOCDELESTADOBENEFICIARIOCPEVCESTADOBENEFICIARIO);
        }
    }
}
