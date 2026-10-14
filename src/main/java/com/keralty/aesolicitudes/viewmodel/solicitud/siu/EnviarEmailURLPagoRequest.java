package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.PlantillaEmailOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class EnviarEmailURLPagoRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudenviarEmailURLPagopthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudenviarEmailURLPagopthisSolicitudInstance;

    @JsonProperty("p_urlpago")
    private String solicitudenviarEmailURLPagopURLPago;

    @JsonProperty("peplantilla_oid")
    private PlantillaEmailOid solicitudenviarEmailURLPagopePlantilla;
    
    @JsonIgnore
    private PlantillaEmail solicitudenviarEmailURLPagopePlantillaInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudenviarEmailURLPagopthisSolicitud();
        checkSolicitudenviarEmailURLPagopURLPago();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudenviarEmailURLPagopthisSolicitud() {
        return this.solicitudenviarEmailURLPagopthisSolicitud;
    }
    
    public void setSolicitudenviarEmailURLPagopthisSolicitud(SolicitudOid solicitudenviarEmailURLPagopthisSolicitud) {
        this.solicitudenviarEmailURLPagopthisSolicitud = solicitudenviarEmailURLPagopthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudenviarEmailURLPagopthisSolicitudInstance() {
        return this.solicitudenviarEmailURLPagopthisSolicitudInstance;
    }
    
    public void setSolicitudenviarEmailURLPagopthisSolicitudInstance(Solicitud solicitudenviarEmailURLPagopthisSolicitud) {
        this.solicitudenviarEmailURLPagopthisSolicitudInstance = solicitudenviarEmailURLPagopthisSolicitud;
        this.solicitudenviarEmailURLPagopthisSolicitud = solicitudenviarEmailURLPagopthisSolicitud != null ? solicitudenviarEmailURLPagopthisSolicitud.getOid() : null;
    }

    private void checkSolicitudenviarEmailURLPagopthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudenviarEmailURLPagopthisSolicitudInstance() == null || this.getSolicitudenviarEmailURLPagopthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ENVIAREMAILURLPAGO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ENVIAREMAILURLPAGO_SOLICITUDENVIAREMAILURLPAGOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_ENVIAREMAILURLPAGO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ENVIAREMAILURLPAGO_SOLICITUDENVIAREMAILURLPAGOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudenviarEmailURLPagopURLPago() {
        return this.solicitudenviarEmailURLPagopURLPago;
    }
    
    public void setSolicitudenviarEmailURLPagopURLPago(String solicitudenviarEmailURLPagopURLPago) {
        this.solicitudenviarEmailURLPagopURLPago = solicitudenviarEmailURLPagopURLPago;
    }

    private void checkSolicitudenviarEmailURLPagopURLPago() throws NotNullArgumentException {
        if(this.getSolicitudenviarEmailURLPagopURLPago() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ENVIAREMAILURLPAGO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ENVIAREMAILURLPAGO_SOLICITUDENVIAREMAILURLPAGOPURLPAGO, SolicitudConstants.SERV_ALIAS_ENVIAREMAILURLPAGO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ENVIAREMAILURLPAGO_SOLICITUDENVIAREMAILURLPAGOPURLPAGO);
        }
    }

    @JsonIgnore
    public PlantillaEmailOid getSolicitudenviarEmailURLPagopePlantilla() {
        return this.solicitudenviarEmailURLPagopePlantilla;
    }
    
    public void setSolicitudenviarEmailURLPagopePlantilla(PlantillaEmailOid solicitudenviarEmailURLPagopePlantilla) {
        this.solicitudenviarEmailURLPagopePlantilla = solicitudenviarEmailURLPagopePlantilla;
    }

    @JsonIgnore
    public PlantillaEmail getSolicitudenviarEmailURLPagopePlantillaInstance() {
        return this.solicitudenviarEmailURLPagopePlantillaInstance;
    }
    
    public void setSolicitudenviarEmailURLPagopePlantillaInstance(PlantillaEmail solicitudenviarEmailURLPagopePlantilla) {
        this.solicitudenviarEmailURLPagopePlantillaInstance = solicitudenviarEmailURLPagopePlantilla;
        this.solicitudenviarEmailURLPagopePlantilla = solicitudenviarEmailURLPagopePlantilla != null ? solicitudenviarEmailURLPagopePlantilla.getOid() : null;
    }
}
