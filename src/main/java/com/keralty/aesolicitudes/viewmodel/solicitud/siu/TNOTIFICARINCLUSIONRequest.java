package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TNOTIFICARINCLUSIONRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTNOTIFICARINCLUSIONpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTNOTIFICARINCLUSIONpthisSolicitudInstance;

    @JsonProperty("ptconficierresolicitud")
    private Boolean solicitudTNOTIFICARINCLUSIONptConfiCierreSolicitud;

    @JsonProperty("ptnumfamiliacore")
    private String solicitudTNOTIFICARINCLUSIONptNumFamiliaCORE;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTNOTIFICARINCLUSIONpthisSolicitud();
        checkSolicitudTNOTIFICARINCLUSIONptConfiCierreSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTNOTIFICARINCLUSIONpthisSolicitud() {
        return this.solicitudTNOTIFICARINCLUSIONpthisSolicitud;
    }
    
    public void setSolicitudTNOTIFICARINCLUSIONpthisSolicitud(SolicitudOid solicitudTNOTIFICARINCLUSIONpthisSolicitud) {
        this.solicitudTNOTIFICARINCLUSIONpthisSolicitud = solicitudTNOTIFICARINCLUSIONpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTNOTIFICARINCLUSIONpthisSolicitudInstance() {
        return this.solicitudTNOTIFICARINCLUSIONpthisSolicitudInstance;
    }
    
    public void setSolicitudTNOTIFICARINCLUSIONpthisSolicitudInstance(Solicitud solicitudTNOTIFICARINCLUSIONpthisSolicitud) {
        this.solicitudTNOTIFICARINCLUSIONpthisSolicitudInstance = solicitudTNOTIFICARINCLUSIONpthisSolicitud;
        this.solicitudTNOTIFICARINCLUSIONpthisSolicitud = solicitudTNOTIFICARINCLUSIONpthisSolicitud != null ? solicitudTNOTIFICARINCLUSIONpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTNOTIFICARINCLUSIONpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTNOTIFICARINCLUSIONpthisSolicitudInstance() == null || this.getSolicitudTNOTIFICARINCLUSIONpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TNOTIFICARINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TNOTIFICARINCLUSION_SOLICITUDTNOTIFICARINCLUSIONPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TNOTIFICARINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TNOTIFICARINCLUSION_SOLICITUDTNOTIFICARINCLUSIONPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTNOTIFICARINCLUSIONptConfiCierreSolicitud() {
        return this.solicitudTNOTIFICARINCLUSIONptConfiCierreSolicitud;
    }
    
    public void setSolicitudTNOTIFICARINCLUSIONptConfiCierreSolicitud(Boolean solicitudTNOTIFICARINCLUSIONptConfiCierreSolicitud) {
        this.solicitudTNOTIFICARINCLUSIONptConfiCierreSolicitud = solicitudTNOTIFICARINCLUSIONptConfiCierreSolicitud;
    }

    private void checkSolicitudTNOTIFICARINCLUSIONptConfiCierreSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTNOTIFICARINCLUSIONptConfiCierreSolicitud() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TNOTIFICARINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TNOTIFICARINCLUSION_SOLICITUDTNOTIFICARINCLUSIONPTCONFICIERRESOLICITUD, SolicitudConstants.SERV_ALIAS_TNOTIFICARINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TNOTIFICARINCLUSION_SOLICITUDTNOTIFICARINCLUSIONPTCONFICIERRESOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTNOTIFICARINCLUSIONptNumFamiliaCORE() {
        return this.solicitudTNOTIFICARINCLUSIONptNumFamiliaCORE;
    }
    
    public void setSolicitudTNOTIFICARINCLUSIONptNumFamiliaCORE(String solicitudTNOTIFICARINCLUSIONptNumFamiliaCORE) {
        this.solicitudTNOTIFICARINCLUSIONptNumFamiliaCORE = solicitudTNOTIFICARINCLUSIONptNumFamiliaCORE;
    }
}
