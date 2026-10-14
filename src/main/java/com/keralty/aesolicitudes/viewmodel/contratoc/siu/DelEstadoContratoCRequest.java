package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;

public class DelEstadoContratoCRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCDelEstadoContratoCpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCDelEstadoContratoCpthisContratoCInstance;

    @JsonProperty("p_evcestadocontrato_oid")
    private EstadoContratoOid contratoCDelEstadoContratoCpevcEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato contratoCDelEstadoContratoCpevcEstadoContratoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCDelEstadoContratoCpthisContratoC();
        checkContratoCDelEstadoContratoCpevcEstadoContrato();
    }

    @JsonIgnore
    public ContratoCOid getContratoCDelEstadoContratoCpthisContratoC() {
        return this.contratoCDelEstadoContratoCpthisContratoC;
    }
    
    public void setContratoCDelEstadoContratoCpthisContratoC(ContratoCOid contratoCDelEstadoContratoCpthisContratoC) {
        this.contratoCDelEstadoContratoCpthisContratoC = contratoCDelEstadoContratoCpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCDelEstadoContratoCpthisContratoCInstance() {
        return this.contratoCDelEstadoContratoCpthisContratoCInstance;
    }
    
    public void setContratoCDelEstadoContratoCpthisContratoCInstance(ContratoC contratoCDelEstadoContratoCpthisContratoC) {
        this.contratoCDelEstadoContratoCpthisContratoCInstance = contratoCDelEstadoContratoCpthisContratoC;
        this.contratoCDelEstadoContratoCpthisContratoC = contratoCDelEstadoContratoCpthisContratoC != null ? contratoCDelEstadoContratoCpthisContratoC.getOid() : null;
    }

    private void checkContratoCDelEstadoContratoCpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCDelEstadoContratoCpthisContratoCInstance() == null || this.getContratoCDelEstadoContratoCpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELESTADOCONTRATOC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELESTADOCONTRATOC_CONTRATOCDELESTADOCONTRATOCPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_DELESTADOCONTRATOC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELESTADOCONTRATOC_CONTRATOCDELESTADOCONTRATOCPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public EstadoContratoOid getContratoCDelEstadoContratoCpevcEstadoContrato() {
        return this.contratoCDelEstadoContratoCpevcEstadoContrato;
    }
    
    public void setContratoCDelEstadoContratoCpevcEstadoContrato(EstadoContratoOid contratoCDelEstadoContratoCpevcEstadoContrato) {
        this.contratoCDelEstadoContratoCpevcEstadoContrato = contratoCDelEstadoContratoCpevcEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getContratoCDelEstadoContratoCpevcEstadoContratoInstance() {
        return this.contratoCDelEstadoContratoCpevcEstadoContratoInstance;
    }
    
    public void setContratoCDelEstadoContratoCpevcEstadoContratoInstance(EstadoContrato contratoCDelEstadoContratoCpevcEstadoContrato) {
        this.contratoCDelEstadoContratoCpevcEstadoContratoInstance = contratoCDelEstadoContratoCpevcEstadoContrato;
        this.contratoCDelEstadoContratoCpevcEstadoContrato = contratoCDelEstadoContratoCpevcEstadoContrato != null ? contratoCDelEstadoContratoCpevcEstadoContrato.getOid() : null;
    }

    private void checkContratoCDelEstadoContratoCpevcEstadoContrato() throws NotNullArgumentException {
        if(this.getContratoCDelEstadoContratoCpevcEstadoContratoInstance() == null || this.getContratoCDelEstadoContratoCpevcEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELESTADOCONTRATOC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELESTADOCONTRATOC_CONTRATOCDELESTADOCONTRATOCPEVCESTADOCONTRATO, ContratoCConstants.SERV_ALIAS_DELESTADOCONTRATOC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELESTADOCONTRATOC_CONTRATOCDELESTADOCONTRATOCPEVCESTADOCONTRATO);
        }
    }
}
