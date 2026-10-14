package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;

public class CalcularLiquidacionRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCCalcularLiquidacionpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCCalcularLiquidacionpthisContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCCalcularLiquidacionpthisContratoC();
    }

    @JsonIgnore
    public ContratoCOid getContratoCCalcularLiquidacionpthisContratoC() {
        return this.contratoCCalcularLiquidacionpthisContratoC;
    }
    
    public void setContratoCCalcularLiquidacionpthisContratoC(ContratoCOid contratoCCalcularLiquidacionpthisContratoC) {
        this.contratoCCalcularLiquidacionpthisContratoC = contratoCCalcularLiquidacionpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCCalcularLiquidacionpthisContratoCInstance() {
        return this.contratoCCalcularLiquidacionpthisContratoCInstance;
    }
    
    public void setContratoCCalcularLiquidacionpthisContratoCInstance(ContratoC contratoCCalcularLiquidacionpthisContratoC) {
        this.contratoCCalcularLiquidacionpthisContratoCInstance = contratoCCalcularLiquidacionpthisContratoC;
        this.contratoCCalcularLiquidacionpthisContratoC = contratoCCalcularLiquidacionpthisContratoC != null ? contratoCCalcularLiquidacionpthisContratoC.getOid() : null;
    }

    private void checkContratoCCalcularLiquidacionpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCCalcularLiquidacionpthisContratoCInstance() == null || this.getContratoCCalcularLiquidacionpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_CALCULARLIQUIDACION, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_CALCULARLIQUIDACION_CONTRATOCCALCULARLIQUIDACIONPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_CALCULARLIQUIDACION, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_CALCULARLIQUIDACION_CONTRATOCCALCULARLIQUIDACIONPTHISCONTRATOC);
        }
    }
}
