package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;

public class MarcarContratoNotificadoRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCmarcarContratoNotificadopthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCmarcarContratoNotificadopthisContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCmarcarContratoNotificadopthisContratoC();
    }

    @JsonIgnore
    public ContratoCOid getContratoCmarcarContratoNotificadopthisContratoC() {
        return this.contratoCmarcarContratoNotificadopthisContratoC;
    }
    
    public void setContratoCmarcarContratoNotificadopthisContratoC(ContratoCOid contratoCmarcarContratoNotificadopthisContratoC) {
        this.contratoCmarcarContratoNotificadopthisContratoC = contratoCmarcarContratoNotificadopthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCmarcarContratoNotificadopthisContratoCInstance() {
        return this.contratoCmarcarContratoNotificadopthisContratoCInstance;
    }
    
    public void setContratoCmarcarContratoNotificadopthisContratoCInstance(ContratoC contratoCmarcarContratoNotificadopthisContratoC) {
        this.contratoCmarcarContratoNotificadopthisContratoCInstance = contratoCmarcarContratoNotificadopthisContratoC;
        this.contratoCmarcarContratoNotificadopthisContratoC = contratoCmarcarContratoNotificadopthisContratoC != null ? contratoCmarcarContratoNotificadopthisContratoC.getOid() : null;
    }

    private void checkContratoCmarcarContratoNotificadopthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCmarcarContratoNotificadopthisContratoCInstance() == null || this.getContratoCmarcarContratoNotificadopthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_MARCARCONTRATONOTIFICADO, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_MARCARCONTRATONOTIFICADO_CONTRATOCMARCARCONTRATONOTIFICADOPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_MARCARCONTRATONOTIFICADO, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_MARCARCONTRATONOTIFICADO_CONTRATOCMARCARCONTRATONOTIFICADOPTHISCONTRATOC);
        }
    }
}
