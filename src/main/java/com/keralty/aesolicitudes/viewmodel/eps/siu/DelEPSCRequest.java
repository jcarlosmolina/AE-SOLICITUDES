package com.keralty.aesolicitudes.viewmodel.eps.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EpsConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.EpsOid;

public class DelEPSCRequest {

    @JsonProperty("p_thiseps_oid")
    private EpsOid epsDelEPSCpthisEPS;
    
    @JsonIgnore
    private Eps epsDelEPSCpthisEPSInstance;

    @JsonProperty("p_evcbeneficiarioc_oid")
    private BeneficiarioCOid epsDelEPSCpevcBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC epsDelEPSCpevcBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEpsDelEPSCpthisEPS();
        checkEpsDelEPSCpevcBeneficiarioC();
    }

    @JsonIgnore
    public EpsOid getEpsDelEPSCpthisEPS() {
        return this.epsDelEPSCpthisEPS;
    }
    
    public void setEpsDelEPSCpthisEPS(EpsOid epsDelEPSCpthisEPS) {
        this.epsDelEPSCpthisEPS = epsDelEPSCpthisEPS;
    }

    @JsonIgnore
    public Eps getEpsDelEPSCpthisEPSInstance() {
        return this.epsDelEPSCpthisEPSInstance;
    }
    
    public void setEpsDelEPSCpthisEPSInstance(Eps epsDelEPSCpthisEPS) {
        this.epsDelEPSCpthisEPSInstance = epsDelEPSCpthisEPS;
        this.epsDelEPSCpthisEPS = epsDelEPSCpthisEPS != null ? epsDelEPSCpthisEPS.getOid() : null;
    }

    private void checkEpsDelEPSCpthisEPS() throws NotNullArgumentException {
        if(this.getEpsDelEPSCpthisEPSInstance() == null || this.getEpsDelEPSCpthisEPSInstance().isNull()) {
            throw new NotNullArgumentException(EpsConstants.SERV_ID_DELEPSC, EpsConstants.CLASS_ID, EpsConstants.ARG_ID_DELEPSC_EPSDELEPSCPTHISEPS, EpsConstants.SERV_ALIAS_DELEPSC, EpsConstants.CLASS_ALIAS, EpsConstants.ARG_ALIAS_DELEPSC_EPSDELEPSCPTHISEPS);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getEpsDelEPSCpevcBeneficiarioC() {
        return this.epsDelEPSCpevcBeneficiarioC;
    }
    
    public void setEpsDelEPSCpevcBeneficiarioC(BeneficiarioCOid epsDelEPSCpevcBeneficiarioC) {
        this.epsDelEPSCpevcBeneficiarioC = epsDelEPSCpevcBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getEpsDelEPSCpevcBeneficiarioCInstance() {
        return this.epsDelEPSCpevcBeneficiarioCInstance;
    }
    
    public void setEpsDelEPSCpevcBeneficiarioCInstance(BeneficiarioC epsDelEPSCpevcBeneficiarioC) {
        this.epsDelEPSCpevcBeneficiarioCInstance = epsDelEPSCpevcBeneficiarioC;
        this.epsDelEPSCpevcBeneficiarioC = epsDelEPSCpevcBeneficiarioC != null ? epsDelEPSCpevcBeneficiarioC.getOid() : null;
    }

    private void checkEpsDelEPSCpevcBeneficiarioC() throws NotNullArgumentException {
        if(this.getEpsDelEPSCpevcBeneficiarioCInstance() == null || this.getEpsDelEPSCpevcBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(EpsConstants.SERV_ID_DELEPSC, EpsConstants.CLASS_ID, EpsConstants.ARG_ID_DELEPSC_EPSDELEPSCPEVCBENEFICIARIOC, EpsConstants.SERV_ALIAS_DELEPSC, EpsConstants.CLASS_ALIAS, EpsConstants.ARG_ALIAS_DELEPSC_EPSDELEPSCPEVCBENEFICIARIOC);
        }
    }
}
