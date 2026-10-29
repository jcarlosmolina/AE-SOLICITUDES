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

public class CalcFechaIniContPlanVolRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudcalcFechaIniContPlanVolpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudcalcFechaIniContPlanVolpthisSolicitudInstance;

    @JsonProperty("pdiainicio")
    private Long solicitudcalcFechaIniContPlanVolpDiaInicio;

    @JsonProperty("pdiafin")
    private Long solicitudcalcFechaIniContPlanVolpDiaFin;

    @JsonProperty("pfechaconfirmacion")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudcalcFechaIniContPlanVolpFechaConfirmacion;

    @JsonProperty("pfechadeparametrizacion")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudcalcFechaIniContPlanVolpFechaDeParametrizacion;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudcalcFechaIniContPlanVolpthisSolicitud();
        checkSolicitudcalcFechaIniContPlanVolpDiaInicio();
        checkSolicitudcalcFechaIniContPlanVolpDiaFin();
        checkSolicitudcalcFechaIniContPlanVolpFechaConfirmacion();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudcalcFechaIniContPlanVolpthisSolicitud() {
        return this.solicitudcalcFechaIniContPlanVolpthisSolicitud;
    }
    
    public void setSolicitudcalcFechaIniContPlanVolpthisSolicitud(SolicitudOid solicitudcalcFechaIniContPlanVolpthisSolicitud) {
        this.solicitudcalcFechaIniContPlanVolpthisSolicitud = solicitudcalcFechaIniContPlanVolpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudcalcFechaIniContPlanVolpthisSolicitudInstance() {
        return this.solicitudcalcFechaIniContPlanVolpthisSolicitudInstance;
    }
    
    public void setSolicitudcalcFechaIniContPlanVolpthisSolicitudInstance(Solicitud solicitudcalcFechaIniContPlanVolpthisSolicitud) {
        this.solicitudcalcFechaIniContPlanVolpthisSolicitudInstance = solicitudcalcFechaIniContPlanVolpthisSolicitud;
        this.solicitudcalcFechaIniContPlanVolpthisSolicitud = solicitudcalcFechaIniContPlanVolpthisSolicitud != null ? solicitudcalcFechaIniContPlanVolpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudcalcFechaIniContPlanVolpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudcalcFechaIniContPlanVolpthisSolicitudInstance() == null || this.getSolicitudcalcFechaIniContPlanVolpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CALCFECHAINICONTPLANVOL, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CALCFECHAINICONTPLANVOL_SOLICITUDCALCFECHAINICONTPLANVOLPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_CALCFECHAINICONTPLANVOL, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CALCFECHAINICONTPLANVOL_SOLICITUDCALCFECHAINICONTPLANVOLPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Long getSolicitudcalcFechaIniContPlanVolpDiaInicio() {
        return this.solicitudcalcFechaIniContPlanVolpDiaInicio;
    }
    
    public void setSolicitudcalcFechaIniContPlanVolpDiaInicio(Long solicitudcalcFechaIniContPlanVolpDiaInicio) {
        this.solicitudcalcFechaIniContPlanVolpDiaInicio = solicitudcalcFechaIniContPlanVolpDiaInicio;
    }

    private void checkSolicitudcalcFechaIniContPlanVolpDiaInicio() throws NotNullArgumentException {
        if(this.getSolicitudcalcFechaIniContPlanVolpDiaInicio() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CALCFECHAINICONTPLANVOL, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CALCFECHAINICONTPLANVOL_SOLICITUDCALCFECHAINICONTPLANVOLPDIAINICIO, SolicitudConstants.SERV_ALIAS_CALCFECHAINICONTPLANVOL, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CALCFECHAINICONTPLANVOL_SOLICITUDCALCFECHAINICONTPLANVOLPDIAINICIO);
        }
    }

    @JsonIgnore
    public Long getSolicitudcalcFechaIniContPlanVolpDiaFin() {
        return this.solicitudcalcFechaIniContPlanVolpDiaFin;
    }
    
    public void setSolicitudcalcFechaIniContPlanVolpDiaFin(Long solicitudcalcFechaIniContPlanVolpDiaFin) {
        this.solicitudcalcFechaIniContPlanVolpDiaFin = solicitudcalcFechaIniContPlanVolpDiaFin;
    }

    private void checkSolicitudcalcFechaIniContPlanVolpDiaFin() throws NotNullArgumentException {
        if(this.getSolicitudcalcFechaIniContPlanVolpDiaFin() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CALCFECHAINICONTPLANVOL, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CALCFECHAINICONTPLANVOL_SOLICITUDCALCFECHAINICONTPLANVOLPDIAFIN, SolicitudConstants.SERV_ALIAS_CALCFECHAINICONTPLANVOL, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CALCFECHAINICONTPLANVOL_SOLICITUDCALCFECHAINICONTPLANVOLPDIAFIN);
        }
    }

    @JsonIgnore
    public Date getSolicitudcalcFechaIniContPlanVolpFechaConfirmacion() {
        return this.solicitudcalcFechaIniContPlanVolpFechaConfirmacion;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudcalcFechaIniContPlanVolpFechaConfirmacion(Date solicitudcalcFechaIniContPlanVolpFechaConfirmacion) {
        this.solicitudcalcFechaIniContPlanVolpFechaConfirmacion = solicitudcalcFechaIniContPlanVolpFechaConfirmacion;
    }

    private void checkSolicitudcalcFechaIniContPlanVolpFechaConfirmacion() throws NotNullArgumentException {
        if(this.getSolicitudcalcFechaIniContPlanVolpFechaConfirmacion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CALCFECHAINICONTPLANVOL, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CALCFECHAINICONTPLANVOL_SOLICITUDCALCFECHAINICONTPLANVOLPFECHACONFIRMACION, SolicitudConstants.SERV_ALIAS_CALCFECHAINICONTPLANVOL, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CALCFECHAINICONTPLANVOL_SOLICITUDCALCFECHAINICONTPLANVOLPFECHACONFIRMACION);
        }
    }

    @JsonIgnore
    public Date getSolicitudcalcFechaIniContPlanVolpFechaDeParametrizacion() {
        return this.solicitudcalcFechaIniContPlanVolpFechaDeParametrizacion;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudcalcFechaIniContPlanVolpFechaDeParametrizacion(Date solicitudcalcFechaIniContPlanVolpFechaDeParametrizacion) {
        this.solicitudcalcFechaIniContPlanVolpFechaDeParametrizacion = solicitudcalcFechaIniContPlanVolpFechaDeParametrizacion;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
