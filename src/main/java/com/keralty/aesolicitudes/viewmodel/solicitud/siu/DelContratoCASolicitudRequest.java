package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DelContratoCASolicitudRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudDelContratoCASolicitudpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudDelContratoCASolicitudpthisSolicitudInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid solicitudDelContratoCASolicitudpevcContratoC;
    
    @JsonIgnore
    private ContratoC solicitudDelContratoCASolicitudpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudDelContratoCASolicitudpthisSolicitud();
        checkSolicitudDelContratoCASolicitudpevcContratoC();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudDelContratoCASolicitudpthisSolicitud() {
        return this.solicitudDelContratoCASolicitudpthisSolicitud;
    }
    
    public void setSolicitudDelContratoCASolicitudpthisSolicitud(SolicitudOid solicitudDelContratoCASolicitudpthisSolicitud) {
        this.solicitudDelContratoCASolicitudpthisSolicitud = solicitudDelContratoCASolicitudpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudDelContratoCASolicitudpthisSolicitudInstance() {
        return this.solicitudDelContratoCASolicitudpthisSolicitudInstance;
    }
    
    public void setSolicitudDelContratoCASolicitudpthisSolicitudInstance(Solicitud solicitudDelContratoCASolicitudpthisSolicitud) {
        this.solicitudDelContratoCASolicitudpthisSolicitudInstance = solicitudDelContratoCASolicitudpthisSolicitud;
        this.solicitudDelContratoCASolicitudpthisSolicitud = solicitudDelContratoCASolicitudpthisSolicitud != null ? solicitudDelContratoCASolicitudpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudDelContratoCASolicitudpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudDelContratoCASolicitudpthisSolicitudInstance() == null || this.getSolicitudDelContratoCASolicitudpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELCONTRATOCASOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELCONTRATOCASOLICITUD_SOLICITUDDELCONTRATOCASOLICITUDPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DELCONTRATOCASOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELCONTRATOCASOLICITUD_SOLICITUDDELCONTRATOCASOLICITUDPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public ContratoCOid getSolicitudDelContratoCASolicitudpevcContratoC() {
        return this.solicitudDelContratoCASolicitudpevcContratoC;
    }
    
    public void setSolicitudDelContratoCASolicitudpevcContratoC(ContratoCOid solicitudDelContratoCASolicitudpevcContratoC) {
        this.solicitudDelContratoCASolicitudpevcContratoC = solicitudDelContratoCASolicitudpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getSolicitudDelContratoCASolicitudpevcContratoCInstance() {
        return this.solicitudDelContratoCASolicitudpevcContratoCInstance;
    }
    
    public void setSolicitudDelContratoCASolicitudpevcContratoCInstance(ContratoC solicitudDelContratoCASolicitudpevcContratoC) {
        this.solicitudDelContratoCASolicitudpevcContratoCInstance = solicitudDelContratoCASolicitudpevcContratoC;
        this.solicitudDelContratoCASolicitudpevcContratoC = solicitudDelContratoCASolicitudpevcContratoC != null ? solicitudDelContratoCASolicitudpevcContratoC.getOid() : null;
    }

    private void checkSolicitudDelContratoCASolicitudpevcContratoC() throws NotNullArgumentException {
        if(this.getSolicitudDelContratoCASolicitudpevcContratoCInstance() == null || this.getSolicitudDelContratoCASolicitudpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELCONTRATOCASOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELCONTRATOCASOLICITUD_SOLICITUDDELCONTRATOCASOLICITUDPEVCCONTRATOC, SolicitudConstants.SERV_ALIAS_DELCONTRATOCASOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELCONTRATOCASOLICITUD_SOLICITUDDELCONTRATOCASOLICITUDPEVCCONTRATOC);
        }
    }
}
