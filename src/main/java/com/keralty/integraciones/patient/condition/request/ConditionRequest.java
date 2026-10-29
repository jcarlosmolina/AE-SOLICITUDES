package com.keralty.integraciones.patient.condition.request;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class ConditionRequest {
    private String resourceType = "Bundle";
    private String type = "transaction";
    private List<Entry> entry;

    @JsonProperty("resourceType")
    public String getResourceType() { return resourceType; }
    @JsonProperty("resourceType")
    public void setResourceType(String value) { this.resourceType = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("entry")
    public List<Entry> getEntry() { return entry; }
    @JsonProperty("entry")
    public void setEntry(List<Entry> value) { this.entry = value; }
    
    @JsonIgnore
	public void asignarIdentificacion(String tipoIdentificacion, String numeroIdentificacion) {
    	setEntry(new ArrayList<Entry>());
    	Entry entry = new Entry();
    	entry.asignarIdentificacion(tipoIdentificacion, numeroIdentificacion);
    	
    	getEntry().add(entry);
	}
}
