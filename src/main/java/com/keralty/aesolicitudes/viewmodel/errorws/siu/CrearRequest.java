package com.keralty.aesolicitudes.viewmodel.errorws.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ErrorWSConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class CrearRequest {

    @JsonProperty("p_agrsolicitud_oid")
    private SolicitudOid errorWScrearpagrSolicitud;
    
    @JsonIgnore
    private Solicitud errorWScrearpagrSolicitudInstance;

    @JsonProperty("p_atrdescripcion")
    private String errorWScrearpatrDescripcion;

    public void checkArguments() throws NotNullArgumentException {
        checkErrorWScrearpagrSolicitud();
        checkErrorWScrearpatrDescripcion();
    }

    @JsonIgnore
    public SolicitudOid getErrorWScrearpagrSolicitud() {
        return this.errorWScrearpagrSolicitud;
    }
    
    public void setErrorWScrearpagrSolicitud(SolicitudOid errorWScrearpagrSolicitud) {
        this.errorWScrearpagrSolicitud = errorWScrearpagrSolicitud;
    }

    @JsonIgnore
    public Solicitud getErrorWScrearpagrSolicitudInstance() {
        return this.errorWScrearpagrSolicitudInstance;
    }
    
    public void setErrorWScrearpagrSolicitudInstance(Solicitud errorWScrearpagrSolicitud) {
        this.errorWScrearpagrSolicitudInstance = errorWScrearpagrSolicitud;
        this.errorWScrearpagrSolicitud = errorWScrearpagrSolicitud != null ? errorWScrearpagrSolicitud.getOid() : null;
    }

    private void checkErrorWScrearpagrSolicitud() throws NotNullArgumentException {
        if(this.getErrorWScrearpagrSolicitudInstance() == null || this.getErrorWScrearpagrSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(ErrorWSConstants.SERV_ID_CREAR, ErrorWSConstants.CLASS_ID, ErrorWSConstants.ARG_ID_CREAR_ERRORWSCREARPAGRSOLICITUD, ErrorWSConstants.SERV_ALIAS_CREAR, ErrorWSConstants.CLASS_ALIAS, ErrorWSConstants.ARG_ALIAS_CREAR_ERRORWSCREARPAGRSOLICITUD);
        }
    }

    @JsonIgnore
    public String getErrorWScrearpatrDescripcion() {
        return this.errorWScrearpatrDescripcion;
    }
    
    public void setErrorWScrearpatrDescripcion(String errorWScrearpatrDescripcion) {
        this.errorWScrearpatrDescripcion = errorWScrearpatrDescripcion;
    }

    private void checkErrorWScrearpatrDescripcion() throws NotNullArgumentException {
        if(this.getErrorWScrearpatrDescripcion() == null) {
            throw new NotNullArgumentException(ErrorWSConstants.SERV_ID_CREAR, ErrorWSConstants.CLASS_ID, ErrorWSConstants.ARG_ID_CREAR_ERRORWSCREARPATRDESCRIPCION, ErrorWSConstants.SERV_ALIAS_CREAR, ErrorWSConstants.CLASS_ALIAS, ErrorWSConstants.ARG_ALIAS_CREAR_ERRORWSCREARPATRDESCRIPCION);
        }
    }
}
