package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class PrevisualizarATOResponse extends ServiceResponse {

    @JsonProperty("oatoken")
    private String documentoGprevisualizarATOoaToken;

    @JsonProperty("oaurldescarga")
    private String documentoGprevisualizarATOoaURLDescarga;

    @JsonProperty("oanumsolicitud")
    private String documentoGprevisualizarATOoaNumSolicitud;

    public PrevisualizarATOResponse() {
        super();
    }

    @JsonIgnore
    public String getDocumentoGprevisualizarATOoaToken() {
        return this.documentoGprevisualizarATOoaToken;
    }
    
    public void setDocumentoGprevisualizarATOoaToken(String documentoGprevisualizarATOoaToken) {
        this.documentoGprevisualizarATOoaToken = documentoGprevisualizarATOoaToken;
    }

    @JsonIgnore
    public String getDocumentoGprevisualizarATOoaURLDescarga() {
        return this.documentoGprevisualizarATOoaURLDescarga;
    }
    
    public void setDocumentoGprevisualizarATOoaURLDescarga(String documentoGprevisualizarATOoaURLDescarga) {
        this.documentoGprevisualizarATOoaURLDescarga = documentoGprevisualizarATOoaURLDescarga;
    }

    @JsonIgnore
    public String getDocumentoGprevisualizarATOoaNumSolicitud() {
        return this.documentoGprevisualizarATOoaNumSolicitud;
    }
    
    public void setDocumentoGprevisualizarATOoaNumSolicitud(String documentoGprevisualizarATOoaNumSolicitud) {
        this.documentoGprevisualizarATOoaNumSolicitud = documentoGprevisualizarATOoaNumSolicitud;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("documentoGprevisualizarATOoaToken", documentoGprevisualizarATOoaToken);
        outArgs.put("documentoGprevisualizarATOoaURLDescarga", documentoGprevisualizarATOoaURLDescarga);
        outArgs.put("documentoGprevisualizarATOoaNumSolicitud", documentoGprevisualizarATOoaNumSolicitud);
        return outArgs;
    }
}
