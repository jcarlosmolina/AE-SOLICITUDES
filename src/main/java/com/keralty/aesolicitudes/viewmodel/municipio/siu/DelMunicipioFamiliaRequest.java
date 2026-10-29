package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class DelMunicipioFamiliaRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioDelMunicipioFamiliapthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioDelMunicipioFamiliapthisMunicipioInstance;

    @JsonProperty("p_evcfamiliac_oid")
    private FamiliaCOid municipioDelMunicipioFamiliapevcFamiliaC;
    
    @JsonIgnore
    private FamiliaC municipioDelMunicipioFamiliapevcFamiliaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioDelMunicipioFamiliapthisMunicipio();
        checkMunicipioDelMunicipioFamiliapevcFamiliaC();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioDelMunicipioFamiliapthisMunicipio() {
        return this.municipioDelMunicipioFamiliapthisMunicipio;
    }
    
    public void setMunicipioDelMunicipioFamiliapthisMunicipio(MunicipioOid municipioDelMunicipioFamiliapthisMunicipio) {
        this.municipioDelMunicipioFamiliapthisMunicipio = municipioDelMunicipioFamiliapthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioDelMunicipioFamiliapthisMunicipioInstance() {
        return this.municipioDelMunicipioFamiliapthisMunicipioInstance;
    }
    
    public void setMunicipioDelMunicipioFamiliapthisMunicipioInstance(Municipio municipioDelMunicipioFamiliapthisMunicipio) {
        this.municipioDelMunicipioFamiliapthisMunicipioInstance = municipioDelMunicipioFamiliapthisMunicipio;
        this.municipioDelMunicipioFamiliapthisMunicipio = municipioDelMunicipioFamiliapthisMunicipio != null ? municipioDelMunicipioFamiliapthisMunicipio.getOid() : null;
    }

    private void checkMunicipioDelMunicipioFamiliapthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioDelMunicipioFamiliapthisMunicipioInstance() == null || this.getMunicipioDelMunicipioFamiliapthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_DELMUNICIPIOFAMILIA, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_DELMUNICIPIOFAMILIA_MUNICIPIODELMUNICIPIOFAMILIAPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_DELMUNICIPIOFAMILIA, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_DELMUNICIPIOFAMILIA_MUNICIPIODELMUNICIPIOFAMILIAPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public FamiliaCOid getMunicipioDelMunicipioFamiliapevcFamiliaC() {
        return this.municipioDelMunicipioFamiliapevcFamiliaC;
    }
    
    public void setMunicipioDelMunicipioFamiliapevcFamiliaC(FamiliaCOid municipioDelMunicipioFamiliapevcFamiliaC) {
        this.municipioDelMunicipioFamiliapevcFamiliaC = municipioDelMunicipioFamiliapevcFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getMunicipioDelMunicipioFamiliapevcFamiliaCInstance() {
        return this.municipioDelMunicipioFamiliapevcFamiliaCInstance;
    }
    
    public void setMunicipioDelMunicipioFamiliapevcFamiliaCInstance(FamiliaC municipioDelMunicipioFamiliapevcFamiliaC) {
        this.municipioDelMunicipioFamiliapevcFamiliaCInstance = municipioDelMunicipioFamiliapevcFamiliaC;
        this.municipioDelMunicipioFamiliapevcFamiliaC = municipioDelMunicipioFamiliapevcFamiliaC != null ? municipioDelMunicipioFamiliapevcFamiliaC.getOid() : null;
    }

    private void checkMunicipioDelMunicipioFamiliapevcFamiliaC() throws NotNullArgumentException {
        if(this.getMunicipioDelMunicipioFamiliapevcFamiliaCInstance() == null || this.getMunicipioDelMunicipioFamiliapevcFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_DELMUNICIPIOFAMILIA, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_DELMUNICIPIOFAMILIA_MUNICIPIODELMUNICIPIOFAMILIAPEVCFAMILIAC, MunicipioConstants.SERV_ALIAS_DELMUNICIPIOFAMILIA, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_DELMUNICIPIOFAMILIA_MUNICIPIODELMUNICIPIOFAMILIAPEVCFAMILIAC);
        }
    }
}
