package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class SearchDocumentoNumIdRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudsearchDocumentoNumIdpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudsearchDocumentoNumIdpthisSolicitudInstance;

    @JsonProperty("p_numidentificacion")
    private String solicitudsearchDocumentoNumIdpNumIdentificacion;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudsearchDocumentoNumIdpthisSolicitud();
        checkSolicitudsearchDocumentoNumIdpNumIdentificacion();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudsearchDocumentoNumIdpthisSolicitud() {
        return this.solicitudsearchDocumentoNumIdpthisSolicitud;
    }
    
    public void setSolicitudsearchDocumentoNumIdpthisSolicitud(SolicitudOid solicitudsearchDocumentoNumIdpthisSolicitud) {
        this.solicitudsearchDocumentoNumIdpthisSolicitud = solicitudsearchDocumentoNumIdpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudsearchDocumentoNumIdpthisSolicitudInstance() {
        return this.solicitudsearchDocumentoNumIdpthisSolicitudInstance;
    }
    
    public void setSolicitudsearchDocumentoNumIdpthisSolicitudInstance(Solicitud solicitudsearchDocumentoNumIdpthisSolicitud) {
        this.solicitudsearchDocumentoNumIdpthisSolicitudInstance = solicitudsearchDocumentoNumIdpthisSolicitud;
        this.solicitudsearchDocumentoNumIdpthisSolicitud = solicitudsearchDocumentoNumIdpthisSolicitud != null ? solicitudsearchDocumentoNumIdpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudsearchDocumentoNumIdpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudsearchDocumentoNumIdpthisSolicitudInstance() == null || this.getSolicitudsearchDocumentoNumIdpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_SEARCHDOCUMENTONUMID, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_SEARCHDOCUMENTONUMID_SOLICITUDSEARCHDOCUMENTONUMIDPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_SEARCHDOCUMENTONUMID, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_SEARCHDOCUMENTONUMID_SOLICITUDSEARCHDOCUMENTONUMIDPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudsearchDocumentoNumIdpNumIdentificacion() {
        return this.solicitudsearchDocumentoNumIdpNumIdentificacion;
    }
    
    public void setSolicitudsearchDocumentoNumIdpNumIdentificacion(String solicitudsearchDocumentoNumIdpNumIdentificacion) {
        this.solicitudsearchDocumentoNumIdpNumIdentificacion = solicitudsearchDocumentoNumIdpNumIdentificacion;
    }

    private void checkSolicitudsearchDocumentoNumIdpNumIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudsearchDocumentoNumIdpNumIdentificacion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_SEARCHDOCUMENTONUMID, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_SEARCHDOCUMENTONUMID_SOLICITUDSEARCHDOCUMENTONUMIDPNUMIDENTIFICACION, SolicitudConstants.SERV_ALIAS_SEARCHDOCUMENTONUMID, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_SEARCHDOCUMENTONUMID_SOLICITUDSEARCHDOCUMENTONUMIDPNUMIDENTIFICACION);
        }
    }
}
