package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class RegistrarDatosCabeceraRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudregistrarDatosCabecerapthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudregistrarDatosCabecerapthisSolicitudInstance;

    @JsonProperty("p_tipocontrato")
    private Long solicitudregistrarDatosCabeceraptipoContrato;

    @JsonProperty("p_codigosucursalrad")
    private String solicitudregistrarDatosCabecerapcodigoSucursalRad;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudregistrarDatosCabecerapthisSolicitud();
        checkSolicitudregistrarDatosCabeceraptipoContrato();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudregistrarDatosCabecerapthisSolicitud() {
        return this.solicitudregistrarDatosCabecerapthisSolicitud;
    }
    
    public void setSolicitudregistrarDatosCabecerapthisSolicitud(SolicitudOid solicitudregistrarDatosCabecerapthisSolicitud) {
        this.solicitudregistrarDatosCabecerapthisSolicitud = solicitudregistrarDatosCabecerapthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudregistrarDatosCabecerapthisSolicitudInstance() {
        return this.solicitudregistrarDatosCabecerapthisSolicitudInstance;
    }
    
    public void setSolicitudregistrarDatosCabecerapthisSolicitudInstance(Solicitud solicitudregistrarDatosCabecerapthisSolicitud) {
        this.solicitudregistrarDatosCabecerapthisSolicitudInstance = solicitudregistrarDatosCabecerapthisSolicitud;
        this.solicitudregistrarDatosCabecerapthisSolicitud = solicitudregistrarDatosCabecerapthisSolicitud != null ? solicitudregistrarDatosCabecerapthisSolicitud.getOid() : null;
    }

    private void checkSolicitudregistrarDatosCabecerapthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudregistrarDatosCabecerapthisSolicitudInstance() == null || this.getSolicitudregistrarDatosCabecerapthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_REGISTRARDATOSCABECERA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_REGISTRARDATOSCABECERA_SOLICITUDREGISTRARDATOSCABECERAPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_REGISTRARDATOSCABECERA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_REGISTRARDATOSCABECERA_SOLICITUDREGISTRARDATOSCABECERAPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Long getSolicitudregistrarDatosCabeceraptipoContrato() {
        return this.solicitudregistrarDatosCabeceraptipoContrato;
    }
    
    public void setSolicitudregistrarDatosCabeceraptipoContrato(Long solicitudregistrarDatosCabeceraptipoContrato) {
        this.solicitudregistrarDatosCabeceraptipoContrato = solicitudregistrarDatosCabeceraptipoContrato;
    }

    private void checkSolicitudregistrarDatosCabeceraptipoContrato() throws NotNullArgumentException {
        if(this.getSolicitudregistrarDatosCabeceraptipoContrato() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_REGISTRARDATOSCABECERA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_REGISTRARDATOSCABECERA_SOLICITUDREGISTRARDATOSCABECERAPTIPOCONTRATO, SolicitudConstants.SERV_ALIAS_REGISTRARDATOSCABECERA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_REGISTRARDATOSCABECERA_SOLICITUDREGISTRARDATOSCABECERAPTIPOCONTRATO);
        }
    }

    @JsonIgnore
    public String getSolicitudregistrarDatosCabecerapcodigoSucursalRad() {
        return this.solicitudregistrarDatosCabecerapcodigoSucursalRad;
    }
    
    public void setSolicitudregistrarDatosCabecerapcodigoSucursalRad(String solicitudregistrarDatosCabecerapcodigoSucursalRad) {
        this.solicitudregistrarDatosCabecerapcodigoSucursalRad = solicitudregistrarDatosCabecerapcodigoSucursalRad;
    }
}
