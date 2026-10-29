package com.keralty.aesolicitudes.viewmodel.plantillaemail.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
public class ICPlantillaEmail {

    @JsonProperty("descripcion")
    private String iCPlantillaEmailDescripcion;

    public ICPlantillaEmail() {
    
    }

    public ICPlantillaEmail(PlantillaEmail instance) {
        if (instance != null) {
            this.iCPlantillaEmailDescripcion = instance.getPlantillaEmailDescripcion();
        }
    }

    @JsonIgnore
    public String getICPlantillaEmailDescripcion() {
        return this.iCPlantillaEmailDescripcion;
    }
    
    public void setICPlantillaEmailDescripcion(String iCPlantillaEmailDescripcion) {
        this.iCPlantillaEmailDescripcion = iCPlantillaEmailDescripcion;
    }
}
