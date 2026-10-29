package com.keralty.aesolicitudes.viewmodel.periodicidad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PeriodicidadConstants;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DelPeriodicidadSolicitudRequest {

    @JsonProperty("p_thisperiodicidad_oid")
    private PeriodicidadOid periodicidadDelPeriodicidadSolicitudpthisPeriodicidad;
    
    @JsonIgnore
    private Periodicidad periodicidadDelPeriodicidadSolicitudpthisPeriodicidadInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid periodicidadDelPeriodicidadSolicitudpevcSolicitud;
    
    @JsonIgnore
    private Solicitud periodicidadDelPeriodicidadSolicitudpevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPeriodicidadDelPeriodicidadSolicitudpthisPeriodicidad();
        checkPeriodicidadDelPeriodicidadSolicitudpevcSolicitud();
    }

    @JsonIgnore
    public PeriodicidadOid getPeriodicidadDelPeriodicidadSolicitudpthisPeriodicidad() {
        return this.periodicidadDelPeriodicidadSolicitudpthisPeriodicidad;
    }
    
    public void setPeriodicidadDelPeriodicidadSolicitudpthisPeriodicidad(PeriodicidadOid periodicidadDelPeriodicidadSolicitudpthisPeriodicidad) {
        this.periodicidadDelPeriodicidadSolicitudpthisPeriodicidad = periodicidadDelPeriodicidadSolicitudpthisPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getPeriodicidadDelPeriodicidadSolicitudpthisPeriodicidadInstance() {
        return this.periodicidadDelPeriodicidadSolicitudpthisPeriodicidadInstance;
    }
    
    public void setPeriodicidadDelPeriodicidadSolicitudpthisPeriodicidadInstance(Periodicidad periodicidadDelPeriodicidadSolicitudpthisPeriodicidad) {
        this.periodicidadDelPeriodicidadSolicitudpthisPeriodicidadInstance = periodicidadDelPeriodicidadSolicitudpthisPeriodicidad;
        this.periodicidadDelPeriodicidadSolicitudpthisPeriodicidad = periodicidadDelPeriodicidadSolicitudpthisPeriodicidad != null ? periodicidadDelPeriodicidadSolicitudpthisPeriodicidad.getOid() : null;
    }

    private void checkPeriodicidadDelPeriodicidadSolicitudpthisPeriodicidad() throws NotNullArgumentException {
        if(this.getPeriodicidadDelPeriodicidadSolicitudpthisPeriodicidadInstance() == null || this.getPeriodicidadDelPeriodicidadSolicitudpthisPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_DELPERIODICIDADSOLICITUD, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_DELPERIODICIDADSOLICITUD_PERIODICIDADDELPERIODICIDADSOLICITUDPTHISPERIODICIDAD, PeriodicidadConstants.SERV_ALIAS_DELPERIODICIDADSOLICITUD, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_DELPERIODICIDADSOLICITUD_PERIODICIDADDELPERIODICIDADSOLICITUDPTHISPERIODICIDAD);
        }
    }

    @JsonIgnore
    public SolicitudOid getPeriodicidadDelPeriodicidadSolicitudpevcSolicitud() {
        return this.periodicidadDelPeriodicidadSolicitudpevcSolicitud;
    }
    
    public void setPeriodicidadDelPeriodicidadSolicitudpevcSolicitud(SolicitudOid periodicidadDelPeriodicidadSolicitudpevcSolicitud) {
        this.periodicidadDelPeriodicidadSolicitudpevcSolicitud = periodicidadDelPeriodicidadSolicitudpevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getPeriodicidadDelPeriodicidadSolicitudpevcSolicitudInstance() {
        return this.periodicidadDelPeriodicidadSolicitudpevcSolicitudInstance;
    }
    
    public void setPeriodicidadDelPeriodicidadSolicitudpevcSolicitudInstance(Solicitud periodicidadDelPeriodicidadSolicitudpevcSolicitud) {
        this.periodicidadDelPeriodicidadSolicitudpevcSolicitudInstance = periodicidadDelPeriodicidadSolicitudpevcSolicitud;
        this.periodicidadDelPeriodicidadSolicitudpevcSolicitud = periodicidadDelPeriodicidadSolicitudpevcSolicitud != null ? periodicidadDelPeriodicidadSolicitudpevcSolicitud.getOid() : null;
    }

    private void checkPeriodicidadDelPeriodicidadSolicitudpevcSolicitud() throws NotNullArgumentException {
        if(this.getPeriodicidadDelPeriodicidadSolicitudpevcSolicitudInstance() == null || this.getPeriodicidadDelPeriodicidadSolicitudpevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_DELPERIODICIDADSOLICITUD, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_DELPERIODICIDADSOLICITUD_PERIODICIDADDELPERIODICIDADSOLICITUDPEVCSOLICITUD, PeriodicidadConstants.SERV_ALIAS_DELPERIODICIDADSOLICITUD, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_DELPERIODICIDADSOLICITUD_PERIODICIDADDELPERIODICIDADSOLICITUDPEVCSOLICITUD);
        }
    }
}
