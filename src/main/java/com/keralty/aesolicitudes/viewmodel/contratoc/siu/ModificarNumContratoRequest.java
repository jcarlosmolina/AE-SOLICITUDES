package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;

public class ModificarNumContratoRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCmodificarNumContratopthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCmodificarNumContratopthisContratoCInstance;

    @JsonProperty("p_numcontrato")
    private String contratoCmodificarNumContratopNumContrato;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCmodificarNumContratopthisContratoC();
        checkContratoCmodificarNumContratopNumContrato();
    }

    @JsonIgnore
    public ContratoCOid getContratoCmodificarNumContratopthisContratoC() {
        return this.contratoCmodificarNumContratopthisContratoC;
    }
    
    public void setContratoCmodificarNumContratopthisContratoC(ContratoCOid contratoCmodificarNumContratopthisContratoC) {
        this.contratoCmodificarNumContratopthisContratoC = contratoCmodificarNumContratopthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCmodificarNumContratopthisContratoCInstance() {
        return this.contratoCmodificarNumContratopthisContratoCInstance;
    }
    
    public void setContratoCmodificarNumContratopthisContratoCInstance(ContratoC contratoCmodificarNumContratopthisContratoC) {
        this.contratoCmodificarNumContratopthisContratoCInstance = contratoCmodificarNumContratopthisContratoC;
        this.contratoCmodificarNumContratopthisContratoC = contratoCmodificarNumContratopthisContratoC != null ? contratoCmodificarNumContratopthisContratoC.getOid() : null;
    }

    private void checkContratoCmodificarNumContratopthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCmodificarNumContratopthisContratoCInstance() == null || this.getContratoCmodificarNumContratopthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_MODIFICARNUMCONTRATO, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_MODIFICARNUMCONTRATO_CONTRATOCMODIFICARNUMCONTRATOPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_MODIFICARNUMCONTRATO, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_MODIFICARNUMCONTRATO_CONTRATOCMODIFICARNUMCONTRATOPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public String getContratoCmodificarNumContratopNumContrato() {
        return this.contratoCmodificarNumContratopNumContrato;
    }
    
    public void setContratoCmodificarNumContratopNumContrato(String contratoCmodificarNumContratopNumContrato) {
        this.contratoCmodificarNumContratopNumContrato = contratoCmodificarNumContratopNumContrato;
    }

    private void checkContratoCmodificarNumContratopNumContrato() throws NotNullArgumentException {
        if(this.getContratoCmodificarNumContratopNumContrato() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_MODIFICARNUMCONTRATO, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_MODIFICARNUMCONTRATO_CONTRATOCMODIFICARNUMCONTRATOPNUMCONTRATO, ContratoCConstants.SERV_ALIAS_MODIFICARNUMCONTRATO, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_MODIFICARNUMCONTRATO_CONTRATOCMODIFICARNUMCONTRATOPNUMCONTRATO);
        }
    }
}
