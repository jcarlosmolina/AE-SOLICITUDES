package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TREASIGNARUSUARIOSResponse extends ServiceResponse {

    @JsonProperty("oanumprocesados")
    private Long solicitudTREASIGNARUSUARIOSoaNumProcesados;

    @JsonProperty("oanumerrores")
    private Long solicitudTREASIGNARUSUARIOSoaNumErrores;

    @JsonProperty("oatextoerrores")
    private String solicitudTREASIGNARUSUARIOSoaTextoErrores;

    public TREASIGNARUSUARIOSResponse() {
        super();
    }

    @JsonIgnore
    public Long getSolicitudTREASIGNARUSUARIOSoaNumProcesados() {
        return this.solicitudTREASIGNARUSUARIOSoaNumProcesados;
    }
    
    public void setSolicitudTREASIGNARUSUARIOSoaNumProcesados(Long solicitudTREASIGNARUSUARIOSoaNumProcesados) {
        this.solicitudTREASIGNARUSUARIOSoaNumProcesados = solicitudTREASIGNARUSUARIOSoaNumProcesados;
    }

    @JsonIgnore
    public Long getSolicitudTREASIGNARUSUARIOSoaNumErrores() {
        return this.solicitudTREASIGNARUSUARIOSoaNumErrores;
    }
    
    public void setSolicitudTREASIGNARUSUARIOSoaNumErrores(Long solicitudTREASIGNARUSUARIOSoaNumErrores) {
        this.solicitudTREASIGNARUSUARIOSoaNumErrores = solicitudTREASIGNARUSUARIOSoaNumErrores;
    }

    @JsonIgnore
    public String getSolicitudTREASIGNARUSUARIOSoaTextoErrores() {
        return this.solicitudTREASIGNARUSUARIOSoaTextoErrores;
    }
    
    public void setSolicitudTREASIGNARUSUARIOSoaTextoErrores(String solicitudTREASIGNARUSUARIOSoaTextoErrores) {
        this.solicitudTREASIGNARUSUARIOSoaTextoErrores = solicitudTREASIGNARUSUARIOSoaTextoErrores;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudTREASIGNARUSUARIOSoaNumProcesados", solicitudTREASIGNARUSUARIOSoaNumProcesados);
        outArgs.put("solicitudTREASIGNARUSUARIOSoaNumErrores", solicitudTREASIGNARUSUARIOSoaNumErrores);
        outArgs.put("solicitudTREASIGNARUSUARIOSoaTextoErrores", solicitudTREASIGNARUSUARIOSoaTextoErrores);
        return outArgs;
    }
}
