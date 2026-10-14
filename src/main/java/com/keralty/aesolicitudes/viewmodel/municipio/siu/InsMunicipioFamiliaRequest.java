package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class InsMunicipioFamiliaRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioInsMunicipioFamiliapthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioInsMunicipioFamiliapthisMunicipioInstance;

    @JsonProperty("p_evcfamiliac_oid")
    private FamiliaCOid municipioInsMunicipioFamiliapevcFamiliaC;
    
    @JsonIgnore
    private FamiliaC municipioInsMunicipioFamiliapevcFamiliaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioInsMunicipioFamiliapthisMunicipio();
        checkMunicipioInsMunicipioFamiliapevcFamiliaC();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioInsMunicipioFamiliapthisMunicipio() {
        return this.municipioInsMunicipioFamiliapthisMunicipio;
    }
    
    public void setMunicipioInsMunicipioFamiliapthisMunicipio(MunicipioOid municipioInsMunicipioFamiliapthisMunicipio) {
        this.municipioInsMunicipioFamiliapthisMunicipio = municipioInsMunicipioFamiliapthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioInsMunicipioFamiliapthisMunicipioInstance() {
        return this.municipioInsMunicipioFamiliapthisMunicipioInstance;
    }
    
    public void setMunicipioInsMunicipioFamiliapthisMunicipioInstance(Municipio municipioInsMunicipioFamiliapthisMunicipio) {
        this.municipioInsMunicipioFamiliapthisMunicipioInstance = municipioInsMunicipioFamiliapthisMunicipio;
        this.municipioInsMunicipioFamiliapthisMunicipio = municipioInsMunicipioFamiliapthisMunicipio != null ? municipioInsMunicipioFamiliapthisMunicipio.getOid() : null;
    }

    private void checkMunicipioInsMunicipioFamiliapthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioFamiliapthisMunicipioInstance() == null || this.getMunicipioInsMunicipioFamiliapthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIOFAMILIA, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIOFAMILIA_MUNICIPIOINSMUNICIPIOFAMILIAPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_INSMUNICIPIOFAMILIA, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIOFAMILIA_MUNICIPIOINSMUNICIPIOFAMILIAPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public FamiliaCOid getMunicipioInsMunicipioFamiliapevcFamiliaC() {
        return this.municipioInsMunicipioFamiliapevcFamiliaC;
    }
    
    public void setMunicipioInsMunicipioFamiliapevcFamiliaC(FamiliaCOid municipioInsMunicipioFamiliapevcFamiliaC) {
        this.municipioInsMunicipioFamiliapevcFamiliaC = municipioInsMunicipioFamiliapevcFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getMunicipioInsMunicipioFamiliapevcFamiliaCInstance() {
        return this.municipioInsMunicipioFamiliapevcFamiliaCInstance;
    }
    
    public void setMunicipioInsMunicipioFamiliapevcFamiliaCInstance(FamiliaC municipioInsMunicipioFamiliapevcFamiliaC) {
        this.municipioInsMunicipioFamiliapevcFamiliaCInstance = municipioInsMunicipioFamiliapevcFamiliaC;
        this.municipioInsMunicipioFamiliapevcFamiliaC = municipioInsMunicipioFamiliapevcFamiliaC != null ? municipioInsMunicipioFamiliapevcFamiliaC.getOid() : null;
    }

    private void checkMunicipioInsMunicipioFamiliapevcFamiliaC() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioFamiliapevcFamiliaCInstance() == null || this.getMunicipioInsMunicipioFamiliapevcFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIOFAMILIA, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIOFAMILIA_MUNICIPIOINSMUNICIPIOFAMILIAPEVCFAMILIAC, MunicipioConstants.SERV_ALIAS_INSMUNICIPIOFAMILIA, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIOFAMILIA_MUNICIPIOINSMUNICIPIOFAMILIAPEVCFAMILIAC);
        }
    }
}
