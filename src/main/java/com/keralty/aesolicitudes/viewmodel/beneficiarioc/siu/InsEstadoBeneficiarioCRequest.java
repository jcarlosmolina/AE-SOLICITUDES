package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoBeneficiarioOid;

public class InsEstadoBeneficiarioCRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance;

    @JsonProperty("p_evcestadobeneficiario_oid")
    private EstadoBeneficiarioOid beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario;
    
    @JsonIgnore
    private EstadoBeneficiario beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC();
        checkBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC() {
        return this.beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC(BeneficiarioCOid beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC) {
        this.beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC = beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance() {
        return this.beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC) {
        this.beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance = beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC;
        this.beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC = beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC != null ? beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance() == null || this.getBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_INSESTADOBENEFICIARIOC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_INSESTADOBENEFICIARIOC_BENEFICIARIOCINSESTADOBENEFICIARIOCPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_INSESTADOBENEFICIARIOC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_INSESTADOBENEFICIARIOC_BENEFICIARIOCINSESTADOBENEFICIARIOCPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario() {
        return this.beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario;
    }
    
    public void setBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario(EstadoBeneficiarioOid beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario) {
        this.beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario = beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario;
    }

    @JsonIgnore
    public EstadoBeneficiario getBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance() {
        return this.beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance;
    }
    
    public void setBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(EstadoBeneficiario beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario) {
        this.beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance = beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario;
        this.beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario = beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario != null ? beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario.getOid() : null;
    }

    private void checkBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario() throws NotNullArgumentException {
        if(this.getBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance() == null || this.getBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_INSESTADOBENEFICIARIOC, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_INSESTADOBENEFICIARIOC_BENEFICIARIOCINSESTADOBENEFICIARIOCPEVCESTADOBENEFICIARIO, BeneficiarioCConstants.SERV_ALIAS_INSESTADOBENEFICIARIOC, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_INSESTADOBENEFICIARIOC_BENEFICIARIOCINSESTADOBENEFICIARIOCPEVCESTADOBENEFICIARIO);
        }
    }
}
