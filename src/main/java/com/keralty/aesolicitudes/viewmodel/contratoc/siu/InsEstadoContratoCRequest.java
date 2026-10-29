package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;

public class InsEstadoContratoCRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCInsEstadoContratoCpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCInsEstadoContratoCpthisContratoCInstance;

    @JsonProperty("p_evcestadocontrato_oid")
    private EstadoContratoOid contratoCInsEstadoContratoCpevcEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato contratoCInsEstadoContratoCpevcEstadoContratoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCInsEstadoContratoCpthisContratoC();
        checkContratoCInsEstadoContratoCpevcEstadoContrato();
    }

    @JsonIgnore
    public ContratoCOid getContratoCInsEstadoContratoCpthisContratoC() {
        return this.contratoCInsEstadoContratoCpthisContratoC;
    }
    
    public void setContratoCInsEstadoContratoCpthisContratoC(ContratoCOid contratoCInsEstadoContratoCpthisContratoC) {
        this.contratoCInsEstadoContratoCpthisContratoC = contratoCInsEstadoContratoCpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCInsEstadoContratoCpthisContratoCInstance() {
        return this.contratoCInsEstadoContratoCpthisContratoCInstance;
    }
    
    public void setContratoCInsEstadoContratoCpthisContratoCInstance(ContratoC contratoCInsEstadoContratoCpthisContratoC) {
        this.contratoCInsEstadoContratoCpthisContratoCInstance = contratoCInsEstadoContratoCpthisContratoC;
        this.contratoCInsEstadoContratoCpthisContratoC = contratoCInsEstadoContratoCpthisContratoC != null ? contratoCInsEstadoContratoCpthisContratoC.getOid() : null;
    }

    private void checkContratoCInsEstadoContratoCpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCInsEstadoContratoCpthisContratoCInstance() == null || this.getContratoCInsEstadoContratoCpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSESTADOCONTRATOC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSESTADOCONTRATOC_CONTRATOCINSESTADOCONTRATOCPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_INSESTADOCONTRATOC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSESTADOCONTRATOC_CONTRATOCINSESTADOCONTRATOCPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public EstadoContratoOid getContratoCInsEstadoContratoCpevcEstadoContrato() {
        return this.contratoCInsEstadoContratoCpevcEstadoContrato;
    }
    
    public void setContratoCInsEstadoContratoCpevcEstadoContrato(EstadoContratoOid contratoCInsEstadoContratoCpevcEstadoContrato) {
        this.contratoCInsEstadoContratoCpevcEstadoContrato = contratoCInsEstadoContratoCpevcEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getContratoCInsEstadoContratoCpevcEstadoContratoInstance() {
        return this.contratoCInsEstadoContratoCpevcEstadoContratoInstance;
    }
    
    public void setContratoCInsEstadoContratoCpevcEstadoContratoInstance(EstadoContrato contratoCInsEstadoContratoCpevcEstadoContrato) {
        this.contratoCInsEstadoContratoCpevcEstadoContratoInstance = contratoCInsEstadoContratoCpevcEstadoContrato;
        this.contratoCInsEstadoContratoCpevcEstadoContrato = contratoCInsEstadoContratoCpevcEstadoContrato != null ? contratoCInsEstadoContratoCpevcEstadoContrato.getOid() : null;
    }

    private void checkContratoCInsEstadoContratoCpevcEstadoContrato() throws NotNullArgumentException {
        if(this.getContratoCInsEstadoContratoCpevcEstadoContratoInstance() == null || this.getContratoCInsEstadoContratoCpevcEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSESTADOCONTRATOC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSESTADOCONTRATOC_CONTRATOCINSESTADOCONTRATOCPEVCESTADOCONTRATO, ContratoCConstants.SERV_ALIAS_INSESTADOCONTRATOC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSESTADOCONTRATOC_CONTRATOCINSESTADOCONTRATOCPEVCESTADOCONTRATO);
        }
    }
}
