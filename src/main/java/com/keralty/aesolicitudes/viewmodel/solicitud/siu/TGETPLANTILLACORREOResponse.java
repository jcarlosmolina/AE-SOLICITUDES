package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.PlantillaEmailOid;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TGETPLANTILLACORREOResponse extends ServiceResponse {


    @JsonProperty("oaplantilla")
    private PlantillaEmailOid solicitudTGETPLANTILLACORREOoaPlantilla;
    
    @JsonIgnore
    private PlantillaEmail solicitudTGETPLANTILLACORREOoaPlantillaInstance;

    public TGETPLANTILLACORREOResponse() {
        super();
    }

    @JsonIgnore
    public PlantillaEmailOid getSolicitudTGETPLANTILLACORREOoaPlantilla() {
        return this.solicitudTGETPLANTILLACORREOoaPlantilla;
    }
    
    public void setSolicitudTGETPLANTILLACORREOoaPlantilla(PlantillaEmailOid solicitudTGETPLANTILLACORREOoaPlantilla) {
        this.solicitudTGETPLANTILLACORREOoaPlantilla = solicitudTGETPLANTILLACORREOoaPlantilla;
    }
    @JsonIgnore
    public PlantillaEmail getSolicitudTGETPLANTILLACORREOoaPlantillaInstance() {
        return this.solicitudTGETPLANTILLACORREOoaPlantillaInstance;
    }
    
    public void setSolicitudTGETPLANTILLACORREOoaPlantillaInstance(PlantillaEmail solicitudTGETPLANTILLACORREOoaPlantilla) {
        if (solicitudTGETPLANTILLACORREOoaPlantilla != null && !solicitudTGETPLANTILLACORREOoaPlantilla.isNull()) {
            this.solicitudTGETPLANTILLACORREOoaPlantilla = solicitudTGETPLANTILLACORREOoaPlantilla.getOid();
            this.solicitudTGETPLANTILLACORREOoaPlantillaInstance = solicitudTGETPLANTILLACORREOoaPlantilla;
        } else {
            this.solicitudTGETPLANTILLACORREOoaPlantilla = null;
            this.solicitudTGETPLANTILLACORREOoaPlantillaInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudTGETPLANTILLACORREOoaPlantilla", solicitudTGETPLANTILLACORREOoaPlantilla);
        return outArgs;
    }
}
