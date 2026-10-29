package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class InsMunicipioFamiliaRequest {

    @JsonProperty("p_thisfamiliac_oid")
    private FamiliaCOid familiaCInsMunicipioFamiliapthisFamiliaC;
    
    @JsonIgnore
    private FamiliaC familiaCInsMunicipioFamiliapthisFamiliaCInstance;

    @JsonProperty("p_evcmunicipio_oid")
    private MunicipioOid familiaCInsMunicipioFamiliapevcMunicipio;
    
    @JsonIgnore
    private Municipio familiaCInsMunicipioFamiliapevcMunicipioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCInsMunicipioFamiliapthisFamiliaC();
        checkFamiliaCInsMunicipioFamiliapevcMunicipio();
    }

    @JsonIgnore
    public FamiliaCOid getFamiliaCInsMunicipioFamiliapthisFamiliaC() {
        return this.familiaCInsMunicipioFamiliapthisFamiliaC;
    }
    
    public void setFamiliaCInsMunicipioFamiliapthisFamiliaC(FamiliaCOid familiaCInsMunicipioFamiliapthisFamiliaC) {
        this.familiaCInsMunicipioFamiliapthisFamiliaC = familiaCInsMunicipioFamiliapthisFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getFamiliaCInsMunicipioFamiliapthisFamiliaCInstance() {
        return this.familiaCInsMunicipioFamiliapthisFamiliaCInstance;
    }
    
    public void setFamiliaCInsMunicipioFamiliapthisFamiliaCInstance(FamiliaC familiaCInsMunicipioFamiliapthisFamiliaC) {
        this.familiaCInsMunicipioFamiliapthisFamiliaCInstance = familiaCInsMunicipioFamiliapthisFamiliaC;
        this.familiaCInsMunicipioFamiliapthisFamiliaC = familiaCInsMunicipioFamiliapthisFamiliaC != null ? familiaCInsMunicipioFamiliapthisFamiliaC.getOid() : null;
    }

    private void checkFamiliaCInsMunicipioFamiliapthisFamiliaC() throws NotNullArgumentException {
        if(this.getFamiliaCInsMunicipioFamiliapthisFamiliaCInstance() == null || this.getFamiliaCInsMunicipioFamiliapthisFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_INSMUNICIPIOFAMILIA, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_INSMUNICIPIOFAMILIA_FAMILIACINSMUNICIPIOFAMILIAPTHISFAMILIAC, FamiliaCConstants.SERV_ALIAS_INSMUNICIPIOFAMILIA, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_INSMUNICIPIOFAMILIA_FAMILIACINSMUNICIPIOFAMILIAPTHISFAMILIAC);
        }
    }

    @JsonIgnore
    public MunicipioOid getFamiliaCInsMunicipioFamiliapevcMunicipio() {
        return this.familiaCInsMunicipioFamiliapevcMunicipio;
    }
    
    public void setFamiliaCInsMunicipioFamiliapevcMunicipio(MunicipioOid familiaCInsMunicipioFamiliapevcMunicipio) {
        this.familiaCInsMunicipioFamiliapevcMunicipio = familiaCInsMunicipioFamiliapevcMunicipio;
    }

    @JsonIgnore
    public Municipio getFamiliaCInsMunicipioFamiliapevcMunicipioInstance() {
        return this.familiaCInsMunicipioFamiliapevcMunicipioInstance;
    }
    
    public void setFamiliaCInsMunicipioFamiliapevcMunicipioInstance(Municipio familiaCInsMunicipioFamiliapevcMunicipio) {
        this.familiaCInsMunicipioFamiliapevcMunicipioInstance = familiaCInsMunicipioFamiliapevcMunicipio;
        this.familiaCInsMunicipioFamiliapevcMunicipio = familiaCInsMunicipioFamiliapevcMunicipio != null ? familiaCInsMunicipioFamiliapevcMunicipio.getOid() : null;
    }

    private void checkFamiliaCInsMunicipioFamiliapevcMunicipio() throws NotNullArgumentException {
        if(this.getFamiliaCInsMunicipioFamiliapevcMunicipioInstance() == null || this.getFamiliaCInsMunicipioFamiliapevcMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_INSMUNICIPIOFAMILIA, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_INSMUNICIPIOFAMILIA_FAMILIACINSMUNICIPIOFAMILIAPEVCMUNICIPIO, FamiliaCConstants.SERV_ALIAS_INSMUNICIPIOFAMILIA, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_INSMUNICIPIOFAMILIA_FAMILIACINSMUNICIPIOFAMILIAPEVCMUNICIPIO);
        }
    }
}
