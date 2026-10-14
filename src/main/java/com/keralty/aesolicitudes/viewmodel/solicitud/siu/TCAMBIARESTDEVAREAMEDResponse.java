package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.PlantillaEmailOid;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TCAMBIARESTDEVAREAMEDResponse extends ServiceResponse {


    @JsonProperty("oaplantilla")
    private PlantillaEmailOid solicitudTCAMBIARESTDEVAREAMEDoaPlantilla;
    
    @JsonIgnore
    private PlantillaEmail solicitudTCAMBIARESTDEVAREAMEDoaPlantillaInstance;

    public TCAMBIARESTDEVAREAMEDResponse() {
        super();
    }

    @JsonIgnore
    public PlantillaEmailOid getSolicitudTCAMBIARESTDEVAREAMEDoaPlantilla() {
        return this.solicitudTCAMBIARESTDEVAREAMEDoaPlantilla;
    }
    
    public void setSolicitudTCAMBIARESTDEVAREAMEDoaPlantilla(PlantillaEmailOid solicitudTCAMBIARESTDEVAREAMEDoaPlantilla) {
        this.solicitudTCAMBIARESTDEVAREAMEDoaPlantilla = solicitudTCAMBIARESTDEVAREAMEDoaPlantilla;
    }
    @JsonIgnore
    public PlantillaEmail getSolicitudTCAMBIARESTDEVAREAMEDoaPlantillaInstance() {
        return this.solicitudTCAMBIARESTDEVAREAMEDoaPlantillaInstance;
    }
    
    public void setSolicitudTCAMBIARESTDEVAREAMEDoaPlantillaInstance(PlantillaEmail solicitudTCAMBIARESTDEVAREAMEDoaPlantilla) {
        if (solicitudTCAMBIARESTDEVAREAMEDoaPlantilla != null && !solicitudTCAMBIARESTDEVAREAMEDoaPlantilla.isNull()) {
            this.solicitudTCAMBIARESTDEVAREAMEDoaPlantilla = solicitudTCAMBIARESTDEVAREAMEDoaPlantilla.getOid();
            this.solicitudTCAMBIARESTDEVAREAMEDoaPlantillaInstance = solicitudTCAMBIARESTDEVAREAMEDoaPlantilla;
        } else {
            this.solicitudTCAMBIARESTDEVAREAMEDoaPlantilla = null;
            this.solicitudTCAMBIARESTDEVAREAMEDoaPlantillaInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudTCAMBIARESTDEVAREAMEDoaPlantilla", solicitudTCAMBIARESTDEVAREAMEDoaPlantilla);
        return outArgs;
    }
}
