package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsPersonaCContratanteRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCInsPersonaCContratantepthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCInsPersonaCContratantepthisPersonaCInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid personaCInsPersonaCContratantepevcContratoC;
    
    @JsonIgnore
    private ContratoC personaCInsPersonaCContratantepevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCInsPersonaCContratantepthisPersonaC();
        checkPersonaCInsPersonaCContratantepevcContratoC();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCInsPersonaCContratantepthisPersonaC() {
        return this.personaCInsPersonaCContratantepthisPersonaC;
    }
    
    public void setPersonaCInsPersonaCContratantepthisPersonaC(PersonaCOid personaCInsPersonaCContratantepthisPersonaC) {
        this.personaCInsPersonaCContratantepthisPersonaC = personaCInsPersonaCContratantepthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCInsPersonaCContratantepthisPersonaCInstance() {
        return this.personaCInsPersonaCContratantepthisPersonaCInstance;
    }
    
    public void setPersonaCInsPersonaCContratantepthisPersonaCInstance(PersonaC personaCInsPersonaCContratantepthisPersonaC) {
        this.personaCInsPersonaCContratantepthisPersonaCInstance = personaCInsPersonaCContratantepthisPersonaC;
        this.personaCInsPersonaCContratantepthisPersonaC = personaCInsPersonaCContratantepthisPersonaC != null ? personaCInsPersonaCContratantepthisPersonaC.getOid() : null;
    }

    private void checkPersonaCInsPersonaCContratantepthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCInsPersonaCContratantepthisPersonaCInstance() == null || this.getPersonaCInsPersonaCContratantepthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSPERSONACCONTRATANTE, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSPERSONACCONTRATANTE_PERSONACINSPERSONACCONTRATANTEPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_INSPERSONACCONTRATANTE, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSPERSONACCONTRATANTE_PERSONACINSPERSONACCONTRATANTEPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public ContratoCOid getPersonaCInsPersonaCContratantepevcContratoC() {
        return this.personaCInsPersonaCContratantepevcContratoC;
    }
    
    public void setPersonaCInsPersonaCContratantepevcContratoC(ContratoCOid personaCInsPersonaCContratantepevcContratoC) {
        this.personaCInsPersonaCContratantepevcContratoC = personaCInsPersonaCContratantepevcContratoC;
    }

    @JsonIgnore
    public ContratoC getPersonaCInsPersonaCContratantepevcContratoCInstance() {
        return this.personaCInsPersonaCContratantepevcContratoCInstance;
    }
    
    public void setPersonaCInsPersonaCContratantepevcContratoCInstance(ContratoC personaCInsPersonaCContratantepevcContratoC) {
        this.personaCInsPersonaCContratantepevcContratoCInstance = personaCInsPersonaCContratantepevcContratoC;
        this.personaCInsPersonaCContratantepevcContratoC = personaCInsPersonaCContratantepevcContratoC != null ? personaCInsPersonaCContratantepevcContratoC.getOid() : null;
    }

    private void checkPersonaCInsPersonaCContratantepevcContratoC() throws NotNullArgumentException {
        if(this.getPersonaCInsPersonaCContratantepevcContratoCInstance() == null || this.getPersonaCInsPersonaCContratantepevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSPERSONACCONTRATANTE, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSPERSONACCONTRATANTE_PERSONACINSPERSONACCONTRATANTEPEVCCONTRATOC, PersonaCConstants.SERV_ALIAS_INSPERSONACCONTRATANTE, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSPERSONACCONTRATANTE_PERSONACINSPERSONACCONTRATANTEPEVCCONTRATOC);
        }
    }
}
