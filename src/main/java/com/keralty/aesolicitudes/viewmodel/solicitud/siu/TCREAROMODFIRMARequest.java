package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCREAROMODFIRMARequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCREAROMODFIRMApthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCREAROMODFIRMApthisSolicitudInstance;

    @JsonProperty("pt_p_atrimagenfirma")
    private byte[] solicitudTCREAROMODFIRMAptpatrImagenFirma;

    @JsonProperty("pt_p_atrlatitud")
    private String solicitudTCREAROMODFIRMAptpatrLatitud;

    @JsonProperty("pt_p_atrlongitud")
    private String solicitudTCREAROMODFIRMAptpatrLongitud;

    @JsonProperty("pt_texto")
    private String solicitudTCREAROMODFIRMAptTexto;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCREAROMODFIRMApthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCREAROMODFIRMApthisSolicitud() {
        return this.solicitudTCREAROMODFIRMApthisSolicitud;
    }
    
    public void setSolicitudTCREAROMODFIRMApthisSolicitud(SolicitudOid solicitudTCREAROMODFIRMApthisSolicitud) {
        this.solicitudTCREAROMODFIRMApthisSolicitud = solicitudTCREAROMODFIRMApthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCREAROMODFIRMApthisSolicitudInstance() {
        return this.solicitudTCREAROMODFIRMApthisSolicitudInstance;
    }
    
    public void setSolicitudTCREAROMODFIRMApthisSolicitudInstance(Solicitud solicitudTCREAROMODFIRMApthisSolicitud) {
        this.solicitudTCREAROMODFIRMApthisSolicitudInstance = solicitudTCREAROMODFIRMApthisSolicitud;
        this.solicitudTCREAROMODFIRMApthisSolicitud = solicitudTCREAROMODFIRMApthisSolicitud != null ? solicitudTCREAROMODFIRMApthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCREAROMODFIRMApthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCREAROMODFIRMApthisSolicitudInstance() == null || this.getSolicitudTCREAROMODFIRMApthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCREAROMODFIRMA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCREAROMODFIRMA_SOLICITUDTCREAROMODFIRMAPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCREAROMODFIRMA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCREAROMODFIRMA_SOLICITUDTCREAROMODFIRMAPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public byte[] getSolicitudTCREAROMODFIRMAptpatrImagenFirma() {
        return this.solicitudTCREAROMODFIRMAptpatrImagenFirma;
    }
    
    public void setSolicitudTCREAROMODFIRMAptpatrImagenFirma(byte[] solicitudTCREAROMODFIRMAptpatrImagenFirma) {
        this.solicitudTCREAROMODFIRMAptpatrImagenFirma = solicitudTCREAROMODFIRMAptpatrImagenFirma;
    }

    @JsonIgnore
    public String getSolicitudTCREAROMODFIRMAptpatrLatitud() {
        return this.solicitudTCREAROMODFIRMAptpatrLatitud;
    }
    
    public void setSolicitudTCREAROMODFIRMAptpatrLatitud(String solicitudTCREAROMODFIRMAptpatrLatitud) {
        this.solicitudTCREAROMODFIRMAptpatrLatitud = solicitudTCREAROMODFIRMAptpatrLatitud;
    }

    @JsonIgnore
    public String getSolicitudTCREAROMODFIRMAptpatrLongitud() {
        return this.solicitudTCREAROMODFIRMAptpatrLongitud;
    }
    
    public void setSolicitudTCREAROMODFIRMAptpatrLongitud(String solicitudTCREAROMODFIRMAptpatrLongitud) {
        this.solicitudTCREAROMODFIRMAptpatrLongitud = solicitudTCREAROMODFIRMAptpatrLongitud;
    }

    @JsonIgnore
    public String getSolicitudTCREAROMODFIRMAptTexto() {
        return this.solicitudTCREAROMODFIRMAptTexto;
    }
    
    public void setSolicitudTCREAROMODFIRMAptTexto(String solicitudTCREAROMODFIRMAptTexto) {
        this.solicitudTCREAROMODFIRMAptTexto = solicitudTCREAROMODFIRMAptTexto;
    }
}
