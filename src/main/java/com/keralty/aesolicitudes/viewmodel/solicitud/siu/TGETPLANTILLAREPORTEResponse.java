package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.ReportesDominioOid;
import com.keralty.aesolicitudes.persistence.ReportesDominio;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TGETPLANTILLAREPORTEResponse extends ServiceResponse {


    @JsonProperty("oaplantilla")
    private ReportesDominioOid solicitudTGETPLANTILLAREPORTEoaPlantilla;
    
    @JsonIgnore
    private ReportesDominio solicitudTGETPLANTILLAREPORTEoaPlantillaInstance;

    @JsonProperty("oareporte")
    private byte[] solicitudTGETPLANTILLAREPORTEoaReporte;

    @JsonProperty("oanombrearchivo")
    private String solicitudTGETPLANTILLAREPORTEoaNombreArchivo;

    public TGETPLANTILLAREPORTEResponse() {
        super();
    }

    @JsonIgnore
    public ReportesDominioOid getSolicitudTGETPLANTILLAREPORTEoaPlantilla() {
        return this.solicitudTGETPLANTILLAREPORTEoaPlantilla;
    }
    
    public void setSolicitudTGETPLANTILLAREPORTEoaPlantilla(ReportesDominioOid solicitudTGETPLANTILLAREPORTEoaPlantilla) {
        this.solicitudTGETPLANTILLAREPORTEoaPlantilla = solicitudTGETPLANTILLAREPORTEoaPlantilla;
    }
    @JsonIgnore
    public ReportesDominio getSolicitudTGETPLANTILLAREPORTEoaPlantillaInstance() {
        return this.solicitudTGETPLANTILLAREPORTEoaPlantillaInstance;
    }
    
    public void setSolicitudTGETPLANTILLAREPORTEoaPlantillaInstance(ReportesDominio solicitudTGETPLANTILLAREPORTEoaPlantilla) {
        if (solicitudTGETPLANTILLAREPORTEoaPlantilla != null && !solicitudTGETPLANTILLAREPORTEoaPlantilla.isNull()) {
            this.solicitudTGETPLANTILLAREPORTEoaPlantilla = solicitudTGETPLANTILLAREPORTEoaPlantilla.getOid();
            this.solicitudTGETPLANTILLAREPORTEoaPlantillaInstance = solicitudTGETPLANTILLAREPORTEoaPlantilla;
        } else {
            this.solicitudTGETPLANTILLAREPORTEoaPlantilla = null;
            this.solicitudTGETPLANTILLAREPORTEoaPlantillaInstance = null;
        }
    }

    @JsonIgnore
    public byte[] getSolicitudTGETPLANTILLAREPORTEoaReporte() {
        return this.solicitudTGETPLANTILLAREPORTEoaReporte;
    }
    
    public void setSolicitudTGETPLANTILLAREPORTEoaReporte(byte[] solicitudTGETPLANTILLAREPORTEoaReporte) {
        this.solicitudTGETPLANTILLAREPORTEoaReporte = solicitudTGETPLANTILLAREPORTEoaReporte;
    }

    @JsonIgnore
    public String getSolicitudTGETPLANTILLAREPORTEoaNombreArchivo() {
        return this.solicitudTGETPLANTILLAREPORTEoaNombreArchivo;
    }
    
    public void setSolicitudTGETPLANTILLAREPORTEoaNombreArchivo(String solicitudTGETPLANTILLAREPORTEoaNombreArchivo) {
        this.solicitudTGETPLANTILLAREPORTEoaNombreArchivo = solicitudTGETPLANTILLAREPORTEoaNombreArchivo;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudTGETPLANTILLAREPORTEoaPlantilla", solicitudTGETPLANTILLAREPORTEoaPlantilla);
        outArgs.put("solicitudTGETPLANTILLAREPORTEoaReporte", solicitudTGETPLANTILLAREPORTEoaReporte);
        outArgs.put("solicitudTGETPLANTILLAREPORTEoaNombreArchivo", solicitudTGETPLANTILLAREPORTEoaNombreArchivo);
        return outArgs;
    }
}
