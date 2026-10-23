package com.keralty.integraciones.patient.questionnaire.request;

import com.fasterxml.jackson.annotation.*;

public class PatientQuestionnaireRequest {
    private String resourceType = "Bundle";
    private String type = "transaction";
    private Entry entry;

    @JsonProperty("resourceType")
    public String getResourceType() { return resourceType; }
    @JsonProperty("resourceType")
    public void setResourceType(String value) { this.resourceType = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("entry")
    public Entry getEntry() { return entry; }
    @JsonProperty("entry")
    public void setEntry(Entry value) { this.entry = value; }
    
    @JsonIgnore
    public void asignarIdentificacion(String tipoIdentificiacion, String numeroIdentificacion) {
    	setEntry(new Entry());
    	getEntry().asignarIdentificacion(tipoIdentificiacion, numeroIdentificacion);
    }
    
}
