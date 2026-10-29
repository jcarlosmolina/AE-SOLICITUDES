package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TNUEVAAFILIACIONResponse extends ServiceResponse {


    @JsonProperty("pt_ps_solicitud")
    private SolicitudOid aesolicitudesTNUEVAAFILIACIONptpsSolicitud;
    
    @JsonIgnore
    private Solicitud aesolicitudesTNUEVAAFILIACIONptpsSolicitudInstance;

    public TNUEVAAFILIACIONResponse() {
        super();
    }

    @JsonIgnore
    public SolicitudOid getAesolicitudesTNUEVAAFILIACIONptpsSolicitud() {
        return this.aesolicitudesTNUEVAAFILIACIONptpsSolicitud;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptpsSolicitud(SolicitudOid aesolicitudesTNUEVAAFILIACIONptpsSolicitud) {
        this.aesolicitudesTNUEVAAFILIACIONptpsSolicitud = aesolicitudesTNUEVAAFILIACIONptpsSolicitud;
    }
    @JsonIgnore
    public Solicitud getAesolicitudesTNUEVAAFILIACIONptpsSolicitudInstance() {
        return this.aesolicitudesTNUEVAAFILIACIONptpsSolicitudInstance;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptpsSolicitudInstance(Solicitud aesolicitudesTNUEVAAFILIACIONptpsSolicitud) {
        if (aesolicitudesTNUEVAAFILIACIONptpsSolicitud != null && !aesolicitudesTNUEVAAFILIACIONptpsSolicitud.isNull()) {
            this.aesolicitudesTNUEVAAFILIACIONptpsSolicitud = aesolicitudesTNUEVAAFILIACIONptpsSolicitud.getOid();
            this.aesolicitudesTNUEVAAFILIACIONptpsSolicitudInstance = aesolicitudesTNUEVAAFILIACIONptpsSolicitud;
        } else {
            this.aesolicitudesTNUEVAAFILIACIONptpsSolicitud = null;
            this.aesolicitudesTNUEVAAFILIACIONptpsSolicitudInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("aesolicitudesTNUEVAAFILIACIONptpsSolicitud", aesolicitudesTNUEVAAFILIACIONptpsSolicitud);
        return outArgs;
    }
}
