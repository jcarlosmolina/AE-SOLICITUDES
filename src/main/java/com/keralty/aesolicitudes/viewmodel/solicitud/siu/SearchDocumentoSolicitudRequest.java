package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class SearchDocumentoSolicitudRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudsearchDocumentoSolicitudpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudsearchDocumentoSolicitudpthisSolicitudInstance;

    @JsonProperty("p_numidentificacion")
    private String solicitudsearchDocumentoSolicitudpNumIdentificacion;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudsearchDocumentoSolicitudpthisSolicitud();
        checkSolicitudsearchDocumentoSolicitudpNumIdentificacion();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudsearchDocumentoSolicitudpthisSolicitud() {
        return this.solicitudsearchDocumentoSolicitudpthisSolicitud;
    }
    
    public void setSolicitudsearchDocumentoSolicitudpthisSolicitud(SolicitudOid solicitudsearchDocumentoSolicitudpthisSolicitud) {
        this.solicitudsearchDocumentoSolicitudpthisSolicitud = solicitudsearchDocumentoSolicitudpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudsearchDocumentoSolicitudpthisSolicitudInstance() {
        return this.solicitudsearchDocumentoSolicitudpthisSolicitudInstance;
    }
    
    public void setSolicitudsearchDocumentoSolicitudpthisSolicitudInstance(Solicitud solicitudsearchDocumentoSolicitudpthisSolicitud) {
        this.solicitudsearchDocumentoSolicitudpthisSolicitudInstance = solicitudsearchDocumentoSolicitudpthisSolicitud;
        this.solicitudsearchDocumentoSolicitudpthisSolicitud = solicitudsearchDocumentoSolicitudpthisSolicitud != null ? solicitudsearchDocumentoSolicitudpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudsearchDocumentoSolicitudpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudsearchDocumentoSolicitudpthisSolicitudInstance() == null || this.getSolicitudsearchDocumentoSolicitudpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_SEARCHDOCUMENTOSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_SEARCHDOCUMENTOSOLICITUD_SOLICITUDSEARCHDOCUMENTOSOLICITUDPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_SEARCHDOCUMENTOSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_SEARCHDOCUMENTOSOLICITUD_SOLICITUDSEARCHDOCUMENTOSOLICITUDPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudsearchDocumentoSolicitudpNumIdentificacion() {
        return this.solicitudsearchDocumentoSolicitudpNumIdentificacion;
    }
    
    public void setSolicitudsearchDocumentoSolicitudpNumIdentificacion(String solicitudsearchDocumentoSolicitudpNumIdentificacion) {
        this.solicitudsearchDocumentoSolicitudpNumIdentificacion = solicitudsearchDocumentoSolicitudpNumIdentificacion;
    }

    private void checkSolicitudsearchDocumentoSolicitudpNumIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudsearchDocumentoSolicitudpNumIdentificacion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_SEARCHDOCUMENTOSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_SEARCHDOCUMENTOSOLICITUD_SOLICITUDSEARCHDOCUMENTOSOLICITUDPNUMIDENTIFICACION, SolicitudConstants.SERV_ALIAS_SEARCHDOCUMENTOSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_SEARCHDOCUMENTOSOLICITUD_SOLICITUDSEARCHDOCUMENTOSOLICITUDPNUMIDENTIFICACION);
        }
    }
}
