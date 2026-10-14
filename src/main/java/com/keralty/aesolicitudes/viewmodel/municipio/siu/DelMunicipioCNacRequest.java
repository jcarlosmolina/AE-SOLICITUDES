package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class DelMunicipioCNacRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioDelMunicipioCNacpthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioDelMunicipioCNacpthisMunicipioInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid municipioDelMunicipioCNacpevcPersonaC;
    
    @JsonIgnore
    private PersonaC municipioDelMunicipioCNacpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioDelMunicipioCNacpthisMunicipio();
        checkMunicipioDelMunicipioCNacpevcPersonaC();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioDelMunicipioCNacpthisMunicipio() {
        return this.municipioDelMunicipioCNacpthisMunicipio;
    }
    
    public void setMunicipioDelMunicipioCNacpthisMunicipio(MunicipioOid municipioDelMunicipioCNacpthisMunicipio) {
        this.municipioDelMunicipioCNacpthisMunicipio = municipioDelMunicipioCNacpthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioDelMunicipioCNacpthisMunicipioInstance() {
        return this.municipioDelMunicipioCNacpthisMunicipioInstance;
    }
    
    public void setMunicipioDelMunicipioCNacpthisMunicipioInstance(Municipio municipioDelMunicipioCNacpthisMunicipio) {
        this.municipioDelMunicipioCNacpthisMunicipioInstance = municipioDelMunicipioCNacpthisMunicipio;
        this.municipioDelMunicipioCNacpthisMunicipio = municipioDelMunicipioCNacpthisMunicipio != null ? municipioDelMunicipioCNacpthisMunicipio.getOid() : null;
    }

    private void checkMunicipioDelMunicipioCNacpthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioDelMunicipioCNacpthisMunicipioInstance() == null || this.getMunicipioDelMunicipioCNacpthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_DELMUNICIPIOCNAC, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_DELMUNICIPIOCNAC_MUNICIPIODELMUNICIPIOCNACPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_DELMUNICIPIOCNAC, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_DELMUNICIPIOCNAC_MUNICIPIODELMUNICIPIOCNACPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public PersonaCOid getMunicipioDelMunicipioCNacpevcPersonaC() {
        return this.municipioDelMunicipioCNacpevcPersonaC;
    }
    
    public void setMunicipioDelMunicipioCNacpevcPersonaC(PersonaCOid municipioDelMunicipioCNacpevcPersonaC) {
        this.municipioDelMunicipioCNacpevcPersonaC = municipioDelMunicipioCNacpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getMunicipioDelMunicipioCNacpevcPersonaCInstance() {
        return this.municipioDelMunicipioCNacpevcPersonaCInstance;
    }
    
    public void setMunicipioDelMunicipioCNacpevcPersonaCInstance(PersonaC municipioDelMunicipioCNacpevcPersonaC) {
        this.municipioDelMunicipioCNacpevcPersonaCInstance = municipioDelMunicipioCNacpevcPersonaC;
        this.municipioDelMunicipioCNacpevcPersonaC = municipioDelMunicipioCNacpevcPersonaC != null ? municipioDelMunicipioCNacpevcPersonaC.getOid() : null;
    }

    private void checkMunicipioDelMunicipioCNacpevcPersonaC() throws NotNullArgumentException {
        if(this.getMunicipioDelMunicipioCNacpevcPersonaCInstance() == null || this.getMunicipioDelMunicipioCNacpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_DELMUNICIPIOCNAC, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_DELMUNICIPIOCNAC_MUNICIPIODELMUNICIPIOCNACPEVCPERSONAC, MunicipioConstants.SERV_ALIAS_DELMUNICIPIOCNAC, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_DELMUNICIPIOCNAC_MUNICIPIODELMUNICIPIOCNACPEVCPERSONAC);
        }
    }
}
