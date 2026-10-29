package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoEntidadCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoEntidadC;

public class InsTipoEntidadCPersonaCRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCInsTipoEntidadCPersonaCpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCInsTipoEntidadCPersonaCpthisPersonaCInstance;

    @JsonProperty("p_evctipoentidadc_oid")
    private TipoEntidadCOid personaCInsTipoEntidadCPersonaCpevcTipoEntidadC;
    
    @JsonIgnore
    private TipoEntidadC personaCInsTipoEntidadCPersonaCpevcTipoEntidadCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCInsTipoEntidadCPersonaCpthisPersonaC();
        checkPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadC();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCInsTipoEntidadCPersonaCpthisPersonaC() {
        return this.personaCInsTipoEntidadCPersonaCpthisPersonaC;
    }
    
    public void setPersonaCInsTipoEntidadCPersonaCpthisPersonaC(PersonaCOid personaCInsTipoEntidadCPersonaCpthisPersonaC) {
        this.personaCInsTipoEntidadCPersonaCpthisPersonaC = personaCInsTipoEntidadCPersonaCpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCInsTipoEntidadCPersonaCpthisPersonaCInstance() {
        return this.personaCInsTipoEntidadCPersonaCpthisPersonaCInstance;
    }
    
    public void setPersonaCInsTipoEntidadCPersonaCpthisPersonaCInstance(PersonaC personaCInsTipoEntidadCPersonaCpthisPersonaC) {
        this.personaCInsTipoEntidadCPersonaCpthisPersonaCInstance = personaCInsTipoEntidadCPersonaCpthisPersonaC;
        this.personaCInsTipoEntidadCPersonaCpthisPersonaC = personaCInsTipoEntidadCPersonaCpthisPersonaC != null ? personaCInsTipoEntidadCPersonaCpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCInsTipoEntidadCPersonaCpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCInsTipoEntidadCPersonaCpthisPersonaCInstance() == null || this.getPersonaCInsTipoEntidadCPersonaCpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSTIPOENTIDADCPERSONAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSTIPOENTIDADCPERSONAC_PERSONACINSTIPOENTIDADCPERSONACPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_INSTIPOENTIDADCPERSONAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSTIPOENTIDADCPERSONAC_PERSONACINSTIPOENTIDADCPERSONACPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public TipoEntidadCOid getPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadC() {
        return this.personaCInsTipoEntidadCPersonaCpevcTipoEntidadC;
    }
    
    public void setPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadC(TipoEntidadCOid personaCInsTipoEntidadCPersonaCpevcTipoEntidadC) {
        this.personaCInsTipoEntidadCPersonaCpevcTipoEntidadC = personaCInsTipoEntidadCPersonaCpevcTipoEntidadC;
    }

    @JsonIgnore
    public TipoEntidadC getPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadCInstance() {
        return this.personaCInsTipoEntidadCPersonaCpevcTipoEntidadCInstance;
    }
    
    public void setPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadCInstance(TipoEntidadC personaCInsTipoEntidadCPersonaCpevcTipoEntidadC) {
        this.personaCInsTipoEntidadCPersonaCpevcTipoEntidadCInstance = personaCInsTipoEntidadCPersonaCpevcTipoEntidadC;
        this.personaCInsTipoEntidadCPersonaCpevcTipoEntidadC = personaCInsTipoEntidadCPersonaCpevcTipoEntidadC != null ? personaCInsTipoEntidadCPersonaCpevcTipoEntidadC.getOid() : null;
    }

    private void checkPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadC() throws NotNullArgumentException {
        if(this.getPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadCInstance() == null || this.getPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSTIPOENTIDADCPERSONAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSTIPOENTIDADCPERSONAC_PERSONACINSTIPOENTIDADCPERSONACPEVCTIPOENTIDADC, PersonaCConstants.SERV_ALIAS_INSTIPOENTIDADCPERSONAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSTIPOENTIDADCPERSONAC_PERSONACINSTIPOENTIDADCPERSONACPEVCTIPOENTIDADC);
        }
    }
}
