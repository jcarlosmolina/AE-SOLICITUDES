package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoEntidadCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoEntidadC;

public class DelTipoEntidadCPersonaCRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCDelTipoEntidadCPersonaCpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCDelTipoEntidadCPersonaCpthisPersonaCInstance;

    @JsonProperty("p_evctipoentidadc_oid")
    private TipoEntidadCOid personaCDelTipoEntidadCPersonaCpevcTipoEntidadC;
    
    @JsonIgnore
    private TipoEntidadC personaCDelTipoEntidadCPersonaCpevcTipoEntidadCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCDelTipoEntidadCPersonaCpthisPersonaC();
        checkPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadC();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCDelTipoEntidadCPersonaCpthisPersonaC() {
        return this.personaCDelTipoEntidadCPersonaCpthisPersonaC;
    }
    
    public void setPersonaCDelTipoEntidadCPersonaCpthisPersonaC(PersonaCOid personaCDelTipoEntidadCPersonaCpthisPersonaC) {
        this.personaCDelTipoEntidadCPersonaCpthisPersonaC = personaCDelTipoEntidadCPersonaCpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCDelTipoEntidadCPersonaCpthisPersonaCInstance() {
        return this.personaCDelTipoEntidadCPersonaCpthisPersonaCInstance;
    }
    
    public void setPersonaCDelTipoEntidadCPersonaCpthisPersonaCInstance(PersonaC personaCDelTipoEntidadCPersonaCpthisPersonaC) {
        this.personaCDelTipoEntidadCPersonaCpthisPersonaCInstance = personaCDelTipoEntidadCPersonaCpthisPersonaC;
        this.personaCDelTipoEntidadCPersonaCpthisPersonaC = personaCDelTipoEntidadCPersonaCpthisPersonaC != null ? personaCDelTipoEntidadCPersonaCpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCDelTipoEntidadCPersonaCpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCDelTipoEntidadCPersonaCpthisPersonaCInstance() == null || this.getPersonaCDelTipoEntidadCPersonaCpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_DELTIPOENTIDADCPERSONAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_DELTIPOENTIDADCPERSONAC_PERSONACDELTIPOENTIDADCPERSONACPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_DELTIPOENTIDADCPERSONAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_DELTIPOENTIDADCPERSONAC_PERSONACDELTIPOENTIDADCPERSONACPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public TipoEntidadCOid getPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadC() {
        return this.personaCDelTipoEntidadCPersonaCpevcTipoEntidadC;
    }
    
    public void setPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadC(TipoEntidadCOid personaCDelTipoEntidadCPersonaCpevcTipoEntidadC) {
        this.personaCDelTipoEntidadCPersonaCpevcTipoEntidadC = personaCDelTipoEntidadCPersonaCpevcTipoEntidadC;
    }

    @JsonIgnore
    public TipoEntidadC getPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadCInstance() {
        return this.personaCDelTipoEntidadCPersonaCpevcTipoEntidadCInstance;
    }
    
    public void setPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadCInstance(TipoEntidadC personaCDelTipoEntidadCPersonaCpevcTipoEntidadC) {
        this.personaCDelTipoEntidadCPersonaCpevcTipoEntidadCInstance = personaCDelTipoEntidadCPersonaCpevcTipoEntidadC;
        this.personaCDelTipoEntidadCPersonaCpevcTipoEntidadC = personaCDelTipoEntidadCPersonaCpevcTipoEntidadC != null ? personaCDelTipoEntidadCPersonaCpevcTipoEntidadC.getOid() : null;
    }

    private void checkPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadC() throws NotNullArgumentException {
        if(this.getPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadCInstance() == null || this.getPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_DELTIPOENTIDADCPERSONAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_DELTIPOENTIDADCPERSONAC_PERSONACDELTIPOENTIDADCPERSONACPEVCTIPOENTIDADC, PersonaCConstants.SERV_ALIAS_DELTIPOENTIDADCPERSONAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_DELTIPOENTIDADCPERSONAC_PERSONACDELTIPOENTIDADCPERSONACPEVCTIPOENTIDADC);
        }
    }
}
