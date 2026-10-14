package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoInstitucionCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoInstitucionC;

public class InsTipoInstitucionCPersonaCRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCInsTipoInstitucionCPersonaCpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCInsTipoInstitucionCPersonaCpthisPersonaCInstance;

    @JsonProperty("p_evctipoinstitucionc_oid")
    private TipoInstitucionCOid personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC;
    
    @JsonIgnore
    private TipoInstitucionC personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCInsTipoInstitucionCPersonaCpthisPersonaC();
        checkPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCInsTipoInstitucionCPersonaCpthisPersonaC() {
        return this.personaCInsTipoInstitucionCPersonaCpthisPersonaC;
    }
    
    public void setPersonaCInsTipoInstitucionCPersonaCpthisPersonaC(PersonaCOid personaCInsTipoInstitucionCPersonaCpthisPersonaC) {
        this.personaCInsTipoInstitucionCPersonaCpthisPersonaC = personaCInsTipoInstitucionCPersonaCpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCInsTipoInstitucionCPersonaCpthisPersonaCInstance() {
        return this.personaCInsTipoInstitucionCPersonaCpthisPersonaCInstance;
    }
    
    public void setPersonaCInsTipoInstitucionCPersonaCpthisPersonaCInstance(PersonaC personaCInsTipoInstitucionCPersonaCpthisPersonaC) {
        this.personaCInsTipoInstitucionCPersonaCpthisPersonaCInstance = personaCInsTipoInstitucionCPersonaCpthisPersonaC;
        this.personaCInsTipoInstitucionCPersonaCpthisPersonaC = personaCInsTipoInstitucionCPersonaCpthisPersonaC != null ? personaCInsTipoInstitucionCPersonaCpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCInsTipoInstitucionCPersonaCpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCInsTipoInstitucionCPersonaCpthisPersonaCInstance() == null || this.getPersonaCInsTipoInstitucionCPersonaCpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSTIPOINSTITUCIONCPERSONAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSTIPOINSTITUCIONCPERSONAC_PERSONACINSTIPOINSTITUCIONCPERSONACPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_INSTIPOINSTITUCIONCPERSONAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSTIPOINSTITUCIONCPERSONAC_PERSONACINSTIPOINSTITUCIONCPERSONACPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public TipoInstitucionCOid getPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC() {
        return this.personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC;
    }
    
    public void setPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC(TipoInstitucionCOid personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC) {
        this.personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC = personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC;
    }

    @JsonIgnore
    public TipoInstitucionC getPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionCInstance() {
        return this.personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionCInstance;
    }
    
    public void setPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionCInstance(TipoInstitucionC personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC) {
        this.personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionCInstance = personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC;
        this.personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC = personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC != null ? personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC.getOid() : null;
    }

    private void checkPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC() throws NotNullArgumentException {
        if(this.getPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionCInstance() == null || this.getPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSTIPOINSTITUCIONCPERSONAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSTIPOINSTITUCIONCPERSONAC_PERSONACINSTIPOINSTITUCIONCPERSONACPEVCTIPOINSTITUCIONC, PersonaCConstants.SERV_ALIAS_INSTIPOINSTITUCIONCPERSONAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSTIPOINSTITUCIONCPERSONAC_PERSONACINSTIPOINSTITUCIONCPERSONACPEVCTIPOINSTITUCIONC);
        }
    }
}
