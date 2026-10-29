package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DelPeriodicidadSolicitudRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudDelPeriodicidadSolicitudpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudDelPeriodicidadSolicitudpthisSolicitudInstance;

    @JsonProperty("p_evcperiodicidad_oid")
    private PeriodicidadOid solicitudDelPeriodicidadSolicitudpevcPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudDelPeriodicidadSolicitudpevcPeriodicidadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudDelPeriodicidadSolicitudpthisSolicitud();
        checkSolicitudDelPeriodicidadSolicitudpevcPeriodicidad();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudDelPeriodicidadSolicitudpthisSolicitud() {
        return this.solicitudDelPeriodicidadSolicitudpthisSolicitud;
    }
    
    public void setSolicitudDelPeriodicidadSolicitudpthisSolicitud(SolicitudOid solicitudDelPeriodicidadSolicitudpthisSolicitud) {
        this.solicitudDelPeriodicidadSolicitudpthisSolicitud = solicitudDelPeriodicidadSolicitudpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudDelPeriodicidadSolicitudpthisSolicitudInstance() {
        return this.solicitudDelPeriodicidadSolicitudpthisSolicitudInstance;
    }
    
    public void setSolicitudDelPeriodicidadSolicitudpthisSolicitudInstance(Solicitud solicitudDelPeriodicidadSolicitudpthisSolicitud) {
        this.solicitudDelPeriodicidadSolicitudpthisSolicitudInstance = solicitudDelPeriodicidadSolicitudpthisSolicitud;
        this.solicitudDelPeriodicidadSolicitudpthisSolicitud = solicitudDelPeriodicidadSolicitudpthisSolicitud != null ? solicitudDelPeriodicidadSolicitudpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudDelPeriodicidadSolicitudpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudDelPeriodicidadSolicitudpthisSolicitudInstance() == null || this.getSolicitudDelPeriodicidadSolicitudpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELPERIODICIDADSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELPERIODICIDADSOLICITUD_SOLICITUDDELPERIODICIDADSOLICITUDPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DELPERIODICIDADSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELPERIODICIDADSOLICITUD_SOLICITUDDELPERIODICIDADSOLICITUDPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public PeriodicidadOid getSolicitudDelPeriodicidadSolicitudpevcPeriodicidad() {
        return this.solicitudDelPeriodicidadSolicitudpevcPeriodicidad;
    }
    
    public void setSolicitudDelPeriodicidadSolicitudpevcPeriodicidad(PeriodicidadOid solicitudDelPeriodicidadSolicitudpevcPeriodicidad) {
        this.solicitudDelPeriodicidadSolicitudpevcPeriodicidad = solicitudDelPeriodicidadSolicitudpevcPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudDelPeriodicidadSolicitudpevcPeriodicidadInstance() {
        return this.solicitudDelPeriodicidadSolicitudpevcPeriodicidadInstance;
    }
    
    public void setSolicitudDelPeriodicidadSolicitudpevcPeriodicidadInstance(Periodicidad solicitudDelPeriodicidadSolicitudpevcPeriodicidad) {
        this.solicitudDelPeriodicidadSolicitudpevcPeriodicidadInstance = solicitudDelPeriodicidadSolicitudpevcPeriodicidad;
        this.solicitudDelPeriodicidadSolicitudpevcPeriodicidad = solicitudDelPeriodicidadSolicitudpevcPeriodicidad != null ? solicitudDelPeriodicidadSolicitudpevcPeriodicidad.getOid() : null;
    }

    private void checkSolicitudDelPeriodicidadSolicitudpevcPeriodicidad() throws NotNullArgumentException {
        if(this.getSolicitudDelPeriodicidadSolicitudpevcPeriodicidadInstance() == null || this.getSolicitudDelPeriodicidadSolicitudpevcPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELPERIODICIDADSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELPERIODICIDADSOLICITUD_SOLICITUDDELPERIODICIDADSOLICITUDPEVCPERIODICIDAD, SolicitudConstants.SERV_ALIAS_DELPERIODICIDADSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELPERIODICIDADSOLICITUD_SOLICITUDDELPERIODICIDADSOLICITUDPEVCPERIODICIDAD);
        }
    }
}
