package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class InsPeriodicidadSolicitudRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudInsPeriodicidadSolicitudpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudInsPeriodicidadSolicitudpthisSolicitudInstance;

    @JsonProperty("p_evcperiodicidad_oid")
    private PeriodicidadOid solicitudInsPeriodicidadSolicitudpevcPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudInsPeriodicidadSolicitudpevcPeriodicidadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudInsPeriodicidadSolicitudpthisSolicitud();
        checkSolicitudInsPeriodicidadSolicitudpevcPeriodicidad();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudInsPeriodicidadSolicitudpthisSolicitud() {
        return this.solicitudInsPeriodicidadSolicitudpthisSolicitud;
    }
    
    public void setSolicitudInsPeriodicidadSolicitudpthisSolicitud(SolicitudOid solicitudInsPeriodicidadSolicitudpthisSolicitud) {
        this.solicitudInsPeriodicidadSolicitudpthisSolicitud = solicitudInsPeriodicidadSolicitudpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudInsPeriodicidadSolicitudpthisSolicitudInstance() {
        return this.solicitudInsPeriodicidadSolicitudpthisSolicitudInstance;
    }
    
    public void setSolicitudInsPeriodicidadSolicitudpthisSolicitudInstance(Solicitud solicitudInsPeriodicidadSolicitudpthisSolicitud) {
        this.solicitudInsPeriodicidadSolicitudpthisSolicitudInstance = solicitudInsPeriodicidadSolicitudpthisSolicitud;
        this.solicitudInsPeriodicidadSolicitudpthisSolicitud = solicitudInsPeriodicidadSolicitudpthisSolicitud != null ? solicitudInsPeriodicidadSolicitudpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudInsPeriodicidadSolicitudpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudInsPeriodicidadSolicitudpthisSolicitudInstance() == null || this.getSolicitudInsPeriodicidadSolicitudpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSPERIODICIDADSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSPERIODICIDADSOLICITUD_SOLICITUDINSPERIODICIDADSOLICITUDPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_INSPERIODICIDADSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSPERIODICIDADSOLICITUD_SOLICITUDINSPERIODICIDADSOLICITUDPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public PeriodicidadOid getSolicitudInsPeriodicidadSolicitudpevcPeriodicidad() {
        return this.solicitudInsPeriodicidadSolicitudpevcPeriodicidad;
    }
    
    public void setSolicitudInsPeriodicidadSolicitudpevcPeriodicidad(PeriodicidadOid solicitudInsPeriodicidadSolicitudpevcPeriodicidad) {
        this.solicitudInsPeriodicidadSolicitudpevcPeriodicidad = solicitudInsPeriodicidadSolicitudpevcPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudInsPeriodicidadSolicitudpevcPeriodicidadInstance() {
        return this.solicitudInsPeriodicidadSolicitudpevcPeriodicidadInstance;
    }
    
    public void setSolicitudInsPeriodicidadSolicitudpevcPeriodicidadInstance(Periodicidad solicitudInsPeriodicidadSolicitudpevcPeriodicidad) {
        this.solicitudInsPeriodicidadSolicitudpevcPeriodicidadInstance = solicitudInsPeriodicidadSolicitudpevcPeriodicidad;
        this.solicitudInsPeriodicidadSolicitudpevcPeriodicidad = solicitudInsPeriodicidadSolicitudpevcPeriodicidad != null ? solicitudInsPeriodicidadSolicitudpevcPeriodicidad.getOid() : null;
    }

    private void checkSolicitudInsPeriodicidadSolicitudpevcPeriodicidad() throws NotNullArgumentException {
        if(this.getSolicitudInsPeriodicidadSolicitudpevcPeriodicidadInstance() == null || this.getSolicitudInsPeriodicidadSolicitudpevcPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSPERIODICIDADSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSPERIODICIDADSOLICITUD_SOLICITUDINSPERIODICIDADSOLICITUDPEVCPERIODICIDAD, SolicitudConstants.SERV_ALIAS_INSPERIODICIDADSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSPERIODICIDADSOLICITUD_SOLICITUDINSPERIODICIDADSOLICITUDPEVCPERIODICIDAD);
        }
    }
}
