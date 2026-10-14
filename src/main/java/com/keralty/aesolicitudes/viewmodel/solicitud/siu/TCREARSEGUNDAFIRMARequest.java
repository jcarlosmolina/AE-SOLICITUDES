package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCREARSEGUNDAFIRMARequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCREARSEGUNDAFIRMApthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCREARSEGUNDAFIRMApthisSolicitudInstance;

    @JsonProperty("pt_p_atrimagenfirma")
    private byte[] solicitudTCREARSEGUNDAFIRMAptpatrImagenFirma;

    @JsonProperty("pt_p_atrlatitud")
    private String solicitudTCREARSEGUNDAFIRMAptpatrLatitud;

    @JsonProperty("pt_p_atrlongitud")
    private String solicitudTCREARSEGUNDAFIRMAptpatrLongitud;

    @JsonProperty("pt_texto")
    private String solicitudTCREARSEGUNDAFIRMAptTexto;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCREARSEGUNDAFIRMApthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCREARSEGUNDAFIRMApthisSolicitud() {
        return this.solicitudTCREARSEGUNDAFIRMApthisSolicitud;
    }
    
    public void setSolicitudTCREARSEGUNDAFIRMApthisSolicitud(SolicitudOid solicitudTCREARSEGUNDAFIRMApthisSolicitud) {
        this.solicitudTCREARSEGUNDAFIRMApthisSolicitud = solicitudTCREARSEGUNDAFIRMApthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCREARSEGUNDAFIRMApthisSolicitudInstance() {
        return this.solicitudTCREARSEGUNDAFIRMApthisSolicitudInstance;
    }
    
    public void setSolicitudTCREARSEGUNDAFIRMApthisSolicitudInstance(Solicitud solicitudTCREARSEGUNDAFIRMApthisSolicitud) {
        this.solicitudTCREARSEGUNDAFIRMApthisSolicitudInstance = solicitudTCREARSEGUNDAFIRMApthisSolicitud;
        this.solicitudTCREARSEGUNDAFIRMApthisSolicitud = solicitudTCREARSEGUNDAFIRMApthisSolicitud != null ? solicitudTCREARSEGUNDAFIRMApthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCREARSEGUNDAFIRMApthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCREARSEGUNDAFIRMApthisSolicitudInstance() == null || this.getSolicitudTCREARSEGUNDAFIRMApthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCREARSEGUNDAFIRMA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCREARSEGUNDAFIRMA_SOLICITUDTCREARSEGUNDAFIRMAPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCREARSEGUNDAFIRMA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCREARSEGUNDAFIRMA_SOLICITUDTCREARSEGUNDAFIRMAPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public byte[] getSolicitudTCREARSEGUNDAFIRMAptpatrImagenFirma() {
        return this.solicitudTCREARSEGUNDAFIRMAptpatrImagenFirma;
    }
    
    public void setSolicitudTCREARSEGUNDAFIRMAptpatrImagenFirma(byte[] solicitudTCREARSEGUNDAFIRMAptpatrImagenFirma) {
        this.solicitudTCREARSEGUNDAFIRMAptpatrImagenFirma = solicitudTCREARSEGUNDAFIRMAptpatrImagenFirma;
    }

    @JsonIgnore
    public String getSolicitudTCREARSEGUNDAFIRMAptpatrLatitud() {
        return this.solicitudTCREARSEGUNDAFIRMAptpatrLatitud;
    }
    
    public void setSolicitudTCREARSEGUNDAFIRMAptpatrLatitud(String solicitudTCREARSEGUNDAFIRMAptpatrLatitud) {
        this.solicitudTCREARSEGUNDAFIRMAptpatrLatitud = solicitudTCREARSEGUNDAFIRMAptpatrLatitud;
    }

    @JsonIgnore
    public String getSolicitudTCREARSEGUNDAFIRMAptpatrLongitud() {
        return this.solicitudTCREARSEGUNDAFIRMAptpatrLongitud;
    }
    
    public void setSolicitudTCREARSEGUNDAFIRMAptpatrLongitud(String solicitudTCREARSEGUNDAFIRMAptpatrLongitud) {
        this.solicitudTCREARSEGUNDAFIRMAptpatrLongitud = solicitudTCREARSEGUNDAFIRMAptpatrLongitud;
    }

    @JsonIgnore
    public String getSolicitudTCREARSEGUNDAFIRMAptTexto() {
        return this.solicitudTCREARSEGUNDAFIRMAptTexto;
    }
    
    public void setSolicitudTCREARSEGUNDAFIRMAptTexto(String solicitudTCREARSEGUNDAFIRMAptTexto) {
        this.solicitudTCREARSEGUNDAFIRMAptTexto = solicitudTCREARSEGUNDAFIRMAptTexto;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
