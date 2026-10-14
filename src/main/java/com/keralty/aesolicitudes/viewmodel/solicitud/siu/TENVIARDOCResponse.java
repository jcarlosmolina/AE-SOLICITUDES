package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.PlantillaEmailOid;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TENVIARDOCResponse extends ServiceResponse {


    @JsonProperty("oaplantilla")
    private PlantillaEmailOid solicitudTENVIARDOCoaPlantilla;
    
    @JsonIgnore
    private PlantillaEmail solicitudTENVIARDOCoaPlantillaInstance;

    public TENVIARDOCResponse() {
        super();
    }

    @JsonIgnore
    public PlantillaEmailOid getSolicitudTENVIARDOCoaPlantilla() {
        return this.solicitudTENVIARDOCoaPlantilla;
    }
    
    public void setSolicitudTENVIARDOCoaPlantilla(PlantillaEmailOid solicitudTENVIARDOCoaPlantilla) {
        this.solicitudTENVIARDOCoaPlantilla = solicitudTENVIARDOCoaPlantilla;
    }
    @JsonIgnore
    public PlantillaEmail getSolicitudTENVIARDOCoaPlantillaInstance() {
        return this.solicitudTENVIARDOCoaPlantillaInstance;
    }
    
    public void setSolicitudTENVIARDOCoaPlantillaInstance(PlantillaEmail solicitudTENVIARDOCoaPlantilla) {
        if (solicitudTENVIARDOCoaPlantilla != null && !solicitudTENVIARDOCoaPlantilla.isNull()) {
            this.solicitudTENVIARDOCoaPlantilla = solicitudTENVIARDOCoaPlantilla.getOid();
            this.solicitudTENVIARDOCoaPlantillaInstance = solicitudTENVIARDOCoaPlantilla;
        } else {
            this.solicitudTENVIARDOCoaPlantilla = null;
            this.solicitudTENVIARDOCoaPlantillaInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudTENVIARDOCoaPlantilla", solicitudTENVIARDOCoaPlantilla);
        return outArgs;
    }
}
