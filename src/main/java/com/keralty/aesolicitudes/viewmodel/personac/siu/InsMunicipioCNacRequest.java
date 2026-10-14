package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsMunicipioCNacRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCInsMunicipioCNacpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCInsMunicipioCNacpthisPersonaCInstance;

    @JsonProperty("p_evcmunicipio_oid")
    private MunicipioOid personaCInsMunicipioCNacpevcMunicipio;
    
    @JsonIgnore
    private Municipio personaCInsMunicipioCNacpevcMunicipioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCInsMunicipioCNacpthisPersonaC();
        checkPersonaCInsMunicipioCNacpevcMunicipio();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCInsMunicipioCNacpthisPersonaC() {
        return this.personaCInsMunicipioCNacpthisPersonaC;
    }
    
    public void setPersonaCInsMunicipioCNacpthisPersonaC(PersonaCOid personaCInsMunicipioCNacpthisPersonaC) {
        this.personaCInsMunicipioCNacpthisPersonaC = personaCInsMunicipioCNacpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCInsMunicipioCNacpthisPersonaCInstance() {
        return this.personaCInsMunicipioCNacpthisPersonaCInstance;
    }
    
    public void setPersonaCInsMunicipioCNacpthisPersonaCInstance(PersonaC personaCInsMunicipioCNacpthisPersonaC) {
        this.personaCInsMunicipioCNacpthisPersonaCInstance = personaCInsMunicipioCNacpthisPersonaC;
        this.personaCInsMunicipioCNacpthisPersonaC = personaCInsMunicipioCNacpthisPersonaC != null ? personaCInsMunicipioCNacpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCInsMunicipioCNacpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCInsMunicipioCNacpthisPersonaCInstance() == null || this.getPersonaCInsMunicipioCNacpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSMUNICIPIOCNAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSMUNICIPIOCNAC_PERSONACINSMUNICIPIOCNACPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_INSMUNICIPIOCNAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSMUNICIPIOCNAC_PERSONACINSMUNICIPIOCNACPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public MunicipioOid getPersonaCInsMunicipioCNacpevcMunicipio() {
        return this.personaCInsMunicipioCNacpevcMunicipio;
    }
    
    public void setPersonaCInsMunicipioCNacpevcMunicipio(MunicipioOid personaCInsMunicipioCNacpevcMunicipio) {
        this.personaCInsMunicipioCNacpevcMunicipio = personaCInsMunicipioCNacpevcMunicipio;
    }

    @JsonIgnore
    public Municipio getPersonaCInsMunicipioCNacpevcMunicipioInstance() {
        return this.personaCInsMunicipioCNacpevcMunicipioInstance;
    }
    
    public void setPersonaCInsMunicipioCNacpevcMunicipioInstance(Municipio personaCInsMunicipioCNacpevcMunicipio) {
        this.personaCInsMunicipioCNacpevcMunicipioInstance = personaCInsMunicipioCNacpevcMunicipio;
        this.personaCInsMunicipioCNacpevcMunicipio = personaCInsMunicipioCNacpevcMunicipio != null ? personaCInsMunicipioCNacpevcMunicipio.getOid() : null;
    }

    private void checkPersonaCInsMunicipioCNacpevcMunicipio() throws NotNullArgumentException {
        if(this.getPersonaCInsMunicipioCNacpevcMunicipioInstance() == null || this.getPersonaCInsMunicipioCNacpevcMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSMUNICIPIOCNAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSMUNICIPIOCNAC_PERSONACINSMUNICIPIOCNACPEVCMUNICIPIO, PersonaCConstants.SERV_ALIAS_INSMUNICIPIOCNAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSMUNICIPIOCNAC_PERSONACINSMUNICIPIOCNACPEVCMUNICIPIO);
        }
    }
}
