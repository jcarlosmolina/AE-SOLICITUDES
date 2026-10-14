package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;

public class TELIMINARRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCTELIMINARpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCTELIMINARpthisContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCTELIMINARpthisContratoC();
    }

    @JsonIgnore
    public ContratoCOid getContratoCTELIMINARpthisContratoC() {
        return this.contratoCTELIMINARpthisContratoC;
    }
    
    public void setContratoCTELIMINARpthisContratoC(ContratoCOid contratoCTELIMINARpthisContratoC) {
        this.contratoCTELIMINARpthisContratoC = contratoCTELIMINARpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCTELIMINARpthisContratoCInstance() {
        return this.contratoCTELIMINARpthisContratoCInstance;
    }
    
    public void setContratoCTELIMINARpthisContratoCInstance(ContratoC contratoCTELIMINARpthisContratoC) {
        this.contratoCTELIMINARpthisContratoCInstance = contratoCTELIMINARpthisContratoC;
        this.contratoCTELIMINARpthisContratoC = contratoCTELIMINARpthisContratoC != null ? contratoCTELIMINARpthisContratoC.getOid() : null;
    }

    private void checkContratoCTELIMINARpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCTELIMINARpthisContratoCInstance() == null || this.getContratoCTELIMINARpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TELIMINAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TELIMINAR_CONTRATOCTELIMINARPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_TELIMINAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TELIMINAR_CONTRATOCTELIMINARPTHISCONTRATOC);
        }
    }
}
