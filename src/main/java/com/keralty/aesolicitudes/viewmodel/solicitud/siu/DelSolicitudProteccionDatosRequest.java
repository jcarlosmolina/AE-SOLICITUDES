package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DelSolicitudProteccionDatosRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudDelSolicitudProteccionDatospthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudDelSolicitudProteccionDatospthisSolicitudInstance;

    @JsonProperty("p_evcprotecciondatos_oid")
    private ProteccionDatosOid solicitudDelSolicitudProteccionDatospevcProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos solicitudDelSolicitudProteccionDatospevcProteccionDatosInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudDelSolicitudProteccionDatospthisSolicitud();
        checkSolicitudDelSolicitudProteccionDatospevcProteccionDatos();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudDelSolicitudProteccionDatospthisSolicitud() {
        return this.solicitudDelSolicitudProteccionDatospthisSolicitud;
    }
    
    public void setSolicitudDelSolicitudProteccionDatospthisSolicitud(SolicitudOid solicitudDelSolicitudProteccionDatospthisSolicitud) {
        this.solicitudDelSolicitudProteccionDatospthisSolicitud = solicitudDelSolicitudProteccionDatospthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudDelSolicitudProteccionDatospthisSolicitudInstance() {
        return this.solicitudDelSolicitudProteccionDatospthisSolicitudInstance;
    }
    
    public void setSolicitudDelSolicitudProteccionDatospthisSolicitudInstance(Solicitud solicitudDelSolicitudProteccionDatospthisSolicitud) {
        this.solicitudDelSolicitudProteccionDatospthisSolicitudInstance = solicitudDelSolicitudProteccionDatospthisSolicitud;
        this.solicitudDelSolicitudProteccionDatospthisSolicitud = solicitudDelSolicitudProteccionDatospthisSolicitud != null ? solicitudDelSolicitudProteccionDatospthisSolicitud.getOid() : null;
    }

    private void checkSolicitudDelSolicitudProteccionDatospthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudDelSolicitudProteccionDatospthisSolicitudInstance() == null || this.getSolicitudDelSolicitudProteccionDatospthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELSOLICITUDPROTECCIONDATOS, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELSOLICITUDPROTECCIONDATOS_SOLICITUDDELSOLICITUDPROTECCIONDATOSPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DELSOLICITUDPROTECCIONDATOS, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELSOLICITUDPROTECCIONDATOS_SOLICITUDDELSOLICITUDPROTECCIONDATOSPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getSolicitudDelSolicitudProteccionDatospevcProteccionDatos() {
        return this.solicitudDelSolicitudProteccionDatospevcProteccionDatos;
    }
    
    public void setSolicitudDelSolicitudProteccionDatospevcProteccionDatos(ProteccionDatosOid solicitudDelSolicitudProteccionDatospevcProteccionDatos) {
        this.solicitudDelSolicitudProteccionDatospevcProteccionDatos = solicitudDelSolicitudProteccionDatospevcProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getSolicitudDelSolicitudProteccionDatospevcProteccionDatosInstance() {
        return this.solicitudDelSolicitudProteccionDatospevcProteccionDatosInstance;
    }
    
    public void setSolicitudDelSolicitudProteccionDatospevcProteccionDatosInstance(ProteccionDatos solicitudDelSolicitudProteccionDatospevcProteccionDatos) {
        this.solicitudDelSolicitudProteccionDatospevcProteccionDatosInstance = solicitudDelSolicitudProteccionDatospevcProteccionDatos;
        this.solicitudDelSolicitudProteccionDatospevcProteccionDatos = solicitudDelSolicitudProteccionDatospevcProteccionDatos != null ? solicitudDelSolicitudProteccionDatospevcProteccionDatos.getOid() : null;
    }

    private void checkSolicitudDelSolicitudProteccionDatospevcProteccionDatos() throws NotNullArgumentException {
        if(this.getSolicitudDelSolicitudProteccionDatospevcProteccionDatosInstance() == null || this.getSolicitudDelSolicitudProteccionDatospevcProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELSOLICITUDPROTECCIONDATOS, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELSOLICITUDPROTECCIONDATOS_SOLICITUDDELSOLICITUDPROTECCIONDATOSPEVCPROTECCIONDATOS, SolicitudConstants.SERV_ALIAS_DELSOLICITUDPROTECCIONDATOS, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELSOLICITUDPROTECCIONDATOS_SOLICITUDDELSOLICITUDPROTECCIONDATOSPEVCPROTECCIONDATOS);
        }
    }
}
