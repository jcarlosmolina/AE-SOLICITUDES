package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DummyDiferenciasLiqRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicituddummyDiferenciasLiqpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicituddummyDiferenciasLiqpthisSolicitudInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicituddummyDiferenciasLiqpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicituddummyDiferenciasLiqpthisSolicitud() {
        return this.solicituddummyDiferenciasLiqpthisSolicitud;
    }
    
    public void setSolicituddummyDiferenciasLiqpthisSolicitud(SolicitudOid solicituddummyDiferenciasLiqpthisSolicitud) {
        this.solicituddummyDiferenciasLiqpthisSolicitud = solicituddummyDiferenciasLiqpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicituddummyDiferenciasLiqpthisSolicitudInstance() {
        return this.solicituddummyDiferenciasLiqpthisSolicitudInstance;
    }
    
    public void setSolicituddummyDiferenciasLiqpthisSolicitudInstance(Solicitud solicituddummyDiferenciasLiqpthisSolicitud) {
        this.solicituddummyDiferenciasLiqpthisSolicitudInstance = solicituddummyDiferenciasLiqpthisSolicitud;
        this.solicituddummyDiferenciasLiqpthisSolicitud = solicituddummyDiferenciasLiqpthisSolicitud != null ? solicituddummyDiferenciasLiqpthisSolicitud.getOid() : null;
    }

    private void checkSolicituddummyDiferenciasLiqpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicituddummyDiferenciasLiqpthisSolicitudInstance() == null || this.getSolicituddummyDiferenciasLiqpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DUMMYDIFERENCIASLIQ, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DUMMYDIFERENCIASLIQ_SOLICITUDDUMMYDIFERENCIASLIQPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DUMMYDIFERENCIASLIQ, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DUMMYDIFERENCIASLIQ_SOLICITUDDUMMYDIFERENCIASLIQPTHISSOLICITUD);
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
