package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class ValidarAtributosUsuarioResponse extends ServiceResponse {

    @JsonProperty("pt_ps_numsolicitud")
    private String solicitudvalidarAtributosUsuarioptpsNumSolicitud;

    public ValidarAtributosUsuarioResponse() {
        super();
    }

    @JsonIgnore
    public String getSolicitudvalidarAtributosUsuarioptpsNumSolicitud() {
        return this.solicitudvalidarAtributosUsuarioptpsNumSolicitud;
    }
    
    public void setSolicitudvalidarAtributosUsuarioptpsNumSolicitud(String solicitudvalidarAtributosUsuarioptpsNumSolicitud) {
        this.solicitudvalidarAtributosUsuarioptpsNumSolicitud = solicitudvalidarAtributosUsuarioptpsNumSolicitud;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudvalidarAtributosUsuarioptpsNumSolicitud", solicitudvalidarAtributosUsuarioptpsNumSolicitud);
        return outArgs;
    }
}
