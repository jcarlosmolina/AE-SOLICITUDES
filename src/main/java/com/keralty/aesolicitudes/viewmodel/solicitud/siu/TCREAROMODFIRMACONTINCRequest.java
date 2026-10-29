package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCREAROMODFIRMACONTINCRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCREAROMODFIRMACONTINCpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCREAROMODFIRMACONTINCpthisSolicitudInstance;

    @JsonProperty("pt_p_atrimagenfirma")
    private byte[] solicitudTCREAROMODFIRMACONTINCptpatrImagenFirma;

    @JsonProperty("pt_p_atrlatitud")
    private String solicitudTCREAROMODFIRMACONTINCptpatrLatitud;

    @JsonProperty("pt_p_atrlongitud")
    private String solicitudTCREAROMODFIRMACONTINCptpatrLongitud;

    @JsonProperty("pt_texto")
    private String solicitudTCREAROMODFIRMACONTINCptTexto;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCREAROMODFIRMACONTINCpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCREAROMODFIRMACONTINCpthisSolicitud() {
        return this.solicitudTCREAROMODFIRMACONTINCpthisSolicitud;
    }
    
    public void setSolicitudTCREAROMODFIRMACONTINCpthisSolicitud(SolicitudOid solicitudTCREAROMODFIRMACONTINCpthisSolicitud) {
        this.solicitudTCREAROMODFIRMACONTINCpthisSolicitud = solicitudTCREAROMODFIRMACONTINCpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCREAROMODFIRMACONTINCpthisSolicitudInstance() {
        return this.solicitudTCREAROMODFIRMACONTINCpthisSolicitudInstance;
    }
    
    public void setSolicitudTCREAROMODFIRMACONTINCpthisSolicitudInstance(Solicitud solicitudTCREAROMODFIRMACONTINCpthisSolicitud) {
        this.solicitudTCREAROMODFIRMACONTINCpthisSolicitudInstance = solicitudTCREAROMODFIRMACONTINCpthisSolicitud;
        this.solicitudTCREAROMODFIRMACONTINCpthisSolicitud = solicitudTCREAROMODFIRMACONTINCpthisSolicitud != null ? solicitudTCREAROMODFIRMACONTINCpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCREAROMODFIRMACONTINCpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCREAROMODFIRMACONTINCpthisSolicitudInstance() == null || this.getSolicitudTCREAROMODFIRMACONTINCpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCREAROMODFIRMACONTINC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCREAROMODFIRMACONTINC_SOLICITUDTCREAROMODFIRMACONTINCPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCREAROMODFIRMACONTINC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCREAROMODFIRMACONTINC_SOLICITUDTCREAROMODFIRMACONTINCPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public byte[] getSolicitudTCREAROMODFIRMACONTINCptpatrImagenFirma() {
        return this.solicitudTCREAROMODFIRMACONTINCptpatrImagenFirma;
    }
    
    public void setSolicitudTCREAROMODFIRMACONTINCptpatrImagenFirma(byte[] solicitudTCREAROMODFIRMACONTINCptpatrImagenFirma) {
        this.solicitudTCREAROMODFIRMACONTINCptpatrImagenFirma = solicitudTCREAROMODFIRMACONTINCptpatrImagenFirma;
    }

    @JsonIgnore
    public String getSolicitudTCREAROMODFIRMACONTINCptpatrLatitud() {
        return this.solicitudTCREAROMODFIRMACONTINCptpatrLatitud;
    }
    
    public void setSolicitudTCREAROMODFIRMACONTINCptpatrLatitud(String solicitudTCREAROMODFIRMACONTINCptpatrLatitud) {
        this.solicitudTCREAROMODFIRMACONTINCptpatrLatitud = solicitudTCREAROMODFIRMACONTINCptpatrLatitud;
    }

    @JsonIgnore
    public String getSolicitudTCREAROMODFIRMACONTINCptpatrLongitud() {
        return this.solicitudTCREAROMODFIRMACONTINCptpatrLongitud;
    }
    
    public void setSolicitudTCREAROMODFIRMACONTINCptpatrLongitud(String solicitudTCREAROMODFIRMACONTINCptpatrLongitud) {
        this.solicitudTCREAROMODFIRMACONTINCptpatrLongitud = solicitudTCREAROMODFIRMACONTINCptpatrLongitud;
    }

    @JsonIgnore
    public String getSolicitudTCREAROMODFIRMACONTINCptTexto() {
        return this.solicitudTCREAROMODFIRMACONTINCptTexto;
    }
    
    public void setSolicitudTCREAROMODFIRMACONTINCptTexto(String solicitudTCREAROMODFIRMACONTINCptTexto) {
        this.solicitudTCREAROMODFIRMACONTINCptTexto = solicitudTCREAROMODFIRMACONTINCptTexto;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
