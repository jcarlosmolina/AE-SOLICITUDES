package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TDASGUSRAFILIRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTDASGUSRAFILIpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTDASGUSRAFILIpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTDASGUSRAFILIpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTDASGUSRAFILIpthisSolicitud() {
        return this.solicitudTDASGUSRAFILIpthisSolicitud;
    }
    
    public void setSolicitudTDASGUSRAFILIpthisSolicitud(SolicitudOid solicitudTDASGUSRAFILIpthisSolicitud) {
        this.solicitudTDASGUSRAFILIpthisSolicitud = solicitudTDASGUSRAFILIpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTDASGUSRAFILIpthisSolicitudInstance() {
        return this.solicitudTDASGUSRAFILIpthisSolicitudInstance;
    }
    
    public void setSolicitudTDASGUSRAFILIpthisSolicitudInstance(Solicitud solicitudTDASGUSRAFILIpthisSolicitud) {
        this.solicitudTDASGUSRAFILIpthisSolicitudInstance = solicitudTDASGUSRAFILIpthisSolicitud;
        this.solicitudTDASGUSRAFILIpthisSolicitud = solicitudTDASGUSRAFILIpthisSolicitud != null ? solicitudTDASGUSRAFILIpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTDASGUSRAFILIpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTDASGUSRAFILIpthisSolicitudInstance() == null || this.getSolicitudTDASGUSRAFILIpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TDASGUSRAFILI, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TDASGUSRAFILI_SOLICITUDTDASGUSRAFILIPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TDASGUSRAFILI, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TDASGUSRAFILI_SOLICITUDTDASGUSRAFILIPTHISSOLICITUD);
        }
    }
}
