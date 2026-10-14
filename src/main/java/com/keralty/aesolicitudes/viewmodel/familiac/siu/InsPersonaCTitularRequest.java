package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsPersonaCTitularRequest {

    @JsonProperty("p_thisfamiliac_oid")
    private FamiliaCOid familiaCInsPersonaCTitularpthisFamiliaC;
    
    @JsonIgnore
    private FamiliaC familiaCInsPersonaCTitularpthisFamiliaCInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid familiaCInsPersonaCTitularpevcPersonaC;
    
    @JsonIgnore
    private PersonaC familiaCInsPersonaCTitularpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCInsPersonaCTitularpthisFamiliaC();
        checkFamiliaCInsPersonaCTitularpevcPersonaC();
    }

    @JsonIgnore
    public FamiliaCOid getFamiliaCInsPersonaCTitularpthisFamiliaC() {
        return this.familiaCInsPersonaCTitularpthisFamiliaC;
    }
    
    public void setFamiliaCInsPersonaCTitularpthisFamiliaC(FamiliaCOid familiaCInsPersonaCTitularpthisFamiliaC) {
        this.familiaCInsPersonaCTitularpthisFamiliaC = familiaCInsPersonaCTitularpthisFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getFamiliaCInsPersonaCTitularpthisFamiliaCInstance() {
        return this.familiaCInsPersonaCTitularpthisFamiliaCInstance;
    }
    
    public void setFamiliaCInsPersonaCTitularpthisFamiliaCInstance(FamiliaC familiaCInsPersonaCTitularpthisFamiliaC) {
        this.familiaCInsPersonaCTitularpthisFamiliaCInstance = familiaCInsPersonaCTitularpthisFamiliaC;
        this.familiaCInsPersonaCTitularpthisFamiliaC = familiaCInsPersonaCTitularpthisFamiliaC != null ? familiaCInsPersonaCTitularpthisFamiliaC.getOid() : null;
    }

    private void checkFamiliaCInsPersonaCTitularpthisFamiliaC() throws NotNullArgumentException {
        if(this.getFamiliaCInsPersonaCTitularpthisFamiliaCInstance() == null || this.getFamiliaCInsPersonaCTitularpthisFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_INSPERSONACTITULAR, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_INSPERSONACTITULAR_FAMILIACINSPERSONACTITULARPTHISFAMILIAC, FamiliaCConstants.SERV_ALIAS_INSPERSONACTITULAR, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_INSPERSONACTITULAR_FAMILIACINSPERSONACTITULARPTHISFAMILIAC);
        }
    }

    @JsonIgnore
    public PersonaCOid getFamiliaCInsPersonaCTitularpevcPersonaC() {
        return this.familiaCInsPersonaCTitularpevcPersonaC;
    }
    
    public void setFamiliaCInsPersonaCTitularpevcPersonaC(PersonaCOid familiaCInsPersonaCTitularpevcPersonaC) {
        this.familiaCInsPersonaCTitularpevcPersonaC = familiaCInsPersonaCTitularpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getFamiliaCInsPersonaCTitularpevcPersonaCInstance() {
        return this.familiaCInsPersonaCTitularpevcPersonaCInstance;
    }
    
    public void setFamiliaCInsPersonaCTitularpevcPersonaCInstance(PersonaC familiaCInsPersonaCTitularpevcPersonaC) {
        this.familiaCInsPersonaCTitularpevcPersonaCInstance = familiaCInsPersonaCTitularpevcPersonaC;
        this.familiaCInsPersonaCTitularpevcPersonaC = familiaCInsPersonaCTitularpevcPersonaC != null ? familiaCInsPersonaCTitularpevcPersonaC.getOid() : null;
    }

    private void checkFamiliaCInsPersonaCTitularpevcPersonaC() throws NotNullArgumentException {
        if(this.getFamiliaCInsPersonaCTitularpevcPersonaCInstance() == null || this.getFamiliaCInsPersonaCTitularpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_INSPERSONACTITULAR, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_INSPERSONACTITULAR_FAMILIACINSPERSONACTITULARPEVCPERSONAC, FamiliaCConstants.SERV_ALIAS_INSPERSONACTITULAR, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_INSPERSONACTITULAR_FAMILIACINSPERSONACTITULARPEVCPERSONAC);
        }
    }
}
