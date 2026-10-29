package com.keralty.aesolicitudes.viewmodel.eps.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EpsConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.EpsOid;

public class InsEPSCRequest {

    @JsonProperty("p_thiseps_oid")
    private EpsOid epsInsEPSCpthisEPS;
    
    @JsonIgnore
    private Eps epsInsEPSCpthisEPSInstance;

    @JsonProperty("p_evcbeneficiarioc_oid")
    private BeneficiarioCOid epsInsEPSCpevcBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC epsInsEPSCpevcBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEpsInsEPSCpthisEPS();
        checkEpsInsEPSCpevcBeneficiarioC();
    }

    @JsonIgnore
    public EpsOid getEpsInsEPSCpthisEPS() {
        return this.epsInsEPSCpthisEPS;
    }
    
    public void setEpsInsEPSCpthisEPS(EpsOid epsInsEPSCpthisEPS) {
        this.epsInsEPSCpthisEPS = epsInsEPSCpthisEPS;
    }

    @JsonIgnore
    public Eps getEpsInsEPSCpthisEPSInstance() {
        return this.epsInsEPSCpthisEPSInstance;
    }
    
    public void setEpsInsEPSCpthisEPSInstance(Eps epsInsEPSCpthisEPS) {
        this.epsInsEPSCpthisEPSInstance = epsInsEPSCpthisEPS;
        this.epsInsEPSCpthisEPS = epsInsEPSCpthisEPS != null ? epsInsEPSCpthisEPS.getOid() : null;
    }

    private void checkEpsInsEPSCpthisEPS() throws NotNullArgumentException {
        if(this.getEpsInsEPSCpthisEPSInstance() == null || this.getEpsInsEPSCpthisEPSInstance().isNull()) {
            throw new NotNullArgumentException(EpsConstants.SERV_ID_INSEPSC, EpsConstants.CLASS_ID, EpsConstants.ARG_ID_INSEPSC_EPSINSEPSCPTHISEPS, EpsConstants.SERV_ALIAS_INSEPSC, EpsConstants.CLASS_ALIAS, EpsConstants.ARG_ALIAS_INSEPSC_EPSINSEPSCPTHISEPS);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getEpsInsEPSCpevcBeneficiarioC() {
        return this.epsInsEPSCpevcBeneficiarioC;
    }
    
    public void setEpsInsEPSCpevcBeneficiarioC(BeneficiarioCOid epsInsEPSCpevcBeneficiarioC) {
        this.epsInsEPSCpevcBeneficiarioC = epsInsEPSCpevcBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getEpsInsEPSCpevcBeneficiarioCInstance() {
        return this.epsInsEPSCpevcBeneficiarioCInstance;
    }
    
    public void setEpsInsEPSCpevcBeneficiarioCInstance(BeneficiarioC epsInsEPSCpevcBeneficiarioC) {
        this.epsInsEPSCpevcBeneficiarioCInstance = epsInsEPSCpevcBeneficiarioC;
        this.epsInsEPSCpevcBeneficiarioC = epsInsEPSCpevcBeneficiarioC != null ? epsInsEPSCpevcBeneficiarioC.getOid() : null;
    }

    private void checkEpsInsEPSCpevcBeneficiarioC() throws NotNullArgumentException {
        if(this.getEpsInsEPSCpevcBeneficiarioCInstance() == null || this.getEpsInsEPSCpevcBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(EpsConstants.SERV_ID_INSEPSC, EpsConstants.CLASS_ID, EpsConstants.ARG_ID_INSEPSC_EPSINSEPSCPEVCBENEFICIARIOC, EpsConstants.SERV_ALIAS_INSEPSC, EpsConstants.CLASS_ALIAS, EpsConstants.ARG_ALIAS_INSEPSC_EPSINSEPSCPEVCBENEFICIARIOC);
        }
    }
}
