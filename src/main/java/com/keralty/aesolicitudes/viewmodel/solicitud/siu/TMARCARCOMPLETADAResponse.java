package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TMARCARCOMPLETADAResponse extends ServiceResponse {

    @JsonProperty("pt_ps_numsolicitud")
    private String solicitudTMARCARCOMPLETADAptpsNumSolicitud;

    public TMARCARCOMPLETADAResponse() {
        super();
    }

    @JsonIgnore
    public String getSolicitudTMARCARCOMPLETADAptpsNumSolicitud() {
        return this.solicitudTMARCARCOMPLETADAptpsNumSolicitud;
    }
    
    public void setSolicitudTMARCARCOMPLETADAptpsNumSolicitud(String solicitudTMARCARCOMPLETADAptpsNumSolicitud) {
        this.solicitudTMARCARCOMPLETADAptpsNumSolicitud = solicitudTMARCARCOMPLETADAptpsNumSolicitud;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudTMARCARCOMPLETADAptpsNumSolicitud", solicitudTMARCARCOMPLETADAptpsNumSolicitud);
        return outArgs;
    }
}
