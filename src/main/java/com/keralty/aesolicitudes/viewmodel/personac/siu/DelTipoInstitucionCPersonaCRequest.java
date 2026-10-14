package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoInstitucionCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoInstitucionC;

public class DelTipoInstitucionCPersonaCRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCDelTipoInstitucionCPersonaCpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCDelTipoInstitucionCPersonaCpthisPersonaCInstance;

    @JsonProperty("p_evctipoinstitucionc_oid")
    private TipoInstitucionCOid personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC;
    
    @JsonIgnore
    private TipoInstitucionC personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCDelTipoInstitucionCPersonaCpthisPersonaC();
        checkPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCDelTipoInstitucionCPersonaCpthisPersonaC() {
        return this.personaCDelTipoInstitucionCPersonaCpthisPersonaC;
    }
    
    public void setPersonaCDelTipoInstitucionCPersonaCpthisPersonaC(PersonaCOid personaCDelTipoInstitucionCPersonaCpthisPersonaC) {
        this.personaCDelTipoInstitucionCPersonaCpthisPersonaC = personaCDelTipoInstitucionCPersonaCpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCDelTipoInstitucionCPersonaCpthisPersonaCInstance() {
        return this.personaCDelTipoInstitucionCPersonaCpthisPersonaCInstance;
    }
    
    public void setPersonaCDelTipoInstitucionCPersonaCpthisPersonaCInstance(PersonaC personaCDelTipoInstitucionCPersonaCpthisPersonaC) {
        this.personaCDelTipoInstitucionCPersonaCpthisPersonaCInstance = personaCDelTipoInstitucionCPersonaCpthisPersonaC;
        this.personaCDelTipoInstitucionCPersonaCpthisPersonaC = personaCDelTipoInstitucionCPersonaCpthisPersonaC != null ? personaCDelTipoInstitucionCPersonaCpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCDelTipoInstitucionCPersonaCpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCDelTipoInstitucionCPersonaCpthisPersonaCInstance() == null || this.getPersonaCDelTipoInstitucionCPersonaCpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_DELTIPOINSTITUCIONCPERSONAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_DELTIPOINSTITUCIONCPERSONAC_PERSONACDELTIPOINSTITUCIONCPERSONACPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_DELTIPOINSTITUCIONCPERSONAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_DELTIPOINSTITUCIONCPERSONAC_PERSONACDELTIPOINSTITUCIONCPERSONACPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public TipoInstitucionCOid getPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC() {
        return this.personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC;
    }
    
    public void setPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC(TipoInstitucionCOid personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC) {
        this.personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC = personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC;
    }

    @JsonIgnore
    public TipoInstitucionC getPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionCInstance() {
        return this.personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionCInstance;
    }
    
    public void setPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionCInstance(TipoInstitucionC personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC) {
        this.personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionCInstance = personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC;
        this.personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC = personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC != null ? personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC.getOid() : null;
    }

    private void checkPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC() throws NotNullArgumentException {
        if(this.getPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionCInstance() == null || this.getPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_DELTIPOINSTITUCIONCPERSONAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_DELTIPOINSTITUCIONCPERSONAC_PERSONACDELTIPOINSTITUCIONCPERSONACPEVCTIPOINSTITUCIONC, PersonaCConstants.SERV_ALIAS_DELTIPOINSTITUCIONCPERSONAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_DELTIPOINSTITUCIONCPERSONAC_PERSONACDELTIPOINSTITUCIONCPERSONACPEVCTIPOINSTITUCIONC);
        }
    }
}
