package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;

public class TMODIFICARESTADORequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCTMODIFICARESTADOpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCTMODIFICARESTADOpthisContratoCInstance;

    @JsonProperty("pt_p_evcestadocontratoc_oid")
    private EstadoContratoOid contratoCTMODIFICARESTADOptpevcEstadoContratoC;
    
    @JsonIgnore
    private EstadoContrato contratoCTMODIFICARESTADOptpevcEstadoContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCTMODIFICARESTADOpthisContratoC();
    }

    @JsonIgnore
    public ContratoCOid getContratoCTMODIFICARESTADOpthisContratoC() {
        return this.contratoCTMODIFICARESTADOpthisContratoC;
    }
    
    public void setContratoCTMODIFICARESTADOpthisContratoC(ContratoCOid contratoCTMODIFICARESTADOpthisContratoC) {
        this.contratoCTMODIFICARESTADOpthisContratoC = contratoCTMODIFICARESTADOpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCTMODIFICARESTADOpthisContratoCInstance() {
        return this.contratoCTMODIFICARESTADOpthisContratoCInstance;
    }
    
    public void setContratoCTMODIFICARESTADOpthisContratoCInstance(ContratoC contratoCTMODIFICARESTADOpthisContratoC) {
        this.contratoCTMODIFICARESTADOpthisContratoCInstance = contratoCTMODIFICARESTADOpthisContratoC;
        this.contratoCTMODIFICARESTADOpthisContratoC = contratoCTMODIFICARESTADOpthisContratoC != null ? contratoCTMODIFICARESTADOpthisContratoC.getOid() : null;
    }

    private void checkContratoCTMODIFICARESTADOpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCTMODIFICARESTADOpthisContratoCInstance() == null || this.getContratoCTMODIFICARESTADOpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TMODIFICARESTADO, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TMODIFICARESTADO_CONTRATOCTMODIFICARESTADOPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_TMODIFICARESTADO, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TMODIFICARESTADO_CONTRATOCTMODIFICARESTADOPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public EstadoContratoOid getContratoCTMODIFICARESTADOptpevcEstadoContratoC() {
        return this.contratoCTMODIFICARESTADOptpevcEstadoContratoC;
    }
    
    public void setContratoCTMODIFICARESTADOptpevcEstadoContratoC(EstadoContratoOid contratoCTMODIFICARESTADOptpevcEstadoContratoC) {
        this.contratoCTMODIFICARESTADOptpevcEstadoContratoC = contratoCTMODIFICARESTADOptpevcEstadoContratoC;
    }

    @JsonIgnore
    public EstadoContrato getContratoCTMODIFICARESTADOptpevcEstadoContratoCInstance() {
        return this.contratoCTMODIFICARESTADOptpevcEstadoContratoCInstance;
    }
    
    public void setContratoCTMODIFICARESTADOptpevcEstadoContratoCInstance(EstadoContrato contratoCTMODIFICARESTADOptpevcEstadoContratoC) {
        this.contratoCTMODIFICARESTADOptpevcEstadoContratoCInstance = contratoCTMODIFICARESTADOptpevcEstadoContratoC;
        this.contratoCTMODIFICARESTADOptpevcEstadoContratoC = contratoCTMODIFICARESTADOptpevcEstadoContratoC != null ? contratoCTMODIFICARESTADOptpevcEstadoContratoC.getOid() : null;
    }
}
