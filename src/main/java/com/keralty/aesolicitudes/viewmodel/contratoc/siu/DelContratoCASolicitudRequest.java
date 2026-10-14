package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DelContratoCASolicitudRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCDelContratoCASolicitudpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCDelContratoCASolicitudpthisContratoCInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid contratoCDelContratoCASolicitudpevcSolicitud;
    
    @JsonIgnore
    private Solicitud contratoCDelContratoCASolicitudpevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCDelContratoCASolicitudpthisContratoC();
        checkContratoCDelContratoCASolicitudpevcSolicitud();
    }

    @JsonIgnore
    public ContratoCOid getContratoCDelContratoCASolicitudpthisContratoC() {
        return this.contratoCDelContratoCASolicitudpthisContratoC;
    }
    
    public void setContratoCDelContratoCASolicitudpthisContratoC(ContratoCOid contratoCDelContratoCASolicitudpthisContratoC) {
        this.contratoCDelContratoCASolicitudpthisContratoC = contratoCDelContratoCASolicitudpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCDelContratoCASolicitudpthisContratoCInstance() {
        return this.contratoCDelContratoCASolicitudpthisContratoCInstance;
    }
    
    public void setContratoCDelContratoCASolicitudpthisContratoCInstance(ContratoC contratoCDelContratoCASolicitudpthisContratoC) {
        this.contratoCDelContratoCASolicitudpthisContratoCInstance = contratoCDelContratoCASolicitudpthisContratoC;
        this.contratoCDelContratoCASolicitudpthisContratoC = contratoCDelContratoCASolicitudpthisContratoC != null ? contratoCDelContratoCASolicitudpthisContratoC.getOid() : null;
    }

    private void checkContratoCDelContratoCASolicitudpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCDelContratoCASolicitudpthisContratoCInstance() == null || this.getContratoCDelContratoCASolicitudpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELCONTRATOCASOLICITUD, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELCONTRATOCASOLICITUD_CONTRATOCDELCONTRATOCASOLICITUDPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_DELCONTRATOCASOLICITUD, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELCONTRATOCASOLICITUD_CONTRATOCDELCONTRATOCASOLICITUDPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public SolicitudOid getContratoCDelContratoCASolicitudpevcSolicitud() {
        return this.contratoCDelContratoCASolicitudpevcSolicitud;
    }
    
    public void setContratoCDelContratoCASolicitudpevcSolicitud(SolicitudOid contratoCDelContratoCASolicitudpevcSolicitud) {
        this.contratoCDelContratoCASolicitudpevcSolicitud = contratoCDelContratoCASolicitudpevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getContratoCDelContratoCASolicitudpevcSolicitudInstance() {
        return this.contratoCDelContratoCASolicitudpevcSolicitudInstance;
    }
    
    public void setContratoCDelContratoCASolicitudpevcSolicitudInstance(Solicitud contratoCDelContratoCASolicitudpevcSolicitud) {
        this.contratoCDelContratoCASolicitudpevcSolicitudInstance = contratoCDelContratoCASolicitudpevcSolicitud;
        this.contratoCDelContratoCASolicitudpevcSolicitud = contratoCDelContratoCASolicitudpevcSolicitud != null ? contratoCDelContratoCASolicitudpevcSolicitud.getOid() : null;
    }

    private void checkContratoCDelContratoCASolicitudpevcSolicitud() throws NotNullArgumentException {
        if(this.getContratoCDelContratoCASolicitudpevcSolicitudInstance() == null || this.getContratoCDelContratoCASolicitudpevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELCONTRATOCASOLICITUD, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELCONTRATOCASOLICITUD_CONTRATOCDELCONTRATOCASOLICITUDPEVCSOLICITUD, ContratoCConstants.SERV_ALIAS_DELCONTRATOCASOLICITUD, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELCONTRATOCASOLICITUD_CONTRATOCDELCONTRATOCASOLICITUDPEVCSOLICITUD);
        }
    }
}
