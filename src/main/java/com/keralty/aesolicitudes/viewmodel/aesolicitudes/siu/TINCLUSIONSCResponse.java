package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TINCLUSIONSCResponse extends ServiceResponse {


    @JsonProperty("pt_ps_solicitud")
    private SolicitudOid aesolicitudesTINCLUSIONSCptpsSolicitud;
    
    @JsonIgnore
    private Solicitud aesolicitudesTINCLUSIONSCptpsSolicitudInstance;

    public TINCLUSIONSCResponse() {
        super();
    }

    @JsonIgnore
    public SolicitudOid getAesolicitudesTINCLUSIONSCptpsSolicitud() {
        return this.aesolicitudesTINCLUSIONSCptpsSolicitud;
    }
    
    public void setAesolicitudesTINCLUSIONSCptpsSolicitud(SolicitudOid aesolicitudesTINCLUSIONSCptpsSolicitud) {
        this.aesolicitudesTINCLUSIONSCptpsSolicitud = aesolicitudesTINCLUSIONSCptpsSolicitud;
    }
    @JsonIgnore
    public Solicitud getAesolicitudesTINCLUSIONSCptpsSolicitudInstance() {
        return this.aesolicitudesTINCLUSIONSCptpsSolicitudInstance;
    }
    
    public void setAesolicitudesTINCLUSIONSCptpsSolicitudInstance(Solicitud aesolicitudesTINCLUSIONSCptpsSolicitud) {
        if (aesolicitudesTINCLUSIONSCptpsSolicitud != null && !aesolicitudesTINCLUSIONSCptpsSolicitud.isNull()) {
            this.aesolicitudesTINCLUSIONSCptpsSolicitud = aesolicitudesTINCLUSIONSCptpsSolicitud.getOid();
            this.aesolicitudesTINCLUSIONSCptpsSolicitudInstance = aesolicitudesTINCLUSIONSCptpsSolicitud;
        } else {
            this.aesolicitudesTINCLUSIONSCptpsSolicitud = null;
            this.aesolicitudesTINCLUSIONSCptpsSolicitudInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("aesolicitudesTINCLUSIONSCptpsSolicitud", aesolicitudesTINCLUSIONSCptpsSolicitud);
        return outArgs;
    }
}
