package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class DelPersonaCContratanteRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCDelPersonaCContratantepthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCDelPersonaCContratantepthisContratoCInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid contratoCDelPersonaCContratantepevcPersonaC;
    
    @JsonIgnore
    private PersonaC contratoCDelPersonaCContratantepevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCDelPersonaCContratantepthisContratoC();
        checkContratoCDelPersonaCContratantepevcPersonaC();
    }

    @JsonIgnore
    public ContratoCOid getContratoCDelPersonaCContratantepthisContratoC() {
        return this.contratoCDelPersonaCContratantepthisContratoC;
    }
    
    public void setContratoCDelPersonaCContratantepthisContratoC(ContratoCOid contratoCDelPersonaCContratantepthisContratoC) {
        this.contratoCDelPersonaCContratantepthisContratoC = contratoCDelPersonaCContratantepthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCDelPersonaCContratantepthisContratoCInstance() {
        return this.contratoCDelPersonaCContratantepthisContratoCInstance;
    }
    
    public void setContratoCDelPersonaCContratantepthisContratoCInstance(ContratoC contratoCDelPersonaCContratantepthisContratoC) {
        this.contratoCDelPersonaCContratantepthisContratoCInstance = contratoCDelPersonaCContratantepthisContratoC;
        this.contratoCDelPersonaCContratantepthisContratoC = contratoCDelPersonaCContratantepthisContratoC != null ? contratoCDelPersonaCContratantepthisContratoC.getOid() : null;
    }

    private void checkContratoCDelPersonaCContratantepthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCDelPersonaCContratantepthisContratoCInstance() == null || this.getContratoCDelPersonaCContratantepthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELPERSONACCONTRATANTE, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELPERSONACCONTRATANTE_CONTRATOCDELPERSONACCONTRATANTEPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_DELPERSONACCONTRATANTE, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELPERSONACCONTRATANTE_CONTRATOCDELPERSONACCONTRATANTEPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public PersonaCOid getContratoCDelPersonaCContratantepevcPersonaC() {
        return this.contratoCDelPersonaCContratantepevcPersonaC;
    }
    
    public void setContratoCDelPersonaCContratantepevcPersonaC(PersonaCOid contratoCDelPersonaCContratantepevcPersonaC) {
        this.contratoCDelPersonaCContratantepevcPersonaC = contratoCDelPersonaCContratantepevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getContratoCDelPersonaCContratantepevcPersonaCInstance() {
        return this.contratoCDelPersonaCContratantepevcPersonaCInstance;
    }
    
    public void setContratoCDelPersonaCContratantepevcPersonaCInstance(PersonaC contratoCDelPersonaCContratantepevcPersonaC) {
        this.contratoCDelPersonaCContratantepevcPersonaCInstance = contratoCDelPersonaCContratantepevcPersonaC;
        this.contratoCDelPersonaCContratantepevcPersonaC = contratoCDelPersonaCContratantepevcPersonaC != null ? contratoCDelPersonaCContratantepevcPersonaC.getOid() : null;
    }

    private void checkContratoCDelPersonaCContratantepevcPersonaC() throws NotNullArgumentException {
        if(this.getContratoCDelPersonaCContratantepevcPersonaCInstance() == null || this.getContratoCDelPersonaCContratantepevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELPERSONACCONTRATANTE, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELPERSONACCONTRATANTE_CONTRATOCDELPERSONACCONTRATANTEPEVCPERSONAC, ContratoCConstants.SERV_ALIAS_DELPERSONACCONTRATANTE, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELPERSONACCONTRATANTE_CONTRATOCDELPERSONACCONTRATANTEPEVCPERSONAC);
        }
    }
}
