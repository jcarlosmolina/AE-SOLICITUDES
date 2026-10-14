package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class SearchDocumentoSolicitudResponse extends ServiceResponse {

    @JsonProperty("pfu_iddocengestor")
    private String solicitudsearchDocumentoSolicitudpfuIdDocEnGestor;

    public SearchDocumentoSolicitudResponse() {
        super();
    }

    @JsonIgnore
    public String getSolicitudsearchDocumentoSolicitudpfuIdDocEnGestor() {
        return this.solicitudsearchDocumentoSolicitudpfuIdDocEnGestor;
    }
    
    public void setSolicitudsearchDocumentoSolicitudpfuIdDocEnGestor(String solicitudsearchDocumentoSolicitudpfuIdDocEnGestor) {
        this.solicitudsearchDocumentoSolicitudpfuIdDocEnGestor = solicitudsearchDocumentoSolicitudpfuIdDocEnGestor;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudsearchDocumentoSolicitudpfuIdDocEnGestor", solicitudsearchDocumentoSolicitudpfuIdDocEnGestor);
        return outArgs;
    }
}
