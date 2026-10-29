package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsPersonaCContratanteRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCInsPersonaCContratantepthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCInsPersonaCContratantepthisContratoCInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid contratoCInsPersonaCContratantepevcPersonaC;
    
    @JsonIgnore
    private PersonaC contratoCInsPersonaCContratantepevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCInsPersonaCContratantepthisContratoC();
        checkContratoCInsPersonaCContratantepevcPersonaC();
    }

    @JsonIgnore
    public ContratoCOid getContratoCInsPersonaCContratantepthisContratoC() {
        return this.contratoCInsPersonaCContratantepthisContratoC;
    }
    
    public void setContratoCInsPersonaCContratantepthisContratoC(ContratoCOid contratoCInsPersonaCContratantepthisContratoC) {
        this.contratoCInsPersonaCContratantepthisContratoC = contratoCInsPersonaCContratantepthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCInsPersonaCContratantepthisContratoCInstance() {
        return this.contratoCInsPersonaCContratantepthisContratoCInstance;
    }
    
    public void setContratoCInsPersonaCContratantepthisContratoCInstance(ContratoC contratoCInsPersonaCContratantepthisContratoC) {
        this.contratoCInsPersonaCContratantepthisContratoCInstance = contratoCInsPersonaCContratantepthisContratoC;
        this.contratoCInsPersonaCContratantepthisContratoC = contratoCInsPersonaCContratantepthisContratoC != null ? contratoCInsPersonaCContratantepthisContratoC.getOid() : null;
    }

    private void checkContratoCInsPersonaCContratantepthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCInsPersonaCContratantepthisContratoCInstance() == null || this.getContratoCInsPersonaCContratantepthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSPERSONACCONTRATANTE, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSPERSONACCONTRATANTE_CONTRATOCINSPERSONACCONTRATANTEPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_INSPERSONACCONTRATANTE, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSPERSONACCONTRATANTE_CONTRATOCINSPERSONACCONTRATANTEPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public PersonaCOid getContratoCInsPersonaCContratantepevcPersonaC() {
        return this.contratoCInsPersonaCContratantepevcPersonaC;
    }
    
    public void setContratoCInsPersonaCContratantepevcPersonaC(PersonaCOid contratoCInsPersonaCContratantepevcPersonaC) {
        this.contratoCInsPersonaCContratantepevcPersonaC = contratoCInsPersonaCContratantepevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getContratoCInsPersonaCContratantepevcPersonaCInstance() {
        return this.contratoCInsPersonaCContratantepevcPersonaCInstance;
    }
    
    public void setContratoCInsPersonaCContratantepevcPersonaCInstance(PersonaC contratoCInsPersonaCContratantepevcPersonaC) {
        this.contratoCInsPersonaCContratantepevcPersonaCInstance = contratoCInsPersonaCContratantepevcPersonaC;
        this.contratoCInsPersonaCContratantepevcPersonaC = contratoCInsPersonaCContratantepevcPersonaC != null ? contratoCInsPersonaCContratantepevcPersonaC.getOid() : null;
    }

    private void checkContratoCInsPersonaCContratantepevcPersonaC() throws NotNullArgumentException {
        if(this.getContratoCInsPersonaCContratantepevcPersonaCInstance() == null || this.getContratoCInsPersonaCContratantepevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSPERSONACCONTRATANTE, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSPERSONACCONTRATANTE_CONTRATOCINSPERSONACCONTRATANTEPEVCPERSONAC, ContratoCConstants.SERV_ALIAS_INSPERSONACCONTRATANTE, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSPERSONACCONTRATANTE_CONTRATOCINSPERSONACCONTRATANTEPEVCPERSONAC);
        }
    }
}
