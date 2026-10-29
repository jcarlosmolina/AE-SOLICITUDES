package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class EnviarEmailResponse extends ServiceResponse {

    @JsonProperty("oaresultado")
    private String solicitudenviarEmailoaResultado;

    public EnviarEmailResponse() {
        super();
    }

    @JsonIgnore
    public String getSolicitudenviarEmailoaResultado() {
        return this.solicitudenviarEmailoaResultado;
    }
    
    public void setSolicitudenviarEmailoaResultado(String solicitudenviarEmailoaResultado) {
        this.solicitudenviarEmailoaResultado = solicitudenviarEmailoaResultado;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudenviarEmailoaResultado", solicitudenviarEmailoaResultado);
        return outArgs;
    }
}
