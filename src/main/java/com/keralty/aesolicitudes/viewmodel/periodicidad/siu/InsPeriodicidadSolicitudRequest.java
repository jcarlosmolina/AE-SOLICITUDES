package com.keralty.aesolicitudes.viewmodel.periodicidad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PeriodicidadConstants;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class InsPeriodicidadSolicitudRequest {

    @JsonProperty("p_thisperiodicidad_oid")
    private PeriodicidadOid periodicidadInsPeriodicidadSolicitudpthisPeriodicidad;
    
    @JsonIgnore
    private Periodicidad periodicidadInsPeriodicidadSolicitudpthisPeriodicidadInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid periodicidadInsPeriodicidadSolicitudpevcSolicitud;
    
    @JsonIgnore
    private Solicitud periodicidadInsPeriodicidadSolicitudpevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPeriodicidadInsPeriodicidadSolicitudpthisPeriodicidad();
        checkPeriodicidadInsPeriodicidadSolicitudpevcSolicitud();
    }

    @JsonIgnore
    public PeriodicidadOid getPeriodicidadInsPeriodicidadSolicitudpthisPeriodicidad() {
        return this.periodicidadInsPeriodicidadSolicitudpthisPeriodicidad;
    }
    
    public void setPeriodicidadInsPeriodicidadSolicitudpthisPeriodicidad(PeriodicidadOid periodicidadInsPeriodicidadSolicitudpthisPeriodicidad) {
        this.periodicidadInsPeriodicidadSolicitudpthisPeriodicidad = periodicidadInsPeriodicidadSolicitudpthisPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getPeriodicidadInsPeriodicidadSolicitudpthisPeriodicidadInstance() {
        return this.periodicidadInsPeriodicidadSolicitudpthisPeriodicidadInstance;
    }
    
    public void setPeriodicidadInsPeriodicidadSolicitudpthisPeriodicidadInstance(Periodicidad periodicidadInsPeriodicidadSolicitudpthisPeriodicidad) {
        this.periodicidadInsPeriodicidadSolicitudpthisPeriodicidadInstance = periodicidadInsPeriodicidadSolicitudpthisPeriodicidad;
        this.periodicidadInsPeriodicidadSolicitudpthisPeriodicidad = periodicidadInsPeriodicidadSolicitudpthisPeriodicidad != null ? periodicidadInsPeriodicidadSolicitudpthisPeriodicidad.getOid() : null;
    }

    private void checkPeriodicidadInsPeriodicidadSolicitudpthisPeriodicidad() throws NotNullArgumentException {
        if(this.getPeriodicidadInsPeriodicidadSolicitudpthisPeriodicidadInstance() == null || this.getPeriodicidadInsPeriodicidadSolicitudpthisPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_INSPERIODICIDADSOLICITUD, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_INSPERIODICIDADSOLICITUD_PERIODICIDADINSPERIODICIDADSOLICITUDPTHISPERIODICIDAD, PeriodicidadConstants.SERV_ALIAS_INSPERIODICIDADSOLICITUD, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_INSPERIODICIDADSOLICITUD_PERIODICIDADINSPERIODICIDADSOLICITUDPTHISPERIODICIDAD);
        }
    }

    @JsonIgnore
    public SolicitudOid getPeriodicidadInsPeriodicidadSolicitudpevcSolicitud() {
        return this.periodicidadInsPeriodicidadSolicitudpevcSolicitud;
    }
    
    public void setPeriodicidadInsPeriodicidadSolicitudpevcSolicitud(SolicitudOid periodicidadInsPeriodicidadSolicitudpevcSolicitud) {
        this.periodicidadInsPeriodicidadSolicitudpevcSolicitud = periodicidadInsPeriodicidadSolicitudpevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getPeriodicidadInsPeriodicidadSolicitudpevcSolicitudInstance() {
        return this.periodicidadInsPeriodicidadSolicitudpevcSolicitudInstance;
    }
    
    public void setPeriodicidadInsPeriodicidadSolicitudpevcSolicitudInstance(Solicitud periodicidadInsPeriodicidadSolicitudpevcSolicitud) {
        this.periodicidadInsPeriodicidadSolicitudpevcSolicitudInstance = periodicidadInsPeriodicidadSolicitudpevcSolicitud;
        this.periodicidadInsPeriodicidadSolicitudpevcSolicitud = periodicidadInsPeriodicidadSolicitudpevcSolicitud != null ? periodicidadInsPeriodicidadSolicitudpevcSolicitud.getOid() : null;
    }

    private void checkPeriodicidadInsPeriodicidadSolicitudpevcSolicitud() throws NotNullArgumentException {
        if(this.getPeriodicidadInsPeriodicidadSolicitudpevcSolicitudInstance() == null || this.getPeriodicidadInsPeriodicidadSolicitudpevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_INSPERIODICIDADSOLICITUD, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_INSPERIODICIDADSOLICITUD_PERIODICIDADINSPERIODICIDADSOLICITUDPEVCSOLICITUD, PeriodicidadConstants.SERV_ALIAS_INSPERIODICIDADSOLICITUD, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_INSPERIODICIDADSOLICITUD_PERIODICIDADINSPERIODICIDADSOLICITUDPEVCSOLICITUD);
        }
    }
}
