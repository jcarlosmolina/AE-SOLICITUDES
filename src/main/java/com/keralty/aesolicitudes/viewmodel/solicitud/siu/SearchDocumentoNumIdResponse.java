package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class SearchDocumentoNumIdResponse extends ServiceResponse {

    @JsonProperty("pfu_iddocengestor")
    private String solicitudsearchDocumentoNumIdpfuIdDocEnGestor;

    public SearchDocumentoNumIdResponse() {
        super();
    }

    @JsonIgnore
    public String getSolicitudsearchDocumentoNumIdpfuIdDocEnGestor() {
        return this.solicitudsearchDocumentoNumIdpfuIdDocEnGestor;
    }
    
    public void setSolicitudsearchDocumentoNumIdpfuIdDocEnGestor(String solicitudsearchDocumentoNumIdpfuIdDocEnGestor) {
        this.solicitudsearchDocumentoNumIdpfuIdDocEnGestor = solicitudsearchDocumentoNumIdpfuIdDocEnGestor;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudsearchDocumentoNumIdpfuIdDocEnGestor", solicitudsearchDocumentoNumIdpfuIdDocEnGestor);
        return outArgs;
    }
}
