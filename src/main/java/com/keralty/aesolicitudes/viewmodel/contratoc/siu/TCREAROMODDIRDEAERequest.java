package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCREAROMODDIRDEAERequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCTCREAROMODDIRDEAEpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCTCREAROMODDIRDEAEpthisContratoCInstance;

    @JsonProperty("p_solicitudae_oid")
    private SolicitudOid contratoCTCREAROMODDIRDEAEpSolicitudAE;
    
    @JsonIgnore
    private Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAEInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCTCREAROMODDIRDEAEpthisContratoC();
        checkContratoCTCREAROMODDIRDEAEpSolicitudAE();
    }

    @JsonIgnore
    public ContratoCOid getContratoCTCREAROMODDIRDEAEpthisContratoC() {
        return this.contratoCTCREAROMODDIRDEAEpthisContratoC;
    }
    
    public void setContratoCTCREAROMODDIRDEAEpthisContratoC(ContratoCOid contratoCTCREAROMODDIRDEAEpthisContratoC) {
        this.contratoCTCREAROMODDIRDEAEpthisContratoC = contratoCTCREAROMODDIRDEAEpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCTCREAROMODDIRDEAEpthisContratoCInstance() {
        return this.contratoCTCREAROMODDIRDEAEpthisContratoCInstance;
    }
    
    public void setContratoCTCREAROMODDIRDEAEpthisContratoCInstance(ContratoC contratoCTCREAROMODDIRDEAEpthisContratoC) {
        this.contratoCTCREAROMODDIRDEAEpthisContratoCInstance = contratoCTCREAROMODDIRDEAEpthisContratoC;
        this.contratoCTCREAROMODDIRDEAEpthisContratoC = contratoCTCREAROMODDIRDEAEpthisContratoC != null ? contratoCTCREAROMODDIRDEAEpthisContratoC.getOid() : null;
    }

    private void checkContratoCTCREAROMODDIRDEAEpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCTCREAROMODDIRDEAEpthisContratoCInstance() == null || this.getContratoCTCREAROMODDIRDEAEpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TCREAROMODDIRDEAE, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_TCREAROMODDIRDEAE, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public SolicitudOid getContratoCTCREAROMODDIRDEAEpSolicitudAE() {
        return this.contratoCTCREAROMODDIRDEAEpSolicitudAE;
    }
    
    public void setContratoCTCREAROMODDIRDEAEpSolicitudAE(SolicitudOid contratoCTCREAROMODDIRDEAEpSolicitudAE) {
        this.contratoCTCREAROMODDIRDEAEpSolicitudAE = contratoCTCREAROMODDIRDEAEpSolicitudAE;
    }

    @JsonIgnore
    public Solicitud getContratoCTCREAROMODDIRDEAEpSolicitudAEInstance() {
        return this.contratoCTCREAROMODDIRDEAEpSolicitudAEInstance;
    }
    
    public void setContratoCTCREAROMODDIRDEAEpSolicitudAEInstance(Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) {
        this.contratoCTCREAROMODDIRDEAEpSolicitudAEInstance = contratoCTCREAROMODDIRDEAEpSolicitudAE;
        this.contratoCTCREAROMODDIRDEAEpSolicitudAE = contratoCTCREAROMODDIRDEAEpSolicitudAE != null ? contratoCTCREAROMODDIRDEAEpSolicitudAE.getOid() : null;
    }

    private void checkContratoCTCREAROMODDIRDEAEpSolicitudAE() throws NotNullArgumentException {
        if(this.getContratoCTCREAROMODDIRDEAEpSolicitudAEInstance() == null || this.getContratoCTCREAROMODDIRDEAEpSolicitudAEInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TCREAROMODDIRDEAE, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPSOLICITUDAE, ContratoCConstants.SERV_ALIAS_TCREAROMODDIRDEAE, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPSOLICITUDAE);
        }
    }
}
