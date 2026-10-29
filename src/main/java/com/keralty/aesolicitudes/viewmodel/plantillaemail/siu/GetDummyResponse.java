package com.keralty.aesolicitudes.viewmodel.plantillaemail.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.PlantillaEmailOid;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class GetDummyResponse extends ServiceResponse {


    @JsonProperty("oaplantillaemail")
    private PlantillaEmailOid plantillaEmailgetDummyoaPlantillaEmail;
    
    @JsonIgnore
    private PlantillaEmail plantillaEmailgetDummyoaPlantillaEmailInstance;

    public GetDummyResponse() {
        super();
    }

    @JsonIgnore
    public PlantillaEmailOid getPlantillaEmailgetDummyoaPlantillaEmail() {
        return this.plantillaEmailgetDummyoaPlantillaEmail;
    }
    
    public void setPlantillaEmailgetDummyoaPlantillaEmail(PlantillaEmailOid plantillaEmailgetDummyoaPlantillaEmail) {
        this.plantillaEmailgetDummyoaPlantillaEmail = plantillaEmailgetDummyoaPlantillaEmail;
    }
    @JsonIgnore
    public PlantillaEmail getPlantillaEmailgetDummyoaPlantillaEmailInstance() {
        return this.plantillaEmailgetDummyoaPlantillaEmailInstance;
    }
    
    public void setPlantillaEmailgetDummyoaPlantillaEmailInstance(PlantillaEmail plantillaEmailgetDummyoaPlantillaEmail) {
        if (plantillaEmailgetDummyoaPlantillaEmail != null && !plantillaEmailgetDummyoaPlantillaEmail.isNull()) {
            this.plantillaEmailgetDummyoaPlantillaEmail = plantillaEmailgetDummyoaPlantillaEmail.getOid();
            this.plantillaEmailgetDummyoaPlantillaEmailInstance = plantillaEmailgetDummyoaPlantillaEmail;
        } else {
            this.plantillaEmailgetDummyoaPlantillaEmail = null;
            this.plantillaEmailgetDummyoaPlantillaEmailInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("plantillaEmailgetDummyoaPlantillaEmail", plantillaEmailgetDummyoaPlantillaEmail);
        return outArgs;
    }
}
