package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class InsContratoCASolicitudRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudInsContratoCASolicitudpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudInsContratoCASolicitudpthisSolicitudInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid solicitudInsContratoCASolicitudpevcContratoC;
    
    @JsonIgnore
    private ContratoC solicitudInsContratoCASolicitudpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudInsContratoCASolicitudpthisSolicitud();
        checkSolicitudInsContratoCASolicitudpevcContratoC();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudInsContratoCASolicitudpthisSolicitud() {
        return this.solicitudInsContratoCASolicitudpthisSolicitud;
    }
    
    public void setSolicitudInsContratoCASolicitudpthisSolicitud(SolicitudOid solicitudInsContratoCASolicitudpthisSolicitud) {
        this.solicitudInsContratoCASolicitudpthisSolicitud = solicitudInsContratoCASolicitudpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudInsContratoCASolicitudpthisSolicitudInstance() {
        return this.solicitudInsContratoCASolicitudpthisSolicitudInstance;
    }
    
    public void setSolicitudInsContratoCASolicitudpthisSolicitudInstance(Solicitud solicitudInsContratoCASolicitudpthisSolicitud) {
        this.solicitudInsContratoCASolicitudpthisSolicitudInstance = solicitudInsContratoCASolicitudpthisSolicitud;
        this.solicitudInsContratoCASolicitudpthisSolicitud = solicitudInsContratoCASolicitudpthisSolicitud != null ? solicitudInsContratoCASolicitudpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudInsContratoCASolicitudpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudInsContratoCASolicitudpthisSolicitudInstance() == null || this.getSolicitudInsContratoCASolicitudpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSCONTRATOCASOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSCONTRATOCASOLICITUD_SOLICITUDINSCONTRATOCASOLICITUDPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_INSCONTRATOCASOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSCONTRATOCASOLICITUD_SOLICITUDINSCONTRATOCASOLICITUDPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public ContratoCOid getSolicitudInsContratoCASolicitudpevcContratoC() {
        return this.solicitudInsContratoCASolicitudpevcContratoC;
    }
    
    public void setSolicitudInsContratoCASolicitudpevcContratoC(ContratoCOid solicitudInsContratoCASolicitudpevcContratoC) {
        this.solicitudInsContratoCASolicitudpevcContratoC = solicitudInsContratoCASolicitudpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getSolicitudInsContratoCASolicitudpevcContratoCInstance() {
        return this.solicitudInsContratoCASolicitudpevcContratoCInstance;
    }
    
    public void setSolicitudInsContratoCASolicitudpevcContratoCInstance(ContratoC solicitudInsContratoCASolicitudpevcContratoC) {
        this.solicitudInsContratoCASolicitudpevcContratoCInstance = solicitudInsContratoCASolicitudpevcContratoC;
        this.solicitudInsContratoCASolicitudpevcContratoC = solicitudInsContratoCASolicitudpevcContratoC != null ? solicitudInsContratoCASolicitudpevcContratoC.getOid() : null;
    }

    private void checkSolicitudInsContratoCASolicitudpevcContratoC() throws NotNullArgumentException {
        if(this.getSolicitudInsContratoCASolicitudpevcContratoCInstance() == null || this.getSolicitudInsContratoCASolicitudpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSCONTRATOCASOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSCONTRATOCASOLICITUD_SOLICITUDINSCONTRATOCASOLICITUDPEVCCONTRATOC, SolicitudConstants.SERV_ALIAS_INSCONTRATOCASOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSCONTRATOCASOLICITUD_SOLICITUDINSCONTRATOCASOLICITUDPEVCCONTRATOC);
        }
    }
}
