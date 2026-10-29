package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.PlantillaEmailOid;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TDEVOLVERResponse extends ServiceResponse {


    @JsonProperty("oaplantilla")
    private PlantillaEmailOid documentoGTDEVOLVERoaPlantilla;
    
    @JsonIgnore
    private PlantillaEmail documentoGTDEVOLVERoaPlantillaInstance;

    public TDEVOLVERResponse() {
        super();
    }

    @JsonIgnore
    public PlantillaEmailOid getDocumentoGTDEVOLVERoaPlantilla() {
        return this.documentoGTDEVOLVERoaPlantilla;
    }
    
    public void setDocumentoGTDEVOLVERoaPlantilla(PlantillaEmailOid documentoGTDEVOLVERoaPlantilla) {
        this.documentoGTDEVOLVERoaPlantilla = documentoGTDEVOLVERoaPlantilla;
    }
    @JsonIgnore
    public PlantillaEmail getDocumentoGTDEVOLVERoaPlantillaInstance() {
        return this.documentoGTDEVOLVERoaPlantillaInstance;
    }
    
    public void setDocumentoGTDEVOLVERoaPlantillaInstance(PlantillaEmail documentoGTDEVOLVERoaPlantilla) {
        if (documentoGTDEVOLVERoaPlantilla != null && !documentoGTDEVOLVERoaPlantilla.isNull()) {
            this.documentoGTDEVOLVERoaPlantilla = documentoGTDEVOLVERoaPlantilla.getOid();
            this.documentoGTDEVOLVERoaPlantillaInstance = documentoGTDEVOLVERoaPlantilla;
        } else {
            this.documentoGTDEVOLVERoaPlantilla = null;
            this.documentoGTDEVOLVERoaPlantillaInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("documentoGTDEVOLVERoaPlantilla", documentoGTDEVOLVERoaPlantilla);
        return outArgs;
    }
}
