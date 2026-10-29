package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class CalcularDifLiquidacionRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudcalcularDifLiquidacionpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudcalcularDifLiquidacionpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudcalcularDifLiquidacionpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudcalcularDifLiquidacionpthisSolicitud() {
        return this.solicitudcalcularDifLiquidacionpthisSolicitud;
    }
    
    public void setSolicitudcalcularDifLiquidacionpthisSolicitud(SolicitudOid solicitudcalcularDifLiquidacionpthisSolicitud) {
        this.solicitudcalcularDifLiquidacionpthisSolicitud = solicitudcalcularDifLiquidacionpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudcalcularDifLiquidacionpthisSolicitudInstance() {
        return this.solicitudcalcularDifLiquidacionpthisSolicitudInstance;
    }
    
    public void setSolicitudcalcularDifLiquidacionpthisSolicitudInstance(Solicitud solicitudcalcularDifLiquidacionpthisSolicitud) {
        this.solicitudcalcularDifLiquidacionpthisSolicitudInstance = solicitudcalcularDifLiquidacionpthisSolicitud;
        this.solicitudcalcularDifLiquidacionpthisSolicitud = solicitudcalcularDifLiquidacionpthisSolicitud != null ? solicitudcalcularDifLiquidacionpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudcalcularDifLiquidacionpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudcalcularDifLiquidacionpthisSolicitudInstance() == null || this.getSolicitudcalcularDifLiquidacionpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CALCULARDIFLIQUIDACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CALCULARDIFLIQUIDACION_SOLICITUDCALCULARDIFLIQUIDACIONPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_CALCULARDIFLIQUIDACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CALCULARDIFLIQUIDACION_SOLICITUDCALCULARDIFLIQUIDACIONPTHISSOLICITUD);
        }
    }
}
