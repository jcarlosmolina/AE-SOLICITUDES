package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class ModFechaInicioContratacionRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudmodFechaInicioContratacionpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudmodFechaInicioContratacionpthisSolicitudInstance;

    @JsonProperty("ptfecha")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudmodFechaInicioContratacionptFecha;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudmodFechaInicioContratacionpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudmodFechaInicioContratacionpthisSolicitud() {
        return this.solicitudmodFechaInicioContratacionpthisSolicitud;
    }
    
    public void setSolicitudmodFechaInicioContratacionpthisSolicitud(SolicitudOid solicitudmodFechaInicioContratacionpthisSolicitud) {
        this.solicitudmodFechaInicioContratacionpthisSolicitud = solicitudmodFechaInicioContratacionpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudmodFechaInicioContratacionpthisSolicitudInstance() {
        return this.solicitudmodFechaInicioContratacionpthisSolicitudInstance;
    }
    
    public void setSolicitudmodFechaInicioContratacionpthisSolicitudInstance(Solicitud solicitudmodFechaInicioContratacionpthisSolicitud) {
        this.solicitudmodFechaInicioContratacionpthisSolicitudInstance = solicitudmodFechaInicioContratacionpthisSolicitud;
        this.solicitudmodFechaInicioContratacionpthisSolicitud = solicitudmodFechaInicioContratacionpthisSolicitud != null ? solicitudmodFechaInicioContratacionpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudmodFechaInicioContratacionpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudmodFechaInicioContratacionpthisSolicitudInstance() == null || this.getSolicitudmodFechaInicioContratacionpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_MODFECHAINICIOCONTRATACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_MODFECHAINICIOCONTRATACION_SOLICITUDMODFECHAINICIOCONTRATACIONPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_MODFECHAINICIOCONTRATACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_MODFECHAINICIOCONTRATACION_SOLICITUDMODFECHAINICIOCONTRATACIONPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Date getSolicitudmodFechaInicioContratacionptFecha() {
        return this.solicitudmodFechaInicioContratacionptFecha;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudmodFechaInicioContratacionptFecha(Date solicitudmodFechaInicioContratacionptFecha) {
        this.solicitudmodFechaInicioContratacionptFecha = solicitudmodFechaInicioContratacionptFecha;
    }
}
