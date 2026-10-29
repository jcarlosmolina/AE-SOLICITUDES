package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class InsContratoCASolicitudRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCInsContratoCASolicitudpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCInsContratoCASolicitudpthisContratoCInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid contratoCInsContratoCASolicitudpevcSolicitud;
    
    @JsonIgnore
    private Solicitud contratoCInsContratoCASolicitudpevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCInsContratoCASolicitudpthisContratoC();
        checkContratoCInsContratoCASolicitudpevcSolicitud();
    }

    @JsonIgnore
    public ContratoCOid getContratoCInsContratoCASolicitudpthisContratoC() {
        return this.contratoCInsContratoCASolicitudpthisContratoC;
    }
    
    public void setContratoCInsContratoCASolicitudpthisContratoC(ContratoCOid contratoCInsContratoCASolicitudpthisContratoC) {
        this.contratoCInsContratoCASolicitudpthisContratoC = contratoCInsContratoCASolicitudpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCInsContratoCASolicitudpthisContratoCInstance() {
        return this.contratoCInsContratoCASolicitudpthisContratoCInstance;
    }
    
    public void setContratoCInsContratoCASolicitudpthisContratoCInstance(ContratoC contratoCInsContratoCASolicitudpthisContratoC) {
        this.contratoCInsContratoCASolicitudpthisContratoCInstance = contratoCInsContratoCASolicitudpthisContratoC;
        this.contratoCInsContratoCASolicitudpthisContratoC = contratoCInsContratoCASolicitudpthisContratoC != null ? contratoCInsContratoCASolicitudpthisContratoC.getOid() : null;
    }

    private void checkContratoCInsContratoCASolicitudpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCInsContratoCASolicitudpthisContratoCInstance() == null || this.getContratoCInsContratoCASolicitudpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSCONTRATOCASOLICITUD, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSCONTRATOCASOLICITUD_CONTRATOCINSCONTRATOCASOLICITUDPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_INSCONTRATOCASOLICITUD, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSCONTRATOCASOLICITUD_CONTRATOCINSCONTRATOCASOLICITUDPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public SolicitudOid getContratoCInsContratoCASolicitudpevcSolicitud() {
        return this.contratoCInsContratoCASolicitudpevcSolicitud;
    }
    
    public void setContratoCInsContratoCASolicitudpevcSolicitud(SolicitudOid contratoCInsContratoCASolicitudpevcSolicitud) {
        this.contratoCInsContratoCASolicitudpevcSolicitud = contratoCInsContratoCASolicitudpevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getContratoCInsContratoCASolicitudpevcSolicitudInstance() {
        return this.contratoCInsContratoCASolicitudpevcSolicitudInstance;
    }
    
    public void setContratoCInsContratoCASolicitudpevcSolicitudInstance(Solicitud contratoCInsContratoCASolicitudpevcSolicitud) {
        this.contratoCInsContratoCASolicitudpevcSolicitudInstance = contratoCInsContratoCASolicitudpevcSolicitud;
        this.contratoCInsContratoCASolicitudpevcSolicitud = contratoCInsContratoCASolicitudpevcSolicitud != null ? contratoCInsContratoCASolicitudpevcSolicitud.getOid() : null;
    }

    private void checkContratoCInsContratoCASolicitudpevcSolicitud() throws NotNullArgumentException {
        if(this.getContratoCInsContratoCASolicitudpevcSolicitudInstance() == null || this.getContratoCInsContratoCASolicitudpevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSCONTRATOCASOLICITUD, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSCONTRATOCASOLICITUD_CONTRATOCINSCONTRATOCASOLICITUDPEVCSOLICITUD, ContratoCConstants.SERV_ALIAS_INSCONTRATOCASOLICITUD, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSCONTRATOCASOLICITUD_CONTRATOCINSCONTRATOCASOLICITUDPEVCSOLICITUD);
        }
    }
}
