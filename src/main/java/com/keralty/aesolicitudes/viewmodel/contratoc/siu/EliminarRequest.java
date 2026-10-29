package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;

public class EliminarRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCeliminarpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCeliminarpthisContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCeliminarpthisContratoC();
    }

    @JsonIgnore
    public ContratoCOid getContratoCeliminarpthisContratoC() {
        return this.contratoCeliminarpthisContratoC;
    }
    
    public void setContratoCeliminarpthisContratoC(ContratoCOid contratoCeliminarpthisContratoC) {
        this.contratoCeliminarpthisContratoC = contratoCeliminarpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCeliminarpthisContratoCInstance() {
        return this.contratoCeliminarpthisContratoCInstance;
    }
    
    public void setContratoCeliminarpthisContratoCInstance(ContratoC contratoCeliminarpthisContratoC) {
        this.contratoCeliminarpthisContratoCInstance = contratoCeliminarpthisContratoC;
        this.contratoCeliminarpthisContratoC = contratoCeliminarpthisContratoC != null ? contratoCeliminarpthisContratoC.getOid() : null;
    }

    private void checkContratoCeliminarpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCeliminarpthisContratoCInstance() == null || this.getContratoCeliminarpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_ELIMINAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_ELIMINAR_CONTRATOCELIMINARPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_ELIMINAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_ELIMINAR_CONTRATOCELIMINARPTHISCONTRATOC);
        }
    }
}
