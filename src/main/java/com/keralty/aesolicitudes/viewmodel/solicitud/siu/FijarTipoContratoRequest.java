package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class FijarTipoContratoRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudfijarTipoContratopthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudfijarTipoContratopthisSolicitudInstance;

    @JsonProperty("p_tipocontrato")
    private Long solicitudfijarTipoContratopTipoContrato;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudfijarTipoContratopthisSolicitud();
        checkSolicitudfijarTipoContratopTipoContrato();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudfijarTipoContratopthisSolicitud() {
        return this.solicitudfijarTipoContratopthisSolicitud;
    }
    
    public void setSolicitudfijarTipoContratopthisSolicitud(SolicitudOid solicitudfijarTipoContratopthisSolicitud) {
        this.solicitudfijarTipoContratopthisSolicitud = solicitudfijarTipoContratopthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudfijarTipoContratopthisSolicitudInstance() {
        return this.solicitudfijarTipoContratopthisSolicitudInstance;
    }
    
    public void setSolicitudfijarTipoContratopthisSolicitudInstance(Solicitud solicitudfijarTipoContratopthisSolicitud) {
        this.solicitudfijarTipoContratopthisSolicitudInstance = solicitudfijarTipoContratopthisSolicitud;
        this.solicitudfijarTipoContratopthisSolicitud = solicitudfijarTipoContratopthisSolicitud != null ? solicitudfijarTipoContratopthisSolicitud.getOid() : null;
    }

    private void checkSolicitudfijarTipoContratopthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudfijarTipoContratopthisSolicitudInstance() == null || this.getSolicitudfijarTipoContratopthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_FIJARTIPOCONTRATO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_FIJARTIPOCONTRATO_SOLICITUDFIJARTIPOCONTRATOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_FIJARTIPOCONTRATO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_FIJARTIPOCONTRATO_SOLICITUDFIJARTIPOCONTRATOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Long getSolicitudfijarTipoContratopTipoContrato() {
        return this.solicitudfijarTipoContratopTipoContrato;
    }
    
    public void setSolicitudfijarTipoContratopTipoContrato(Long solicitudfijarTipoContratopTipoContrato) {
        this.solicitudfijarTipoContratopTipoContrato = solicitudfijarTipoContratopTipoContrato;
    }

    private void checkSolicitudfijarTipoContratopTipoContrato() throws NotNullArgumentException {
        if(this.getSolicitudfijarTipoContratopTipoContrato() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_FIJARTIPOCONTRATO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_FIJARTIPOCONTRATO_SOLICITUDFIJARTIPOCONTRATOPTIPOCONTRATO, SolicitudConstants.SERV_ALIAS_FIJARTIPOCONTRATO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_FIJARTIPOCONTRATO_SOLICITUDFIJARTIPOCONTRATOPTIPOCONTRATO);
        }
    }
}
