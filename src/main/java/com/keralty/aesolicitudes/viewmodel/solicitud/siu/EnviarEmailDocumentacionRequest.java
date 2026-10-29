package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.PlantillaEmailOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class EnviarEmailDocumentacionRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudenviarEmailDocumentacionpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudenviarEmailDocumentacionpthisSolicitudInstance;

    @JsonProperty("pfu_rutaadjunto")
    private String solicitudenviarEmailDocumentacionpfuRutaAdjunto;

    @JsonProperty("peplantilla_oid")
    private PlantillaEmailOid solicitudenviarEmailDocumentacionpePlantilla;
    
    @JsonIgnore
    private PlantillaEmail solicitudenviarEmailDocumentacionpePlantillaInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudenviarEmailDocumentacionpthisSolicitud();
        checkSolicitudenviarEmailDocumentacionpfuRutaAdjunto();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudenviarEmailDocumentacionpthisSolicitud() {
        return this.solicitudenviarEmailDocumentacionpthisSolicitud;
    }
    
    public void setSolicitudenviarEmailDocumentacionpthisSolicitud(SolicitudOid solicitudenviarEmailDocumentacionpthisSolicitud) {
        this.solicitudenviarEmailDocumentacionpthisSolicitud = solicitudenviarEmailDocumentacionpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudenviarEmailDocumentacionpthisSolicitudInstance() {
        return this.solicitudenviarEmailDocumentacionpthisSolicitudInstance;
    }
    
    public void setSolicitudenviarEmailDocumentacionpthisSolicitudInstance(Solicitud solicitudenviarEmailDocumentacionpthisSolicitud) {
        this.solicitudenviarEmailDocumentacionpthisSolicitudInstance = solicitudenviarEmailDocumentacionpthisSolicitud;
        this.solicitudenviarEmailDocumentacionpthisSolicitud = solicitudenviarEmailDocumentacionpthisSolicitud != null ? solicitudenviarEmailDocumentacionpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudenviarEmailDocumentacionpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudenviarEmailDocumentacionpthisSolicitudInstance() == null || this.getSolicitudenviarEmailDocumentacionpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ENVIAREMAILDOCUMENTACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ENVIAREMAILDOCUMENTACION_SOLICITUDENVIAREMAILDOCUMENTACIONPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_ENVIAREMAILDOCUMENTACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ENVIAREMAILDOCUMENTACION_SOLICITUDENVIAREMAILDOCUMENTACIONPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudenviarEmailDocumentacionpfuRutaAdjunto() {
        return this.solicitudenviarEmailDocumentacionpfuRutaAdjunto;
    }
    
    public void setSolicitudenviarEmailDocumentacionpfuRutaAdjunto(String solicitudenviarEmailDocumentacionpfuRutaAdjunto) {
        this.solicitudenviarEmailDocumentacionpfuRutaAdjunto = solicitudenviarEmailDocumentacionpfuRutaAdjunto;
    }

    private void checkSolicitudenviarEmailDocumentacionpfuRutaAdjunto() throws NotNullArgumentException {
        if(this.getSolicitudenviarEmailDocumentacionpfuRutaAdjunto() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ENVIAREMAILDOCUMENTACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ENVIAREMAILDOCUMENTACION_SOLICITUDENVIAREMAILDOCUMENTACIONPFURUTAADJUNTO, SolicitudConstants.SERV_ALIAS_ENVIAREMAILDOCUMENTACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ENVIAREMAILDOCUMENTACION_SOLICITUDENVIAREMAILDOCUMENTACIONPFURUTAADJUNTO);
        }
    }

    @JsonIgnore
    public PlantillaEmailOid getSolicitudenviarEmailDocumentacionpePlantilla() {
        return this.solicitudenviarEmailDocumentacionpePlantilla;
    }
    
    public void setSolicitudenviarEmailDocumentacionpePlantilla(PlantillaEmailOid solicitudenviarEmailDocumentacionpePlantilla) {
        this.solicitudenviarEmailDocumentacionpePlantilla = solicitudenviarEmailDocumentacionpePlantilla;
    }

    @JsonIgnore
    public PlantillaEmail getSolicitudenviarEmailDocumentacionpePlantillaInstance() {
        return this.solicitudenviarEmailDocumentacionpePlantillaInstance;
    }
    
    public void setSolicitudenviarEmailDocumentacionpePlantillaInstance(PlantillaEmail solicitudenviarEmailDocumentacionpePlantilla) {
        this.solicitudenviarEmailDocumentacionpePlantillaInstance = solicitudenviarEmailDocumentacionpePlantilla;
        this.solicitudenviarEmailDocumentacionpePlantilla = solicitudenviarEmailDocumentacionpePlantilla != null ? solicitudenviarEmailDocumentacionpePlantilla.getOid() : null;
    }
}
