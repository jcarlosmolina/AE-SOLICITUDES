package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;

public class TELIMINARRequest {

    @JsonProperty("p_thisfamiliac_oid")
    private FamiliaCOid familiaCTELIMINARpthisFamiliaC;
    
    @JsonIgnore
    private FamiliaC familiaCTELIMINARpthisFamiliaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCTELIMINARpthisFamiliaC();
    }

    @JsonIgnore
    public FamiliaCOid getFamiliaCTELIMINARpthisFamiliaC() {
        return this.familiaCTELIMINARpthisFamiliaC;
    }
    
    public void setFamiliaCTELIMINARpthisFamiliaC(FamiliaCOid familiaCTELIMINARpthisFamiliaC) {
        this.familiaCTELIMINARpthisFamiliaC = familiaCTELIMINARpthisFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getFamiliaCTELIMINARpthisFamiliaCInstance() {
        return this.familiaCTELIMINARpthisFamiliaCInstance;
    }
    
    public void setFamiliaCTELIMINARpthisFamiliaCInstance(FamiliaC familiaCTELIMINARpthisFamiliaC) {
        this.familiaCTELIMINARpthisFamiliaCInstance = familiaCTELIMINARpthisFamiliaC;
        this.familiaCTELIMINARpthisFamiliaC = familiaCTELIMINARpthisFamiliaC != null ? familiaCTELIMINARpthisFamiliaC.getOid() : null;
    }

    private void checkFamiliaCTELIMINARpthisFamiliaC() throws NotNullArgumentException {
        if(this.getFamiliaCTELIMINARpthisFamiliaCInstance() == null || this.getFamiliaCTELIMINARpthisFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_TELIMINAR, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_TELIMINAR_FAMILIACTELIMINARPTHISFAMILIAC, FamiliaCConstants.SERV_ALIAS_TELIMINAR, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_TELIMINAR_FAMILIACTELIMINARPTHISFAMILIAC);
        }
    }
}
