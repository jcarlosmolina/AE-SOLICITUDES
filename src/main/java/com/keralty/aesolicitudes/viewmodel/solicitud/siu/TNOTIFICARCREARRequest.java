package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TNOTIFICARCREARRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTNOTIFICARCREARpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTNOTIFICARCREARpthisSolicitudInstance;

    @JsonProperty("ptconficierresolicitud")
    private Boolean solicitudTNOTIFICARCREARptConfiCierreSolicitud;

    @JsonProperty("ptnumfamiliacore")
    private String solicitudTNOTIFICARCREARptNumFamiliaCORE;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTNOTIFICARCREARpthisSolicitud();
        checkSolicitudTNOTIFICARCREARptConfiCierreSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTNOTIFICARCREARpthisSolicitud() {
        return this.solicitudTNOTIFICARCREARpthisSolicitud;
    }
    
    public void setSolicitudTNOTIFICARCREARpthisSolicitud(SolicitudOid solicitudTNOTIFICARCREARpthisSolicitud) {
        this.solicitudTNOTIFICARCREARpthisSolicitud = solicitudTNOTIFICARCREARpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTNOTIFICARCREARpthisSolicitudInstance() {
        return this.solicitudTNOTIFICARCREARpthisSolicitudInstance;
    }
    
    public void setSolicitudTNOTIFICARCREARpthisSolicitudInstance(Solicitud solicitudTNOTIFICARCREARpthisSolicitud) {
        this.solicitudTNOTIFICARCREARpthisSolicitudInstance = solicitudTNOTIFICARCREARpthisSolicitud;
        this.solicitudTNOTIFICARCREARpthisSolicitud = solicitudTNOTIFICARCREARpthisSolicitud != null ? solicitudTNOTIFICARCREARpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTNOTIFICARCREARpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTNOTIFICARCREARpthisSolicitudInstance() == null || this.getSolicitudTNOTIFICARCREARpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TNOTIFICARCREAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TNOTIFICARCREAR_SOLICITUDTNOTIFICARCREARPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TNOTIFICARCREAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TNOTIFICARCREAR_SOLICITUDTNOTIFICARCREARPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTNOTIFICARCREARptConfiCierreSolicitud() {
        return this.solicitudTNOTIFICARCREARptConfiCierreSolicitud;
    }
    
    public void setSolicitudTNOTIFICARCREARptConfiCierreSolicitud(Boolean solicitudTNOTIFICARCREARptConfiCierreSolicitud) {
        this.solicitudTNOTIFICARCREARptConfiCierreSolicitud = solicitudTNOTIFICARCREARptConfiCierreSolicitud;
    }

    private void checkSolicitudTNOTIFICARCREARptConfiCierreSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTNOTIFICARCREARptConfiCierreSolicitud() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TNOTIFICARCREAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TNOTIFICARCREAR_SOLICITUDTNOTIFICARCREARPTCONFICIERRESOLICITUD, SolicitudConstants.SERV_ALIAS_TNOTIFICARCREAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TNOTIFICARCREAR_SOLICITUDTNOTIFICARCREARPTCONFICIERRESOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTNOTIFICARCREARptNumFamiliaCORE() {
        return this.solicitudTNOTIFICARCREARptNumFamiliaCORE;
    }
    
    public void setSolicitudTNOTIFICARCREARptNumFamiliaCORE(String solicitudTNOTIFICARCREARptNumFamiliaCORE) {
        this.solicitudTNOTIFICARCREARptNumFamiliaCORE = solicitudTNOTIFICARCREARptNumFamiliaCORE;
    }
}
