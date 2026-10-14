package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class DelMunicipioFamiliaRequest {

    @JsonProperty("p_thisfamiliac_oid")
    private FamiliaCOid familiaCDelMunicipioFamiliapthisFamiliaC;
    
    @JsonIgnore
    private FamiliaC familiaCDelMunicipioFamiliapthisFamiliaCInstance;

    @JsonProperty("p_evcmunicipio_oid")
    private MunicipioOid familiaCDelMunicipioFamiliapevcMunicipio;
    
    @JsonIgnore
    private Municipio familiaCDelMunicipioFamiliapevcMunicipioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCDelMunicipioFamiliapthisFamiliaC();
        checkFamiliaCDelMunicipioFamiliapevcMunicipio();
    }

    @JsonIgnore
    public FamiliaCOid getFamiliaCDelMunicipioFamiliapthisFamiliaC() {
        return this.familiaCDelMunicipioFamiliapthisFamiliaC;
    }
    
    public void setFamiliaCDelMunicipioFamiliapthisFamiliaC(FamiliaCOid familiaCDelMunicipioFamiliapthisFamiliaC) {
        this.familiaCDelMunicipioFamiliapthisFamiliaC = familiaCDelMunicipioFamiliapthisFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getFamiliaCDelMunicipioFamiliapthisFamiliaCInstance() {
        return this.familiaCDelMunicipioFamiliapthisFamiliaCInstance;
    }
    
    public void setFamiliaCDelMunicipioFamiliapthisFamiliaCInstance(FamiliaC familiaCDelMunicipioFamiliapthisFamiliaC) {
        this.familiaCDelMunicipioFamiliapthisFamiliaCInstance = familiaCDelMunicipioFamiliapthisFamiliaC;
        this.familiaCDelMunicipioFamiliapthisFamiliaC = familiaCDelMunicipioFamiliapthisFamiliaC != null ? familiaCDelMunicipioFamiliapthisFamiliaC.getOid() : null;
    }

    private void checkFamiliaCDelMunicipioFamiliapthisFamiliaC() throws NotNullArgumentException {
        if(this.getFamiliaCDelMunicipioFamiliapthisFamiliaCInstance() == null || this.getFamiliaCDelMunicipioFamiliapthisFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_DELMUNICIPIOFAMILIA, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_DELMUNICIPIOFAMILIA_FAMILIACDELMUNICIPIOFAMILIAPTHISFAMILIAC, FamiliaCConstants.SERV_ALIAS_DELMUNICIPIOFAMILIA, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_DELMUNICIPIOFAMILIA_FAMILIACDELMUNICIPIOFAMILIAPTHISFAMILIAC);
        }
    }

    @JsonIgnore
    public MunicipioOid getFamiliaCDelMunicipioFamiliapevcMunicipio() {
        return this.familiaCDelMunicipioFamiliapevcMunicipio;
    }
    
    public void setFamiliaCDelMunicipioFamiliapevcMunicipio(MunicipioOid familiaCDelMunicipioFamiliapevcMunicipio) {
        this.familiaCDelMunicipioFamiliapevcMunicipio = familiaCDelMunicipioFamiliapevcMunicipio;
    }

    @JsonIgnore
    public Municipio getFamiliaCDelMunicipioFamiliapevcMunicipioInstance() {
        return this.familiaCDelMunicipioFamiliapevcMunicipioInstance;
    }
    
    public void setFamiliaCDelMunicipioFamiliapevcMunicipioInstance(Municipio familiaCDelMunicipioFamiliapevcMunicipio) {
        this.familiaCDelMunicipioFamiliapevcMunicipioInstance = familiaCDelMunicipioFamiliapevcMunicipio;
        this.familiaCDelMunicipioFamiliapevcMunicipio = familiaCDelMunicipioFamiliapevcMunicipio != null ? familiaCDelMunicipioFamiliapevcMunicipio.getOid() : null;
    }

    private void checkFamiliaCDelMunicipioFamiliapevcMunicipio() throws NotNullArgumentException {
        if(this.getFamiliaCDelMunicipioFamiliapevcMunicipioInstance() == null || this.getFamiliaCDelMunicipioFamiliapevcMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_DELMUNICIPIOFAMILIA, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_DELMUNICIPIOFAMILIA_FAMILIACDELMUNICIPIOFAMILIAPEVCMUNICIPIO, FamiliaCConstants.SERV_ALIAS_DELMUNICIPIOFAMILIA, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_DELMUNICIPIOFAMILIA_FAMILIACDELMUNICIPIOFAMILIAPEVCMUNICIPIO);
        }
    }
}
