package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TMODDIRECCIONRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTMODDIRECCIONpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTMODDIRECCIONpthisSolicitudInstance;

    @JsonProperty("pt_direcciones_json")
    private String solicitudTMODDIRECCIONptDirecciones;
    
    @JsonIgnore
    private Direccion solicitudTMODDIRECCIONptDireccionesInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTMODDIRECCIONpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTMODDIRECCIONpthisSolicitud() {
        return this.solicitudTMODDIRECCIONpthisSolicitud;
    }
    
    public void setSolicitudTMODDIRECCIONpthisSolicitud(SolicitudOid solicitudTMODDIRECCIONpthisSolicitud) {
        this.solicitudTMODDIRECCIONpthisSolicitud = solicitudTMODDIRECCIONpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTMODDIRECCIONpthisSolicitudInstance() {
        return this.solicitudTMODDIRECCIONpthisSolicitudInstance;
    }
    
    public void setSolicitudTMODDIRECCIONpthisSolicitudInstance(Solicitud solicitudTMODDIRECCIONpthisSolicitud) {
        this.solicitudTMODDIRECCIONpthisSolicitudInstance = solicitudTMODDIRECCIONpthisSolicitud;
        this.solicitudTMODDIRECCIONpthisSolicitud = solicitudTMODDIRECCIONpthisSolicitud != null ? solicitudTMODDIRECCIONpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTMODDIRECCIONpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTMODDIRECCIONpthisSolicitudInstance() == null || this.getSolicitudTMODDIRECCIONpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODDIRECCION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODDIRECCION_SOLICITUDTMODDIRECCIONPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TMODDIRECCION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODDIRECCION_SOLICITUDTMODDIRECCIONPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTMODDIRECCIONptDirecciones() {
        return this.solicitudTMODDIRECCIONptDirecciones;
    }
    
    public void setSolicitudTMODDIRECCIONptDirecciones(String solicitudTMODDIRECCIONptDirecciones) {
        this.solicitudTMODDIRECCIONptDirecciones = solicitudTMODDIRECCIONptDirecciones;
    }

    @JsonIgnore
    public Direccion getSolicitudTMODDIRECCIONptDireccionesInstance() {
        return this.solicitudTMODDIRECCIONptDireccionesInstance;
    }
    
    public void setSolicitudTMODDIRECCIONptDireccionesInstance(Direccion solicitudTMODDIRECCIONptDirecciones) {
        this.solicitudTMODDIRECCIONptDireccionesInstance = solicitudTMODDIRECCIONptDirecciones;
        this.solicitudTMODDIRECCIONptDirecciones = solicitudTMODDIRECCIONptDirecciones != null ? solicitudTMODDIRECCIONptDirecciones.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
