package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class InsSolicitudProteccionDatosRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudInsSolicitudProteccionDatospthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudInsSolicitudProteccionDatospthisSolicitudInstance;

    @JsonProperty("p_evcprotecciondatos_oid")
    private ProteccionDatosOid solicitudInsSolicitudProteccionDatospevcProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos solicitudInsSolicitudProteccionDatospevcProteccionDatosInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudInsSolicitudProteccionDatospthisSolicitud();
        checkSolicitudInsSolicitudProteccionDatospevcProteccionDatos();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudInsSolicitudProteccionDatospthisSolicitud() {
        return this.solicitudInsSolicitudProteccionDatospthisSolicitud;
    }
    
    public void setSolicitudInsSolicitudProteccionDatospthisSolicitud(SolicitudOid solicitudInsSolicitudProteccionDatospthisSolicitud) {
        this.solicitudInsSolicitudProteccionDatospthisSolicitud = solicitudInsSolicitudProteccionDatospthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudInsSolicitudProteccionDatospthisSolicitudInstance() {
        return this.solicitudInsSolicitudProteccionDatospthisSolicitudInstance;
    }
    
    public void setSolicitudInsSolicitudProteccionDatospthisSolicitudInstance(Solicitud solicitudInsSolicitudProteccionDatospthisSolicitud) {
        this.solicitudInsSolicitudProteccionDatospthisSolicitudInstance = solicitudInsSolicitudProteccionDatospthisSolicitud;
        this.solicitudInsSolicitudProteccionDatospthisSolicitud = solicitudInsSolicitudProteccionDatospthisSolicitud != null ? solicitudInsSolicitudProteccionDatospthisSolicitud.getOid() : null;
    }

    private void checkSolicitudInsSolicitudProteccionDatospthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudInsSolicitudProteccionDatospthisSolicitudInstance() == null || this.getSolicitudInsSolicitudProteccionDatospthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSSOLICITUDPROTECCIONDATOS, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSSOLICITUDPROTECCIONDATOS_SOLICITUDINSSOLICITUDPROTECCIONDATOSPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_INSSOLICITUDPROTECCIONDATOS, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSSOLICITUDPROTECCIONDATOS_SOLICITUDINSSOLICITUDPROTECCIONDATOSPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getSolicitudInsSolicitudProteccionDatospevcProteccionDatos() {
        return this.solicitudInsSolicitudProteccionDatospevcProteccionDatos;
    }
    
    public void setSolicitudInsSolicitudProteccionDatospevcProteccionDatos(ProteccionDatosOid solicitudInsSolicitudProteccionDatospevcProteccionDatos) {
        this.solicitudInsSolicitudProteccionDatospevcProteccionDatos = solicitudInsSolicitudProteccionDatospevcProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getSolicitudInsSolicitudProteccionDatospevcProteccionDatosInstance() {
        return this.solicitudInsSolicitudProteccionDatospevcProteccionDatosInstance;
    }
    
    public void setSolicitudInsSolicitudProteccionDatospevcProteccionDatosInstance(ProteccionDatos solicitudInsSolicitudProteccionDatospevcProteccionDatos) {
        this.solicitudInsSolicitudProteccionDatospevcProteccionDatosInstance = solicitudInsSolicitudProteccionDatospevcProteccionDatos;
        this.solicitudInsSolicitudProteccionDatospevcProteccionDatos = solicitudInsSolicitudProteccionDatospevcProteccionDatos != null ? solicitudInsSolicitudProteccionDatospevcProteccionDatos.getOid() : null;
    }

    private void checkSolicitudInsSolicitudProteccionDatospevcProteccionDatos() throws NotNullArgumentException {
        if(this.getSolicitudInsSolicitudProteccionDatospevcProteccionDatosInstance() == null || this.getSolicitudInsSolicitudProteccionDatospevcProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSSOLICITUDPROTECCIONDATOS, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSSOLICITUDPROTECCIONDATOS_SOLICITUDINSSOLICITUDPROTECCIONDATOSPEVCPROTECCIONDATOS, SolicitudConstants.SERV_ALIAS_INSSOLICITUDPROTECCIONDATOS, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSSOLICITUDPROTECCIONDATOS_SOLICITUDINSSOLICITUDPROTECCIONDATOSPEVCPROTECCIONDATOS);
        }
    }
}
