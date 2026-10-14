package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class FormarArchivoDocumentacionResponse extends ServiceResponse {

    @JsonProperty("psnombrearchivo")
    private String solicitudformarArchivoDocumentacionpsNombreArchivo;

    public FormarArchivoDocumentacionResponse() {
        super();
    }

    @JsonIgnore
    public String getSolicitudformarArchivoDocumentacionpsNombreArchivo() {
        return this.solicitudformarArchivoDocumentacionpsNombreArchivo;
    }
    
    public void setSolicitudformarArchivoDocumentacionpsNombreArchivo(String solicitudformarArchivoDocumentacionpsNombreArchivo) {
        this.solicitudformarArchivoDocumentacionpsNombreArchivo = solicitudformarArchivoDocumentacionpsNombreArchivo;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudformarArchivoDocumentacionpsNombreArchivo", solicitudformarArchivoDocumentacionpsNombreArchivo);
        return outArgs;
    }
}
