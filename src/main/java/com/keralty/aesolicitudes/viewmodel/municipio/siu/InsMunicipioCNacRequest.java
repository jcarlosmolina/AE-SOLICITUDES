package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsMunicipioCNacRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioInsMunicipioCNacpthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioInsMunicipioCNacpthisMunicipioInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid municipioInsMunicipioCNacpevcPersonaC;
    
    @JsonIgnore
    private PersonaC municipioInsMunicipioCNacpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioInsMunicipioCNacpthisMunicipio();
        checkMunicipioInsMunicipioCNacpevcPersonaC();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioInsMunicipioCNacpthisMunicipio() {
        return this.municipioInsMunicipioCNacpthisMunicipio;
    }
    
    public void setMunicipioInsMunicipioCNacpthisMunicipio(MunicipioOid municipioInsMunicipioCNacpthisMunicipio) {
        this.municipioInsMunicipioCNacpthisMunicipio = municipioInsMunicipioCNacpthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioInsMunicipioCNacpthisMunicipioInstance() {
        return this.municipioInsMunicipioCNacpthisMunicipioInstance;
    }
    
    public void setMunicipioInsMunicipioCNacpthisMunicipioInstance(Municipio municipioInsMunicipioCNacpthisMunicipio) {
        this.municipioInsMunicipioCNacpthisMunicipioInstance = municipioInsMunicipioCNacpthisMunicipio;
        this.municipioInsMunicipioCNacpthisMunicipio = municipioInsMunicipioCNacpthisMunicipio != null ? municipioInsMunicipioCNacpthisMunicipio.getOid() : null;
    }

    private void checkMunicipioInsMunicipioCNacpthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioCNacpthisMunicipioInstance() == null || this.getMunicipioInsMunicipioCNacpthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIOCNAC, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIOCNAC_MUNICIPIOINSMUNICIPIOCNACPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_INSMUNICIPIOCNAC, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIOCNAC_MUNICIPIOINSMUNICIPIOCNACPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public PersonaCOid getMunicipioInsMunicipioCNacpevcPersonaC() {
        return this.municipioInsMunicipioCNacpevcPersonaC;
    }
    
    public void setMunicipioInsMunicipioCNacpevcPersonaC(PersonaCOid municipioInsMunicipioCNacpevcPersonaC) {
        this.municipioInsMunicipioCNacpevcPersonaC = municipioInsMunicipioCNacpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getMunicipioInsMunicipioCNacpevcPersonaCInstance() {
        return this.municipioInsMunicipioCNacpevcPersonaCInstance;
    }
    
    public void setMunicipioInsMunicipioCNacpevcPersonaCInstance(PersonaC municipioInsMunicipioCNacpevcPersonaC) {
        this.municipioInsMunicipioCNacpevcPersonaCInstance = municipioInsMunicipioCNacpevcPersonaC;
        this.municipioInsMunicipioCNacpevcPersonaC = municipioInsMunicipioCNacpevcPersonaC != null ? municipioInsMunicipioCNacpevcPersonaC.getOid() : null;
    }

    private void checkMunicipioInsMunicipioCNacpevcPersonaC() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioCNacpevcPersonaCInstance() == null || this.getMunicipioInsMunicipioCNacpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIOCNAC, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIOCNAC_MUNICIPIOINSMUNICIPIOCNACPEVCPERSONAC, MunicipioConstants.SERV_ALIAS_INSMUNICIPIOCNAC, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIOCNAC_MUNICIPIOINSMUNICIPIOCNACPEVCPERSONAC);
        }
    }
}
