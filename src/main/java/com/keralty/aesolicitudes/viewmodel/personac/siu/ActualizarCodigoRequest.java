package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class ActualizarCodigoRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCactualizarCodigopthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCactualizarCodigopthisPersonaCInstance;

    @JsonProperty("p_codigo")
    private Long personaCactualizarCodigopCodigo;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCactualizarCodigopthisPersonaC();
        checkPersonaCactualizarCodigopCodigo();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCactualizarCodigopthisPersonaC() {
        return this.personaCactualizarCodigopthisPersonaC;
    }
    
    public void setPersonaCactualizarCodigopthisPersonaC(PersonaCOid personaCactualizarCodigopthisPersonaC) {
        this.personaCactualizarCodigopthisPersonaC = personaCactualizarCodigopthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCactualizarCodigopthisPersonaCInstance() {
        return this.personaCactualizarCodigopthisPersonaCInstance;
    }
    
    public void setPersonaCactualizarCodigopthisPersonaCInstance(PersonaC personaCactualizarCodigopthisPersonaC) {
        this.personaCactualizarCodigopthisPersonaCInstance = personaCactualizarCodigopthisPersonaC;
        this.personaCactualizarCodigopthisPersonaC = personaCactualizarCodigopthisPersonaC != null ? personaCactualizarCodigopthisPersonaC.getOid() : null;
    }

    private void checkPersonaCactualizarCodigopthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCactualizarCodigopthisPersonaCInstance() == null || this.getPersonaCactualizarCodigopthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_ACTUALIZARCODIGO, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_ACTUALIZARCODIGO_PERSONACACTUALIZARCODIGOPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_ACTUALIZARCODIGO, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_ACTUALIZARCODIGO_PERSONACACTUALIZARCODIGOPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public Long getPersonaCactualizarCodigopCodigo() {
        return this.personaCactualizarCodigopCodigo;
    }
    
    public void setPersonaCactualizarCodigopCodigo(Long personaCactualizarCodigopCodigo) {
        this.personaCactualizarCodigopCodigo = personaCactualizarCodigopCodigo;
    }

    private void checkPersonaCactualizarCodigopCodigo() throws NotNullArgumentException {
        if(this.getPersonaCactualizarCodigopCodigo() == null) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_ACTUALIZARCODIGO, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_ACTUALIZARCODIGO_PERSONACACTUALIZARCODIGOPCODIGO, PersonaCConstants.SERV_ALIAS_ACTUALIZARCODIGO, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_ACTUALIZARCODIGO_PERSONACACTUALIZARCODIGOPCODIGO);
        }
    }
}
