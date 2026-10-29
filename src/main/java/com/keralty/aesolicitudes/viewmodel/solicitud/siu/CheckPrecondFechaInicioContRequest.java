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

public class CheckPrecondFechaInicioContRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudcheckPrecondFechaInicioContpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudcheckPrecondFechaInicioContpthisSolicitudInstance;

    @JsonProperty("ptfecha")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudcheckPrecondFechaInicioContptFecha;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudcheckPrecondFechaInicioContpthisSolicitud();
        checkSolicitudcheckPrecondFechaInicioContptFecha();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudcheckPrecondFechaInicioContpthisSolicitud() {
        return this.solicitudcheckPrecondFechaInicioContpthisSolicitud;
    }
    
    public void setSolicitudcheckPrecondFechaInicioContpthisSolicitud(SolicitudOid solicitudcheckPrecondFechaInicioContpthisSolicitud) {
        this.solicitudcheckPrecondFechaInicioContpthisSolicitud = solicitudcheckPrecondFechaInicioContpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudcheckPrecondFechaInicioContpthisSolicitudInstance() {
        return this.solicitudcheckPrecondFechaInicioContpthisSolicitudInstance;
    }
    
    public void setSolicitudcheckPrecondFechaInicioContpthisSolicitudInstance(Solicitud solicitudcheckPrecondFechaInicioContpthisSolicitud) {
        this.solicitudcheckPrecondFechaInicioContpthisSolicitudInstance = solicitudcheckPrecondFechaInicioContpthisSolicitud;
        this.solicitudcheckPrecondFechaInicioContpthisSolicitud = solicitudcheckPrecondFechaInicioContpthisSolicitud != null ? solicitudcheckPrecondFechaInicioContpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudcheckPrecondFechaInicioContpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudcheckPrecondFechaInicioContpthisSolicitudInstance() == null || this.getSolicitudcheckPrecondFechaInicioContpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CHECKPRECONDFECHAINICIOCONT, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CHECKPRECONDFECHAINICIOCONT_SOLICITUDCHECKPRECONDFECHAINICIOCONTPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_CHECKPRECONDFECHAINICIOCONT, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CHECKPRECONDFECHAINICIOCONT_SOLICITUDCHECKPRECONDFECHAINICIOCONTPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Date getSolicitudcheckPrecondFechaInicioContptFecha() {
        return this.solicitudcheckPrecondFechaInicioContptFecha;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudcheckPrecondFechaInicioContptFecha(Date solicitudcheckPrecondFechaInicioContptFecha) {
        this.solicitudcheckPrecondFechaInicioContptFecha = solicitudcheckPrecondFechaInicioContptFecha;
    }

    private void checkSolicitudcheckPrecondFechaInicioContptFecha() throws NotNullArgumentException {
        if(this.getSolicitudcheckPrecondFechaInicioContptFecha() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CHECKPRECONDFECHAINICIOCONT, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CHECKPRECONDFECHAINICIOCONT_SOLICITUDCHECKPRECONDFECHAINICIOCONTPTFECHA, SolicitudConstants.SERV_ALIAS_CHECKPRECONDFECHAINICIOCONT, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CHECKPRECONDFECHAINICIOCONT_SOLICITUDCHECKPRECONDFECHAINICIOCONTPTFECHA);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
