package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;

public class EliminarRequest {

    @JsonProperty("p_thisfamiliac_oid")
    private FamiliaCOid familiaCeliminarpthisFamiliaC;
    
    @JsonIgnore
    private FamiliaC familiaCeliminarpthisFamiliaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCeliminarpthisFamiliaC();
    }

    @JsonIgnore
    public FamiliaCOid getFamiliaCeliminarpthisFamiliaC() {
        return this.familiaCeliminarpthisFamiliaC;
    }
    
    public void setFamiliaCeliminarpthisFamiliaC(FamiliaCOid familiaCeliminarpthisFamiliaC) {
        this.familiaCeliminarpthisFamiliaC = familiaCeliminarpthisFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getFamiliaCeliminarpthisFamiliaCInstance() {
        return this.familiaCeliminarpthisFamiliaCInstance;
    }
    
    public void setFamiliaCeliminarpthisFamiliaCInstance(FamiliaC familiaCeliminarpthisFamiliaC) {
        this.familiaCeliminarpthisFamiliaCInstance = familiaCeliminarpthisFamiliaC;
        this.familiaCeliminarpthisFamiliaC = familiaCeliminarpthisFamiliaC != null ? familiaCeliminarpthisFamiliaC.getOid() : null;
    }

    private void checkFamiliaCeliminarpthisFamiliaC() throws NotNullArgumentException {
        if(this.getFamiliaCeliminarpthisFamiliaCInstance() == null || this.getFamiliaCeliminarpthisFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_ELIMINAR, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_ELIMINAR_FAMILIACELIMINARPTHISFAMILIAC, FamiliaCConstants.SERV_ALIAS_ELIMINAR, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_ELIMINAR_FAMILIACELIMINARPTHISFAMILIAC);
        }
    }
}
